package com.charl.seckill.service.impl;

import com.charl.seckill.dao.GoodsRepository;
import com.charl.seckill.entity.Goods;
import com.charl.seckill.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private GoodsRepository goodsRepository;

    @Override
    public Goods queryGoodById(Integer id) {

        Optional<Goods> byId = goodsRepository.findById(id);

        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }
}
