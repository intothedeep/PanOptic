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
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class ControlRegBlockedSite extends JFrame {
	JPanel contentPane;
	JTextField urlTF;
	JTextField siteNameTF;
	JLabel siteNameL;
	JLabel urlL;
	JButton ok;

	public ControlRegBlockedSite() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		
		urlL = new JLabel("URL");
		urlL.setFont(new Font("¹è´ÞÀÇ¹ÎÁ· µµÇö", Font.BOLD, 15));
		urlL.setBounds(100, 85, 60, 14);
		getContentPane().add(urlL);
		
		siteNameL = new JLabel("\uC2F8\uC774\uD2B8\uBA85");
		siteNameL.setFont(new Font("¹è´ÞÀÇ¹ÎÁ· µµÇö", Font.BOLD, 15));
		siteNameL.setBounds(100, 125, 60, 14);
		getContentPane().add(siteNameL);
		
		urlTF = new JTextField();
		urlTF.setBackground(SystemColor.controlHighlight);
		urlTF.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		urlTF.setBounds(210, 80, 150, 20);
		getContentPane().add(urlTF);
		urlTF.setColumns(10);
		urlTF.requestFocus();
		
		siteNameTF = new JTextField();
		siteNameTF.setBackground(SystemColor.controlHighlight);
		siteNameTF.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		siteNameTF.setBounds(210, 120, 150, 20);
		getContentPane().add(siteNameTF);
		siteNameTF.setColumns(10);
		
		ok = new JButton("È®ÀÎ");
		ok.setBackground(new Color(200, 162, 255));
		ok.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		ok.setForeground(SystemColor.window);
		ok.setBounds(180, 170, 90, 23);
		getContentPane().add(ok);
		
		Fix.FIXFRAME(this);
	}
}
