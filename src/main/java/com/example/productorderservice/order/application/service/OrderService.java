package com.example.productorderservice.order.application.service;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.order.application.port.OrderPort;
import com.example.productorderservice.product.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.getProductId());
        Order order = new Order(product, request.getQuantity());
        orderPort.save(order);
    }
}
