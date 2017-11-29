package com.kitri.admin.main.employeePanel;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmpMain extends JPanel {
	JButton empListBtn;

	EmpCon control;
	EmpList empList;
	EmpDetailInfo empDetail;

	public EmpMain() {
		control = new EmpCon(this);
		empList = new EmpList();
		empDetail = new EmpDetailInfo();
		
		setLayout(new GridLayout(10, 1, 0, 0));
		empListBtn = new JButton("\uC9C1\uC6D0\uB9AC\uC2A4\uD2B8");
		empListBtn.setBackground(new Color(200, 162, 255));
		empListBtn.setForeground(new Color(255,255,255));
		empListBtn.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
		add(empListBtn);
		
//		Main 이벤트
		empListBtn.addActionListener(control);
//		직원 리스트 이벤트
//		empList.detail.addActionListener(control);
		empList.jTable.addMouseListener(control);
		empList.searchBtn.addActionListener(control);
		empList.searchTf.addActionListener(control);
//		직원 상세 정보 이벤트
		empDetail.closeBtn.addActionListener(control);
		empDetail.updateBtn.addActionListener(control);
		
	}
}
