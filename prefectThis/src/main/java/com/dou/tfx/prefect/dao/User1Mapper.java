package com.dou.tfx.prefect.dao;

import com.dou.tfx.prefect.enity.User1;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
* Created by Mybatis Generator 2020/05/08
*/
@Repository
@Mapper
public interface User1Mapper {

    int deleteByPrimaryKey(Long id);

    int insert(User1 record);

    int insertSelective(User1 record);

    User1 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User1 record);

    int updateByPrimaryKey(User1 record);
}
