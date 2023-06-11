package com.example.deck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.deck.DTO.DeckDTO;
import com.example.deck.DTO.DrawCardsDTO;
import com.example.deck.controller.Controller;
import com.example.deck.model.Deck;
import com.example.deck.repository.DeckRepository;
import com.example.deck.client.ClientFeign;

@Service
@Configurable
public class DeckService {
	private final DeckRepository deckRepository;
	private final ClientFeign clientFeign;
	
	@Autowired
	public DeckService(DeckRepository deckRepository, ClientFeign clientFeign) {
		this.deckRepository = deckRepository;
		this.clientFeign = clientFeign;
	}
	
	public String createNewDeck() {
		Deck response = clientFeign.createNewDeck();
		Deck deck = new Deck();
		deck.setDeck_id(response.getDeck_id());
		deckRepository.save(deck);
		
		return response.getDeck_id();
	}
	
	
	
}
