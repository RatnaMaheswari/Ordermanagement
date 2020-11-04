package com.ordermanagements.demo.services;

import java.util.List;
import java.util.Optional;

import com.ordermanagements.demo.entities.Order;
import com.ordermanagements.demo.entities.OrderDto;

public interface OrderService {
	

	public Optional<Order> getOrderById(int orderId);

	//public Mono<Order> addOrder(Order order);

	public Order updateOrder(int orderId, Order order);

	public void deleteOrder(int orderId);

	public List<Order> getAllOrder();

	public Order addOrder( OrderDto order);
}
