package com.pokemon.shop.controller;

import com.pokemon.shop.model.Card;
import com.pokemon.shop.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<Card> getAll() {
        return cardService.findAll();
    }

    @GetMapping("/{id}")
    public Card getById(@PathVariable Long id) {
        return cardService.findById(id);
    }

    @PostMapping
    public Card create(@RequestBody Card card) {
        return cardService.save(card);
    }

    @PutMapping("/{id}")
    public Card update(@PathVariable Long id, @RequestBody Card card) {
        card.setId(id);
        return cardService.save(card);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cardService.delete(id);
    }
}
