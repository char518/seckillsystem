package com.charl.seckill.service;

import com.charl.seckill.vo.SkuVo;
import com.charl.seckill.vo.request.QuerySkuVo;
import com.charl.seckill.vo.response.PageResponseVo;

import java.util.List;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-09-06 16:25
 **/
public interface ISkuService {

    int createSku(SkuVo vo);

    int updateSkc(SkuVo vo);

    PageResponseVo<SkuVo> getSkuList(QuerySkuVo vo);

}
