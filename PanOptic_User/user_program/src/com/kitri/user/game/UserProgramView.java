package com.kitri.user.game;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.kitri.user.order.OrderListener;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class UserProgramView extends JFrame {
	public  GameViewMouseListener gmListener;
	private JPanel backgroundPane;
	private JPanel emptyPane;
	private JLabel emptyTitleLabel;
	public JPanel gameListPane;
	public JPanel gameContentsPane;
	public JButton enternetBtn;
	public JButton actionGameBtn;
	public JButton issueGameBtn;
	public CardLayout clGameContentsPane = new CardLayout();
	public JButton onlineGameBtn;
	public InternetPane gameEnternetPane;
	public HotGamePane hotGamePane;
	public OnlineGamePane onlineGamePane;
	public JButton cdGameBtn;
	public JButton sportsGameBtn;
	public JButton ectBtn;
	public GameChangeActionListener gListener;
	public ActionGamePane actionGamePane;
	public CdGamePane cdGamePane;
	public SportsGamePane sportsGamePane;
	public EctGamePane ectGamePane;
	
	/**
	 * 
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {		
//				try {
//					UserProgramView frame = new UserProgramView();
//					frame.setVisible(true);
////					frame.setLocationRelativeTo(null);
//					Dimension frameSize = frame.getSize(); // «¡∑π¿” ªÁ¿Ã¡Ó
//					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ∏¥œ≈Õ ªÁ¿Ã¡Ó
//					frame.setLocation((screenSize.width - frameSize.width), (screenSize.height - screenSize.height));
//					frame.setResizable(false);//√¢≈©±‚∫Ø∞Ê∫“∞°¥…«œ∞‘«œ¥¬∞≈
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public static void main(String[] args) {
	    new UserProgramView().setVisible(true);
	    
	}
	UserProgramView frame;
	/**
	 * Create the frame.
	 */
	public UserProgramView() {

		gmListener = new GameViewMouseListener(this);
		gListener = new GameChangeActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		backgroundPane = new JPanel();
		backgroundPane.setBackground(Color.WHITE);
		backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPane);
		backgroundPane.setLayout(new BorderLayout(0, 0));
		
		emptyPane = new JPanel();
		backgroundPane.add(emptyPane, BorderLayout.NORTH);
		emptyPane.setLayout(new BorderLayout(100, 100));
		
		emptyTitleLabel = new JLabel("              ");
		emptyTitleLabel.setBorder(new LineBorder(Color.WHITE));
		emptyTitleLabel.setBackground(new Color(230, 230, 250));
		emptyTitleLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 31));
		emptyPane.add(emptyTitleLabel);
		
		gameListPane = new JPanel();
		backgroundPane.add(gameListPane, BorderLayout.WEST);
		gameListPane.setLayout(new GridLayout(7, 1, 0, 0));
		
		gameContentsPane = new JPanel();
		
		gameContentsPane.setLayout(clGameContentsPane);
		hotGamePane = new HotGamePane(this);
		hotGamePane.setBackground(new Color(255, 255, 255));
		onlineGamePane= new OnlineGamePane(this);
		onlineGamePane.setBackground(new Color(255, 255, 255));
		gameEnternetPane = new InternetPane(this);
		gameEnternetPane.setBackground(new Color(255, 255, 255));
		
		
		gameContentsPane.add(gameEnternetPane, "1");
		gameContentsPane.add(hotGamePane,"2");
		gameContentsPane.add(onlineGamePane,"3");
		
		backgroundPane.add(gameContentsPane, BorderLayout.CENTER);
		
		actionGamePane = new ActionGamePane(this);
		actionGamePane.setBackground(new Color(255, 255, 255));
		gameContentsPane.add(actionGamePane, "4");
		
		cdGamePane = new CdGamePane(this);
		cdGamePane.setBackground(new Color(255, 255, 255));
		gameContentsPane.add(cdGamePane, "5");
		
		sportsGamePane = new SportsGamePane(this);
		sportsGamePane.setBackground(new Color(255, 255, 255));
		gameContentsPane.add(sportsGamePane, "6");
		
		ectGamePane = new EctGamePane(this);
		ectGamePane.setBackground(new Color(255, 255, 255));
		gameContentsPane.add(ectGamePane, "7");
		
		

		enternetBtn = new JButton("\uC778\uD130\uB137\uBE0C\uB77C\uC6B0\uC800");
		enternetBtn.setForeground(new Color(255, 255, 255));
		enternetBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		enternetBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		enternetBtn.setBackground(new Color(200, 162, 255));
		gameListPane.add(enternetBtn);
		

		issueGameBtn = new JButton("\uC778\uAE30\uAC8C\uC784");
		issueGameBtn.setForeground(new Color(255, 255, 255));
		issueGameBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		issueGameBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		issueGameBtn.setBackground(new Color(200, 162, 255));
		gameListPane.add(issueGameBtn);
		
		onlineGameBtn = new JButton("\uC628\uB77C\uC778\uAC8C\uC784");
		onlineGameBtn.setForeground(new Color(255, 255, 255));
		onlineGameBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		onlineGameBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		onlineGameBtn.setBackground(new Color(200, 162, 255));
		gameListPane.add(onlineGameBtn);
		
		actionGameBtn = new JButton("\uC561\uC158&FPS");
		actionGameBtn.setForeground(new Color(255, 255, 255));
		actionGameBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		actionGameBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		actionGameBtn.setBackground(new Color(200, 162, 255));
		gameListPane.add(actionGameBtn);
		
		cdGameBtn = new JButton("CD\uAC8C\uC784");
		cdGameBtn.setForeground(new Color(255, 255, 255));
		cdGameBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		cdGameBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		cdGameBtn.setBackground(new Color(200, 162, 255));
		gameListPane.add(cdGameBtn);
		
		sportsGameBtn = new JButton("  \uC2A4\uD3EC\uCE20&\uB808\uC774\uC2F1  ");
		sportsGameBtn.setForeground(new Color(255, 255, 255));
		sportsGameBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		sportsGameBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		sportsGameBtn.setBackground(new Color(200, 162, 255));
		gameListPane.add(sportsGameBtn);
		
		ectBtn = new JButton("\uAE30\uD0C0");
		ectBtn.setForeground(new Color(255, 255, 255));
		ectBtn.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		ectBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		ectBtn.setBackground(new Color(200, 162, 255));
		gameListPane.add(ectBtn);
		
		
		enternetBtn.addActionListener(gListener);
		issueGameBtn.addActionListener(gListener);
		onlineGameBtn.addActionListener(gListener);
		actionGameBtn.addActionListener(gListener);
		cdGameBtn.addActionListener(gListener);
		sportsGameBtn.addActionListener(gListener);
		ectBtn.addActionListener(gListener);
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);	
		
	}
	
}
