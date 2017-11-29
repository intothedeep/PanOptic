package com.kitri.user.game;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OnlineGamePane extends JPanel {
	JLabel gameLabel[];
	UserProgramView uView;
	/**
	 * Create the panel.
	 */
	public OnlineGamePane(UserProgramView uView) {
		this.uView =uView;
		setLayout(new GridLayout(7, 8, 10, 10));
		gameLabel = new JLabel[56];
		int len = gameLabel.length;
		
		gameLabel[0] = new JLabel();
		gameLabel[0].setIcon(new ImageIcon("UserMainImage\\lol.png"));
		add(gameLabel[0]);
		for (int i = 1; i < len; i++) {
			gameLabel[i] = new JLabel(" ");
			gameLabel[i
			          ].addMouseListener(uView.gmListener);
			add(gameLabel[i]);
		}
	}
}
