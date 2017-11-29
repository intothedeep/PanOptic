package com.kitri.user.game;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HotGamePane extends JPanel {

	public JLabel gameLabel[];
	UserProgramView uView;

	/**
	 * Create the panel.
	 */
	public HotGamePane(UserProgramView uView){
		this.uView =uView;
		setLayout(new GridLayout(7, 8, 10, 10));

		gameLabel = new JLabel[56];
		int len = gameLabel.length;
		ImageIcon icon = new ImageIcon("UserMainImage\\overwatch.jpg");
		gameLabel[0] = new JLabel("");
		gameLabel[0].setIcon(icon);
		add(gameLabel[0]);
		for (int i = 1; i < len; i++) {
			gameLabel[i] = new JLabel(" ");
			gameLabel[i].addMouseListener(uView.gmListener);
			add(gameLabel[i]);
		}
	}
}
