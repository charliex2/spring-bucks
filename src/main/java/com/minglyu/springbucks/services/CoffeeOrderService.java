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
                // Collections.singletonList
                // 这个方法主要用于只有一个元素的优化，减少内存分配，无需分配额外的内存，可以从SingletonList内部类看得出来,由于只有一个element,因此可以做到内存分配最小化，相比之下ArrayList的DEFAULT_CAPACITY=10个。
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
