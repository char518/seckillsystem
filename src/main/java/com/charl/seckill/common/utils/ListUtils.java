package com.charl.seckill.common.utils;


import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by Administrator on 2018/03/22.
 */
public class ListUtils {

    public interface Function<T>{
        void apply(T param);
    }

    /**
     * 按固定size分割，分割完调用apply
     * @param targetList
     * @param batchSize
     * @param function
     * @param <T>
     */
    public static <T> void toFixBatchSize(List<T> targetList, int batchSize, Function function){

        int batchCount = (int) Math.ceil((double) targetList.size() / batchSize);
        for (int i = 0; i < batchCount; i++) {
            List<T> splitList = new ArrayList<>();
            if ((i + 1) * batchSize > targetList.size()) {
                splitList.addAll(targetList.subList(i * batchSize, targetList.size()));
            } else {
                splitList.addAll(targetList.subList(i * batchSize, (i + 1) * batchSize));
            }
            function.apply(splitList);
        }
    }

    /**
     * 分割成固定的数量count
     * @param targetList
     * @param count
     * @param function
     * @param <T>
     */
    public static <T> void toFixBatchCount(List<T> targetList, int count, Function function) {
        int batchSize = (int) Math.ceil((double) targetList.size() / count);
        for (int i = 0; i < count; i++) {
            List<T> splitList = new ArrayList<>();
            if ((i + 1) * batchSize > targetList.size()) {
                splitList.addAll(targetList.subList(i * batchSize, targetList.size()));
            } else {
                splitList.addAll(targetList.subList(i * batchSize, (i + 1) * batchSize));
            }
            function.apply(splitList);
        }
    }

    /**
     * 去除list中重复的元素
     * @param list
     * @return
     */
    public static <T> List<T> removeDuplicateElement(List<T> list) {
        LinkedHashSet<T> set = new LinkedHashSet<T>(list.size());
        set.addAll(list);
        List<T> resultList = new ArrayList<>(set);
        return resultList;
    }

    /**
     * 根据index 和 total 对map 分割处理
     *
     * @param list
     * @param index
     * @param total
     * @param <T>
     * @return
     */
    public static <T> List<T> shardList(List<T> list, int index, int total) {
        int size = list.size();
        int avgSize = size / total;

        int end = (index + 1) * avgSize >= size ? size : (index + 1) * avgSize;
        return list.subList(index * avgSize, end);
    }

    /**
     * 两个list取差集
     *
     * @param originList
     * @param targetList
     * @param <T>
     * @return
     */
    public static <T> List<T> differenceSet(List<T> originList, List<T> targetList) {
        if (CollectionUtils.isEmpty(targetList)) {
            return originList;
        }
        Set<T> set = new HashSet<>(targetList);
        List<T> result = new ArrayList<>();
        for (T t : originList) {
            if (!set.contains(t)) {
                result.add(t);
            }
        }
        return result;
    }

}
