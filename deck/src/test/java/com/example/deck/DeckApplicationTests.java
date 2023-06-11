package com.example.deck;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.deck.client.ClientFeign;
import com.example.deck.controller.Controller;
import com.example.deck.DTO.CardDTO;
import com.example.deck.DTO.DrawCardsDTO;


import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DeckApplicationTests {
	@Mock
	private ClientFeign clientFeign;
	
	@Mock
	private Controller controller;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		controller = new Controller();
	}
	
	 @ExtendWith(MockitoExtension.class)
	 @Test
	    public void testCalculateBiggestSum() {
		 
	        // Mocked cards array
	        CardDTO[] cards = new CardDTO[20];

	        // Create example cards for each player
	        cards[0] = new CardDTO("KING");
	        cards[1] = new CardDTO("2");
	        cards[2] = new CardDTO("10");
	        cards[3] = new CardDTO("ACE");
	        cards[4] = new CardDTO("JACK");
	        cards[5] = new CardDTO("5");
	        cards[6] = new CardDTO("QUEEN");
	        cards[7] = new CardDTO("3");
	        cards[8] = new CardDTO("8");
	        cards[9] = new CardDTO("KING");
	        cards[10] = new CardDTO("4");
	        cards[11] = new CardDTO("6");
	        cards[12] = new CardDTO("9");
	        cards[13] = new CardDTO("ACE");
	        cards[14] = new CardDTO("JACK");
	        cards[15] = new CardDTO("KING");
	        cards[16] = new CardDTO("QUEEN");
	        cards[17] = new CardDTO("ACE");
	        cards[18] = new CardDTO("7");
	        cards[19] = new CardDTO("5");
	        

	        String result = controller.calculateBiggestSum();

	        String expected = "Player 1 Cards: [KING, 2, 10, ACE, JACK]\n"
	                + "Player 1 Sum: 36\n"
	                + "Player 2 Cards: [5, QUEEN, 3, 8, KING]\n"
	                + "Player 2 Sum: 26\n"
	                + "Player 3 Cards: [4, 6, 9, ACE, JACK]\n"
	                + "Player 3 Sum: 34\n"
	                + "Player 4 Cards: [KING, QUEEN, ACE, 7, 5]\n"
	                + "Player 4 Sum: 36\n"
	                + "Biggest Sum: 36";

	        assertEquals(expected, result);
	    }

	    @Test
	    public void testCalculateSum() {
	        CardDTO[] cards = new CardDTO[5];

	        // Example cards with values "2", "JACK", "ACE", "5", "10"
	        cards[0] = new CardDTO("2");
	        cards[1] = new CardDTO("JACK");
	        cards[2] = new CardDTO("ACE");
	        cards[3] = new CardDTO("5");
	        cards[4] = new CardDTO("10");


	        int sum = controller.calculateSum(cards, 0, 4);

	        assertEquals(29, sum);
	    }

	    @Test
	    public void testGetCards() {
	        CardDTO[] cards = new CardDTO[5];

	        // Example cards with values "KING", "QUEEN", "ACE", "10", "7"
	        cards[0] = new CardDTO("KING");
	        cards[1] = new CardDTO("QUEEN");
	        cards[2] = new CardDTO("ACE");
	        cards[3] = new CardDTO("10");
	        cards[4] = new CardDTO("7");


	        List<String> values = controller.getCards(cards, 0, 4);

	        List<String> expected = Arrays.asList("KING", "QUEEN", "ACE", "10", "7");

	        assertEquals(expected, values);
	    }

}
