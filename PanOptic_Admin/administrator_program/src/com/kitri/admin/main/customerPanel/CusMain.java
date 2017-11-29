package com.kitri.admin.main.customerPanel;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CusMain extends JPanel {
	JButton cusListBtn;

	public CusCon control;
	public CusList cusList;
	
	public CusMain() {
		control = new CusCon(this);
		cusList = new CusList();
		
		setLayout(new GridLayout(10, 1, 0, 0));
		cusListBtn = new JButton("\uD68C\uC6D0\uB9AC\uC2A4\uD2B8");
		cusListBtn.setBackground(new Color(200, 162, 255));
		cusListBtn.setForeground(new Color(255,255,255));
		cusListBtn.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(cusListBtn);
		
//		main 이벤트
		cusListBtn.addActionListener(control);
		
//		list 이벤트
		cusList.searchBut.addActionListener(control);
		cusList.searchTf.addActionListener(control);
		cusList.searchCombo.addActionListener(control);
		cusList.listCombo.addActionListener(control);
	}

}
