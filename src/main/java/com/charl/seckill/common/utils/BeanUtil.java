package com.charl.seckill.common.utils;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @program: blog
 * @description: 拷贝的对象属性必须要实现get和set方法，不然无法进行拷贝
 * @author: charl
 * @create: 2018-07-20 11:03
 **/
public class BeanUtil {

    /**
     * the beanCopierMap
     */
    private static final ConcurrentMap<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();

    /**
     * @description 两个类对象之间转换(深度拷贝)
     * @param source
     * @param target
     * @return
     * @return T
     */
    public static <T> T copy(Object source, Class<T> target) {
        T ret = null;
        if (source != null) {
            try {
                ret = target.newInstance();
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("create class[" + target.getName()
                        + "] instance error", e);
            }
            BeanCopier beanCopier = getBeanCopier(source.getClass(), target);
            beanCopier.copy(source, ret, new DeepCopyConverter(target));
        }
        return ret;
    }

    /**
     * 把一个list转换成另外一个list
     * @param list
     * @param target
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(List<?> list, Class<T> target) {
        if (org.springframework.util.CollectionUtils.isEmpty(list)) {
            return Collections.EMPTY_LIST;
        }

        List<T> result = new ArrayList<>(list.size());
        for (Object source : list) {
            T copy = copy(source, target);
            result.add(copy);
        }

        return result;
    }

    public static class DeepCopyConverter implements Converter {

        /**
         * The Target.
         */
        private Class<?> target;

        /**
         * Instantiates a new Deep copy converter.
         *
         * @param target
         *            the target
         */
        public DeepCopyConverter(Class<?> target) {
            this.target = target;
        }

        @Override
        public Object convert(Object value, Class targetClazz, Object methodName) {
            if (value instanceof List) {
                List values = (List) value;
                List retList = new ArrayList<>(values.size());
                for (final Object source : values) {
                    String tempFieldName = methodName.toString().replace("set",
                            "");
                    String fieldName = tempFieldName.substring(0, 1)
                            .toLowerCase() + tempFieldName.substring(1);
                    Class clazz = ClassUtil.getElementType(target, fieldName);
                    retList.add(BeanUtil.copy(source, clazz));
                }
                return retList;
            } else if (value instanceof Map) {
            } else if (!ClassUtil.isPrimitive(targetClazz)) {
                return BeanUtil.copy(value, targetClazz);
            }
            return value;
        }
    }

    /**
     * @description 获取BeanCopier
     * @param source
     * @param target
     * @return
     * @return BeanCopier
     */
    public static BeanCopier getBeanCopier(Class<?> source, Class<?> target) {
        String beanCopierKey = generateBeanKey(source, target);
        if (beanCopierMap.containsKey(beanCopierKey)) {
            return beanCopierMap.get(beanCopierKey);
        } else {
            BeanCopier beanCopier = BeanCopier.create(source, target, true);
            beanCopierMap.putIfAbsent(beanCopierKey, beanCopier);
        }
        return beanCopierMap.get(beanCopierKey);
    }

    /**
     * @description 生成两个类的key
     * @param source
     * @param target
     * @return
     * @return String
     */
    public static String generateBeanKey(Class<?> source, Class<?> target) {
        return source.getName() + "@" + target.getName();
    }

}
