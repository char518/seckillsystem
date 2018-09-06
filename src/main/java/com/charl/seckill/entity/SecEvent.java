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
 * @create: 2018-09-06 15:56
 **/
@Data
@Entity
public class SecEvent {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    /**
     * 事件编号
     */
    private String eventNo;

    /**
     * 事件名称
     */
    private String eventName;

    /**
     * 事件开始事件
     */
    private Date startTime;

    /**
     * 事件结束事件
     */
    private Date endTime;

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
