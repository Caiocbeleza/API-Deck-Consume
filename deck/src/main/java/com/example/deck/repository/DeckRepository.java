package com.example.deck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.deck.DTO.DeckDTO;
import com.example.deck.model.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long>{

}
