package com.bookstore.orderservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.orderservice.model.Order;
import com.bookstore.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    public Order findOrder(long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Order> findOrders() {
        return repository.findAll();
    }

    public Order updateOrder(long id, Order order) {

        Order o = repository.findById(id).orElse(null);

        o.setBookId(order.getBookId());
        o.setCustomerName(order.getCustomerName());
        o.setOrderDate(LocalDate.now());
        o.setQuantity(order.getQuantity());
        o.setStatus(order.getStatus());
        o.setTotalPrice(order.getTotalPrice());
        return repository.save(o);
    }

    public void deleteOrder(long id) {
        repository.deleteById(id);
    }
}