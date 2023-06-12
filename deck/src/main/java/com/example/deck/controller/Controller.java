package com.example.deck.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.deck.DTO.CardDTO;
import com.example.deck.DTO.DeckDTO;
import com.example.deck.DTO.DrawCardsDTO;
import com.example.deck.client.ClientFeign;
import com.example.deck.model.Deck;
import com.example.deck.service.DeckService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class Controller {
	
	@Autowired
	private ClientFeign clientFeign;
	
	@Autowired
	private DeckService deckService;
	
	
	public Controller() {};
	
	
	public Controller(ClientFeign clientFeign) {
		this.clientFeign = clientFeign;
	}


	@RequestMapping("/{deck_id}/shuffle")
	public DeckDTO shuffleDeck(@PathVariable("deck_id") String deck_id) {
		return clientFeign.shuffleDeck(deck_id);
	}
	
	@RequestMapping("/{deck_id}/draw/?count=20")
	public DrawCardsDTO drawCards(@PathVariable("deck_id") String deck_id) {
		return clientFeign.drawCards(deck_id);
	}
	

	 @RequestMapping(value = "/calculates/{deck_id}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	 @ResponseBody
	 public String calculateBiggestSum(@PathVariable("deck_id") String deck_id) {
		       

		DrawCardsDTO drawResponse = clientFeign.drawCards(deck_id);
        CardDTO[] cards = drawResponse.getCards();

        int player1Sum = calculateSum(cards, 0, 4);
        int player2Sum = calculateSum(cards, 5, 9);
        int player3Sum = calculateSum(cards, 10, 14);
        int player4Sum = calculateSum(cards, 15, 19);
        
        List<String> player1Cards = getCards(cards, 0, 4);
        List<String> player2Cards = getCards(cards, 5, 9);
        List<String> player3Cards = getCards(cards, 10, 14);
        List<String> player4Cards = getCards(cards, 15, 19);

        int maxSum = Math.max(Math.max(player1Sum, player2Sum), Math.max(player3Sum, player4Sum));
        
     // Check if there are two or more players with the biggest sum
        int countMaxSum = 0;
        if (player1Sum == maxSum) {
            countMaxSum++;
        }
        if (player2Sum == maxSum) {
            countMaxSum++;
        }
        if (player3Sum == maxSum) {
            countMaxSum++;
        }
        if (player4Sum == maxSum) {
            countMaxSum++;
        }

        if (countMaxSum >= 2) {
        	 return "Player 1 Cards: " + player1Cards + "\n"
             		+ "Player 1 Sum: " + player1Sum + "\n"
             		+ "Player 2 Cards: " + player2Cards + "\n"
                     + "Player 2 Sum: " + player2Sum + "\n"
                     + "Player 3 Cards: " + player3Cards + "\n"
                     + "Player 3 Sum: " + player3Sum + "\n"
                     + "Player 4 Cards: " + player4Cards + "\n"
                     + "Player 4 Sum: " + player4Sum + "\n"
                     + "Biggest Sum: " + maxSum;        
       }else {
        	String winner = "";
        	if (player1Sum == maxSum) {
                winner = "O Vencedor é o Jogador 1 " + "com " + maxSum + " pontos!";
            } else if (player2Sum == maxSum) {
            	winner = "O Vencedor é o Jogador 2 " + "com " + maxSum + " pontos!";
            } else if (player3Sum == maxSum) {
            	winner = "O Vencedor é o Jogador 3 " + "com " + maxSum + " pontos!";
            } else if (player4Sum == maxSum) {
            	winner = "O Vencedor é o Jogador 4 " + "com " + maxSum + " pontos!";
            }
        	
        	return winner;
        }
    }

    public int calculateSum(CardDTO[] cards, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            String value = cards[i].getValue();
            switch (value) {
                case "KING":
                	sum += 13;
                	break;
                case "QUEEN":
                	sum += 12;
                	break;
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
    
    public List<String> getCards(CardDTO[] cards, int start, int end) {
    	List<String> values = new ArrayList<String>();
        for (int i = start; i <= end; i++) {
            String value = cards[i].getValue();
            values.add(value);
        }
        return values;
    }
    
    public Deck newDeck() {
    	return clientFeign.createNewDeck();
    }
    
    @GetMapping("/create")
    public String createNewDeck() {
    	String deck_id = deckService.createNewDeck();
        return deck_id;
    }
	
	
	
}
