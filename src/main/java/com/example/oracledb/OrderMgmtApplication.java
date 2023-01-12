package com.example.oracledb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class OrderMgmtApplication {
	public static void main(String[] args) {SpringApplication.run(OrderMgmtApplication.class, args);
	}
}