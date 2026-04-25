package com.pokemon.shop.controller;

import com.pokemon.shop.model.Order;
import com.pokemon.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
}
