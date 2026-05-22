package com.pokemon.shop.service;

import com.pokemon.shop.exception.ResourceNotFoundException;
import com.pokemon.shop.model.Card;
import com.pokemon.shop.model.Order;
import com.pokemon.shop.repository.CardRepository;
import com.pokemon.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CardRepository cardRepository;

    public Order createOrder(Order order) {
        String[] ids = order.getCardIds().split(",");
        double total = 0;
        for (String idStr : ids) {
            Long cardId = Long.parseLong(idStr.trim());
            Card card = cardRepository.findById(cardId)
                    .orElseThrow(() -> new ResourceNotFoundException("Card", cardId));
            total += card.getPrice();
        }
        order.setTotalPrice(total);
        return orderRepository.save(order);
    }
}
