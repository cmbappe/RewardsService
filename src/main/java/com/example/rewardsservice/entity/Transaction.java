package com.example.rewardsservice.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    Long id;

    Date transactionDate;

    Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    Customer customer;

    public Transaction(Customer customer, Double amount, Date transactionDate){
        this.customer = customer;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

}
