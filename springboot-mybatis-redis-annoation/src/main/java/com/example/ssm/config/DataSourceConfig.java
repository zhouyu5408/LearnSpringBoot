package com.example.ssm.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = { DataSourceConfig.PACKAGE })
public class DataSourceConfig {

	static final String PACKAGE = "com.example.ssm.dao";
	static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String user;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClass;

	@Bean
	public DataSource mysqlDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(mysqlDataSource());
		sessionFactoryBean.setConfigLocation(new ClassPathResource("/config/mybatis/mybatis_cfg.xml"));
		sessionFactoryBean
				.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
		return sessionFactoryBean;
	}

	/**
	 * 事务 管理
	 * 
	 * @param driverManagerDataSource
	 * @return
	 */
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource driverManagerDataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(driverManagerDataSource);
		return transactionManager;
	}
}
