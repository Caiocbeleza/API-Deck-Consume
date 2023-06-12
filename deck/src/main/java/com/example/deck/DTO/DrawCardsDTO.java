package com.example.deck.DTO;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrawCardsDTO {
	
	private CardDTO[] cards;

	
	
	public CardDTO[] getCards() {
		return cards;
	}
	public void setCards(CardDTO[] cards) {
		this.cards = cards;
	}

	

}
