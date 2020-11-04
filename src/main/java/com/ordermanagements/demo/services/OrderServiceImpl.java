package com.ordermanagements.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagements.demo.entities.Order;
import com.ordermanagements.demo.entities.OrderDto;
import com.ordermanagements.demo.repo.OrderReository;
import com.ordermanagements.services.demo.exceptions.OrderNotFoundException;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderReository orderRepo;

	
	@Override
	public Optional<Order> getOrderById(int orderId) {

		return orderRepo.findById(orderId);
	}

	/*
	 * @Override public Mono<Order> addOrder(Order order) {
	 * 
	 * return orderRepo.addOrder(order); }
	 */

	@Override
	public Order updateOrder(int orderId, Order order) {
		Order orderToBeUpdate = orderRepo.findById(orderId).orElseThrow(OrderNotFoundException::new);
		orderToBeUpdate.setCost(order.getCost());
		orderToBeUpdate.setProductName(order.getProductName());
		return orderRepo.save(orderToBeUpdate);

	}

	@Override
	public void deleteOrder(int orderId) {
		orderRepo.deleteById(orderId);
	}

	@Override
	public List<Order> getAllOrder() {

		return orderRepo.findAll();
	}

	@Override
	public Order addOrder(OrderDto order) {
		
		
		Order order2=new Order();
		BeanUtils.copyProperties(order, order2);
		return  orderRepo.save(order2);
	}

}
