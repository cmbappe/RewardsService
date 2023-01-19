package com.example.rewardsservice.service;

import com.example.rewardsservice.entity.Customer;
import com.example.rewardsservice.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RewardsService {
    @Autowired
    CustomerService customerService;
    @Autowired
    TransactionService transactionService;

    public Integer getCustomerTotalReward(Customer customer) {
        List<Transaction> transactionList = customer.getTransactions();
        return ComputePoints(transactionList);
    }
    public Integer getCustomerMonthlyReward(Customer customer, Integer month) {
        List<Transaction> transactionList = transactionService.getTransactionsByCustomerAndTransactionMonth(customer, month);
        return ComputePoints(transactionList);
    }
    private Integer ComputePoints(List<Transaction> transactionList) {
        if(transactionList == null || transactionList.isEmpty())
            return 0;
        Integer totalPoints = 0;
        for(Transaction transaction : transactionList){
            int amount = transaction.getAmount().intValue();

            if( amount > 50)
                totalPoints += amount - 50;
            if(amount > 100)
                totalPoints += amount - 100;
        }
        return totalPoints;
    }
}
