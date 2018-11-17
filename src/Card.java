
public class Card {
	protected String face;
	protected int value;
	protected String suit;
	
	//Create a card - constructor
	public Card() {
		value = 0;
		face = null;
		suit = null;
	}
	
	public Card(int val, String cardFace, String cardSuit) {
		value = val;
		face = cardFace;
		suit = cardSuit;
	}
	
	public int getCardValue() {
		return value;
	}
	
	public String getCardSuit() {
		return suit;
	}
	
	public String getCardFace() {
		return face;
	}
	
	public String toCardString() {
		return "Face: "+ face + " Suit: " + suit + " Value: " + value; 
	}
	
	public void setCardValue(int val) {
		value = val;
	}
	
	
	
	
}
