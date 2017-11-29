package com.kitri.admin.join;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EmployeeJoin extends JFrame {
	
	public EmployeeJoinController control;
	
	private JPanel contentPane;
	public JTextField empjoinTf;
	public JTextField IdTf;
	public JTextField nameTf;
	public JTextField eMailTf;
	public JTextField payTf;
	public JTextField phoneTf;
	public JPasswordField pwTf;
	public JPasswordField pwCheckTf;
	private JPanel yymmdd;
	public JComboBox yy;
	public JComboBox mm;
	public JComboBox dd;
	private JPanel hireyymmdd;
	public JComboBox hireYear;
	public JComboBox hireMonth;
	public JComboBox hireDay;
	public JButton checkBut;
	public JPanel maleRadio;
	private JLabel infoLabel;
	private JPanel subInfoCbTfPanel2;
	public JRadioButton manRBut;
	public JRadioButton womanRBut;
	private JLabel addinfoLabel;
	private JPanel subInfoTfPanel;
	private JPanel backgroundPanel;
	private JPanel joinBasicPanel;
	private JLabel IdLabel;
	private JLabel nameLabel;
	private JLabel pwLabel;
	private JLabel pwCheckLabel;
	private JLabel birthLabel;
	private JLabel hireDateL;
	private JPanel joinBasicTfPanel;
	public JComboBox jobCb;
	private JPanel subInfoLabelPanel2;
	private JLabel jobLabel;
	private JLabel phoneLabel;
	private JPanel subinfoLabelPanel;
	private JLabel eMailLabel;
	private JLabel wageL;
	public JButton closeBut;
	public JButton joinBut;

	public boolean checkId;
	public boolean isMale;
	private EmployeeJoinListener listener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeJoin frame = new EmployeeJoin();
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
	public EmployeeJoin() {
		
		listener = new EmployeeJoinListener(this);
		
		
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		backgroundPanel = new JPanel();
		backgroundPanel.setLayout(null);
		backgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		backgroundPanel.setBounds(0, 0, 478, 545);
		contentPane.add(backgroundPanel);

		empjoinTf = new JTextField();
		empjoinTf.setText("\uC9C1\uC6D0\uB4F1\uB85D");
		empjoinTf.setHorizontalAlignment(SwingConstants.CENTER);
		empjoinTf.setEditable(false);
		empjoinTf.setColumns(10);
		empjoinTf.setBounds(17, 25, 444, 50);
		backgroundPanel.add(empjoinTf);

		joinBasicPanel = new JPanel();
		joinBasicPanel.setBounds(17, 116, 91, 245);
		backgroundPanel.add(joinBasicPanel);
		joinBasicPanel.setLayout(new GridLayout(0, 1, 0, 0));

		IdLabel = new JLabel("* \uC544\uC774\uB514");
		IdLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		IdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(IdLabel);

		nameLabel = new JLabel("* \uC774\uB984");
		nameLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(nameLabel);

		pwLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638");
		pwLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		pwLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(pwLabel);

		pwCheckLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638\uD655\uC778");
		pwCheckLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		pwCheckLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(pwCheckLabel);

		birthLabel = new JLabel("* \uC0DD\uB144\uC6D4\uC77C");
		birthLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		birthLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(birthLabel);

		hireDateL = new JLabel("* \uC785\uC0AC\uC77C");
		hireDateL.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(hireDateL);

		joinBasicTfPanel = new JPanel();
		joinBasicTfPanel.setBounds(114, 116, 234, 245);
		backgroundPanel.add(joinBasicTfPanel);
		joinBasicTfPanel.setLayout(new GridLayout(6, 0, 5, 5));

		IdTf = new JTextField();
		IdTf.setColumns(10);
		joinBasicTfPanel.add(IdTf);

		nameTf = new JTextField();
		nameTf.setColumns(10);
		joinBasicTfPanel.add(nameTf);

		pwTf = new JPasswordField();
		joinBasicTfPanel.add(pwTf);

		pwCheckTf = new JPasswordField();
		joinBasicTfPanel.add(pwCheckTf);

		yymmdd = new JPanel();
		joinBasicTfPanel.add(yymmdd);
		yymmdd.setLayout(new GridLayout(1, 3, 5, 5));

		yy = new JComboBox();
		addComboBoxItems(yy, 1980, 2010);
		yymmdd.add(yy);

		mm = new JComboBox();
		addComboBoxItems(mm, 1, 12);
		yymmdd.add(mm);

		dd = new JComboBox();
		addComboBoxItems(dd, 1, 31);
		yymmdd.add(dd);

		hireyymmdd = new JPanel();
		joinBasicTfPanel.add(hireyymmdd);
		hireyymmdd.setLayout(new GridLayout(1, 3, 3, 3));

		hireYear = new JComboBox();
		addComboBoxItems(hireYear, 1980, 2017);
		hireyymmdd.add(hireYear);

		hireMonth = new JComboBox();
		addComboBoxItems(hireMonth, 1, 12);
		hireyymmdd.add(hireMonth);

		hireDay = new JComboBox();
		addComboBoxItems(hireDay, 1, 31);
		hireyymmdd.add(hireDay);

		checkBut = new JButton("\uC911\uBCF5\uD655\uC778");
		checkBut.setBounds(356, 116, 105, 35);
		backgroundPanel.add(checkBut);

		maleRadio = new JPanel();
		maleRadio.setBounds(356, 324, 105, 43);
		backgroundPanel.add(maleRadio);

		manRBut = new JRadioButton("\uB0A8");
		maleRadio.add(manRBut);

		womanRBut = new JRadioButton("\uC5EC");
		maleRadio.add(womanRBut);

		infoLabel = new JLabel("\uAE30\uBCF8\uC815\uBCF4");
		infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel.setBounds(17, 90, 91, 21);
		backgroundPanel.add(infoLabel);

		addinfoLabel = new JLabel("\uBD80\uAC00\uC815\uBCF4");
		addinfoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addinfoLabel.setBounds(17, 376, 91, 21);
		backgroundPanel.add(addinfoLabel);

		subInfoTfPanel = new JPanel();
		subInfoTfPanel.setBounds(79, 404, 156, 74);
		backgroundPanel.add(subInfoTfPanel);
		subInfoTfPanel.setLayout(new GridLayout(0, 1, 0, 0));

		eMailTf = new JTextField();
		eMailTf.setHorizontalAlignment(SwingConstants.LEFT);
		eMailTf.setColumns(10);
		subInfoTfPanel.add(eMailTf);

		payTf = new JTextField();
		payTf.setHorizontalAlignment(SwingConstants.LEFT);
		payTf.setColumns(10);
		subInfoTfPanel.add(payTf);

		subInfoCbTfPanel2 = new JPanel();
		subInfoCbTfPanel2.setBounds(291, 404, 170, 74);
		backgroundPanel.add(subInfoCbTfPanel2);
		subInfoCbTfPanel2.setLayout(new GridLayout(0, 1, 5, 5));

		jobCb = new JComboBox();
		subInfoCbTfPanel2.add(jobCb);
		jobCb.addItem("관리자");
		jobCb.addItem("직원");

		phoneTf = new JTextField();
		phoneTf.setColumns(10);
		subInfoCbTfPanel2.add(phoneTf);

		subInfoLabelPanel2 = new JPanel();
		subInfoLabelPanel2.setBounds(239, 404, 61, 74);
		backgroundPanel.add(subInfoLabelPanel2);
		subInfoLabelPanel2.setLayout(new GridLayout(0, 1, 5, 5));

		jobLabel = new JLabel("* \uC9C1\uAE09");
		jobLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subInfoLabelPanel2.add(jobLabel);

		phoneLabel = new JLabel("* \uD578\uB4DC\uD3F0");
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subInfoLabelPanel2.add(phoneLabel);

		subinfoLabelPanel = new JPanel();
		subinfoLabelPanel.setBounds(17, 404, 72, 74);
		backgroundPanel.add(subinfoLabelPanel);
		subinfoLabelPanel.setLayout(new GridLayout(0, 1, 5, 5));

		eMailLabel = new JLabel("* E-Mail");
		eMailLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		eMailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subinfoLabelPanel.add(eMailLabel);

		wageL = new JLabel("* \uC2DC\uAE09");
		wageL.setHorizontalTextPosition(SwingConstants.LEFT);
		wageL.setHorizontalAlignment(SwingConstants.LEFT);
		subinfoLabelPanel.add(wageL);

		closeBut = new JButton("\uB2EB\uAE30");
		closeBut.setBounds(336, 495, 125, 35);
		backgroundPanel.add(closeBut);

		joinBut = new JButton("\uAC00\uC785\uC694\uCCAD");
		joinBut.setBounds(194, 496, 125, 34);
		backgroundPanel.add(joinBut);
		
		closeBut.addActionListener(listener);
		joinBut.addActionListener(listener);
		manRBut.addActionListener(listener);
		womanRBut.addActionListener(listener);
		checkBut.addActionListener(listener);
		
		this.setLocationRelativeTo(null);

	}

	private void addComboBoxItems(JComboBox box, int start, int end) {
		for (int i = start; i <= end; i++) {
			box.addItem(i);
		}
	}
		
	public void checkIdFalseDigalog(){
		JOptionPane.showMessageDialog(this, "중복된 아이디입니다.", "아이디중복확인", JOptionPane.WARNING_MESSAGE);
	}
	
	public void joinFailDaialog(){
		JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다.", "회원가입실패", JOptionPane.WARNING_MESSAGE);
	}
	
	public void payInputError(){
		JOptionPane.showMessageDialog(this, "금액입력 오류입니다.", "금액입력 오류", JOptionPane.WARNING_MESSAGE);
	}
		

	public void hpInputError() {
		JOptionPane.showMessageDialog(this, "핸드폰번호입력 오류입니다.", "핸드폰번호입력 실패", JOptionPane.WARNING_MESSAGE);
		
	}

	public void pwTooShort() {
		JOptionPane.showMessageDialog(this, "8자리 이상 비밀번호를 입력해주세요." , "비밀번호 오류", JOptionPane.WARNING_MESSAGE);		
	}

	public void pwCheckError() {
		JOptionPane.showMessageDialog(this, "비밀번호가 같지 않습니다.","비밀번호확인 실패",JOptionPane.WARNING_MESSAGE);
	}

	public void emailInputError() {
		JOptionPane.showMessageDialog(this, "이메일주소 오류입니다.", "메일주소확인 실패",JOptionPane.WARNING_MESSAGE);	
	}

	public void checkidCheckDialog() {
		JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디입니다.", "사용할 수 없는 아이디입니다.", JOptionPane.WARNING_MESSAGE);
	}
	
}
