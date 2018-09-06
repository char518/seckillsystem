package com.charl.seckill.service.impl;

import com.charl.seckill.common.utils.BeanUtil;
import com.charl.seckill.dao.SkuRepository;
import com.charl.seckill.entity.Sku;
import com.charl.seckill.service.ISkuService;
import com.charl.seckill.vo.SkuVo;
import com.charl.seckill.vo.request.QuerySkuVo;
import com.charl.seckill.vo.response.PageResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-09-06 16:37
 **/
@Service
public class SkuService implements ISkuService {

    @Autowired
    private SkuRepository skuRepository;

    @Override
    public int createSku(SkuVo vo) {
        Sku sku = BeanUtil.copy(vo, Sku.class);
        Date date = new Date();
        sku.setAddTime(date);
        sku.setUpdateTime(date);

        Sku save = skuRepository.save(sku);
        return save.getId();
    }

    @Override
    public int updateSkc(SkuVo vo) {
        Sku sku = BeanUtil.copy(vo, Sku.class);
        Sku save = skuRepository.save(sku);
        return save.getId();
    }

    @Override
    public PageResponseVo<SkuVo> getSkuList(QuerySkuVo vo) {
        Pageable pageable = PageRequest.of(vo.getPageNo(), vo.getPageSize(), Sort.Direction.ASC, "id");
        Specification<Sku> skuSpecification = new Specification<Sku>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                Predicate p1 = criteriaBuilder.equal(root.get("state").as(Integer.class), vo.getState());
                query.where(criteriaBuilder.and(p1));
                return query.getRestriction();
            }
        };

        Page<Sku> skuPage = skuRepository.findAll(skuSpecification, pageable);
        List<SkuVo> skuVos = BeanUtil.copyList(skuPage.getContent(), SkuVo.class);

        return PageResponseVo.buildPageVo(skuVos, (int) skuPage.getTotalElements());
    }

}
