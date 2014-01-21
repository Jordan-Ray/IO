package io.view;

import io.controller.IOController;
import io.view.IOPanel;

import javax.swing.JFrame;

/***
 * Frame for the IO project.
 * @author jray1621
 * @version 1.0 13/12/2013 Created setup method and constructor.
 */
public class IOFrame extends JFrame
{
	/**
	 * IOPanel for the frame.
	 */
	private IOController baseController;
	private IOPanel basePanel;
	
	/**
	 * constructor for the IOFrame.
	 * @param baseController
	 */
	public IOFrame(IOController baseController)
	{
		this.baseController = baseController;
		basePanel = new IOPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * Sets up the frame size and loads the content panel.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,300);
		this.setVisible(true);
	}
	

}
