package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.example.demo")
public class DemoApplication {

	public static void main(String[] args) {

		// https://fuji.lmq.cloudamqp.com/exchange#vhost=omlpscph&name=bdmg.analise.exchange
		// https://api.cloudamqp.com/console/e31355e4-953f-4887-aaa9-e3179bf3dc27/details

		System.out.println("Subindo o Motor de Crédito");
		SpringApplication.run(DemoApplication.class, args);
	}

}
