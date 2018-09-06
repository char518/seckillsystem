package com.charl.seckill.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-09-06 16:26
 **/
@Data
@ApiModel("商品skuVo")
public class SkuVo {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String image;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String desc;

    /**
     * 原价
     */
    @ApiModelProperty(value = "原价")
    private BigDecimal originPrice;

    /**
     * 售价
     */
    @ApiModelProperty(value = "售价")
    private BigDecimal sellPrice;

    /**
     * 状态：0.下架 1.上架
     */
    @ApiModelProperty(value = "状态：0.下架 1.上架")
    private Integer state;

}
