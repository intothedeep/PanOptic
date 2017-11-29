package com.kitri.admin.main.storePanel;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.Color;

public class StoreMain extends JPanel {
	JButton settleBtn;
	StoreCon control;
	
	public StoreSettleAccount settleAccount;
		
	public StoreMain() {
		
		settleAccount = new StoreSettleAccount();
		settleAccount.setBackground(new Color(255, 255, 255));
		settleAccount.getContentPane().setBackground(new Color(255, 255, 255));
		control = new StoreCon(this);
		
		setLayout(new GridLayout(10, 1, 0, 0));
		settleBtn = new JButton("정산");
		settleBtn.setBackground(new Color(200, 162, 255));
		settleBtn.setForeground(new Color(255,255,255));
		settleBtn.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(settleBtn);
		
//		store 이벤트
		settleBtn.addActionListener(control);
		
//		settle 이벤트
		settleAccount.searchBtn.addActionListener(control);
	}

}
