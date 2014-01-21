package io.controller;

import io.controller.IOController;

/**
 * The Runner class for the IO project.
 * @author Jordan Ray
 * @version 1.0 13/12/2013 Basic Runner structure.
 */
public class IORunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		IOController appController = new IOController();
		appController.start();

	}

}
