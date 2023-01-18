package com.example.rewardsservice;

import com.example.rewardsservice.entity.Customer;
import com.example.rewardsservice.entity.Transaction;
import com.example.rewardsservice.service.CustomerService;
import com.example.rewardsservice.service.TransactionService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class RewardsServiceApplication {

	@Autowired
	CustomerService customerService;
	@Autowired
	TransactionService transactionService;

	public static void main(String[] args) {
		SpringApplication.run(RewardsServiceApplication.class, args);
	}

	@Bean
	InitializingBean loadInitData(){
		return () -> {
			Customer chrisM = new Customer("Christian Mbappe");
			Customer johnD  = new Customer("John Doe");
			Customer allieB = new Customer("Allie Burnrow");

			customerService.save(chrisM);
			customerService.save(johnD);
			customerService.save(allieB);

			transactionService.save(new Transaction(chrisM, 120.0, new Date("11/24/2022")));
			transactionService.save(new Transaction(chrisM, 40.0, new Date("12/15/2022")));
			transactionService.save(new Transaction(chrisM, 70.0, new Date("01/03/2023")));
			transactionService.save(new Transaction(johnD, 160.0, new Date("01/15/2023")));
			transactionService.save(new Transaction(johnD, 95.0, new Date("01/16/2023")));
			transactionService.save(new Transaction(allieB, 50.0, new Date("11/30/2022")));
			transactionService.save(new Transaction(allieB, 100.0, new Date("12/23/2022")));
		};
	}

}
