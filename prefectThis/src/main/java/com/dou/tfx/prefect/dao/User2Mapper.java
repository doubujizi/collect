package com.dou.tfx.prefect.dao;

import com.dou.tfx.prefect.config.datasource.DataSource;
import com.dou.tfx.prefect.enity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/9 16:08
 */
@Repository
@Mapper
public interface User2Mapper {
    int deleteByPrimaryKey(Long id);

    @DataSource("secondary")
    int insert(User record);

    int insertSelective(User record);

    @DataSource("secondary")
    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
