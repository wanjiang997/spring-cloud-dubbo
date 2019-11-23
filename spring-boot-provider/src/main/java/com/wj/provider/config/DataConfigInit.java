package com.wj.provider.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: wanjiang
 * Date: 2019/11/23
 * Time: 14:10
 */
@Configuration
@Slf4j
public class DataConfigInit {

    private static final Logger logger = LoggerFactory.getLogger(DataConfigInit.class);

    @Primary
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        logger.info("===============primaryDataSource init====================");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "primaryDataSourceJdbcTemplate")
    public JdbcTemplate primaryDataSourceJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "spareDataSource")
    @Qualifier("spareDataSources")
    @ConfigurationProperties(prefix = "spring.datasource.spare")
    public DataSource spareDataSource(){
        logger.info("===============spareDataSource init====================");
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "spareDataSourceJdbcTemplate")
    public JdbcTemplate drmpDataSourceJdbcTemplate(@Qualifier("spareDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
