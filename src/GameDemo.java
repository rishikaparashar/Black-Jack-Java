
/*public class GameDemo {
	public static void main(String[] args) {
		PlayGame gameFrame = new PlayGame();
		gameFrame.Display();
	}
}*/

import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JLabel;

public class GameDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			PlayGame gameFrame = new PlayGame();
			gameFrame.Display();
			Hand dealerHand = new Hand();
			Hand playerHand = new Hand();
			BlackJack newGame = new BlackJack(dealerHand, playerHand);
			
			System.out.println("Deal Cards - y or Y/n or N");
			String deal = sc.nextLine();
			if(deal.equals("y") || deal.equals("Y")) {
				newGame.DealCards();
				//String dealerCard0 = "BACK of CARD";
				String dealerCard0, dealerCard1, dealerCard2;
				String playerCard1, playerCard2;
				Card dealerCrd = null;
				Iterator<Card> dealerItr = (dealerHand.inHandCards.iterator());
				int count = 0;
				while(dealerItr.hasNext()) {
					dealerCrd = dealerItr.next();
					if(count == 0) {
						dealerCard1 = dealerCrd.getCardFace();
						System.out.println("Dealer card " + dealerCard1);
					}
					else {
						dealerCard2 = dealerCrd.getCardFace();
						System.out.println("Dealer card " + dealerCard2);
					}
					count ++;
				}
				
				Card playerCrd = null;
				Iterator<Card> playerItr = (dealerHand.inHandCards.iterator());
				count = 0;
				while(playerItr.hasNext()) {
					playerCrd = playerItr.next();
					if(count == 0) {
						playerCard1 = playerCrd.getCardFace();
						System.out.println("Player card " + playerCard1);
					}
					else {
						playerCard2 = playerCrd.getCardFace();
						System.out.println("Player card " + playerCard2);
					}
					count ++;
				}
			}
			while(playerHand.getHandValue() <= 21) {
				System.out.println("What you want? " + "Enter H/h for hit me, S/s for stand");
				String nextCall = sc.nextLine();
				if(nextCall.equals("H") || nextCall.equals("h")) {
					Card hitcard = newGame.HitMe(playerHand);
					String hitCard = hitcard.getCardFace();
					System.out.println("Hit Card " + hitCard);
					if(newGame.PlayerBusted(playerHand))     
						{
							System.out.println("Player Busted");
						}
					System.out.println("  Player:   " + newGame.HandValue(playerHand));
				}
				else {
					
					playGameInstance.dealerPanel.add(playGameInstance.dealerCard1);

					playGameInstance.dealerHand = playGameInstance.newGame.DealerHand();
					playGameInstance.dealerPanel.removeAll();
					playGameInstance.dealerPanel.add(playGameInstance.dealerLabel);
					playGameInstance.dealerLabel.setText(" " + playGameInstance.dealerLabel.getText());  
				    
				    //iterate through cards and re-display
				    Card dealerHitCard = null;
				    Iterator<Card> itr = (playGameInstance.dealerHand.inHandCards).iterator();
				    while (itr.hasNext())
				    {
				    	dealerHitCard = itr.next();
				    	playGameInstance.dealerHitMe = new JLabel(dealerHitCard.getCardFace());
				    	playGameInstance.dealerPanel.add(playGameInstance.dealerHitMe);
				    }
				    
				    playGameInstance.dealerLabel.setText(" Dealer: " + playGameInstance.newGame.HandValue(playGameInstance.dealerHand));
				    playGameInstance.playerLabel.setText(" Player: " + playGameInstance.newGame.HandValue(playGameInstance.playerHand));
				    
				    playGameInstance.winLosePane.setText(playGameInstance.newGame.Winner());
				    playGameInstance.hitMeBtn.setEnabled(false);
				    playGameInstance.standBtn.setEnabled(false);
				    playGameInstance.playAgainBtn.setEnabled(false);
				}
			}
			
			
			
		}
		finally {
			sc.close();
		}
		
		
		
		
	}
}
