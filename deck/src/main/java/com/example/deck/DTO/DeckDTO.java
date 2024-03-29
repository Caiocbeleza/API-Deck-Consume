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
public class DeckDTO {
	
	@JsonProperty("id")
	private Long id;
	@JsonProperty("deck_id")
	private String deck_id;
	
	public DeckDTO() {}
	
	public DeckDTO(String deck_id) {
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
		return "DeckDTO [deck_id=" + deck_id  + "]";
	}

}
