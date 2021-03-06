package edu.sjsu.cs151.tetris.animation;

import edu.sjsu.cs151.tetris.model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 * Test Class for the welcomeScreen
 * @author Luksawee
 * @author Nick
 */
public class WelcomeScreen {

	/**
	 * Main method for welcome screen animation test
	 * @param args unused
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(600, 800);
		
		final MoveableShape zShape = new DrawTetromino('Z', 0, 0, TETROMINO_WIDTH);
		final MoveableShape iShape = new DrawTetromino('I', 0, 0, TETROMINO_WIDTH);
		final MoveableShape oShape = new DrawTetromino('O', 0, 0, TETROMINO_WIDTH);
		final MoveableShape lShape = new DrawTetromino('L', 0, 0, TETROMINO_WIDTH);
		final MoveableShape tShape = new DrawTetromino('T', 0, 9, TETROMINO_WIDTH);
		final MoveableShape jShape = new DrawTetromino('J', 0, 9, TETROMINO_WIDTH);
		final MoveableShape sShape = new DrawTetromino('S', 0, 9, TETROMINO_WIDTH);

		ShapeIcon iconZ = new ShapeIcon(zShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconI = new ShapeIcon(iShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconO = new ShapeIcon(oShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconL = new ShapeIcon(lShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconT = new ShapeIcon(tShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconJ = new ShapeIcon(jShape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon iconS = new ShapeIcon(sShape, ICON_WIDTH, ICON_HEIGHT);

		final JLabel labelZ = new JLabel(iconZ);
		final JLabel labelI = new JLabel(iconI);
		final JLabel labelO = new JLabel(iconO);
		final JLabel labelL = new JLabel(iconL);
		final JLabel labelT = new JLabel(iconT);
		final JLabel labelJ = new JLabel(iconJ);
		final JLabel labelS = new JLabel(iconS);
		
		JButton welcomeButton = new JButton("Start Tetris Game");
		welcomeButton.setFont(new Font("TimesRoman", Font.BOLD, 30));
		welcomeButton.setBackground(Color.DARK_GRAY);
		welcomeButton.setOpaque(true);
		welcomeButton.setVisible(true);	


		Panel northPanel = new Panel();
		northPanel.setLayout(new FlowLayout());
		northPanel.add(labelZ);
		northPanel.add(labelI);
		northPanel.add(labelO);
		northPanel.add(labelL);
		northPanel.setVisible(true);

		Panel southPanel = new Panel();
		southPanel.setLayout(new FlowLayout());
		southPanel.add(labelT);
		southPanel.add(labelJ);
		southPanel.add(labelS);
		southPanel.setVisible(true);

		JPanel welcomePanel = new JPanel();
		welcomePanel.setSize(605, 800);
		welcomePanel.setLayout(new BorderLayout());
		welcomePanel.add(northPanel, BorderLayout.NORTH);
		welcomePanel.add(welcomeButton, BorderLayout.CENTER);
		welcomePanel.add(southPanel, BorderLayout.SOUTH);
		welcomePanel.setVisible(true);
		
		frame.add(welcomePanel);
		
		// to hide the welcome panel
		welcomeButton.addActionListener(event -> frame.remove(welcomePanel));
		// to visible the main screen
		welcomeButton.addActionListener(event -> northPanel.setVisible(false));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		final int delay1 = 3000;
		// Milliseconds between timer ticks
		ActionListener listener1 = event -> {
			if (zShape.getY() >= 0) {
				zShape.translate(0, 1);
				labelZ.repaint();
				lShape.translate(0, 1);
				labelL.repaint();
				tShape.moveUp(0, 1);
				labelT.repaint();
				sShape.moveUp(0, 1);
				labelS.repaint();
			}
			if (zShape.getY() > 12) {
				zShape.moveUp(0, 13);
				labelZ.repaint();
				lShape.moveUp(0, 13);
				labelL.repaint();
				tShape.translate(0, 13);
				labelT.repaint();
				sShape.translate(0, 13);
				labelS.repaint();
			}
		};
		Timer t1 = new Timer(delay1, listener1);
		t1.start();

		final int delay2 = 1000;
		// Milliseconds between timer ticks
		ActionListener listener2 = event -> {
			if (iShape.getY() >= 0) {
				iShape.translate(0, 1);
				labelI.repaint();
				oShape.translate(0, 1);
				labelO.repaint();
				jShape.moveUp(0, 1);
				labelJ.repaint();
			}
			if (iShape.getY() > 12) {
				iShape.moveUp(0, 13);
				labelI.repaint();
				oShape.moveUp(0, 13);
				labelO.repaint();
				jShape.translate(0, 13);
				labelJ.repaint();
			}
		};
		Timer t2 = new Timer(delay2, listener2);
		t2.start();
	}

	private static final int ICON_WIDTH = 145;
	private static final int ICON_HEIGHT = 350;
	private static final int TETROMINO_WIDTH = 30;
	Block[] blocks = new Block[4];
	Tetromino tetromino = new Tetromino();
}