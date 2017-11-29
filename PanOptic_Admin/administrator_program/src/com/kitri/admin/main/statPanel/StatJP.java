package com.kitri.admin.main.statPanel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public StatJP() {
		setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton btnNewButton = new JButton("\uB098\uC774\uBCC4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("\uC2DC\uAC04\uBCC4");
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC694\uC77C\uBCC4");
		add(btnNewButton_2);
		add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("\uC2DD\uC0AC\uBCC4");
		add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\uAC8C\uC784\uBCC4");
		add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\uC2A4\uB0B5\uBCC4");
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("\uC74C\uB8CC\uBCC4");
		add(btnNewButton_7);
		
		JButton btnNewButton_3 = new JButton("\uC131\uBCC4");
		add(btnNewButton_3);

	}

}
