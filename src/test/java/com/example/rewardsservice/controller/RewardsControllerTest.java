package com.example.rewardsservice.controller;

import com.example.rewardsservice.entity.Customer;
import com.example.rewardsservice.entity.CustomerPoints;
import com.example.rewardsservice.entity.Transaction;
import com.example.rewardsservice.exception.CustomerNotFoundException;
import com.example.rewardsservice.exception.TransactionNotFoundException;
import com.example.rewardsservice.service.CustomerService;
import com.example.rewardsservice.service.RewardsService;
import com.example.rewardsservice.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RewardsControllerTest {

    @InjectMocks
    private RewardsController rewardsController;

    @Mock
    private CustomerService customerService;

    @Mock
    private TransactionService transactionService;

    @Mock
    private RewardsService rewardsService;

    @Test
    public void testGetCustomerTotalReward_validId_returnsPoints() {

        Long id = 1L;
        Customer customer = new Customer("Joe Average");
        when(customerService.getOneById(id)).thenReturn(Optional.of(customer));
        Integer totalPoints = 100;
        when(rewardsService.getCustomerTotalReward(customer)).thenReturn(totalPoints);

        ResponseEntity<CustomerPoints> response = rewardsController.getCustomerTotalReward(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody().getCustomer());
        assertEquals(totalPoints, response.getBody().getPoints());
    }

    @Test
    public void testGetCustomerTotalReward_invalidId_throwsException() {

        Long id = 1L;
        when(customerService.getOneById(id)).thenReturn(Optional.empty());

        try {
            rewardsController.getCustomerTotalReward(id);
            fail();
        } catch (CustomerNotFoundException e) {
            assertEquals(String.format("Customer %s not found", id), e.getMessage());
        }
    }

    @Test
    public void testGetCustomerMonthlyReward_validIdAndMonth_returnsPoints() throws Exception {

        Long id = 1L;
        Integer month = 1;
        Customer customer = new Customer("Joe Average");
        when(customerService.getOneById(id)).thenReturn(Optional.of(customer));

        List<Transaction> transactions = Arrays.asList(
                new Transaction(customer, 120.0, new Date("01/04/2023")),
                new Transaction(customer, 70.0, new Date("01/15/2023"))
        );
        when(transactionService.findbyMonth(month)).thenReturn(transactions);
        Integer totalPoints = 110;
        when(rewardsService.getCustomerMonthlyReward(customer, month)).thenReturn(totalPoints);

        ResponseEntity<CustomerPoints> response = rewardsController.getCustomerMonthlyReward(id, month);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody().getCustomer());
        assertEquals(totalPoints, response.getBody().getPoints());
    }

    @Test
    public void testGetCustomerMonthlyReward_invalidId_throwsException() {

        Long id = 1L;
        Integer month = 1;
        when(customerService.getOneById(id)).thenReturn(Optional.empty());

        try {
            rewardsController.getCustomerMonthlyReward(id, month);
            fail();
        } catch (CustomerNotFoundException e) {
            assertEquals(String.format("Customer %s not found", id), e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetCustomerMonthlyReward_invalidMonth_throwsException() {

        Long id = 1L;
        Integer month = 1;
        Customer customer = new Customer("Joe Average");
        when(customerService.getOneById(id)).thenReturn(Optional.of(customer));

        when(transactionService.findbyMonth(month)).thenReturn(new ArrayList());

        try {
            rewardsController.getCustomerMonthlyReward(id, month);
            fail();
        } catch (TransactionNotFoundException e) {
            assertEquals(String.format("No transaction found for month %d", month), e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}