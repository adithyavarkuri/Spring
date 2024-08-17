package com.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class JDBCConfig {
	
	@Bean public DataSource mysqlDataSource()
    {
        DriverManagerDataSource dataSource
            = new DriverManagerDataSource();
        dataSource.setDriverClassName(
            "com.mysql.jdbc.Driver");
        dataSource.setUrl(
            "jdbc:mysql://localhost:3306/JPA?characterEncoding=latin1");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
 
        return dataSource;
    }

}
