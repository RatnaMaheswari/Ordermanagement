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

import com.ordermanagements.demo.entities.Order;
import com.ordermanagements.demo.entities.OrderDto;
import com.ordermanagements.demo.services.OrderService;
import com.ordermanagements.services.demo.exceptions.OrderNotFoundException;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping(path = "/orderManagement")
public class OrderManagementController {

	private static final Logger log = LoggerFactory.getLogger(OrderManagementController.class);

	@Autowired
	private OrderService orderservice;

	@GetMapping(path = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Order>> getAllCustomers() {

		log.info("get all orders");
		return new ResponseEntity<List<Order>>(orderservice.getAllOrder(), HttpStatus.OK);

	}

	@GetMapping(path = "/order/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> getAnOrder(@PathVariable(name = "orderId") int orderId) {
		Order order = orderservice.getOrderById(orderId).orElseThrow(OrderNotFoundException::new);
		log.info("get orders by id");
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	/*
	 * @PostMapping(path = "/order", consumes = MediaType.APPLICATION_JSON_VALUE,
	 * produces = MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<Mono<Order>> addOrder(@Valid @RequestBody Order order) {
	 * Log.info(" adding new orders"); return new
	 * ResponseEntity<Mono<Order>>(orderservice.addOrder(order),
	 * HttpStatus.CREATED); }
	 */

	@PutMapping(path = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> updateOrder(@PathVariable(name = "orderId") Integer orderId,

			@RequestBody Order order) {
		log.info("updating the orders data");
		return new ResponseEntity<Order>(orderservice.updateOrder(orderId, order), HttpStatus.OK);
	}

	@PostMapping(path = "/order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> addOrder(@Valid @RequestBody OrderDto order) {
		log.info(" adding new customers");
		return new ResponseEntity<Order>(orderservice.addOrder(order), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteOrder(@PathVariable(name = "orderId") Integer orderId) {
		log.info("deleting the orderss by id");
		orderservice.deleteOrder(orderId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
