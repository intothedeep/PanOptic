package com.kitri.admin.main.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri.admin.main.PcMain;
import com.kitri.admin.main.fixCon.Fix;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

public class AdminLogin extends JFrame {
	public JPanel contentPane;
	public JTextField idTf;
	JButton loginBtn;

	public PcMain pcMain;
	AdminLoginCon control;
	public JPasswordField pwTf;
	
	
	public AdminLogin(PcMain pcMain) {
		this.pcMain = pcMain;
		control = new AdminLoginCon(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 294, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel idL = new JLabel("I D :");
		idL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		idL.setHorizontalAlignment(SwingConstants.RIGHT);
		idL.setBounds(28, 87, 75, 34);
		contentPane.add(idL);

		JLabel pwL = new JLabel("Password :");
		pwL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		pwL.setHorizontalAlignment(SwingConstants.RIGHT);
		pwL.setBounds(17, 136, 86, 34);
		contentPane.add(pwL);

		idTf = new JTextField();
		idTf.setBounds(109, 88, 135, 34);
		contentPane.add(idTf);

		loginBtn = new JButton("Log in");
		loginBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		loginBtn.setForeground(new Color(255, 255, 255));
		loginBtn.setBackground(new Color(135, 206, 250));
		loginBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 18));
		loginBtn.setBounds(28, 194, 215, 34);
		contentPane.add(loginBtn);
		
		pwTf = new JPasswordField();
		pwTf.setBounds(109, 136, 135, 34);
		contentPane.add(pwTf);

		Fix.FIXFRAME(this);
//		login ¿Ã∫£∆Æ µÓ∑œ
		loginBtn.addActionListener(control);
		idTf.addActionListener(control);
		pwTf.addActionListener(control);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
