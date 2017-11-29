package com.kitri.admin.messenger;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import com.kitri.admin.main.ComDetailView;

import java.awt.Component;

public class Messenger extends JInternalFrame {
	public JTextField msgTf;
	private JPanel backgroundPane;
	private JLabel msgTitleLabel;
	private JPanel msgTitlePane;
	private JScrollPane msgTextAreaPane;
	public JTextArea msgtextArea;
	private JPanel messageTfPane;
	public JButton msgBtn;
	public MessengerListener listener;
	public StringBuilder messageBuffer;
	public ComDetailView detailView;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messenger frame = new Messenger(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Messenger(ComDetailView detailView) {
	    super("PC " + detailView.index);
	    this.detailView = detailView;
	    	messageBuffer = new StringBuilder("");
		listener = new MessengerListener(this);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 433, 354);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.WHITE);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);
		
		msgTitlePane = new JPanel();
		msgTitlePane.setOpaque(false);
		FlowLayout fl_MsgTitlePane = (FlowLayout) msgTitlePane.getLayout();
		fl_MsgTitlePane.setAlignment(FlowLayout.LEFT);
		msgTitlePane.setBounds(12, 10, 175, 34);
		backgroundPane.add(msgTitlePane);
		
		msgTitleLabel = new JLabel("[ \uB300\uD654\uCC3D ]");
		msgTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		msgTitleLabel.setIcon(new ImageIcon("UserMainImage\\chatmakr.png"));
		msgTitleLabel.setForeground(new Color(200, 162, 255));
		msgTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		msgTitleLabel.setFont(new Font("¹è´ÞÀÇ¹ÎÁ· µµÇö", Font.BOLD, 23));
		msgTitlePane.add(msgTitleLabel);
		
		msgTextAreaPane = new JScrollPane();
		msgTextAreaPane.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(230, 230, 250)));
		msgTextAreaPane.setBounds(12, 54, 387, 189);
		backgroundPane.add(msgTextAreaPane);
		
		msgtextArea = new JTextArea();
		msgtextArea.setEnabled(false);
		msgtextArea.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(176, 196, 222)));
		msgtextArea.setBackground(new Color(240, 248, 255));
		msgtextArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		msgTextAreaPane.setViewportView(msgtextArea);
		
		messageTfPane = new JPanel();
		messageTfPane.setOpaque(false);
		messageTfPane.setBounds(12, 253, 387, 39);
		backgroundPane.add(messageTfPane);
		messageTfPane.setLayout(new BorderLayout(0, 0));
		
		msgTf = new JTextField();
		msgTf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(192, 192, 192)));
		messageTfPane.add(msgTf);
		msgTf.setColumns(10);
		
		msgBtn = new JButton("      \uC804\uC1A1      ");
		msgBtn.setForeground(new Color(255, 255, 255));
		msgBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(135, 206, 250)));
		msgBtn.setBackground(new Color(135, 206, 250));
		messageTfPane.add(msgBtn, BorderLayout.EAST);
		msgBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		msgBtn.addActionListener(listener);
		msgTf.addActionListener(listener);
		
		setClosable(true);
		
		setVisible(false);
	}
}
