package com.kitri.user.game;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EctGamePane extends JPanel {
	UserProgramView uView;
	JLabel gameLabel[];
	/**
	 * Create the panel.
	 */
	public EctGamePane(UserProgramView uView) {
		this.uView = uView;
		setLayout(new GridLayout(7, 8, 10, 10));
		gameLabel = new JLabel[56];
		int len = gameLabel.length;
		for (int i = 0; i < len; i++) {
			gameLabel[i] = new JLabel();
			gameLabel[i].addMouseListener(uView.gmListener);
			add(gameLabel[i]);
		}

	}

}
