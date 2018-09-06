package com.charl.seckill.service.impl;

import com.charl.seckill.dao.SkuRepository;
import com.charl.seckill.entity.Sku;
import com.charl.seckill.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-08-27 15:22
 **/
@Service
public class ProductService implements IProductService {

    @Autowired
    private SkuRepository goodsRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Sku queryGoodById(Integer id) {

        Optional<Sku> byId = goodsRepository.findById(id);

        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    @Override
    public int addGood(Sku goods) {
        Sku save = goodsRepository.save(goods);
        return 1;
    }

    @Override
    public int updateGoods(Sku goods) {
        Sku save = goodsRepository.save(goods);
        return 1;
    }
}
