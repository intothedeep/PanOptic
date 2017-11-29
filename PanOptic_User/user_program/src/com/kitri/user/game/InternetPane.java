package com.kitri.user.game;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InternetPane extends JPanel {
	JLabel gameLabel[];
	UserProgramView uView;
	String[] path = {"chrome.png", "IE.png", "firefox.png"};
	/**
	 * Create the panel.
	 */
	public InternetPane(UserProgramView uView) {
		this.uView =uView;
		setLayout(new GridLayout(7, 8, 10, 10));
		gameLabel = new JLabel[56];
		int len = gameLabel.length;
		int pathLen = path.length;
		for(int i = 0; i < pathLen; i++){
		    gameLabel[i] = new JLabel();
		    gameLabel[i].setIcon(new ImageIcon("UserMainImage\\" + path[i]));
		    add(gameLabel[i]);
		}
		
		for (int i = pathLen + 1; i < len; i++) {
			gameLabel[i] = new JLabel(" ");
			gameLabel[i].addMouseListener(uView.gmListener);
			add(gameLabel[i]);
		}

	}

}
