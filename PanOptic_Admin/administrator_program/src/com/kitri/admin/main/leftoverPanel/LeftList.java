package com.kitri.admin.main.leftoverPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import java.awt.Font;

public class LeftList extends JFrame {

	private JPanel contentPane;
	public JTextField searchTf;
	private JPanel backgroundPanel;
	public JButton searchBtn;
	public JScrollBar sb1;
	public JScrollBar sb2;
	private JLabel leftFoodL;
	public DefaultTableCellRenderer tScheduleCellRenderer;
	public TableColumnModel tcmSchedule;
	
//	public CardLayout card = new CardLayout();
//	JPanel cardP;
	public JPanel leftListP;
	DefaultTableModel model;
	JTable leftJtable;
	JScrollPane leftScrollPane;
//	public JPanel searchListP;
//	public JTable searchListJtable;
//	public JScrollPane searchListScrollPane;
	JFrame jFrame = new JFrame();

	public Vector<String> column = new Vector<>();
	public Vector<Vector> rows = new Vector<>();
	
	public LeftList() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		backgroundPanel = new JPanel();
		backgroundPanel.setOpaque(false);
		backgroundPanel.setBounds(0, 0, 685, 555);
		contentPane.add(backgroundPanel);
		backgroundPanel.setLayout(null);
		backgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		searchBtn = new JButton("");
		searchBtn.setIcon(new ImageIcon("adminImg\\q1.png"));
		searchBtn.setForeground(Color.WHITE);
		searchBtn.setBorder(null);
		searchBtn.setBackground(Color.WHITE);
		searchBtn.setBounds(592, 25, 30, 27);
		backgroundPanel.add(searchBtn);
		
		searchTf = new JTextField();
		searchTf.setColumns(10);
		searchTf.setBounds(397, 25, 186, 27);
		backgroundPanel.add(searchTf);
		
//		cardP = new JPanel(card);
		sb1 = new JScrollBar();
		sb1.setBackground(new Color(255, 255, 255));
//		sb2 = new JScrollBar();
	
		leftListP = new JPanel();
		leftListP.setOpaque(false);
		leftListP.setLayout(new BorderLayout(0, 0));
		leftListP.setBounds(72, 74, 550, 430);
		leftListP.add(sb1, BorderLayout.EAST);

		backgroundPanel.add(leftListP);
		
		model = new DefaultTableModel(rows, column);
		leftJtable = new JTable(model);
		model.fireTableDataChanged();
		leftScrollPane = new JScrollPane(leftJtable);
		leftScrollPane.setOpaque(false);
		leftListP.add(leftScrollPane, BorderLayout.CENTER);
		leftJtable.setEnabled(false);
		leftScrollPane.getViewport().setBackground(new Color(255, 255, 255));
		
		// 정렬할 테이블의 ColumnModel을 가져옴
		tcmSchedule = leftJtable.getColumnModel();
		
		leftFoodL = new JLabel("\uC7AC\uACE0\uB7C9");
		leftFoodL.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		leftFoodL.setHorizontalAlignment(SwingConstants.CENTER);
		leftFoodL.setBounds(43, 31, 109, 21);
		backgroundPanel.add(leftFoodL);
		
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		tScheduleCellRenderer = new DefaultTableCellRenderer();
		 
		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		 
		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}

		setAlwaysOnTop(true);
//		tcmSchedule = searchListJtable.getColumnModel();
//		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
//		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
//		}
	}
}
