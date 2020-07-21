package com.ming.bns.system.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hikari")
public class DBProperties {
    private HikariDataSource dataSource1;
    private HikariDataSource dataSource2;

    public DBProperties() {
    }

    public HikariDataSource getDataSource1() {
        return dataSource1;
    }

    public void setDataSource1(HikariDataSource dataSource1) {
        this.dataSource1 = dataSource1;
    }

    public HikariDataSource getDataSource2() {
        return dataSource2;
    }

    public void setDataSource2(HikariDataSource dataSource2) {
        this.dataSource2 = dataSource2;
    }
}
