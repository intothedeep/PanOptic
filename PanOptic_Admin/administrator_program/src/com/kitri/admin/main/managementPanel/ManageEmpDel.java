package com.kitri.admin.main.managementPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class ManageEmpDel extends JFrame {

	private JPanel contentPane;
	private JTextField idTf;
	private JTextField nameTf;

	public ManageEmpDel() {
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 8));
		setTitle("\uC9C1\uC6D0\uC815\uBCF4\uC0AD\uC81C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel empty = new JLabel("");
		panel.add(empty);
		
		JPanel centerP = new JPanel();
		centerP.setOpaque(false);
		panel.add(centerP);
		centerP.setLayout(null);
		
		JLabel idL = new JLabel("ID :");
		idL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		idL.setHorizontalAlignment(SwingConstants.RIGHT);
		idL.setBounds(79, 2, 46, 25);
		centerP.add(idL);
		
		idTf = new JTextField();
		idTf.setBounds(149, 0, 165, 28);
		centerP.add(idTf);
		idTf.setColumns(10);
		
		JLabel nameL = new JLabel("Name :");
		nameL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		nameL.setHorizontalAlignment(SwingConstants.RIGHT);
		nameL.setBounds(79, 36, 46, 26);
		centerP.add(nameL);
		
		nameTf = new JTextField();
		nameTf.setBounds(149, 36, 165, 26);
		centerP.add(nameTf);
		nameTf.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel bottomP = new JPanel();
		bottomP.setOpaque(false);
		panel.add(bottomP);
		
		JButton deleteEmp = new JButton("  \uC0AD\uC81C  ");
		deleteEmp.setForeground(new Color(255, 255, 255));
		deleteEmp.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		deleteEmp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		deleteEmp.setBackground(new Color(200, 162, 255));
		bottomP.add(deleteEmp);
		
		JButton update = new JButton("  \uC218\uC815  ");
		update.setForeground(new Color(255, 255, 255));
		update.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		update.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		update.setBackground(new Color(200, 162, 255));
		bottomP.add(update);
		
		JButton exit = new JButton(" \uB098\uAC00\uAE30 ");
		exit.setForeground(new Color(255, 255, 255));
		exit.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		exit.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		exit.setBackground(new Color(200, 162, 255));
		bottomP.add(exit);
		
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new ManageEmpDel();
	}
}
