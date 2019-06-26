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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by chenjunhong06 on 2019/6/20.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryGdpiccaims",
        transactionManagerRef="transactionManagerGdpiccaims",
        basePackages= { "com.example.demo.service.gdpiccaims" }) //设置Repository所在位置
public class GdpiccaimsDataSourceConfig {

    @Autowired @Qualifier("gdpiccaimsDataSource")
    private DataSource gdpiccaimsDataSource;

    @Primary
    @Bean(name = "entityManagerGdpiccaims")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryGdpiccaims(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryGdpiccaims")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryGdpiccaims (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(gdpiccaimsDataSource)
                .properties(getVendorProperties(gdpiccaimsDataSource))
                .packages("com.example.demo.domain.gdpiccaims") //设置实体类所在位置
                .persistenceUnit("gdpiccaimsPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerGdpiccaims")
    public PlatformTransactionManager transactionManagerGdpiccaims(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryGdpiccaims(builder).getObject());
    }

}
