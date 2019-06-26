package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by chenjunhong06 on 2019/6/20.
 */
@Configuration
public class DataSourceConfig {
    /*创建gdpiccaims的datasource实例
    * */
     //主源
    @Bean(name = "gdpiccaimsDataSource")
    @Qualifier("gdpiccaimsDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }
    /*创建webshopdb的DataSource实例
    * */
    @Bean(name = "piccaimDataSource")
    @Qualifier("piccaimDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

}
