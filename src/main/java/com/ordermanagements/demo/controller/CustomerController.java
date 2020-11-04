package com.ordermanagements.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagements.demo.entities.Customer;
import com.ordermanagements.demo.entities.CustomerDto;
import com.ordermanagements.demo.services.CustomerService;
import com.ordermanagements.services.demo.exceptions.CustomerNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/customerManagement")
public class CustomerController {

	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomers() {

		log.info("get all customers");
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);

	}

	@GetMapping(path = "customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getAnCustomer(@PathVariable(name = "customerId") int customerId) {
		Customer customer = customerService.getCustomerById(customerId).orElseThrow(CustomerNotFoundException::new);
		log.info("get customers by id");
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@PutMapping(path = "customers/{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@PathVariable(name = "customerId") int customerID,

			@RequestBody Customer customer) {
		log.info("updating the customers data");
		return new ResponseEntity<Customer>(customerService.updateCustomer(customerID, customer), HttpStatus.OK);
	}

	@PostMapping(path = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody CustomerDto customer) {
		log.info(" adding new customers");
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "customerId") int customerId) {
		log.info("deleting the customers by id");
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
