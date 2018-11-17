import java.util.Iterator;

public class BlackJack {
	Hand dealer;
	Hand player;
	Deck newDeck;
	
	public BlackJack(Hand dealer, Hand player) {
		this.dealer = dealer;
		this.player = player;
		this.newDeck = new Deck(); 
	}
	
	public void DealCards() {
		dealer.AddNewCard(newDeck);
		dealer.AddNewCard(newDeck);
		dealer.AddNewCard(newDeck);
		dealer.AddNewCard(newDeck);
	}
	
	public Card HitMe(Hand playerWhoHits) {
		Card card = playerWhoHits.AddNewCard(newDeck);
		return card;
	}
	
	public int HandValue(Hand user) {
		int value = user.getHandValue();
		return value;
	}
	
	public void DiscardCard(Hand player, Card discardCard) {
		Card card = null;
		boolean cardFound = false;
		Iterator<Card> itr = player.inHandCards.iterator();
		if(itr.hasNext() && !cardFound) {
			card = itr.next();
			if(discardCard.equals(card)) {
				player.RemoveCard(card);
				cardFound = true;
			}
		}
		if(!cardFound) {
			System.out.println("Not found");
		}
	}
	
	public boolean IsBlackJack() {
		boolean isBlackJack = false;
		if(player.getHandValue() == 21) {
			isBlackJack = true;
		}
		return isBlackJack;
	}
	
	public boolean PlayerBusted(Hand plyr) {
		boolean isBusted = false;
		if(plyr.getHandValue() > 21) {
			isBusted = true;
		}
		return isBusted;
	}
	
	public Hand DealerHand() {
		Hand dealerHand = dealer;
		while(dealerHand.getHandValue() <=16) {
			dealerHand.AddNewCard(newDeck);
		}
		return dealerHand;
	}
	
	public String Winner() {
		String winner = "";
		if((player.getHandValue() < dealer.getHandValue()) && dealer.getHandValue() <= 21) {
			winner = "Player Looses";
		}
		else if((player.getHandValue() == dealer.getHandValue()) && player.getHandValue() <= 21) {
			winner = "Draw";
		}
		else {
			winner = "Player wins";
		}
		return winner;
	}
}
