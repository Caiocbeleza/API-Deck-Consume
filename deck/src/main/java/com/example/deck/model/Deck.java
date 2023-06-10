package com.example.deck.model;

import jakarta.persistence.*;

@Entity
@Table(name = "decks")
public class Deck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "shuffled")
	private Boolean shuffled;	
	
	@Column(name = "deck_id")
	private String deck_id;
	
	@Column(name = "remaining")
	private Integer remaining;
	
	public Deck() {}
	
	public Deck(Boolean shuffled, String deck_id, Integer remaining) {
		this.shuffled = shuffled;
		this.deck_id = deck_id;
		this.remaining = remaining;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getShuffled() {
		return shuffled;
	}

	public void setShuffled(Boolean shuffled) {
		this.shuffled = shuffled;
	}

	public String getDeck_id() {
		return deck_id;
	}

	public void setDeck_id(String deck_id) {
		this.deck_id = deck_id;
	}

	public Integer getRemaining() {
		return remaining;
	}

	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}

	@Override
	public String toString() {
		return "Deck [id=" + id + ", shuffled=" + shuffled + ", deck_id=" + deck_id + ", remaining=" + remaining + "]";
	}
	
	
	
	
}
