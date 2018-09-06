package com.charl.seckill.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-09-06 15:58
 **/
@Data
@Entity
public class SecEventDetail {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    /**
     * 关键事件id
     */
    private Integer eventId;

    /**
     * 商品skc列表
     */
    private Integer skuId;

    /**
     * 需要卖出的库存数量
     */
    private Integer stock;

    /**
     * 状态：0.上架 1.下架
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
