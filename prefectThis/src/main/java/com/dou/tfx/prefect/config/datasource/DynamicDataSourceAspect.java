package com.dou.tfx.prefect.config.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/9 16:05
 */
@Aspect
@Order(-1)// 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    //拦截注解
    @Before("@annotation(dataSource)")
    public void changeDataSource(JoinPoint point, DataSource dataSource) throws Throwable {
        String value = dataSource.value();
        if (value.equals("primary")) {
            DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Primary);
        } else if (value.equals("secondary")) {
            DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Secondary);
        } else {
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", dataSource.value(), point.getSignature());
            DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Primary);//默认使用主数据库
        }

    }

    @After("@annotation(dataSource)") //清除数据源的配置
    public void restoreDataSource(JoinPoint point, DataSource dataSource) {
        logger.debug("Revert DataSource : {} > {}", dataSource.value(), point.getSignature());
        DataSourceType.clearDataBaseType();

    }
}
