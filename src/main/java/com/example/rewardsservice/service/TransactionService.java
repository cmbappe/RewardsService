package com.example.rewardsservice.service;

import com.example.rewardsservice.entity.Customer;
import com.example.rewardsservice.entity.Transaction;
import com.example.rewardsservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository repo;

    public List<Transaction> getAll(){
        return repo.findAll();
    }

    public Optional<Transaction> getOneById(Long id){
        return repo.findById(id);
    }
    public List<Transaction> getTransactionsByCustomerAndTransactionMonth(Customer customer, Integer month){
        return repo.getTransactionsByCustomerAndTransactionMonth(customer, month);
    }

    public List<Transaction> findbyMonth(Integer month){
        return repo.findByMonth(month);
    }
    public void save(Transaction transaction){
        repo.save(transaction);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
