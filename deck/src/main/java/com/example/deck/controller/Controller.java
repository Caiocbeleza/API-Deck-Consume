package com.example.deck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.deck.DTO.DeckDTO;
import com.example.deck.client.ClientFeign;
import com.example.deck.service.DeckService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class Controller {
	
	@Autowired
	private ClientFeign clientFeign;
	private DeckService deckService;
	
	@RequestMapping("shuffle")
	public DeckDTO shuffleDeck() {
		return clientFeign.shuffleDeck();
	}
	
	
}
