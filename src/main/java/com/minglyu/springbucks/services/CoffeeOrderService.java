package com.minglyu.springbucks.services;

import com.minglyu.springbucks.entities.Coffee;
import com.minglyu.springbucks.entities.CoffeeOrder;
import com.minglyu.springbucks.repositories.CoffeeOrderRepository;
import com.minglyu.springbucks.repositories.CoffeeRepository;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class CoffeeOrderService {

    @Autowired
    CoffeeRepository coffeeRepository;

    @Autowired
    CoffeeOrderRepository coffeeOrderRepository;

    public void create() {
        Coffee latte = Coffee.builder()
                .name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        coffeeRepository.save(latte);

        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 40.0))
                .build();
        coffeeRepository.save(espresso);


        CoffeeOrder coffeeOrder = CoffeeOrder.builder()
                .customer("Li Lei")
                .coffees(Collections.singletonList(espresso))
                .build();

        coffeeOrderRepository.save(coffeeOrder);

        coffeeOrder = CoffeeOrder.builder()
                .customer("Han Meimei")
                .coffees(Arrays.asList(latte, espresso))
                .build();
        coffeeOrderRepository.save(coffeeOrder);

    }

}
