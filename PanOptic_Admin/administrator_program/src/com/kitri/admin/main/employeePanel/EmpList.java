package com.kitri.admin.main.employeePanel;

import java.awt.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EmpList extends JFrame {
	

	public JPanel contentPane;
	public JTable table;
//	public JButton detail;
	
	JFrame jFrame = new JFrame();

	public Vector<String> column = new Vector<>();
	public Vector<Vector> rows = new Vector<>();
	
	DefaultTableModel model;
	JTable jTable;
	JScrollPane jScollPane;
	
	public JTextField searchTf;
	JButton searchBtn;

	public EmpList() {
		setForeground(SystemColor.menu);
		setAlwaysOnTop(true);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 700, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("\uC9C1\uC6D0\uB9AC\uC2A4\uD2B8");
		lblNewLabel.setBounds(17, 25, 78, 21);
		contentPane.add(lblNewLabel);
		
		searchBtn = new JButton("");
		searchBtn.setBorderPainted(false);
		searchBtn.setBorder(null);
		searchBtn.setForeground(Color.WHITE);
		searchBtn.setBackground(Color.WHITE);
		searchBtn.setIcon(new ImageIcon("adminImg\\q1.png"));
		searchBtn.setBounds(631, 25, 30, 27);
		contentPane.add(searchBtn);
		
		searchTf = new JTextField();
		searchTf.setBounds(436, 25, 186, 27);
		contentPane.add(searchTf);
		searchTf.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(17, 60, 644, 479);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollBar scrollBar = new JScrollBar();
		panel.add(scrollBar, BorderLayout.EAST);
		
		model = new DefaultTableModel(rows, column);
		jTable = new JTable(model);
		jScollPane = new JScrollPane(jTable);
		jScollPane.getViewport().setBackground(new Color(255, 255, 255));
		
		panel.add(jScollPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
//		detail = new JButton("ÀÚ¼¼È÷");
//		detail.setBounds(510, 540, 100, 30);
//		contentPane.add(detail);
		
	
		
		setResizable(false);
		setLocationRelativeTo(null);
	}
}
