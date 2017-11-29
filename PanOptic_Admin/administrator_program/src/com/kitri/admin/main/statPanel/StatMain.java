package com.kitri.admin.main.statPanel;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatMain extends JPanel {

	/**
	 * Create the panel.
	 */
	public StatMain() {
		setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton btnNewButton = new JButton("\uB098\uC774\uBCC4");
		btnNewButton.setBackground(new Color(200, 162, 255));
		btnNewButton.setForeground(new Color(255,255,255));
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		
		JButton btnNewButton_1 = new JButton("\uC2DC\uAC04\uBCC4");
		btnNewButton_1.setBackground(new Color(200, 162, 255));
		btnNewButton_1.setForeground(new Color(255,255,255));
		btnNewButton_1.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC694\uC77C\uBCC4");
		btnNewButton_2.setBackground(new Color(200, 162, 255));
		btnNewButton_2.setForeground(new Color(255,255,255));
		btnNewButton_2.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(btnNewButton_2);
		add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("\uC2DD\uC0AC\uBCC4");
		btnNewButton_4.setBackground(new Color(200, 162, 255));
		btnNewButton_4.setForeground(new Color(255,255,255));
		btnNewButton_4.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\uAC8C\uC784\uBCC4");
		btnNewButton_5.setBackground(new Color(200, 162, 255));
		btnNewButton_5.setForeground(new Color(255,255,255));
		btnNewButton_5.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\uC2A4\uB0B5\uBCC4");
		btnNewButton_6.setBackground(new Color(200, 162, 255));
		btnNewButton_6.setForeground(new Color(255,255,255));
		btnNewButton_6.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("\uC74C\uB8CC\uBCC4");
		btnNewButton_7.setBackground(new Color(200, 162, 255));
		btnNewButton_7.setForeground(new Color(255,255,255));
		btnNewButton_7.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(btnNewButton_7);
		
		JButton btnNewButton_3 = new JButton("\uC131\uBCC4");
		btnNewButton_3.setBackground(new Color(200, 162, 255));
		btnNewButton_3.setForeground(new Color(255,255,255));
		btnNewButton_3.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(btnNewButton_3);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		

	}

}
