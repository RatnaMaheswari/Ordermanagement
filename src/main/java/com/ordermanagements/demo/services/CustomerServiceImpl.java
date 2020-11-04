package com.ordermanagements.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagements.demo.entities.Customer;
import com.ordermanagements.demo.entities.CustomerDto;
import com.ordermanagements.demo.repo.CustomerRepository;
import com.ordermanagements.services.demo.exceptions.CustomerNotFoundException;

@Service


public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/*
	 * @Override public Mono<Customer> getAllCustomer() { return (Mono<Customer>)
	 * customerRepository.findAll();
	 * 
	 * }
	 */

	@Override
	public Optional<Customer> getCustomerById(int customerId)throws CustomerNotFoundException {

		return customerRepository.findById(customerId);
	}

	/*
	 * @Override public Customer updateCustomer(int customerId, Customer
	 * customer)throws CustomerNotFoundException {
	 * 
	 * Customer customerToBeUpdate = customerRepository.findById(customerId)
	 * .orElseThrow(CustomerNotFoundException::new);
	 * customerToBeUpdate.setCustomerName(customer.getCustomerName()); return
	 * customerRepository.save(customerToBeUpdate);
	 * 
	 * }
	 */
	


	@Override
	public void deleteCustomer(int customerId) {

		customerRepository.deleteById(customerId);
	}

	
	
	 @Override public List<Customer> getAllCustomers() { List<Customer>
	  customer=customerRepository.findAll();
	  
	 return customer; }
	 

	@Override
	public Customer addCustomer(CustomerDto customer) {
		Customer customer2=new Customer();
		BeanUtils.copyProperties(customer, customer2);
		return customerRepository.save(customer2);
	}




	@Override
	public Customer updateCustomer(int customerId, Customer customer)throws CustomerNotFoundException  {

		Customer customerToBeUpdate = customerRepository.findById(customerId)
				.orElseThrow(CustomerNotFoundException::new);
		customerToBeUpdate.setCustomerName(customer.getCustomerName());
		return customerRepository.save(customerToBeUpdate);

	}
}