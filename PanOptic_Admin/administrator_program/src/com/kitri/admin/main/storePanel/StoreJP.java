package com.kitri.admin.main.storePanel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class StoreJP extends JPanel {

	/**
	 * Create the panel.
	 */
	public StoreJP() {
		setLayout(new GridLayout(10, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("\uB9E4\uCD9C");
		add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\uC815\uC0B0");
		add(btnNewButton);

	}

}
