package edu.sjsu.cs151.tetris.controller;

	/**
	 * Class that will create the connection between model and view.
	 */

	public class Message
	{
		public static enum ValveResponse 
		{
			REDRAW, 
			CHANGE_NEXT, 
			SCORES_UPDATE, 
			LOST, 
			MOVE_LEFT, 
			MOVE_RIGHT, 
			FASTER, 
			ROTATE_LEFT, 
			ROTATE_RIGHT, 
			RESTART, 
			GET_NEWGAME,
			WIN;};
		private ValveResponse valveResponse;
		private int add_info;  // for the score
		private int [][] data;  // to draw figure
		
		/**
		 * @param t Type of the message we create
		 */
		public Message(ValveResponse v)
		{
			valveResponse = v;
			add_info = 0;
		}
		
		/**
		 * @param t	Type of the message we create.
		 * @param a	Additional information for example scores while updating scores.
		 */
		public Message (ValveResponse v, int a)
		{
			valveResponse = v;
			add_info = a;
		}
		
		/**
		 * @param t	Type of the message we create.
		 * @param d	Two dimensional array with data to be shown on the board type int.
		 */
		public Message (ValveResponse v, int [][] d)
		{
			valveResponse = v;
			data = d;
		}
		
		/**
		 * @return Type of the received message.
		 */
		public ValveResponse getValveResponse()
		{
			return valveResponse;
		}
		
		/**
		 * @return Additional information (single int value)
		 */
		public int getAdd()
		{
			return add_info;
		}	
		
		/**
		 * @return Received data to be shown on the screen.
		 */
		public int[][] getData()
		{
			return data;
		}
	}

