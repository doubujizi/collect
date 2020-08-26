package com.dou.tfx.prefect.dao;

import com.dou.tfx.prefect.enity.User;
import com.dou.tfx.prefect.enity.UserTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Mybatis Generator 2020/04/28
 */
@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);
    UserTest selectByPrimaryKey1();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
