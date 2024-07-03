package com.VCriate.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VCriate.model.Order;
import com.VCriate.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrderOptional = orderRepository.findById(id);
        if (existingOrderOptional.isPresent()) {
            Order existingOrder = existingOrderOptional.get();
            existingOrder.setCustomerId(updatedOrder.getCustomerId());
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
            existingOrder.setStatus(updatedOrder.getStatus());
            return orderRepository.save(existingOrder);
        }
        return null; // Or throw an exception indicating order not found
    }

    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}

