import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class hitMeBtn implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PlayGame playGameInstance;
	
	public hitMeBtn(PlayGame playGame) {
		playGameInstance = playGame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Card hitcard = playGameInstance.newGame.HitMe(playGameInstance.playerHand);
		playGameInstance.playerHitMe = new JLabel(hitcard.getCardFace());
		playGameInstance.playerPanel.add(playGameInstance.playerHitMe);
		playGameInstance.playerPanel.repaint();
			 
		if(playGameInstance.newGame.PlayerBusted(playGameInstance.playerHand))     
			{
				playGameInstance.winLosePane.setText("Bust");
				playGameInstance.hitMeBtn.setEnabled(false);
				playGameInstance.dealBtn.setEnabled(false);
				playGameInstance.standBtn.setEnabled(false);
				playGameInstance.playAgainBtn.setEnabled(true);
			}
			playGameInstance.playerLabel.setText("  Player:   " + playGameInstance.newGame.HandValue(playGameInstance.playerHand));
	}
}


