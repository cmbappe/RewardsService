package com.example.rewardsservice.repository;

import com.example.rewardsservice.entity.Customer;
import com.example.rewardsservice.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE customer=:customer AND MONTH(transactionDate) = :month")
    List<Transaction> getTransactionsByCustomerAndTransactionMonth(Customer customer,Integer month);
}
