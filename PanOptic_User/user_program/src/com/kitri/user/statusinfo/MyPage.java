package com.kitri.user.statusinfo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

public class MyPage extends JFrame {

    private JPanel backgroundPane;
    public JPasswordField mypgPwTf;
    public JTextField mypgHpTf;
    public JTextField mypgMailTf;
    private JPanel middlePane;
    public JLabel mypgName;
    private JLabel mypgNameLabel;
    private JLabel mypgIdLabel;
    private JLabel mypgPwLabel;
    private JLabel mypgHpLabel;
    private JLabel mypgMailLabel;
    private JLabel mypgAccuTimeLabel;
    public JLabel mypgId;
    private JLabel mypgPointLabel;
    public JLabel mypgRestTime;
    public JLabel mypgAccuTime;
    private JLabel mypgRestTimeLabel;
    public JLabel mypgPoint;
    public JButton mypgChangeBtn;
    public JButton mypgCancelBtn;
    private JLabel mypageTitleLabel;
    private JPanel bottomPane;
    private JPanel titlePane;
    public MyPageListener listener;
    public JLabel mppgPwCheckLabel;
    public JPasswordField  mypgPwCheck;
    
    
	ImageIcon wholeImageIcon = new ImageIcon("UserMainImage\\myPage.png");
	Image wholeIamge = wholeImageIcon.getImage();
    /**
     * Launch the application.
     */

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    // mypage frame = new mypage();
		    // frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public MyPage() {
	listener = new MyPageListener(this);
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setBounds(100, 100, 382, 489);
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

	middlePane = new JPanel();
	middlePane.setBounds(0, 79, 366, 302);
	middlePane.setOpaque(false);
	backgroundPane.add(middlePane);
	middlePane.setLayout(null);

	mypgName = new JLabel("");
	mypgName.setBounds(186, 37, 116, 15);
	middlePane.add(mypgName);

	mypgNameLabel = new JLabel("회원이름");
	mypgNameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	mypgNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgNameLabel.setVerticalAlignment(SwingConstants.TOP);
	mypgNameLabel.setBounds(55, 37, 114, 15);
	middlePane.add(mypgNameLabel);

	mypgIdLabel = new JLabel("ID");
	mypgIdLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	mypgIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgIdLabel.setBounds(55, 67, 114, 15);
	middlePane.add(mypgIdLabel);

	mypgPwLabel = new JLabel("PW");
	mypgPwLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	mypgPwLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgPwLabel.setBounds(55, 97, 114, 15);
	middlePane.add(mypgPwLabel);

	mypgHpLabel = new JLabel("핸드폰번호");
	mypgHpLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	mypgHpLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgHpLabel.setBounds(100, 155, 69, 15);
	middlePane.add(mypgHpLabel);

	mypgMailLabel = new JLabel("이메일주소");
	mypgMailLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	mypgMailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgMailLabel.setBounds(100, 185, 69, 15);
	middlePane.add(mypgMailLabel);

	mypgAccuTimeLabel = new JLabel("누적사용시간");
	mypgAccuTimeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	mypgAccuTimeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgAccuTimeLabel.setBounds(89, 210, 80, 15);
	middlePane.add(mypgAccuTimeLabel);

	mypgRestTimeLabel = new JLabel("잔여시간");
	mypgRestTimeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	mypgRestTimeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgRestTimeLabel.setBounds(89, 241, 80, 15);
	middlePane.add(mypgRestTimeLabel);

	mypgId = new JLabel("");
	mypgId.setBounds(186, 67, 116, 15);
	middlePane.add(mypgId);

	mypgPwTf = new JPasswordField();
	mypgPwTf.setBorder(new LineBorder(Color.WHITE));
	mypgPwTf.setBackground(SystemColor.controlHighlight);
	mypgPwTf.setBounds(186, 94, 116, 21);
	middlePane.add(mypgPwTf);
	mypgPwTf.setColumns(10);
	
	mppgPwCheckLabel = new JLabel("Pw Check");
	mppgPwCheckLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	mppgPwCheckLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mppgPwCheckLabel.setBounds(100, 125, 69, 15);
	
	middlePane.add(mppgPwCheckLabel);
	mypgPwCheck = new JPasswordField();
	mypgPwCheck.setBackground(SystemColor.controlHighlight);
	mypgPwCheck.setBorder(new LineBorder(Color.WHITE));
	mypgPwCheck.setColumns(10);
	mypgPwCheck.setBounds(186, 122, 116, 21);
	middlePane.add(mypgPwCheck);
	
	mypgHpTf = new JTextField();
	mypgHpTf.setBorder(new LineBorder(Color.WHITE));
	mypgHpTf.setBackground(SystemColor.controlHighlight);
	mypgHpTf.setColumns(10);
	mypgHpTf.setBounds(186, 152, 116, 21);
	middlePane.add(mypgHpTf);

	mypgMailTf = new JTextField();
	mypgMailTf.setBorder(new LineBorder(Color.WHITE));
	mypgMailTf.setBackground(SystemColor.controlHighlight);
	mypgMailTf.setColumns(10);
	mypgMailTf.setBounds(186, 182, 116, 21);
	middlePane.add(mypgMailTf);
	
	

	mypgAccuTime = new JLabel("");
	mypgAccuTime.setBounds(186, 213, 116, 15);
	middlePane.add(mypgAccuTime);

	mypgRestTime = new JLabel("");
	mypgRestTime.setBounds(186, 241, 116, 15);
	middlePane.add(mypgRestTime);

	mypgPointLabel = new JLabel("포인트");
	mypgPointLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	mypgPointLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	mypgPointLabel.setBounds(89, 266, 80, 15);
	middlePane.add(mypgPointLabel);

	mypgPoint = new JLabel("");
	mypgPoint.setBounds(186, 266, 116, 15);
	middlePane.add(mypgPoint);

	bottomPane = new JPanel();
	bottomPane.setBounds(84, 378, 185, 62);
	bottomPane.setOpaque(false);
	backgroundPane.add(bottomPane);

	mypgChangeBtn = new JButton("\uC218\uC815");
	mypgChangeBtn.setBackground(new Color(135, 199, 255));
	mypgChangeBtn.setForeground(Color.WHITE);
	mypgChangeBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	mypgChangeBtn.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
	    }
	});
	bottomPane.add(mypgChangeBtn);

	mypgCancelBtn = new JButton("\uCDE8\uC18C");
	mypgCancelBtn.setBackground(new Color(135, 199, 255));
	mypgCancelBtn.setForeground(Color.WHITE);
	mypgCancelBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
	bottomPane.add(mypgCancelBtn);

	titlePane = new JPanel();
	titlePane.setOpaque(false);
	titlePane.setBounds(54, 46, 268, 48);
	backgroundPane.add(titlePane);

	mypageTitleLabel = new JLabel("      ");
	mypageTitleLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 20));
	titlePane.add(mypageTitleLabel);

	setVisible(false);
	mypgCancelBtn.addActionListener(listener);
	mypgChangeBtn.addActionListener(listener);
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
