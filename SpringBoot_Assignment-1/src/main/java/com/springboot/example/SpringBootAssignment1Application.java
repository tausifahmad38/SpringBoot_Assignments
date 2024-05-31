package com.springboot.example;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootAssignment1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignment1Application.class, args);
	}
	@Bean
    public CommandLineRunner returnBeans(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            System.out.println("\n*********************Beans************************\n");
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }         };    }   

}
