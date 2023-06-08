package com.example.deck.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class DeckDTO {
	
	private Boolean success;
	private String deck_id;
	private Boolean shuffled;
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



	public Boolean getShuffled() {
		return shuffled;
	}



	public void setShuffled(Boolean shuffled) {
		this.shuffled = shuffled;
	}



	public Integer getRemaining() {
		return remaining;
	}



	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}



	@Override
	public String toString() {
		return "DeckDTO [success=" + success + ", deck_id=" + deck_id + ", shuffled=" + shuffled + ", remaining="
				+ remaining + "]";
	}

}
