package com.example.deck.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.deck.DTO.DeckDTO;
import com.example.deck.DTO.DrawCardsDTO;
import com.example.deck.model.Deck;
import com.example.deck.DTO.CardDTO;

@FeignClient(name = "deck", url = "https://deckofcardsapi.com/api/deck")
public interface ClientFeign {
	
	@GetMapping(value = "/0o6545th6v9c/shuffle")
	DeckDTO shuffleDeck();
	
	@GetMapping(value = "/0o6545th6v9c/draw/?count=20")
	DrawCardsDTO drawCards();
	
	@GetMapping(value = "/new")
	Deck createNewDeck();
	

}
