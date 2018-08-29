package com.charl.seckill.controller;

import com.charl.seckill.entity.Goods;
import com.charl.seckill.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-08-27 15:20
 **/
@RestController
@Api(value = "【秒杀系统】秒杀", description = "秒杀接口")
public class SeckillController {

    @Autowired
    private IProductService productService;

    @PostMapping(value = "/seckill/getProductById")
    @ApiOperation(value = "根据id查询商品信息")
    public Goods getProductById(@RequestBody Integer id) {
        Goods goods = productService.queryGoodById(id);
        return goods;
    }


}
