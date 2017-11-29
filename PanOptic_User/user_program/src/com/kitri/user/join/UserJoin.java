package com.kitri.user.join;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class UserJoin extends JInternalFrame {

	private JPanel backgroundPane;
	public JTextField joinTf;
	public JTextField joinName;
	public JButton joinConfirmBtn;
	public JButton joinCloseBtn;
	private JPanel baseInfoLabelPane;
	private JLabel joinIdLabel;
	private JLabel joinNameLabel;
	private JLabel joinPwLabel;
	private JLabel joinPwCheckLabel;
	private JLabel joinBirthLabel;
	private JPanel baseInfoPane;
	public JTextField joinId;
	public JButton overCheckBtn;
	private JPanel genderCheckPane;
	private JLabel joinBaseLabel;
	public JRadioButton maleRadio;
	public JRadioButton femaleRadio;
	private ButtonGroup genderGroup;

	public boolean isMale;

	private UserJoinListener listener;

	public boolean checkId;
	public JPasswordField joinPw;
	public JPasswordField joinPwCheck;
	private JPanel yymmdd;
	private JPanel SubInfoLabelPanel;
	private JLabel eMailL;
	public JTextField joinEmailTf;
	public JTextField joinHpTf;
	private JPanel SubInfoLabelPanel2;
	public JComboBox yy;
	public JComboBox mm;
	public JComboBox dd;
	
	ImageIcon wholeImageIcon = new ImageIcon("img\\userJoin.png");
	Image wholeIamge = wholeImageIcon.getImage();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserJoin frame = new UserJoin();
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
	public UserJoin() {
		listener = new UserJoinListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 490);
		backgroundPane = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(wholeIamge, 0, 0, null);
				setOpaque(false);
			}
		};
		backgroundPane.setBackground(Color.WHITE);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(null);

		joinTf = new JTextField();
		joinTf.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		joinTf.setOpaque(false);
		joinTf.setEditable(false);
		joinTf.setBounds(17, 25, 444, 50);
		joinTf.setHorizontalAlignment(SwingConstants.CENTER);
		joinTf.setText("\uD68C\uC6D0\uAC00\uC785");
		backgroundPane.add(joinTf);
		joinTf.setColumns(10);

		joinConfirmBtn = new JButton("\uAC00\uC785\uC694\uCCAD");
		joinConfirmBtn.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		joinConfirmBtn.setBackground(new Color(200, 163, 255));
		joinConfirmBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		joinConfirmBtn.setBounds(194, 380, 125, 34);
		backgroundPane.add(joinConfirmBtn);

		joinCloseBtn = new JButton("\uB2EB\uAE30");
		joinCloseBtn.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		joinCloseBtn.setBackground(new Color(200, 163, 255));
		joinCloseBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		joinCloseBtn.setBounds(336, 380, 125, 34);
		backgroundPane.add(joinCloseBtn);

		baseInfoLabelPane = new JPanel();
		baseInfoLabelPane.setOpaque(false);
		baseInfoLabelPane.setBounds(17, 116, 91, 208);
		backgroundPane.add(baseInfoLabelPane);
		baseInfoLabelPane.setLayout(new GridLayout(0, 1, 0, 0));

		joinIdLabel = new JLabel("* \uC544\uC774\uB514");
		joinIdLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		joinIdLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinIdLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		baseInfoLabelPane.add(joinIdLabel);

		joinNameLabel = new JLabel("* \uC774\uB984");
		joinNameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		joinNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinNameLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		baseInfoLabelPane.add(joinNameLabel);

		joinPwLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638");
		joinPwLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		joinPwLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinPwLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		baseInfoLabelPane.add(joinPwLabel);

		joinPwCheckLabel = new JLabel("* \uBE44\uBC00\uBC88\uD638\uD655\uC778");
		joinPwCheckLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		joinPwCheckLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinPwCheckLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		baseInfoLabelPane.add(joinPwCheckLabel);

		joinBirthLabel = new JLabel("* \uC0DD\uB144\uC6D4\uC77C");
		joinBirthLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		joinBirthLabel.setHorizontalAlignment(SwingConstants.LEFT);
		joinBirthLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		baseInfoLabelPane.add(joinBirthLabel);

		baseInfoPane = new JPanel();
		baseInfoPane.setOpaque(false);
		baseInfoPane.setBounds(114, 116, 234, 208);
		backgroundPane.add(baseInfoPane);
		baseInfoPane.setLayout(new GridLayout(5, 0, 5, 5));

		joinId = new JTextField();
		joinId.setBorder(new LineBorder(SystemColor.window));
		joinId.setBackground(SystemColor.controlHighlight);
		baseInfoPane.add(joinId);
		joinId.setColumns(10);

		joinName = new JTextField();
		joinName.setBorder(new LineBorder(SystemColor.window));
		joinName.setBackground(SystemColor.controlHighlight);
		baseInfoPane.add(joinName);
		joinName.setColumns(10);

		joinPw = new JPasswordField();
		joinPw.setBorder(new LineBorder(SystemColor.window));
		joinPw.setBackground(SystemColor.controlHighlight);
		baseInfoPane.add(joinPw);

		joinPwCheck = new JPasswordField();
		joinPwCheck.setBorder(new LineBorder(SystemColor.window));
		joinPwCheck.setBackground(SystemColor.controlHighlight);
		baseInfoPane.add(joinPwCheck);

		yymmdd = new JPanel();
		yymmdd.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		baseInfoPane.add(yymmdd);
		yymmdd.setLayout(new GridLayout(1, 3, 5, 5));

		yy = new JComboBox();
		yy.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addComboBoxItems(yy, 1980, 2010);
		yymmdd.add(yy);

		mm = new JComboBox();
		mm.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addComboBoxItems(mm, 1, 12);
		yymmdd.add(mm);

		dd = new JComboBox();
		dd.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		addComboBoxItems(dd, 1, 31);
		yymmdd.add(dd);

		overCheckBtn = new JButton("\uC911\uBCF5\uD655\uC778");
		overCheckBtn.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		overCheckBtn.setBackground(new Color(200, 162, 255));
		overCheckBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		overCheckBtn.setBounds(356, 116, 105, 35);
		overCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		backgroundPane.add(overCheckBtn);

		genderCheckPane = new JPanel();
		genderCheckPane.setOpaque(false);
		genderGroup = new ButtonGroup();
		genderCheckPane.setBounds(356, 279, 105, 43);
		backgroundPane.add(genderCheckPane);

		maleRadio = new JRadioButton("\uB0A8", true);
		maleRadio.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		maleRadio.setOpaque(false);

		femaleRadio = new JRadioButton("\uC5EC", false);
		femaleRadio.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		femaleRadio.setOpaque(false);

		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);

		genderCheckPane.add(maleRadio);
		genderCheckPane.add(femaleRadio);

		joinBaseLabel = new JLabel("\uAE30\uBCF8\uC815\uBCF4");
		joinBaseLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		joinBaseLabel.setBounds(17, 90, 91, 21);
		joinBaseLabel.setHorizontalAlignment(SwingConstants.LEFT);
		backgroundPane.add(joinBaseLabel);

		SubInfoLabelPanel2 = new JPanel();
		SubInfoLabelPanel2.setOpaque(false);
		SubInfoLabelPanel2.setBounds(243, 330, 218, 35);
		backgroundPane.add(SubInfoLabelPanel2);
		SubInfoLabelPanel2.setLayout(new BorderLayout(10, 0));

		JLabel hpL = new JLabel("* \uD578\uB4DC\uD3F0");
		hpL.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		SubInfoLabelPanel2.add(hpL, BorderLayout.WEST);

		joinHpTf = new JTextField();
		joinHpTf.setBorder(new LineBorder(SystemColor.window));
		joinHpTf.setBackground(SystemColor.controlHighlight);
		SubInfoLabelPanel2.add(joinHpTf);
		joinHpTf.setColumns(10);

		SubInfoLabelPanel = new JPanel();
		SubInfoLabelPanel.setOpaque(false);
		SubInfoLabelPanel.setBounds(17, 330, 218, 35);
		backgroundPane.add(SubInfoLabelPanel);
		SubInfoLabelPanel.setLayout(new BorderLayout(10, 0));

		eMailL = new JLabel("* E-mail");
		eMailL.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		SubInfoLabelPanel.add(eMailL, BorderLayout.WEST);

		joinEmailTf = new JTextField();
		joinEmailTf.setBorder(new LineBorder(SystemColor.window));
		joinEmailTf.setBackground(SystemColor.controlHighlight);
		SubInfoLabelPanel.add(joinEmailTf);
		joinEmailTf.setColumns(10);
		
		setBackground(Color.WHITE);

		joinCloseBtn.addActionListener(listener);
		joinConfirmBtn.addActionListener(listener);
		overCheckBtn.addActionListener(listener);
		maleRadio.addActionListener(listener);
		femaleRadio.addActionListener(listener);

		// this.setLocationRelativeTo(null);
	}

	private void addComboBoxItems(JComboBox box, int start, int end) {
		for (int i = start; i <= end; i++) {
			box.addItem(i);
		}
	}

	public void checkIdFalseDialog() {
		JOptionPane.showMessageDialog(this, "중복된 아이디입니다.", "아이디중복확인", JOptionPane.WARNING_MESSAGE);

	}

	public void checkIdTrueDialog() {
		JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디입니다.", "아이디중복확인", JOptionPane.WARNING_MESSAGE);

	}

	public void checkIdCheckDialog() {
		JOptionPane.showMessageDialog(this, "아이디 중복확인 해주세요.", "아이디중복확인", JOptionPane.WARNING_MESSAGE);

	}

	public void joinFailDialog() {
		JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다.", "회원가입 실패", JOptionPane.WARNING_MESSAGE);

	}

	public void pwTooShort() {
		JOptionPane.showMessageDialog(this, "8자리 이상 비밀번호를 입력해주세요.", "비밀번호 오류", JOptionPane.WARNING_MESSAGE);

	}

	public void pwCheckError() {
		JOptionPane.showMessageDialog(this, "비밀번호가 같지않습니다.", "비밀번호확인 실패", JOptionPane.WARNING_MESSAGE);
	}

	public void emailInputError() {
		JOptionPane.showMessageDialog(this, "이메일주소오류입니다.", "메일주소확인 실패", JOptionPane.WARNING_MESSAGE);
	}

	public void hpInputError() {
		JOptionPane.showMessageDialog(this, "핸드폰번호입력오류입니다..", "핸드폰번호입력실패", JOptionPane.WARNING_MESSAGE);
	}
}