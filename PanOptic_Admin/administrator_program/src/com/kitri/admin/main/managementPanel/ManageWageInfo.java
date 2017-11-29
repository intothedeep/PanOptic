package com.kitri.admin.main.managementPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import java.awt.Color;
import java.awt.Font;

public class ManageWageInfo extends JFrame {

	private JPanel contentPane;
	private JPanel backgroundPanel;
	private JLabel empWageLaabel;
	public JPanel JTablePanel;
	public JScrollBar wageScrollBar;
	public TableColumnModel tcmSchedule;
	public DefaultTableCellRenderer tScheduleCellRenderer;

	public JButton searchBtn;
	public JTextField searchTf;
	JFrame jFrame = new JFrame();

	public Vector<String> column;
	public Vector<Vector> rows;
	
	DefaultTableModel model;
	JTable jTable;
	JScrollPane WagejScollPane;
	
	
	public ManageWageInfo() {

		

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		backgroundPanel = new JPanel();
		backgroundPanel.setOpaque(false);
		backgroundPanel.setLayout(null);
		backgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		backgroundPanel.setBounds(0, 0, 678, 554);
		contentPane.add(backgroundPanel);

		empWageLaabel = new JLabel("\uC9C1\uC6D0\uAE09\uC5EC\uC870\uD68C");
		empWageLaabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		empWageLaabel.setBounds(17, 25, 98, 21);
		backgroundPanel.add(empWageLaabel);

		searchBtn = new JButton("");
		searchBtn.setIcon(new ImageIcon("C:\\java\\workspace\\javase\\PanOptic\\src\\img\\q1.png"));
		searchBtn.setForeground(Color.WHITE);
		searchBtn.setBorder(null);
		searchBtn.setBackground(Color.WHITE);
		searchBtn.setBounds(631, 25, 30, 27);
		backgroundPanel.add(searchBtn);

		searchTf = new JTextField();
		searchTf.setColumns(10);
		searchTf.setBounds(436, 25, 186, 27);
		backgroundPanel.add(searchTf);

		model = new DefaultTableModel(rows,	column);
		jTable = new JTable(model);
		WagejScollPane = new JScrollPane(jTable);
		WagejScollPane.getViewport().setBackground(new Color(255,255,255));
		jTable.setEnabled(false);
		
		JTablePanel = new JPanel();
		JTablePanel.setOpaque(false);
		JTablePanel.setBounds(17, 60, 644, 479);
		backgroundPanel.add(JTablePanel);
		JTablePanel.setLayout(new BorderLayout(0, 0));

		wageScrollBar = new JScrollBar();
		wageScrollBar.setBackground(new Color(255, 255, 255));
		JTablePanel.add(wageScrollBar, BorderLayout.EAST);

		// 정렬할 테이블의 ColumnModel을 가져옴
		tcmSchedule = jTable.getColumnModel();

		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		tScheduleCellRenderer = new DefaultTableCellRenderer();

		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		JTablePanel.add(WagejScollPane);
	}
}
