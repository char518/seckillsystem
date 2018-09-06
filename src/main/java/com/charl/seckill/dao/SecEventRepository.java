package com.charl.seckill.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @program: seckill
 * @description:
 * @author: charl
 * @create: 2018-09-06 16:20
 **/
@Repository
public interface SecEventRepository extends JpaRepository<SecEventRepository, Integer>, JpaSpecificationExecutor<SecEventRepository> {
}
