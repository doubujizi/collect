package com.dou.tfx.prefect.enity;

import lombok.Data;

/**
* Created by Mybatis Generator 2020/04/28
*/
@Data
public class User {
    /**
	* 自增id
	*/
    private Long id;

    /**
	* 用户名
	*/
    private String name;

    /**
	* 密码
	*/
    private String password;
}