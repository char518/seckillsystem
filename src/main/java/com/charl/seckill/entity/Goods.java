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
public class Goods {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String image;

    private BigDecimal originPrice;

    private BigDecimal sellPrice;

    private Integer stock;

    private Integer userId;

    private Date createTime;

    private Date updateTime;

    private Integer delFlag;

}
