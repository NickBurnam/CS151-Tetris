package edu.sjsu.cs151.tetris.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * The class to test the block.
 * @author Luksawee
 */
class BlockTest {

	@Test
	public void testBlock() {
		Block block1 = new Block(2,3);
		int x = block1.getXPosition();
		int y = block1.getYPosition();
		assertEquals(2, x);
		assertEquals(3, y);
	}
	
	@Test
	public void testSetXPosition() {
		Block block1 = new Block();
		block1.setXPosition(5);
		int x = block1.getXPosition();
		assertEquals(5, x);
	}
	
	@Test
	public void testSetYPosition() {
		Block block1 = new Block();
		block1.setYPosition(1);
		int y = block1.getYPosition();
		assertEquals(1, y);
	}

}
