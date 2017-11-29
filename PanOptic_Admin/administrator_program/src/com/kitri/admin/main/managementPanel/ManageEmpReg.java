package com.kitri.admin.main.managementPanel;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class ManageEmpReg extends JFrame {

	private JPanel contentPane;
	public JPanel RadionButPanel;
	public JLabel infoLabel;
	public JPanel subInfoCbTfPanel2;

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
	private JPanel subInfoLabelPanel2;
	private JLabel jobLabel;
	private JLabel phoneLabel;
	private JPanel subinfoLabelPanel;
	private JLabel eMailLabel;
	private JLabel wageL;
	
	public JButton joinBtn;
	public JButton closeBtn;
	public JButton checkBtn;

	public JComboBox position;
	
	CheckboxGroup isMale;
	Checkbox manCheck;
	Checkbox womanCheck;
	
	public JTextField empJoinTf;
	public JTextField idTf;
	public JTextField nameTf;
	public JTextField eMailTf;
	public JTextField hourPayTf;
	public JTextField hpTf;
	public JPasswordField pwTf;
	public JPasswordField pwCheckTf;
	
	public JPanel hireyymmdd;
	public JComboBox hireYear;
	public JComboBox hireMonth;
	public JComboBox hireDay;
	
	public JPanel yymmdd;
	public JComboBox yy;
	public JComboBox mm;
	public JComboBox dd;
	
	public ManageEmpReg() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		backgroundPanel = new JPanel();
		backgroundPanel.setOpaque(false);
		backgroundPanel.setLayout(null);
		backgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		backgroundPanel.setBounds(0, 0, 478, 545);
		contentPane.add(backgroundPanel);
		
		empJoinTf = new JTextField();
		empJoinTf.setOpaque(false);
		empJoinTf.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		empJoinTf.setText("Á÷¿øµî·Ï");
		empJoinTf.setHorizontalAlignment(SwingConstants.CENTER);
		empJoinTf.setEditable(false);
		empJoinTf.setColumns(10);
		empJoinTf.setBounds(17, 25, 444, 50);
		backgroundPanel.add(empJoinTf);
		
		joinBasicPanel = new JPanel();
		joinBasicPanel.setOpaque(false);
		joinBasicPanel.setBounds(17, 116, 91, 245);
		backgroundPanel.add(joinBasicPanel);
		joinBasicPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		IdLabel = new JLabel("* \uC544\uC774\uB514");
		IdLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		IdLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		IdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(IdLabel);
		
		nameLabel = new JLabel("* \uC774\uB984");
		nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		nameLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(nameLabel);
		
		pwLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638");
		pwLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		pwLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		pwLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(pwLabel);
		
		pwCheckLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638\uD655\uC778");
		pwCheckLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		pwCheckLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		pwCheckLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(pwCheckLabel);
		
		birthLabel = new JLabel("* \uC0DD\uB144\uC6D4\uC77C");
		birthLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		birthLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		birthLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(birthLabel);
		
		hireDateL = new JLabel("* \uC785\uC0AC\uC77C");
		hireDateL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		hireDateL.setHorizontalAlignment(SwingConstants.LEFT);
		joinBasicPanel.add(hireDateL);
		
		joinBasicTfPanel = new JPanel();
		joinBasicTfPanel.setOpaque(false);
		joinBasicTfPanel.setBounds(114, 116, 234, 245);
		backgroundPanel.add(joinBasicTfPanel);
		joinBasicTfPanel.setLayout(new GridLayout(6, 0, 5, 5));
		
		idTf = new JTextField();
		idTf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.window));
		idTf.setBackground(SystemColor.controlHighlight);
		idTf.setColumns(10);
		joinBasicTfPanel.add(idTf);
		
		nameTf = new JTextField();
		nameTf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.window));
		nameTf.setBackground(SystemColor.controlHighlight);
		nameTf.setColumns(10);
		joinBasicTfPanel.add(nameTf);
		
		pwTf = new JPasswordField();
		pwTf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.window));
		pwTf.setBackground(SystemColor.controlHighlight);
		joinBasicTfPanel.add(pwTf);
		
		pwCheckTf = new JPasswordField();
		pwCheckTf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.window));
		pwCheckTf.setBackground(SystemColor.controlHighlight);
		joinBasicTfPanel.add(pwCheckTf);
		
		yymmdd = new JPanel();
		joinBasicTfPanel.add(yymmdd);
		yymmdd.setLayout(new GridLayout(1, 3, 5, 5));
		
		yy = new JComboBox();
		yy.setBackground(new Color(255, 255, 255));
		addComboBoxItems(yy, 1980, 2010);
		yymmdd.add(yy);
		
		mm = new JComboBox();
		mm.setBackground(new Color(255, 255, 255));
		addComboBoxItems(mm, 1, 12);
		yymmdd.add(mm);
		
		dd = new JComboBox();
		dd.setBackground(new Color(255, 255, 255));
		addComboBoxItems(dd, 1, 31);
		yymmdd.add(dd);
		
		hireyymmdd = new JPanel();
		joinBasicTfPanel.add(hireyymmdd);
		hireyymmdd.setLayout(new GridLayout(1, 3, 3, 3));
		
		hireYear = new JComboBox();
		hireYear.setBackground(new Color(255, 255, 255));
		addComboBoxItems(hireYear, 1980, 2017);
		hireyymmdd.add(hireYear);
		
		hireMonth = new JComboBox();
		hireMonth.setBackground(new Color(255, 255, 255));
		addComboBoxItems(hireMonth, 1, 12);
		hireyymmdd.add(hireMonth);
		
		hireDay = new JComboBox();
		hireDay.setBackground(new Color(255, 255, 255));
		addComboBoxItems(hireDay, 1, 31);
		hireyymmdd.add(hireDay);
		
		checkBtn = new JButton("\uC911\uBCF5\uD655\uC778");
		checkBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		checkBtn.setForeground(new Color(255, 255, 255));
		checkBtn.setBackground(new Color(200, 162, 255));
		checkBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		checkBtn.setBounds(356, 116, 105, 35);
		backgroundPanel.add(checkBtn);
		
		RadionButPanel = new JPanel();
		RadionButPanel.setOpaque(false);
		RadionButPanel.setBounds(356, 324, 105, 43);
		backgroundPanel.add(RadionButPanel);
		
		isMale = new CheckboxGroup();
		manCheck = new Checkbox("³²ÀÚ", isMale, true);
		manCheck.setBackground(new Color(255, 255, 255));
		manCheck.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		womanCheck = new Checkbox("¿©ÀÚ", isMale, false);
		womanCheck.setBackground(new Color(255, 255, 255));
		womanCheck.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		RadionButPanel.add(manCheck);
		RadionButPanel.add(womanCheck);
		
		infoLabel = new JLabel("\uAE30\uBCF8\uC815\uBCF4");
		infoLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel.setBounds(17, 90, 91, 21);
		backgroundPanel.add(infoLabel);
		
		addinfoLabel = new JLabel("\uBD80\uAC00\uC815\uBCF4");
		addinfoLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		addinfoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addinfoLabel.setBounds(17, 376, 91, 21);
		backgroundPanel.add(addinfoLabel);
		
		subInfoTfPanel = new JPanel();
		subInfoTfPanel.setOpaque(false);
		subInfoTfPanel.setBounds(79, 404, 156, 74);
		backgroundPanel.add(subInfoTfPanel);
		subInfoTfPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		eMailTf = new JTextField();
		eMailTf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.window));
		eMailTf.setBackground(SystemColor.controlHighlight);
		eMailTf.setHorizontalAlignment(SwingConstants.LEFT);
		eMailTf.setColumns(10);
		subInfoTfPanel.add(eMailTf);
		
		hourPayTf = new JTextField();
		hourPayTf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.window));
		hourPayTf.setBackground(SystemColor.controlHighlight);
		hourPayTf.setHorizontalAlignment(SwingConstants.LEFT);
		hourPayTf.setColumns(10);
		subInfoTfPanel.add(hourPayTf);
		
		subInfoCbTfPanel2 = new JPanel();
		subInfoCbTfPanel2.setOpaque(false);
		subInfoCbTfPanel2.setBounds(291, 404, 170, 74);
		backgroundPanel.add(subInfoCbTfPanel2);
		subInfoCbTfPanel2.setLayout(new GridLayout(0, 1, 5, 5));
		
		position = new JComboBox();
		position.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		position.setBackground(new Color(255, 255, 255));
		subInfoCbTfPanel2.add(position);
		position.addItem("°ü¸®ÀÚ");
		position.addItem("Á÷¿ø");
		
		hpTf = new JTextField();
		hpTf.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.window));
		hpTf.setBackground(SystemColor.controlHighlight);
		hpTf.setColumns(10);
		subInfoCbTfPanel2.add(hpTf);
		
		subInfoLabelPanel2 = new JPanel();
		subInfoLabelPanel2.setOpaque(false);
		subInfoLabelPanel2.setBounds(239, 404, 61, 74);
		backgroundPanel.add(subInfoLabelPanel2);
		subInfoLabelPanel2.setLayout(new GridLayout(0, 1, 5, 5));
		
		jobLabel = new JLabel("* \uC9C1\uAE09");
		jobLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		jobLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subInfoLabelPanel2.add(jobLabel);
		
		phoneLabel = new JLabel("* \uD578\uB4DC\uD3F0");
		phoneLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subInfoLabelPanel2.add(phoneLabel);
		
		subinfoLabelPanel = new JPanel();
		subinfoLabelPanel.setOpaque(false);
		subinfoLabelPanel.setBounds(17, 404, 72, 74);
		backgroundPanel.add(subinfoLabelPanel);
		subinfoLabelPanel.setLayout(new GridLayout(0, 1, 5, 5));
		
		eMailLabel = new JLabel("* E-Mail");
		eMailLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		eMailLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		eMailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		subinfoLabelPanel.add(eMailLabel);
		
		wageL = new JLabel("* \uC2DC\uAE09");
		wageL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		wageL.setHorizontalTextPosition(SwingConstants.LEFT);
		wageL.setHorizontalAlignment(SwingConstants.LEFT);
		subinfoLabelPanel.add(wageL);
		
		closeBtn = new JButton("\uB2EB\uAE30");
		closeBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		closeBtn.setBackground(new Color(200, 162, 255));
		closeBtn.setForeground(new Color(255, 255, 255));
		closeBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		closeBtn.setBounds(336, 495, 125, 35);
		backgroundPanel.add(closeBtn);
		
		joinBtn = new JButton("\uAC00\uC785\uC694\uCCAD");
		joinBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		joinBtn.setBackground(new Color(200, 162, 255));
		joinBtn.setForeground(new Color(255, 255, 255));
		joinBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		joinBtn.setBounds(194, 496, 125, 34);
		backgroundPanel.add(joinBtn);
		
		this.setLocationRelativeTo(null);
	}

	private void addComboBoxItems(JComboBox box, int start, int end) {
		for (int i = start; i <= end; i++) {
			box.addItem(i);
		}
	}
}
