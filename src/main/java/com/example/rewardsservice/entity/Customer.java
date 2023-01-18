package com.example.rewardsservice.entity;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactions;

    public Customer(String name){
        this.name = name;
    }
}
