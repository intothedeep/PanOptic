package com.kitri.admin.main.customerPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

public class CusBlacklist extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	JFrame jFrame = new JFrame();

	String columnNames[] =
	{ "이름", "ID", "E-mail", "주소" };

	Object rowData[][] =
	{
	{ "김하람", "HaRam", "HaRam1@naver.com", "서울시 구로구 구로동" },
	{ "김하연", "kimHY", "KimHY@naver.com", "서울시 구로구 구로동" }};
	
	JTable jTable = new JTable(rowData, columnNames);
	JScrollPane jScollPane = new JScrollPane(jTable);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusBlacklist frame = new CusBlacklist();
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
	public CusBlacklist() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 677, 542);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBounds(0, 0, 678, 545);
		panel.add(panel_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\java\\workspace\\javase\\PanOptic\\src\\img\\q1.png"));
		button.setForeground(Color.WHITE);
		button.setBorder(null);
		button.setBackground(Color.WHITE);
		button.setBounds(631, 25, 30, 27);
		panel_1.add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(436, 25, 186, 27);
		panel_1.add(textField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(17, 60, 644, 479);
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(jScollPane, BorderLayout.NORTH);
		

		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(17, 25, 171, 27);
		panel_1.add(comboBox);
		comboBox.addItem("블랙리스트");
		comboBox.addItem("고객리스트");
      }
}

