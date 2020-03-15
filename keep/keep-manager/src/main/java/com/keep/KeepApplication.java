package com.keep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.keep.mapper")
public class KeepApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeepApplication.class, args);
	}

}
