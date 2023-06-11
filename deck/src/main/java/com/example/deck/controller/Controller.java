package com.example.deck.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.deck.DTO.CardDTO;
import com.example.deck.DTO.DeckDTO;
import com.example.deck.DTO.DrawCardsDTO;
import com.example.deck.Enum.Cards;
import com.example.deck.Enum.Cards.CardsEnum;
import com.example.deck.client.ClientFeign;
import com.example.deck.model.Deck;
import com.example.deck.repository.DeckRepository;
import com.example.deck.service.DeckService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class Controller {
	
	@Autowired
	private ClientFeign clientFeign;
	
	@Autowired
	private DeckService deckService;
	
	@Autowired
	private DeckRepository deckRepository;
	
	@RequestMapping("shuffle")
	public DeckDTO shuffleDeck() {
		return clientFeign.shuffleDeck();
	}
	
	public DrawCardsDTO drawCards() {
		return clientFeign.drawCards();
	}
	
//	@RequestMapping("sum")
//	public Integer sumHand() {
//		DrawCardsDTO draw =  this.drawCards();
//		List<CardDTO> cards = draw.getCards();
//		int sum = 0;
//		
//		for(CardDTO card : cards) {
//			sum += getValueAsNumber(card.getValue());
//			System.out.println(card.getValue());
//		}
//		
//		return sum;
//	}
	
	private int getValueAsNumber(String value) {
		if(value.equals("ACE")) {
			return 1;
		}
		if(value.equals("JACK")) {
			return 11;
		}
		if(value.equals("QUEEN")) {
			return 12;
		}
		if(value.equals("KING")) {
			return 13;
		}
		else {
			return Integer.parseInt(value);
		}
		
	}
	
	 @RequestMapping(value = "/calculates", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	 @ResponseBody
	 public String calculateBiggestSum() {
		
		DrawCardsDTO draw =  this.drawCards();
		CardDTO[] cardsDto = draw.getCards();
       

		DrawCardsDTO drawResponse = clientFeign.drawCards(); // Draw 20 cards
        CardDTO[] cards = drawResponse.getCards();

        int player1Sum = calculateSum(cards, 0, 4);
        int player2Sum = calculateSum(cards, 5, 9);
        int player3Sum = calculateSum(cards, 10, 14);
        int player4Sum = calculateSum(cards, 15, 19);

        int maxSum = Math.max(Math.max(player1Sum, player2Sum), Math.max(player3Sum, player4Sum));

        return "Player 1 Sum: " + player1Sum + "\n"
                + "Player 2 Sum: " + player2Sum + "\n"
                + "Player 3 Sum: " + player3Sum + "\n"
                + "Player 4 Sum: " + player4Sum + "\n"
                + "Biggest Sum: " + maxSum;
    }

    private int calculateSum(CardDTO[] cards, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            String value = cards[i].getValue();
            switch (value) {
                case "KING":
                	sum += 13;
                case "QUEEN":
                	sum += 12;
                case "JACK":
                    sum += 11;
                    break;
                case "ACE":
                    sum += 1;
                    break;
                default:
                    sum += Integer.parseInt(value);
                    break;
            }
        }
        return sum;
    }
	
	
	
}
