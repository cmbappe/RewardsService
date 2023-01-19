package com.example.rewardsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerPoints {

    private Customer customer;
    private Integer points;
}
