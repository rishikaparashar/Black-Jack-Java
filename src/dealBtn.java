import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JLabel;

public class dealBtn implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PlayGame playGameInstance = null;
	
	//PlayGame playGame = new PlayGame();
	
	public dealBtn(PlayGame playGame) {
		playGameInstance = playGame;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		playGameInstance.dealerPanel.add(playGameInstance.dealerLabel);
		playGameInstance.playerPanel.add(playGameInstance.playerLabel);
		
		playGameInstance.newGame.DealCards();
		
		playGameInstance.dealerCard0 = new JLabel("BACK of CARD");
		
		Card dealerCrd = null;
		Iterator<Card> dealerItr = (playGameInstance.dealerHand.inHandCards.iterator());
		int count = 0;
		while(dealerItr.hasNext()) {
			dealerCrd = dealerItr.next();
			if(count == 0) {
				playGameInstance.dealerCard1 = new JLabel(dealerCrd.getCardFace());
			}
			else
				playGameInstance.dealerCard2 = new JLabel(dealerCrd.getCardFace());
			count ++;
		}
		
		Card playerCrd = null;
		Iterator<Card> playerItr = (playGameInstance.dealerHand.inHandCards.iterator());
		count = 0;
		while(playerItr.hasNext()) {
			playerCrd = playerItr.next();
			if(count == 0) {
				playGameInstance.playerCard1 = new JLabel(playerCrd.getCardFace());
			}
			else
				playGameInstance.playerCard2 = new JLabel(playerCrd.getCardFace());
			count ++;
		}
		
		playGameInstance.dealerPanel.add(playGameInstance.dealerCard0);
		playGameInstance.dealerPanel.add(playGameInstance.dealerCard2);
		
		playGameInstance.playerPanel.add(playGameInstance.playerCard1);
		playGameInstance.playerPanel.add(playGameInstance.playerCard2);
		
		playGameInstance.dealerLabel.setText(" Dealer: " + dealerCrd.getCardValue());
		playGameInstance.playerLabel.setText(" Player: " + playGameInstance.newGame.HandValue(playGameInstance.playerHand));
		
		playGameInstance.hitMeBtn.setEnabled(true);
		playGameInstance.standBtn.setEnabled(true);
		playGameInstance.dealBtn.setEnabled(false);

	    if(playGameInstance.newGame.IsBlackJack())     
	     {
			playGameInstance.hitMeBtn.setEnabled(false);
			playGameInstance.standBtn.setEnabled(false);
			playGameInstance.dealBtn.setEnabled(false);
			playGameInstance.playAgainBtn.setEnabled(true);
			playGameInstance.winLosePane.setText("BlackJack");
	     }

	    playGameInstance.add(playGameInstance.dealerPanel,BorderLayout.CENTER);
	    playGameInstance.add(playGameInstance.playerPanel,BorderLayout.SOUTH);
	}
}


