package com.khan.learn_spring_aop;

import com.khan.learn_spring_aop.aopexample.business.BusinessService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final BusinessService1 businessService1;

    public LearnSpringAopApplication(BusinessService1 businessService1) {
        this.businessService1 = businessService1;
    }

    public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) {
		logger.info("Value returned from business service 1: {}", businessService1.calculateMax());
	}
}
