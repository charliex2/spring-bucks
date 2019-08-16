package com.minglyu.springbucks;

import com.minglyu.springbucks.services.CoffeeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBucksApplication {

    @Autowired
    CoffeeOrderService coffeeOrderService;
    public static void main(String[] args) {
        SpringApplication.run(SpringBucksApplication.class, args);
    }

}
