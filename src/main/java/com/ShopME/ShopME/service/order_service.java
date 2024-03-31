package com.ShopME.ShopME.service;

import com.ShopME.ShopME.Repository.OrderRepository;
import com.ShopME.ShopME.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class order_service {
    public final OrderRepository orderRepository;

    @Autowired
    public order_service(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save_order(Order order) {
        return orderRepository.save(order);
    }

    public Iterable<Order> check_my_orders(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order get_order(String order_id)
    {
        return  orderRepository.findByOrderId(order_id);
    }
}
