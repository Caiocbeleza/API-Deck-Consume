package com.example.deck.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrawCardsDTO {
	
	@JsonProperty("cards")
	private CardDTO[] cards;
	
	public DrawCardsDTO() {}
	
	public DrawCardsDTO(CardDTO[] cards) {
		this.cards = cards;
	}

	
	
	public CardDTO[] getCards() {
		return cards;
	}
	public void setCards(CardDTO[] cards) {
		this.cards = cards;
	}

	

}
