package com.dou.tfx.prefect.config.datasource;

import java.lang.annotation.*;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/9 16:03
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value() default "primary"; //该值即key值，默认使用默认数据库
}
