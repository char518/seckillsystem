package com.charl.seckill.dao;

import com.charl.seckill.entity.SecEventDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-09-06 16:21
 **/
@Repository
public interface SecEventDetailRepository extends JpaRepository<SecEventDetail, Integer>, JpaSpecificationExecutor<SecEventDetail> {
}
