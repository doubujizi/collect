package com.dou.tfx.prefect.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/8/26 10:13
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTest {
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

    private String password1;
}
