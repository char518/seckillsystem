package com.charl.seckill.service;

import com.charl.seckill.entity.Sku;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-08-27 15:21
 **/
public interface IProductService {

    Sku queryGoodById(Integer id);

    int addGood(Sku goods);

    int updateGoods(Sku goods);

}
