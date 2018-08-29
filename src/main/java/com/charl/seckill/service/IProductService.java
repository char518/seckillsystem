package com.charl.seckill.service;

import com.charl.seckill.entity.Goods;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-08-27 15:21
 **/
public interface IProductService {

    Goods queryGoodById(Integer id);

}
