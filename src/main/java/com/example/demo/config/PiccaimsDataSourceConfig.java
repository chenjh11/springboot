package com.example.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by chenjunhong06 on 2019/6/20.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryPiccaims",
        transactionManagerRef="transactionManagerPiccaims",
        basePackages= { "com.example.demo.service.piccaims" }) //设置Repository所在位置
public class PiccaimsDataSourceConfig {
    @Autowired @Qualifier("piccaimDataSource")
    private DataSource piccaimDataSource;

    @Bean(name = "entityManagerPiccaims")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPiccaims(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryPiccaims")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPiccaims (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(piccaimDataSource)
                .properties(getVendorProperties(piccaimDataSource))
                .packages("com.example.demo.domain.piccaims") //设置实体类所在位置
                .persistenceUnit("piccaimsPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "transactionManagerPiccaims")
    PlatformTransactionManager transactionManagerPiccaims(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPiccaims(builder).getObject());
    }



}
