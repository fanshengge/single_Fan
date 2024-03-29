package com.mbps.cd.movieservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ShenggeFan
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix // 启用Hystrix，需要加上此注解
public class MovieServiceApplication {

	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}
}
