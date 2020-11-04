package com.ordermanagements.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermanagements.demo.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	//public Mono<Customer> getAllCustomer();
}
