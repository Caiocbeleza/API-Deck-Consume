package com.example.deck.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.deck.DTO.DeckDTO;
import com.example.deck.DTO.DrawCardsDTO;
import com.example.deck.DTO.CardDTO;

@FeignClient(name = "deck", url = "https://deckofcardsapi.com/api/deck/new")
public interface ClientFeign {
	
	@GetMapping(value = "/shuffle")
	DeckDTO shuffleDeck();
	
	@GetMapping(value = "/draw/?count=5")
	DrawCardsDTO drawCards();
	

}