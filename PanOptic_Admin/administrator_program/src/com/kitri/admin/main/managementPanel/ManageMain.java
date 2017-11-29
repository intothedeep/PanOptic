package com.kitri.admin.main.managementPanel;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ManageMain extends JPanel {

	JButton wageInfoBtn;
	JButton regEmpBtn;
	JButton revenueBtn;
	
	ManageCon control;
	ManageEmpReg regEmp;
	ManageWageInfo wageInfo;

	public ManageMain() {
		control = new ManageCon(this);
		regEmp = new ManageEmpReg();
		wageInfo = new ManageWageInfo();

		setLayout(new GridLayout(10, 1, 0, 0));

		wageInfoBtn = new JButton("급여정보");
		wageInfoBtn.setBackground(new Color(200, 162, 255));
		wageInfoBtn.setForeground(new Color(255,255,255));
		wageInfoBtn.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(wageInfoBtn);

		regEmpBtn = new JButton("\uC9C1\uC6D0\uB4F1\uB85D");
		regEmpBtn.setBackground(new Color(200, 162, 255));
		regEmpBtn.setForeground(new Color(255,255,255));
		regEmpBtn.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(regEmpBtn);

		revenueBtn = new JButton("\uC790\uC0B0\uAD00\uB9AC");
		revenueBtn.setBackground(new Color(200, 162, 255));
		revenueBtn.setForeground(new Color(255,255,255));
		revenueBtn.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(revenueBtn);

//		manage event
		wageInfoBtn.addActionListener(control);
		regEmpBtn.addActionListener(control);
		revenueBtn.addActionListener(control);
		
//		regEmp event
		regEmp.checkBtn.addActionListener(control);
		regEmp.closeBtn.addActionListener(control);
		regEmp.joinBtn.addActionListener(control);
		
//		wageEmp event
		wageInfo.searchBtn.addActionListener(control);
		wageInfo.searchTf.addActionListener(control);

	}

}
