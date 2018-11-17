import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class PlayGame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel topPanel = new JPanel();
	JPanel playerPanel = new JPanel();
	JPanel dealerPanel = new JPanel();
	JTextPane winLosePane = new JTextPane();
	JButton hitMeBtn = new JButton();
	JButton dealBtn = new JButton();
	JButton standBtn = new JButton();
	JButton playAgainBtn = new JButton();
	JLabel dealerLabel = new JLabel();
	JLabel playerLabel = new JLabel();
	
	Hand dealerHand = new Hand();
	Hand playerHand = new Hand();
	BlackJack newGame = new BlackJack(dealerHand, playerHand);
	
	JLabel playerCard1;
	JLabel playerCard2;
	JLabel playerHitMe;
	JLabel dealerCard0;
	JLabel dealerCard1;
	JLabel dealerCard2;
	JLabel dealerHitMe;
	
	public PlayGame() {
		topPanel.setBackground(new Color(0,122,0));
		playerPanel.setBackground(new Color(0,122,0));
		dealerPanel.setBackground(new Color(0,122,0));
		
		topPanel.setLayout(new FlowLayout());
		winLosePane.setText(" ");
		winLosePane.setFont(new java.awt.Font("Helvetica Bold", 1, 20));
		dealBtn.setText("  Deal");
		dealBtn.addActionListener(new dealBtn(this));
		hitMeBtn.setText("  Hit");
		hitMeBtn.addActionListener(new hitMeBtn(this));
		hitMeBtn.setEnabled(false);
		standBtn.setText("  Stand");
		standBtn.addActionListener(new standBtn(this));   
		standBtn.setEnabled(false);
		playAgainBtn.setText("  PlayAgain");
		playAgainBtn.addActionListener(new playAgainBtn(this));
		playAgainBtn.setEnabled(false);
		
		dealerLabel.setText("  Dealer:  ");
	    playerLabel.setText("  Player:  ");

	    topPanel.add(winLosePane);
	    topPanel.add(dealBtn);
	    topPanel.add(hitMeBtn);
	    topPanel.add(standBtn);
	    topPanel.add(playAgainBtn);
	    playerPanel.add(playerLabel);
	    dealerPanel.add(dealerLabel);
	    
	    setLayout(new BorderLayout());
	    add(topPanel,BorderLayout.NORTH);
	    add(dealerPanel,BorderLayout.CENTER);
	    add(playerPanel,BorderLayout.SOUTH);
	}
	
	public void Display() {
		JFrame jFrame = new JFrame("BLACKJACK");
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setContentPane(this);
		jFrame.setPreferredSize(new Dimension(700, 500));
		jFrame.pack();
		jFrame.setVisible(true);
	}
	
	
}

