package edu.sjsu.cs151.tetris.game;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.sjsu.cs151.tetris.controller.Controller;
import edu.sjsu.cs151.tetris.controller.Message;
import edu.sjsu.cs151.tetris.controller.TimeController;
import edu.sjsu.cs151.tetris.model.Model;
import edu.sjsu.cs151.tetris.view.ViewMain;

/**
 * The main class to compile the Tetris game
 * @author Luksawee
 * @author Nick
 */
public class Tetris {

	private ViewMain viewMain;
	private Model model;
	private Controller controller;
	private TimeController tController;

	private Thread controllerThread;
	private Thread viewThread;
	private Thread tControllerThread;

	/* Creating BlockongQueues */
	private BlockingQueue<Message> controllerToViewQueue = new LinkedBlockingQueue<Message>();
	private BlockingQueue<Message> viewToControllerQueue = new LinkedBlockingQueue<Message>();

	/**
	 * Method to instantiate MVC and threads
	 */
	public Tetris() {
		/* Creating MVC (with 2 controllers) */
		model = new Model();
		viewMain = new ViewMain();
		controller = new Controller();
		tController = new TimeController();

		/* Passing BlockingQueues and model to Controller */
		controller.setModel(model);
		controller.setControllerToViewQueue(controllerToViewQueue);
		controller.setViewToControllerQueue(viewToControllerQueue);
		

		/*
		 * TimeController does not need viewToController BlockingQueue because it does
		 * not interact with user
		 */
		tController.setModel(model, viewMain);
		tController.setControllerToViewQueue(controllerToViewQueue);

		/*
		 * View does not need Model (data) because all it needs it receives from
		 * messages
		 */
		viewMain.setControllerToViewQueue(controllerToViewQueue);
		viewMain.setViewToControllerQueue(viewToControllerQueue);

		/* Creating and running threads */
		controllerThread = new Thread(controller);
		viewThread = new Thread(viewMain);
		tControllerThread = new Thread(tController);
		controllerThread.start();
		viewThread.start();
		tControllerThread.start();
	}
	
	/**
	 * Main method to start the game
	 * @param args unused
	 */
	public static void main(String[] args) 
	{
		/* Creating Main class object starts the game */
		Tetris Tetris = new Tetris();
		
	}
}
