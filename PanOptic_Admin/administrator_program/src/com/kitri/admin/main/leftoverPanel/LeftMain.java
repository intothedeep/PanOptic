package com.kitri.admin.main.leftoverPanel;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.kitri.admin.main.controlPanel.ControlConstant;
import com.kitri.admin.main.fixCon.Fix;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;

public class LeftMain extends JPanel {
	JButton leftOverBtn;
	
	LeftList leftList;
	LeftCon control;
	
	public LeftMain() {
		leftList = new LeftList();
		control = new LeftCon(this);
	
		setLayout(new GridLayout(10, 1, 0, 0));
		leftOverBtn = new JButton("\uC7AC\uACE0\uAD00\uB9AC");
		leftOverBtn.setBackground(new Color(200, 162, 255));
		leftOverBtn.setForeground(new Color(255,255,255));
		leftOverBtn.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(leftOverBtn);
		
//		LeftMain â
		leftOverBtn.addActionListener(control);
//		leftList â
		leftList.searchBtn.addActionListener(control);
		leftList.searchTf.addActionListener(control);
	}
}
