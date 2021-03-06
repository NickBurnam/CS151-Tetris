package edu.sjsu.cs151.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The class that class the panel for player to play a game.
 * @author Luksawee
 */
public class InGamePanel extends JPanel
{
	/**
	 * The in-game panel constuctor
	 */
	public InGamePanel() {
		inGamePanel = new JPanel();
		inGamePanel.setSize(800, 820);
		inGamePanel.setFocusable(true);

		level = new JLabel();
		level.setFont(new Font("TimesRoman", Font.BOLD, 24));
		level.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		name = new JLabel();
		name.setFont(new Font("TimesRoman", Font.BOLD, 24));
		name.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		score = new JLabel();
		score.setFont(new Font("TimesRoman", Font.BOLD, 24));
		score.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel pause = new JLabel		("esc        PAUSE      ");
		pause.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		JLabel moveLeft = new JLabel	(" <-          Move Left  ");
		moveLeft.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		JLabel moveRight = new JLabel	("   ->          Move Right  ");
		moveRight.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		JLabel rotate = new JLabel		("z          Rotate      ");
		rotate.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		JLabel dropFaster = new JLabel	(" Space   Drop faster");
		dropFaster.setFont(new Font("TimesRoman", Font.BOLD, 20));
		
		JPanel gameInfo = new JPanel();
		gameInfo.setPreferredSize(new Dimension(200, 800));
		gameInfo.setBackground(new Color(176, 196, 222));
				
		JPanel playerPanel = new JPanel();
		playerPanel.setPreferredSize(new Dimension(200, 400));
		playerPanel.setBackground(new Color(176, 196, 222));
		playerPanel.setOpaque(true);
		playerPanel.add(name);
		playerPanel.add(level);
		playerPanel.add(score);
		
		JPanel nextTetrominoPanel = new JPanel();
		nextTetrominoPanel.setPreferredSize(new Dimension(200, 400));
		nextTetrominoPanel.setBackground(new Color(176, 196, 222));
		nextTetrominoPanel.setOpaque(true);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setPreferredSize(new Dimension(200, 200));
		controlPanel.setBackground(new Color(176, 196, 222));
		controlPanel.setOpaque(true);
		//controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		controlPanel.add(pause);
		controlPanel.add(moveLeft);
		controlPanel.add(moveRight);
		controlPanel.add(rotate);
		controlPanel.add(dropFaster);
		
		
		gameInfo.setLayout(new BoxLayout(gameInfo, BoxLayout.Y_AXIS));
		gameInfo.add(playerPanel);
		gameInfo.add(nextTetrominoPanel);
		gameInfo.add(controlPanel);

		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(400, 800));
		center.setBackground(new Color(0, 0, 0));
		center.setOpaque(true);
		
		colors = new Color[20][10];
		for(int i = 0; i< 20 ; ++i)
			for(int j = 0; j<10; ++j)
				colors[i][j] = Color.DARK_GRAY;
		
		boardGamePanel = new BoardGamePanel(colors);
		boardGamePanel.setPreferredSize(new Dimension(400, 820));
		boardGamePanel.setVerifyInputWhenFocusTarget(true);
		boardGamePanel.setVisible(true);
		
		inGamePanel.setLayout(new BorderLayout());
		inGamePanel.add(boardGamePanel, BorderLayout.CENTER);
		inGamePanel.add(gameInfo, BorderLayout.WEST);
		inGamePanel.setVisible(true);
	}
	
	/**
	 * The method to set the level.
	 * @param playerLevel the level to set
	 */
	public void setLevelInGamePanel(String playerLevel)
	{
		this.playerLevel = playerLevel;
	}
	
	/**
	 * The method to get the level.
	 * @return palyerlevel the current level
	 */
	public String getLevelInGamePanel()
	{
		return playerLevel;
	}
	
	/**
	 * The method to set the player name.
	 * @param playerName the desired name
	 */
	public void setPlayerInGamePanel(String playerName)
	{
		this.playerName = playerName;
	}
	
	/**
	 * The method to get player name.
	 * @return playerName the current name
	 */
	public String getNameInGamePanel()
	{
		return playerName;
	}
	
	/**
	 * The method to set the score.
	 * @param playerScore the score to set
	 */
	public void setScoreInGamePanel(String playerScore)
	{
		this.playerScore = playerScore;
	}
	
	/**
	 * The method to return score.
	 * @return playerScore the current score
	 */
	public String getScoreInGamePanel()
	{
		return playerScore;
	}
	/**
	 * method to return In-game panel.
	 * @return ingamePanel the in-game panel
	 */
	public JPanel getInGamePanel()
	{
		return inGamePanel;
	}
	
	/**
	 * Method to set name in label name.
	 * @param name the desired name
	 */
	public void setLabelName(String name)
	{
		this.name.setText("Name:   " + name);
	}
	
	/**
	 * Method to return name label.
	 * @return name the current name label
	 */
	public JLabel getNameLabel()
	{
		return name;
	}
	
	/**
	 * Method to set the score.
	 * @param score the desired score
	 */
	public void setScoreLabel(String score)
	{
		this.score.setText("Score:   " + score);
	}
	
	/**
	 * Method to return score label.
	 * @return score the score label
	 */
	public JLabel getScoreLabel()
	{
		return score;
	}
	
	/**
	 * Method to set the level label.
	 * @param level the desired level
	 */
	public void setLevelLabel(String level)
	{
		this.level.setText("Level:   " + level);
	}
	
	/**
	 * Method to get level label
	 * @return level the level label
	 */
	public JLabel getLevelLabel()
	{
		return level;
	}
	
	/**
	 * Method to set score
	 * @param aScore the desired score
	 */
	public void setAScore(int aScore)
	{
		this.aScore = this.aScore + aScore;
	}
	
	/**
	 * Method to set the level
	 * @param aLevel the desired level
	 */
	public void setALevel(int aLevel)
	{
		this.aLevel = aLevel;
	}
	
	/**
	 * Method to return the score
	 * @return aScore the current score
	 */
	public int getAScore()
	{
		return aScore;
	}
	
	/**
	 * Method to return the level.
	 * @return aLevel the current level
	 */
	public int getALevel()
	{
		return aLevel;
	}
	
	/**
	 * Method to get boardgamePanel.
	 * @return boardGamePanel the board-game panel
	 */
	public BoardGamePanel getBoardGamePanel()
	{
		return boardGamePanel;
	}
	
	/**
	 * The method to set boolean lost.
	 * @param lost the desired lost value
	 */
	public void setLost(boolean lost)
	{
		this.lost = lost;
	}
	
	/**
	 * Method to set boolean start.
	 * @param gameStart the boolean game-start value
	 */
	public void setGameStart(boolean gameStart)
	{
		this.gameStart = gameStart;
	}
	
	/**
	 * Method to get boolean start.
	 * @return gameStart the boolean game-start value
	 */
	public boolean getGameStart()
	{
		return gameStart;
	}
	
	
	private String playerLevel;
	private String playerName;
	private String playerScore;
	
	private JPanel inGamePanel;
	private JLabel name;
	private JLabel score;
	private JLabel level;
	
	private BoardGamePanel boardGamePanel;
	
	private int aScore;
	private int aLevel;
	private Color[][] colors;
	private boolean lost = false;
	private boolean gameStart = false; // to make to new figure drop
}
