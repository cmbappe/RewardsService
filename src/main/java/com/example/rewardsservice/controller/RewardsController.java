package com.example.rewardsservice.controller;

import com.example.rewardsservice.entity.Customer;
import com.example.rewardsservice.entity.CustomerPoints;
import com.example.rewardsservice.exception.CustomerNotFoundException;
import com.example.rewardsservice.exception.TransactionNotFoundException;
import com.example.rewardsservice.service.CustomerService;
import com.example.rewardsservice.service.RewardsService;
import com.example.rewardsservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 *
 */
@RestController
public class RewardsController {
    @Autowired
    CustomerService customerService;

    @Autowired
    TransactionService transactionService;
    @Autowired
    RewardsService rewardsService;


    @GetMapping("/rewards-service/customers/{id}")
    public ResponseEntity<CustomerPoints> getCustomerTotalReward(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getOneById(id);
        if(!customer.isPresent()){
            throw new CustomerNotFoundException(String.format("Customer %s not found", id));
        }

        Integer totalPoints = rewardsService.getCustomerTotalReward(customer.get());
        return new ResponseEntity<>( new CustomerPoints(customer.get(), totalPoints), HttpStatus.OK);
    }

    @GetMapping("/rewards-service/customers/{id}/{month}")
    public ResponseEntity<CustomerPoints> getCustomerMonthlyReward(@PathVariable Long id, @PathVariable Integer month) throws Exception {
        Optional<Customer> customer = customerService.getOneById(id);
        if(!customer.isPresent()){
            throw new CustomerNotFoundException(String.format("Customer %s not found", id));
        }

        if(transactionService.findbyMonth(month).isEmpty()){
            throw new TransactionNotFoundException(String.format("No transaction found for month %d", month));
        }

        Integer totalPoints = rewardsService.getCustomerMonthlyReward(customer.get(), month);
        return new ResponseEntity<>( new CustomerPoints(customer.get(), totalPoints), HttpStatus.OK);
    }
}
