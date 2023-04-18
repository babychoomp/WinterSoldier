package com.dami.wintersoldier.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration					// DbConfig.java 클래스가 Spring Container에서 빈 객체를 생성하고 관리하기 위한 설정 정보를 제공
@EnableTransactionManagement	// DbConfig.java 클래스에서 트랜잭션 관리 기능을 사용 가능. 메서드 내에서 실행되는 모든 데이터베이스 작업은 하나의 트랜잭션으로 묶이게 됨. 하나의 메소드가 실패하면 전체 메소드의 실패로 간주하여 
public class DbConfig {
	
	@Bean(destroyMethod = "close")
	// 해당 빈 객체가 스프링 컨테이너에서 삭제될 때 close() 메서드를 호출하여 객체에서 사용한 자원을 안전하게 해제할 수 있도록 지정
	DataSource dataSource() { 
		// @Bean annotation은 dataSource() 메서드가 빈 객체를 정의하는 매서드임을 나타냄
		// 해당 메서드를 호출하면 데이터 소스 객체가 생성되어 반환됨
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/wsdb?autoReconnect=true&serverTimezone=UTC&characterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setMaxIdle(5);
		dataSource.setMinIdle(0);
		dataSource.setDefaultAutoCommit(false);
		
		return dataSource;
	}
	
	@Bean
	DataSourceTransactionManager transactionManager() {  
		return new DataSourceTransactionManager(dataSource());
	}
	

}