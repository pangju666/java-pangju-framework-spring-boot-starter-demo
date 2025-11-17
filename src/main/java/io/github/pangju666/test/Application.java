package io.github.pangju666.test;

//import org.mybatis.spring.annotation//.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan("io.github.pangju666.test.mapper")
@SpringBootApplication
public class Application {
	void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
