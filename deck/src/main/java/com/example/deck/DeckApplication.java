package com.example.deck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DeckApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeckApplication.class, args);
	}

}
