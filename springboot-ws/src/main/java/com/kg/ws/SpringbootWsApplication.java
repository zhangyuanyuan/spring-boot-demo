package com.kg.ws;

import com.kg.ws.support.CustomerRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomerRepositoryFactoryBean.class)
@EnableCaching
public class SpringbootWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWsApplication.class, args);
	}
}
