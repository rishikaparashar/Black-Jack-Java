import java.util.ArrayList;
import java.util.Iterator;

public class Hand {
	
	protected ArrayList<Card> inHandCards;
	protected int handValue, count;
	
	public Hand() {
		inHandCards = new ArrayList<Card>(12);
		handValue = 0;
		count = 0;
	}
	
	private void IsBusted(Card newCard) {
		if(handValue > 21) {
			if(AceInHand()) {
				handValue -= 10;
				
			}
		}
	}
	
	private boolean AceInHand() {
		boolean isAce = false;
		Card card = null;
		Iterator<Card> itr = inHandCards.iterator();
		while(itr.hasNext() && !isAce) {
			card = itr.next();
			if(card.getCardValue() == 11) {
				card.setCardValue(1);
				isAce = true;
			}
		}
		return isAce;
	}
	
	public Card AddNewCard(Deck currentDeck) {
		Card newCard;
		newCard = currentDeck.getCard();
		inHandCards.add(newCard);
		handValue += newCard.getCardValue();
		IsBusted(newCard);
		count++;
		return newCard;
	}
	
	public int getHandValue() {
		return handValue;
	}
	
	public Card RemoveCard(Card card) {
		inHandCards.remove(card);
		return card;
	}
	
	public String toString() {
		String thisHand = "";
		Card cardString = null;
		int i = 0;
		Iterator<Card> itr = inHandCards.iterator();
		while(itr.hasNext()) {
			cardString = itr.next();
			thisHand += "Card " + i + ": " + cardString.getCardValue() + "\n";
			i++;
		}
		return thisHand;
	}
	
	
}
