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
    /**
     * Selects all Customers and provides result as a List<Customer>
     * @return
     */
    public List<Customer> getAll(){
        return repo.findAll();
    }

    /**
     * Takes id as input and returns one row as an Optional<Customer>
     * @param id
     * @return
     */
    public Optional<Customer> getOneById(Long id){
        return repo.findById(id);
    }

    /**
     * Takes an Object Customer as input and saves it
     * @param customer
     */
    public void save(Customer customer){
        repo.save(customer);
    }

    /**
     * Takes PK(ID) as input and deletes User Object data
     * @param id
     */
    public void delete(Long id){
        repo.deleteById(id);
    }
}
