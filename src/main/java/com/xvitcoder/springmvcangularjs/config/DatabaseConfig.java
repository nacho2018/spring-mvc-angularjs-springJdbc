package com.xvitcoder.springmvcangularjs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

	@Bean
	public DriverManagerDataSource dataSource() {

		DriverManagerDataSource bds = new DriverManagerDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		bds.setUsername("root");
		bds.setPassword("admin");

		return bds;
	}
	
	@Bean
	DataSourceTransactionManager transactionManager(){
		
		return new DataSourceTransactionManager(dataSource());
	}
}
