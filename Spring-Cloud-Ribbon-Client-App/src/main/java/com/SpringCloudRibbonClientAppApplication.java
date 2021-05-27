package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.client.config.IClientConfig;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="productserver" , configuration = RibbonConfiguration.class)
public class SpringCloudRibbonClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbonClientAppApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
