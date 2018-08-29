package com.charl.seckill.dao;

import com.charl.seckill.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-08-27 15:18
 **/
@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
}
