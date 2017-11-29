package com.kitri.admin.main.controlPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class ControlAgeRestriction extends JFrame {

	private JPanel contentPane;
	public JButton restrictionButton;
	public ControlAgeRestrictionController controller;

	public ControlAgeRestriction() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 610);
		controller = new ControlAgeRestrictionController(this);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1998");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(136, 210, 85, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB144\uC0DD \uC774\uC0C1\uC740 10\uC2DC\uAE4C\uC9C0 \uC774\uC6A9 \uAC00\uB2A5 \uD569\uB2C8\uB2E4.");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(218, 214, 326, 27);
		contentPane.add(lblNewLabel_1);
		
		restrictionButton = new JButton("\uC54C\uB9BC \uD31D\uC5C5\uCC3D \uBCF4\uB0B4\uAE30");
		restrictionButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		restrictionButton.setForeground(new Color(255, 255, 255));
		restrictionButton.setFont(new Font("¹è´ÞÀÇ¹ÎÁ· µµÇö", Font.BOLD, 17));
		restrictionButton.setBackground(new Color(255, 69, 0));
		restrictionButton.setBounds(136, 281, 398, 56);
		contentPane.add(restrictionButton);	
		
		
		restrictionButton.addActionListener(controller);

		setAlwaysOnTop(true);
	}
}
