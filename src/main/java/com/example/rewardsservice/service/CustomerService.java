package com.example.rewardsservice.service;

import com.example.rewardsservice.entity.Customer;
import com.example.rewardsservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repo;

    public List<Customer> getAll(){
        return repo.findAll();
    }

    public Optional<Customer> getOneById(Long id){
        return repo.findById(id);
    }

    public void save(Customer customer){
        repo.save(customer);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
