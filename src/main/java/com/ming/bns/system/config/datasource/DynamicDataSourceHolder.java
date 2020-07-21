package com.ming.bns.system.config.datasource;

/**
 * 线程共享工具
 * 动态数据源持有者，负责利用ThreadLocal存取数据源名称
 * 数据源信息要保证在同一线程下切换后不要被其他线程修改，
 * 所以我们将数据源信息保存在ThreadLocal共享中
 */
public class DynamicDataSourceHolder {
    /**
     * 本地线程共享对象
     */
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void putDataSource(String name) {
        THREAD_LOCAL.set(name);
    }

    public static String getDataSource() {
        return THREAD_LOCAL.get();
    }

    public static void removeDataSource() {
        THREAD_LOCAL.remove();
    }
}
