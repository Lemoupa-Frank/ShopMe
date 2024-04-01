package com.ShopME.ShopME;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShopMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopMeApplication.class, args);
	}

}
