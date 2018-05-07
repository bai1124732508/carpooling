package com.carpooling.run;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.carpooling.**.dao")
@ComponentScan("com.carpooling")
public class Application {
	public static void main(String[] args) {
		SpringApplication springapp = new SpringApplication(Application.class);
		springapp.run(args);
    }

}
