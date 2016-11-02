package com.ksimeo.ya.tutorial.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


/**
 * Created by Avega on 29.09.14.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.ksimeo.ya.tutorial.dao")
public class JPAConfiguration {
    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        //MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/movies");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws ClassNotFoundException {
        HibernateJpaVendorAdapter hibernateAdapter = new HibernateJpaVendorAdapter();
        hibernateAdapter.setGenerateDdl(true);
        hibernateAdapter.setShowSql(true);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setJpaVendorAdapter(hibernateAdapter);
        entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactory.setPackagesToScan("com.ksimeo.ya.tutorial.models");
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

    @Bean
    public EntityManager createEntityManager(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(emf);

        return tm;
    }

    @Bean
    public HibernateExceptionTranslator exceptionTranslator() {
        return  new HibernateExceptionTranslator();
    }
}

