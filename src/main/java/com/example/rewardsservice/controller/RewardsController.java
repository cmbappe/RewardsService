package com.example.rewardsservice.controller;

import com.example.rewardsservice.entity.Customer;
import com.example.rewardsservice.service.CustomerService;
import com.example.rewardsservice.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RewardsController {
    @Autowired
    CustomerService customerService;
    @Autowired
    RewardsService rewardsService;


    @GetMapping("/rewards-service/customers/{id}")
    public String getCustomerTotalReward(@PathVariable Long id) throws Exception{
        Optional<Customer> customer = customerService.getOneById(id);
        if(!customer.isPresent()){
            throw new Exception("No Customer found!");
        }

        Integer totalPoints = rewardsService.getCustomerTotalReward(customer.get());
        return String.format("Customer: %s\n Total Reward: %d", customer.get().getName(), totalPoints);
    }

    @GetMapping("/rewards-service/customers/{id}/{month}")
    public String getCustomerMonthlyReward(@PathVariable Long id, @PathVariable Integer month) throws Exception {
        Optional<Customer> customer = customerService.getOneById(id);
        if(!customer.isPresent()){
            throw new Exception("No Customer found!");
        }

        Integer totalPoints = rewardsService.getCustomerMonthlyReward(customer.get(), month);
        return String.format("Customer: %s\n Total Reward: %d", customer.get().getName(), totalPoints);
    }
}
