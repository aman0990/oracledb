package com.example.oracledb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.RepoInterface.CustomerRepository")
//@ComponentScan(basePackages = {"com.example.*"})
public class OrderMgmtApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderMgmtApplication.class, args);
	}
}