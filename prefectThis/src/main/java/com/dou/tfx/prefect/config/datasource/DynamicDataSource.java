package com.dou.tfx.prefect.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/9 16:04
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
        return dataBaseType;
    }

}

