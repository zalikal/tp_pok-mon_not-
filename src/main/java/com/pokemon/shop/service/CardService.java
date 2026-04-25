package com.pokemon.shop.service;

import com.pokemon.shop.model.Card;
import com.pokemon.shop.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findById(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card introuvable"));
    }

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public void delete(Long id) {
        cardRepository.deleteById(id);
    }
}

