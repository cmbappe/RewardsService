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

    /**
     * Selects all transactions and provides result as a List<Transaction>
     * @return
     */
    public List<Transaction> getAll(){
        return repo.findAll();
    }

    /**
     * Takes id as input and returns one row as an Optional<Transaction>
     * @param id
     * @return
     */
    public Optional<Transaction> getOneById(Long id){
        return repo.findById(id);
    }

    /**
     * Takes customer and month as input and selects all transactions matching the WHERE clause
     * WHERE customer=:customer AND MONTH(transactionDate)=:month and returns a List<Transaction>
     * @param customer
     * @param month
     * @return
     */
    public List<Transaction> getTransactionsByCustomerAndTransactionMonth(Customer customer, Integer month){
        return repo.getTransactionsByCustomerAndTransactionMonth(customer, month);
    }

    /**
     * Takes month as input and returns all transactions matching the WHERE clause
     * WHERE MONTH(transactionDate)=:month and returns a List<Transaction>
     * @param month
     * @return
     */
    public List<Transaction> findbyMonth(Integer month){
        return repo.findByMonth(month);
    }

    /**
     * Takes an Object Transaction as input and saves it
     * @param transaction
     */
    public void save(Transaction transaction){
        repo.save(transaction);
    }

    /**
     * Takes PK(ID) as input and deletes Transaction Object data
     * @param id
     */
    public void delete(Long id){
        repo.deleteById(id);
    }
}
