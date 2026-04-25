package com.pokemon.shop.service;

import com.pokemon.shop.model.Card;
import com.pokemon.shop.model.Order;
import com.pokemon.shop.repository.CardRepository;
import com.pokemon.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CardRepository cardRepository;

    public Order createOrder(Order order) {
        String[] ids = order.getCardIds().split(",");
        double total = 0;
        for (String idStr : ids) {
            Card card = cardRepository.findById(Long.parseLong(idStr.trim()))
                    .orElseThrow(() -> new RuntimeException("Card introuvable"));
            total += card.getPrice();
        }
        order.setTotalPrice(total);
        return orderRepository.save(order);
    }
}
