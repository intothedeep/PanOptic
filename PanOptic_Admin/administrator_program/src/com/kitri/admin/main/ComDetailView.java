package com.kitri.admin.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.admin.messenger.Messenger;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComDetailView extends JInternalFrame {

    private JPanel contentPane;
    public JLabel comViewId;
    private JLabel comViewNameLabel;
    public JLabel comViewName;
    private JLabel comViewRestTimeLabel;
    public JLabel comViewRestTime;
    private JLabel comViewUseTimeLabel;
    public JLabel comViewUseTime;
    private JLabel comViewUseProgram;
    private JLabel comViewIdLabel;

    public PcMain pcMain;
    public JButton closeButton;
    public ComDetailViewController controller;
    public JTextArea comViewUseProgramTA;
    private JScrollPane scrollPane;
    public JButton messengerButton;
    public int index;
    public Messenger messenger;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ComDetailView frame = new ComDetailView(null, 0);
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
    public ComDetailView(PcMain pcMain, int index) {
	this.index = index;
	this.pcMain = pcMain;
	messenger = new Messenger(this);
	controller = new ComDetailViewController(this);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 334, 352);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	comViewIdLabel = new JLabel("ID");
	comViewIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	comViewIdLabel.setBounds(49, 21, 57, 15);
	contentPane.add(comViewIdLabel);

	comViewId = new JLabel();
	comViewId.setBounds(144, 18, 116, 21);
	contentPane.add(comViewId);
	// comViewId.setColumns(10);

	comViewNameLabel = new JLabel("\uC774\uB984");
	comViewNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	comViewNameLabel.setBounds(49, 54, 57, 15);
	contentPane.add(comViewNameLabel);

	comViewName = new JLabel();
	// comViewName.setColumns(10);
	comViewName.setBounds(144, 51, 116, 21);
	contentPane.add(comViewName);

	comViewRestTimeLabel = new JLabel("\uC794\uC5EC\uC2DC\uAC04");
	comViewRestTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	comViewRestTimeLabel.setBounds(49, 92, 57, 15);
	contentPane.add(comViewRestTimeLabel);

	comViewRestTime = new JLabel();
	// comViewRestTime.setColumns(10);
	comViewRestTime.setBounds(144, 89, 116, 21);
	contentPane.add(comViewRestTime);

	comViewUseTimeLabel = new JLabel("\uC0AC\uC6A9\uC2DC\uAC04");
	comViewUseTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	comViewUseTimeLabel.setBounds(49, 131, 57, 15);
	contentPane.add(comViewUseTimeLabel);

	comViewUseTime = new JLabel();
	// comViewUseTime.setColumns(10);
	comViewUseTime.setBounds(144, 128, 116, 21);
	contentPane.add(comViewUseTime);

	comViewUseProgram = new JLabel("\uC0AC\uC6A9\uD504\uB85C\uADF8\uB7A8");
	comViewUseProgram.setHorizontalAlignment(SwingConstants.RIGHT);
	comViewUseProgram.setBounds(15, 169, 91, 15);
	contentPane.add(comViewUseProgram);
	JScrollPane scrollPane = new JScrollPane();
	contentPane.add(scrollPane);

	closeButton = new JButton("\uB2EB\uAE30");
	closeButton.setBounds(209, 292, 97, 23);
	contentPane.add(closeButton);
	
	comViewUseProgramTA = new JTextArea();
	contentPane.add(comViewUseProgramTA);
	comViewUseProgramTA.setBounds(25, 194, 279, 61);
	comViewUseProgramTA.setEditable(false);
	scrollPane = new JScrollPane(comViewUseProgramTA);
	scrollPane.setBounds(25, 194, 281, 88);
	contentPane.add(scrollPane);
	
	messengerButton = new JButton("\uBA54\uC2E0\uC800");
	messengerButton.setBounds(100, 292, 97, 23);
	contentPane.add(messengerButton);
	

	pcMain.contentPane.add(messenger);

	messengerButton.addActionListener(controller);
	closeButton.addActionListener(controller);

    }
}