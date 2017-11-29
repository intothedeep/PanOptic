package com.kitri.admin.main.controlPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri.admin.main.fixCon.Fix;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class ControlDelBlockedSite extends JFrame {
	JPanel contentPane;
	JTextField siteNameTF;
	JButton ok;
	JLabel siteName;

	public ControlDelBlockedSite() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		
		siteName = new JLabel("\uC2F8\uC774\uD2B8\uBA85");
		siteName.setFont(new Font("¹è´ÞÀÇ¹ÎÁ· µµÇö", Font.BOLD, 15));
		siteName.setBounds(100, 105, 80, 14);
		getContentPane().add(siteName, BorderLayout.WEST);
		
		siteNameTF = new JTextField();
		siteNameTF.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		siteNameTF.setBounds(200, 102, 150, 20);
		getContentPane().add(siteNameTF);
		siteNameTF.setColumns(10);
		siteNameTF.requestFocus();
		
		ok = new JButton("È®ÀÎ");
		ok.setForeground(new Color(255, 255, 255));
		ok.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		ok.setBackground(new Color(200, 162, 255));
		ok.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		ok.setBounds(170, 160, 90, 21);
		getContentPane().add(ok);
		
		Fix.FIXFRAME(this);
	}

}
