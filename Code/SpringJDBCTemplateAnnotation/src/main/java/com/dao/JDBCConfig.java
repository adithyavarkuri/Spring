package com.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("com.dao")
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
	
	@Bean public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(mysqlDataSource());
		return jdbcTemplate;
	}
	
	@Bean public NamedParameterJdbcTemplate namedJdbcTemplate() {
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(mysqlDataSource());
		return jdbcTemplate;
	}

	@Bean
	public SimpleJdbcInsert simpleJdbcInsert() {
		return new SimpleJdbcInsert(mysqlDataSource());
	}
	
	
	@Bean
	public SimpleJdbcCall simpleJdbcCall() {
		return new SimpleJdbcCall(mysqlDataSource());
	}
	
}
