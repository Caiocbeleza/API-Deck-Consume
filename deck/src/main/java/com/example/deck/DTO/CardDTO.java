package com.example.deck.DTO;

import java.util.ArrayList;

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
public class CardDTO {
	
	@JsonProperty("value")
	private String value;

	
	public CardDTO(String value) {
		this.value = value;
		
	}
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	
	
	
	

}
