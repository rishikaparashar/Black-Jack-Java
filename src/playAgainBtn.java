import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class playAgainBtn implements ActionListener {
	
	private PlayGame playGameInstance = null;
	public playAgainBtn(PlayGame playGame) {
		playGameInstance = playGame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		playGameInstance.dealerLabel.setText("Dealer: ");
		playGameInstance.playerLabel.setText("Player: ");
		playGameInstance.winLosePane.setText(""); 
		Hand newDealerhand = new Hand();
		Hand newPlayerHand = new Hand();
		playGameInstance.newGame = new BlackJack(newDealerhand, newPlayerHand);

		playGameInstance.dealerPanel.removeAll();
		playGameInstance.playerPanel.removeAll();

		playGameInstance.hitMeBtn.setEnabled(false);
		playGameInstance.standBtn.setEnabled(false);
		playGameInstance.playAgainBtn.setEnabled(false);
		playGameInstance.dealBtn.setEnabled(true);
	}

}
