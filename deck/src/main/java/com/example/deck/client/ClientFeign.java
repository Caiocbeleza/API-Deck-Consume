package com.example.deck.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.deck.DTO.DeckDTO;
import com.example.deck.DTO.DrawCardsDTO;
import com.example.deck.model.Deck;



@FeignClient(name = "deck", url = "https://deckofcardsapi.com/api/deck")
public interface ClientFeign {
	
	@GetMapping(value = "/{deck_id}/shuffle")
	DeckDTO shuffleDeck(@PathVariable("deck_id") String deck_id);
	
	@GetMapping(value = "/{deck_id}/draw/?count=20")
	DrawCardsDTO drawCards(@PathVariable("deck_id") String deck_id);
	
	@GetMapping(value = "/new")
	Deck createNewDeck();
	

}
