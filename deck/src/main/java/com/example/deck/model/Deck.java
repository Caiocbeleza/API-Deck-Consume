package com.example.deck.model;

import jakarta.persistence.*;

@Entity
@Table(name = "decks")
public class Deck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "deck_id")
	private String deck_id;
	
	
	public Deck() {}
	
	public Deck(String deck_id) {
		this.deck_id = deck_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeck_id() {
		return deck_id;
	}

	public void setDeck_id(String deck_id) {
		this.deck_id = deck_id;
	}

	@Override
	public String toString() {
		return "Deck [id=" + id + ", deck_id=" + deck_id + "]";
	}
	
	
	
	
}
