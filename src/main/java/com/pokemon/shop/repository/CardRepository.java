package com.pokemon.shop.repository;

import com.pokemon.shop.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
