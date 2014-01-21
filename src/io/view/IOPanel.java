package io.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import io.controller.IOController;
import io.model.Game;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class IOPanel extends JPanel
{
	private IOController baseController;
	private JButton saveButton;
	private JButton loadButton;
	private JTextField titleField;
	private JTextField rankingField;
	private JTextArea rulesArea;
	private JLabel rulesLabel;
	private JLabel rankingLabel;
	private JLabel titleLabel;
	private SpringLayout baseLayout;
	private JLabel gameCountLabel;
	
	
	public IOPanel(IOController baseController)
	{
		this.baseController = baseController;
		
		saveButton = new JButton("Save the game stuff");
		loadButton = new JButton("Load the game stuff");
		titleField = new JTextField(15);
		titleLabel = new JLabel("Game Title");
		rankingField = new JTextField(15);
		rankingLabel = new JLabel("Game Ranking");
		rulesLabel = new JLabel("Rules");
		gameCountLabel = new JLabel("Current Game Count :" );
		
		rulesArea = new JTextArea(5, 20);
		
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.SOUTH, gameCountLabel, -6, SpringLayout.NORTH, titleLabel);
		baseLayout.putConstraint(SpringLayout.EAST, gameCountLabel, 0, SpringLayout.EAST, loadButton);
		
		
		
	
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(rankingField);
		this.add(rankingLabel);
		this.add(rulesArea);
		this.add(rulesLabel);
		this.add(saveButton);
		this.add(titleField);
		this.add(titleLabel);
		this.add(loadButton);
		this.add(gameCountLabel);
		
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, rulesLabel, -84, SpringLayout.WEST, rulesArea);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, -39, SpringLayout.WEST, saveButton);
		baseLayout.putConstraint(SpringLayout.WEST, titleField, 0, SpringLayout.WEST, rankingField);
		baseLayout.putConstraint(SpringLayout.SOUTH, titleField, -17, SpringLayout.NORTH, rankingField);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 18, SpringLayout.SOUTH, rulesArea);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, rankingField);
		baseLayout.putConstraint(SpringLayout.SOUTH, rankingField, -21, SpringLayout.NORTH, rulesArea);
		baseLayout.putConstraint(SpringLayout.EAST, rankingField, -115, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, rulesArea, -86, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, rulesArea, -87, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, rankingLabel, 76, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, titleLabel, 3, SpringLayout.NORTH, titleField);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 0, SpringLayout.WEST, rankingLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, rulesLabel, 57, SpringLayout.SOUTH, rankingLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, rankingLabel, 3, SpringLayout.NORTH, rankingField);
		
		
	}
	
	public void setupListeners()
	{
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Game tempGame = baseController.makeGameFromInput(titleField.getText(), rankingField.getText(), rulesArea.getText());
				if(tempGame != null)
				{
					baseController.saveGameInformation(tempGame);
					gameCountLabel.setText("current game count: " + baseController.getProjectGames().size());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Try again wiht a valid number");
				}
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Game tempGame = baseController.readGameInformation();
				if( tempGame != null)
				{
					titleField.setText(tempGame.getGameTitle());
					rankingField.setText(Integer.toString(tempGame.getFunRanking()));
					String temp = "";
					for(String currentRule : tempGame.getGameRules() )
					{
						temp+= currentRule + "\n";
					}
					rulesArea.setText(temp);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Check the save file make sure it is in order.");
				}
			}
		});
		
	}
}
