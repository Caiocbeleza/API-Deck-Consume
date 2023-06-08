package com.example.deck.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.deck.DTO.DeckDTO;

@FeignClient(name = "deck", url = "https://deckofcardsapi.com/api/deck/new")
public interface ClientFeign {
	
	@GetMapping(value = "/shuffle")
	DeckDTO shuffleDeck();

}
