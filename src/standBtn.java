import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JLabel;

public class standBtn implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PlayGame playGameInstance;
	
	public standBtn(PlayGame playGame) {
		playGameInstance = playGame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		playGameInstance.dealerPanel.remove(playGameInstance.dealerCard0);
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
