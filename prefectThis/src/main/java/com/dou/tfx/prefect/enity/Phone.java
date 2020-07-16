package com.dou.tfx.prefect.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/7/15 16:55
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Phone {
    private Long id;
    private String name;
    private String phoneNumber;
}
