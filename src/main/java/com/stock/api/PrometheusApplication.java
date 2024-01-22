package com.stock.api;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class PrometheusApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrometheusApplication.class, args);
	}

}
