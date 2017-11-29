package com.kitri.admin.main.customerPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

public class CusList extends JFrame {
	JFrame jFrame = new JFrame();

	public JPanel contentPane;
	public JButton searchBut;
	public JComboBox listCombo;
	public JComboBox searchCombo;
	public JTextField searchTf;
	
	public JPanel mainPanel;

	public CardLayout card = new CardLayout();
	public JPanel jTablePanel;
	
	public DefaultTableModel model;
//	public DefaultTableModel blackModel;
	
	public JTable jTable;
	public JScrollPane jScrollPane;
		
	public TableColumnModel tcmSchedule;
	public TableColumnModel tcmSchedule2;
	
	public DefaultTableCellRenderer tScheduleCellRenderer;
	public DefaultTableCellRenderer tScheduleCellRenderer2;

	public Vector<String> column = new Vector<>();
	public Vector<Vector> rows = new Vector<>();

	public CusList() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);

		setBounds(100, 100, 700, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		mainPanel = new JPanel();
		mainPanel.setOpaque(false);

		mainPanel.setBounds(0, 0, 678, 545);
		mainPanel.setLayout(null);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		jTablePanel = new JPanel();
		jTablePanel.setOpaque(false);
		jTablePanel.setBounds(17, 60, 644, 479);
		jTablePanel.setLayout(null);

				
		searchBut = new JButton("");
		searchBut.setIcon(new ImageIcon("adminImg\\q1.png"));
		searchBut.setForeground(Color.WHITE);
		searchBut.setBorder(null);
		searchBut.setBackground(Color.WHITE);
		searchBut.setBounds(631, 25, 30, 27);


		searchTf = new JTextField();
		searchTf.setColumns(10);
		searchTf.setBounds(436, 25, 186, 27);
		mainPanel.add(searchTf);

		listCombo = new JComboBox();
		listCombo.setBounds(17, 25, 171, 27);
		listCombo.addItem("������Ʈ");
		listCombo.addItem("������Ʈ");
		mainPanel.add(listCombo);

		searchCombo = new JComboBox();
		searchCombo.setBounds(353, 25, 75, 27);
		searchCombo.addItem("��ü");
		searchCombo.addItem("�̸�");
		mainPanel.add(searchCombo);
		
		mainPanel.add(searchBut);

		
		
		model = new DefaultTableModel(rows, column);
		jTable = new JTable(model);
		jTable.setBounds(99, 231, 444, -195);
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.getViewport().setBackground(new Color(255,255,255));
		jScrollPane.setOpaque(false);
		jScrollPane.setBounds(0, 0, 644, 479);
		jTablePanel.add(jScrollPane);
		mainPanel.add(jTablePanel);
		contentPane.add(mainPanel);

		
	

	


//		// DefaultTableCellHeaderRenderer ���� (��� ������ ����)
//		tScheduleCellRenderer = new DefaultTableCellRenderer();
//
//		// DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
//		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

//		// �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
//		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
//			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
//		}
//
//		// DefaultTableCellHeaderRenderer ���� (��� ������ ����)
//		tScheduleCellRenderer2 = new DefaultTableCellRenderer();
//
//		// DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
//		tScheduleCellRenderer2.setHorizontalAlignment(SwingConstants.CENTER);
//
//		// �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
//		for (int i = 0; i < tcmSchedule2.getColumnCount(); i++) {
//			tcmSchedule2.getColumn(i).setCellRenderer(tScheduleCellRenderer2);

//		}
	}
}
