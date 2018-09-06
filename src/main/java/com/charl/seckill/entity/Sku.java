package com.charl.seckill.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-08-27 14:53
 **/
@Entity
@Data
public class Sku {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片
     */
    private String image;

    /**
     * 描述
     */
    private String desc;

    /**
     * 原价
     */
    private BigDecimal originPrice;

    /**
     * 售价
     */
    private BigDecimal sellPrice;

    /**
     * 状态：0.下架 1.上架
     */
    private Integer state;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
