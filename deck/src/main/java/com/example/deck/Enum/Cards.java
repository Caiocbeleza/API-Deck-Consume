package com.example.deck.Enum;

public enum Cards {
	A,	J, 	Q,	K;
	
	public enum CardsEnum{
		ACE(1), JACK(11), QUEEN(12), KING(13);
		
		public int cardValue;
		
		CardsEnum(int value){
			cardValue = value;
		}
	}
	
	

}
