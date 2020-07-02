package com.dou.tfx.prefect.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/9 16:05
 */
@Configuration
@MapperScan(basePackages = "com.dou.tfx.prefect.dao", sqlSessionFactoryRef = "SqlSessionFactory")
@Slf4j
public class DynamicDataSourceConfig {
    @Value("${spring.datasource.primary.driver-class-name}")
    private String driverPrimary;
    @Value("${spring.datasource.primary.url}")
    private String urlPrimary;
    @Value("${spring.datasource.primary.username}")
    private String userNamePrimary;
    @Value("${spring.datasource.primary.password}")
    private String passwordPrimary;


    // 将这个对象放入Spring容器中
    @Bean(name = "primaryDataSource")
    // 表示这个数据源是默认数据源
    @Primary
    // 读取application.properties中的配置参数映射成为一个对象
    // prefix表示参数的前缀
    public javax.sql.DataSource getDateSource1() {
        // 创建基础hikari数据源
        log.info("开始初始化数据库(1)配置...");
        DataSourceBuilder<HikariDataSource> hikariDataSourceBuilder = DataSourceBuilder.create().type(HikariDataSource.class);
        HikariDataSource hikariDataSource = hikariDataSourceBuilder.driverClassName(driverPrimary).url(urlPrimary).username(userNamePrimary).password(passwordPrimary).build();
        hikariDataSource.setAutoCommit(true);//update自动提交设置
        hikariDataSource.setConnectionTestQuery("select 1");//连接查询语句设置
        hikariDataSource.setConnectionTimeout(3000);//连接超时时间设置
        hikariDataSource.setIdleTimeout(600000);//连接空闲生命周期设置
        hikariDataSource.setIsolateInternalQueries(false);//执行查询启动设置
        hikariDataSource.setMaximumPoolSize(3000);//连接池允许的最大连接数量
        hikariDataSource.setMaxLifetime(1800000);//检查空余连接优化连接池设置时间,单位毫秒
        hikariDataSource.setMinimumIdle(10);//连接池保持最小空余连接数量
        hikariDataSource.setPoolName("hikariPoolPrimary");//连接池名称
        return hikariDataSource;
    }


    @Value("${spring.datasource.secondary.driver-class-name}")
    private String driverSecondary;
    @Value("${spring.datasource.secondary.url}")
    private String urlSecondary;
    @Value("${spring.datasource.secondary.username}")
    private String userNameSecondary;
    @Value("${spring.datasource.secondary.password}")
    private String passwordSecondary;

    @Bean(name = "secondaryDataSource")

    public javax.sql.DataSource getDateSource2() {
        // 创建基础hikari数据源
        log.info("开始初始化数据库(2)配置...");
        DataSourceBuilder<HikariDataSource> hikariDataSourceBuilder = DataSourceBuilder.create().type(HikariDataSource.class);
        HikariDataSource hikariDataSource = hikariDataSourceBuilder.driverClassName(driverSecondary).url(urlSecondary).username(userNameSecondary).password(passwordSecondary).build();
        hikariDataSource.setAutoCommit(true);//update自动提交设置
        hikariDataSource.setConnectionTestQuery("select 2");//连接查询语句设置
        hikariDataSource.setConnectionTimeout(3000);//连接超时时间设置
        hikariDataSource.setIdleTimeout(600000);//连接空闲生命周期设置
        hikariDataSource.setIsolateInternalQueries(false);//执行查询启动设置
        hikariDataSource.setMaximumPoolSize(3000);//连接池允许的最大连接数量
        hikariDataSource.setMaxLifetime(1800000);//检查空余连接优化连接池设置时间,单位毫秒
        hikariDataSource.setMinimumIdle(10);//连接池保持最小空余连接数量
        hikariDataSource.setPoolName("hikariPoolSecondary");//连接池名称
        return hikariDataSource;
    }

    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("primaryDataSource") javax.sql.DataSource primaryDataSource,
                                        @Qualifier("secondaryDataSource") javax.sql.DataSource secondaryDataSource) {

        //这个地方是比较核心的targetDataSource 集合是我们数据库和名字之间的映射
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.DataBaseType.Primary, primaryDataSource);
        targetDataSource.put(DataSourceType.DataBaseType.Secondary, secondaryDataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(primaryDataSource);//设置默认对象
        return dataSource;
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*Mapper.xml"));//设置我们的xml文件路径
        return bean.getObject();
    }

    //@Bean
    //@Primary
    //public ChainedTransactionManager transactionManager(@Qualifier("primaryDataSource") DataSource primaryDataSource,
    //                                                    @Qualifier("secondaryDataSource") DataSource secondaryDataSource) {
    //    DataSourceTransactionManager primaryTransactionManager = new DataSourceTransactionManager(primaryDataSource);
    //    DataSourceTransactionManager secondaryTransactionManager = new DataSourceTransactionManager(
    //            secondaryDataSource);
    //    ChainedTransactionManager chainedTransactionManager = new ChainedTransactionManager(primaryTransactionManager,
    //            secondaryTransactionManager);
    //    return chainedTransactionManager;
    //}
}
