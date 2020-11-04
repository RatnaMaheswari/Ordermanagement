package com.ordermanagements.demo.services;

import java.util.List;
import java.util.Optional;

import com.ordermanagements.demo.entities.Customer;
import com.ordermanagements.demo.entities.CustomerDto;

public interface CustomerService {

	// Mono<Customer> getAllCustomer();

	public Optional<Customer> getCustomerById(int customerId);

	// public Mono<Customer> addCustomer(Customer customer);
	public Customer addCustomer(CustomerDto customer);

	public Customer updateCustomer(int customerId, Customer customer);

	public void deleteCustomer(int customerId);

	public List<Customer> getAllCustomers();

	//Customer updateCustomer(int customerId, CustomerDto customerd) throws CustomerNotFoundException;
}
