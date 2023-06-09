package com.example.deck.DTO;

import java.util.ArrayList;

public class DrawCardsDTO {
	
	private Boolean success;
	private String deck_id;
	private ArrayList<CardDTO> cards;
	private Integer remaining;
	
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getDeck_id() {
		return deck_id;
	}
	public void setDeck_id(String deck_id) {
		this.deck_id = deck_id;
	}
	public ArrayList<CardDTO> getCards() {
		return cards;
	}
	public void setCards(ArrayList<CardDTO> cards) {
		this.cards = cards;
	}
	public Integer getRemaining() {
		return remaining;
	}
	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}
	
	

}
