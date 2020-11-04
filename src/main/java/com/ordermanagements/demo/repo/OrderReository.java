package com.ordermanagements.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordermanagements.demo.entities.Order;

@Repository
public interface OrderReository extends JpaRepository<Order, Integer> {

	//public Mono<Order> addOrder(Order order);

}
