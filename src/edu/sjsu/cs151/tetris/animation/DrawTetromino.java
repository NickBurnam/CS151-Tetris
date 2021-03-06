package edu.sjsu.cs151.tetris.animation;
import edu.sjsu.cs151.tetris.model.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

/**
 * The class that use to draw the figure
 * @author Luksawee
 * @author Nick
 */
public class DrawTetromino implements MoveableShape 
{
	/**
	 * Constructs a figure item.
	 * @param x     the left of the bounding rectangle
	 * @param y     the top of the bounding rectangle
	 * @param width the width of the bounding rectangle
	 */
	public DrawTetromino(char shape, int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.shape = shape;
		this.width = width;
	}

	/**
	 * Method to move figure up
	 * @param dx The x value
	 * @param dy The y value
	 */
	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	/**
	 * Method to move figure down
	 * @param dx The x value
	 * @param dy The y value
	 */
	public void moveUp(int dx, int dy) {
		x -= dx;
		y -= dy;
	}

	/**
	 * Method to draw the tetromino
	 * @param g2 The graphics context
	 */
	public void draw(Graphics2D g2) {
		 tetromino.setShape(shape);
		 tetromino.setBlocks();
		 blocks = tetromino.getBlocks();
		 Rectangle2D.Double [] zBlock = new Rectangle2D.Double[4];
		 
		 // (double x, double y, double w, double h)
		// Z Shape
		 
		for (int i = 0; i < 4; i++)
		{
			int xPosition = x + blocks[i].getXPosition();
			int yPosition = y + blocks[i].getYPosition();
			zBlock[i] = new Rectangle2D.Double((xPosition * width), (yPosition * width) , width, width);
			
			if(shape == 'Z')
				g2.setColor(Color.red);
				
			if(shape == 'I')
				g2.setColor(Color.cyan);
			
			if(shape == 'O')
				g2.setColor(Color.yellow);
			
			if(shape == 'L')
				g2.setColor(Color.orange);
			
			if(shape == 'T')
				g2.setColor(Color.pink);
			
			if(shape == 'J')
				g2.setColor(Color.blue);
			
			if(shape == 'S')
				g2.setColor(Color.green);
			
			g2.fill(zBlock[i]);
			g2.setColor(Color.black);
			g2.draw(zBlock[i]);	
		}
	 }
	
	/**
	 * Method to return y coordinate
	 * @return y The y coordinate
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Method to return x coordinate
	 * @return x The x coordinate
	 */
	public int getX()
	{
		return x;
	}

	private int x;
	private int y;
	private char shape;
	private int width;
	Block [] blocks = new Block[4];
	Tetromino tetromino = new Tetromino();
	
}
