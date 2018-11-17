package com.fly.rq_house_service;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//Mybatis 扫描mapper包路径
@MapperScan("com.fly.rq_house_service.mapper")
//开启feign
@EnableFeignClients
//开启Hystrix
@EnableCircuitBreaker
public class RqHouseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RqHouseServiceApplication.class, args);
	}


	//配置阿里巴巴druid数据源
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DruidDataSource druidDataSource(){
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}
}
