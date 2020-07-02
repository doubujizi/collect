package com.dou.tfx.prefect.config.datasource;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/5/9 16:04
 */
public class DataSourceType {
    //内部枚举类，用于选择特定的数据类型
    public enum DataBaseType {
        Primary, Secondary
    }

    // 使用ThreadLocal保证线程安全
    private static final ThreadLocal<DataBaseType> TYPE = new ThreadLocal<>();

    // 往当前线程里设置数据源类型
    public static void setDataBaseType(DataBaseType dataBaseType) {
        if (dataBaseType == null) {
            throw new NullPointerException();
        }
        TYPE.set(dataBaseType);
    }

    // 获取数据源类型
    public static DataBaseType getDataBaseType() {
        DataBaseType dataBaseType = TYPE.get() == null ? DataBaseType.Primary : TYPE.get();
        return dataBaseType;
    }

    // 清空数据类型
    public static void clearDataBaseType() {
        TYPE.remove();
    }
}

