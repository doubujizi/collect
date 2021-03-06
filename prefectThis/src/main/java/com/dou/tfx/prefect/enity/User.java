package com.dou.tfx.prefect.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Mybatis Generator 2020/04/28
 */
@AllArgsConstructor
@NoArgsConstructor
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

    private Phone phone;
}
