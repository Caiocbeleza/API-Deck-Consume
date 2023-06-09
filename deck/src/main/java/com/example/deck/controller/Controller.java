package com.example.deck.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.deck.DTO.CardDTO;
import com.example.deck.DTO.DeckDTO;
import com.example.deck.DTO.DrawCardsDTO;
import com.example.deck.Enum.Cards;
import com.example.deck.Enum.Cards.CardsEnum;
import com.example.deck.client.ClientFeign;
import com.example.deck.service.DeckService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class Controller {
	
	@Autowired
	private ClientFeign clientFeign;
	
	@Autowired
	private DeckService deckService;
	
	@RequestMapping("shuffle")
	public DeckDTO shuffleDeck() {
		return clientFeign.shuffleDeck();
	}
	
	@RequestMapping("draw")
	public DrawCardsDTO drawCards() {
		return clientFeign.drawCards();
	}
	
	@RequestMapping("sum")
	public Integer sumHand() {
		DrawCardsDTO draw =  this.drawCards();
		List<CardDTO> cards = draw.getCards();
		List<String> cardValues = new ArrayList<String>();
		Integer cardSum = 0;
		int i = 0;
		for (CardDTO card : cards) {
			cardValues.add(card.getValue());
			System.out.println(cardValues);
			cardSum +=  Integer.parseInt(card.getValue());
		}
		return cardSum;
		
	}
	
	
	
}
