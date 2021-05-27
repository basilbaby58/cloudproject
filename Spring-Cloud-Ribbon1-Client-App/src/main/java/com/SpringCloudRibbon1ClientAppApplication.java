package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.config.RibbonConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="productservercopy",configuration =RibbonConfiguration.class)
public class SpringCloudRibbon1ClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbon1ClientAppApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplatee() {
		return new RestTemplate();
	}

}
