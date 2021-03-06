package edu.sjsu.cs151.tetris.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Class that creates the game over panel
 * @author Luksawee
 * @author Nick
 */
public class GameOverPanel extends Panel
{
	/**
	 * The constructor for the game over panel
	 */
	public GameOverPanel()
	{
		gameOverPanel = new JPanel();
		gameOverPanel.setPreferredSize(new Dimension(600, 800));
		gameOverPanel.setBackground(new Color(128,128,128));
		gameOverPanel.setOpaque(true);
		
		JLabel gameOver = new JLabel("  GAME OVER!!!  ");
		gameOver.setBackground(new Color(128,128,128));
		gameOver.setOpaque(true);
		gameOver.setFont(new Font("TimesRoman", Font.BOLD, 64));	
		setLabelCenter(gameOver);
		
		retryButton = new JButton("  Retry Level  ");
		retryButton.setBackground(Color.WHITE);
		setButton(retryButton, 48);
		
		returnToMainManu = new JButton("  Return to Main Manu  ");
		returnToMainManu.setBackground(Color.WHITE);
		setButton(returnToMainManu, 48);
		
		JPanel box1 = new JPanel(new GridLayout(1, 10));
		box1.setBackground(new Color(128,128,128));
		JPanel box2 = new JPanel(new GridLayout(1, 10));
		box2.setBackground(new Color(128,128,128));
		JPanel box3 = new JPanel(new GridLayout(1, 10));
		box3.setBackground(new Color(128,128,128));
		JPanel box4 = new JPanel(new GridLayout(1, 10));
		box4.setBackground(new Color (128,128,128));
		
        
		gameOverPanel.setLayout(new BoxLayout(gameOverPanel, BoxLayout.Y_AXIS));		
		gameOverPanel.add(box1);
		gameOverPanel.add(gameOver);
		
		gameOverPanel.add(box2);
		gameOverPanel.add(retryButton);
		
		gameOverPanel.add(box3);
		gameOverPanel.add(returnToMainManu);
		gameOverPanel.add(box4);

		gameOverPanel.setVisible(true);
		
	}
	
	/**
	 * The method to return game over Panel.
	 * @return gameOverPanel the game over panel
	 */
	public JPanel getGameOverPanel()
	{
		return gameOverPanel;
	}
	
	/**
	 * The method to return retry button.
	 * @return retryButton the retry button
	 */
	public JButton getRetryButton()
	{
		return retryButton;
	}
	
	/**
	 * The method to return main menu button.
	 * @return returnToMainManu the return main menu button
	 */
	public JButton getReturnToMainManu()
	{
		return returnToMainManu;
	}
	
	private JPanel gameOverPanel;
	private JButton retryButton;
	private JButton returnToMainManu;
}

