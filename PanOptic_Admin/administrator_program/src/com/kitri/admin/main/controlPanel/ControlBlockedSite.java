package com.kitri.admin.main.controlPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.kitri.admin.main.fixCon.Fix;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Font;

public class ControlBlockedSite extends JFrame {
	public JPanel contentPane;
	public DefaultTableModel model;
	public JTable jTable;
	public JScrollPane jScrollPane;
	public JPanel mainPanel;
	public JPanel jtablePanel;
	public JButton delBtn;
	public JButton regBtn;
	public JButton edit;
	
	
	public Vector<String> column = new Vector<>();
	public Vector<Vector> rows = new Vector<>();

	public ControlBlockedSite() {
		super("Â÷´Ü ½ÎÀÌÆ® °ü¸®");
//	check
//		System.out.println(rows);
		setBounds(100, 100, 700, 610);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		
		model = new DefaultTableModel(rows, column);
		jtablePanel = new JPanel();
		jtablePanel.setOpaque(false);
		jtablePanel.setBounds(84, 25, 491, 437);
		jTable = new JTable(model);
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.getViewport().setBackground(new Color(255,255,255));
		jScrollPane.setBounds(0, 0, 491, 437);
		
		delBtn = new JButton("\uC0AD\uC81C");
		delBtn.setForeground(new Color(255, 255, 255));
		delBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		delBtn.setBackground(new Color(200, 162, 255));
		delBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		regBtn = new JButton("\uB4F1\uB85D");
		regBtn.setForeground(new Color(255, 255, 255));
		regBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		regBtn.setBackground(new Color(200, 162, 255));
		regBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		edit = new JButton("\uC218\uC815");
		edit.setForeground(new Color(255, 255, 255));
		edit.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		edit.setBackground(new Color(200, 162, 255));
		edit.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		
		jtablePanel.setLayout(null);
		jtablePanel.add(jScrollPane);
		mainPanel.setLayout(null);
		mainPanel.add(jtablePanel);
		contentPane.add(mainPanel, BorderLayout.CENTER);

		delBtn.setBounds(485, 473, 89, 23);
		mainPanel.add(delBtn);
		regBtn.setBounds(387, 473, 89, 23);
		mainPanel.add(regBtn);
		edit.setBounds(84, 473, 89, 23);
		mainPanel.add(edit);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Fix.FIXFRAME(this);
	}
}
