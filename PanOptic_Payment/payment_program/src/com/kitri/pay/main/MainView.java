package com.kitri.pay.main;

import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kitri.pay.join.UserJoin;
import com.kitri.pay.login.UserLogin;
import com.kitri.pay.payment.PaymentView;

public class MainView extends JFrame {

	public int TIME_COUNT = 8;
	public int POINT_COUNT = 5;
	public int FUNCTION_COUNT = 3;

	public int[] timeMoney = { 1000, 1200, 1500, 2000, 2500, 3000, 4000, 5000 };
	public int[] pointMoney = { 1000, 2500, 4000, 7000, 10000 };
	public String[] timeStr = { "1�ð�  1000��", "2�ð�  1200��", "3�ð�  1500��", "4�ð�  2000��", "5�ð�  2500��", "6�ð�  3000��",
			"7�ð�  4000��", "8�ð�  5000��" };
	public String[] pointStr = { "1000P  1000��", "3000P  2500��", "5000P  4000��", "10000P  7000��", "15000P  10000��" };
	public String[] functionStr = { "ȸ������", "����Ʈ����", "ī�����" };
	public boolean[] isClickTime;
	public boolean[] isClickPoint;

	private int money;

	public JLabel[] timeButton;
	public JLabel[] pointButton;
	public JButton[] functionButton;

	public JPanel contentPane;
	private JPanel timeButtonPanel;
	private JPanel pointButtonPanel;
	private JPanel functionPanel;
	private JPanel mainPanel;
	private JPanel mainLabelPanel;
	private JLabel lblNewLabel;
	private JPanel timePanel;
	private JPanel timeLabelPanel;
	private JLabel timeLabel;
	private JPanel pointPanel;
	private JPanel pointLabelPanel;
	private JLabel pointLabel;

	private MainViewListener listener;
	private JLabel moneyLabel;

	private static MainView view;

	public UserJoin join; // internal
	public UserLogin login;
	public PaymentView payment;
	private JInternalFrame internalFrame;
	public JTextArea ta;
	public int payType;
	private JPanel panel_1;

	ImageIcon wholeImageIcon = new ImageIcon("img\\userMainTest.png");
	Image wholeIamge = wholeImageIcon.getImage();
	private JPanel functionCenterPanel;
	private JPanel functionTitlePanel;
	private JLabel functionTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					// frame.setContentPane(new JLabel(new
					// ImageIcon(ImageIO.read(new
					// File("C:\\java\\workspace\\javase\\PanOptic\\src\\img\\userMainTest.png")))));
					// Image Background =
					// Toolkit.getDefaultToolkit().createImage("C:\\java\\workspace\\javase\\PanOptic\\src\\img\\userMainTest.png");
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
	public MainView() {

		ta = new JTextArea();

		view = this;
		money = 0;

		isClickTime = new boolean[TIME_COUNT];
		isClickPoint = new boolean[POINT_COUNT];

		listener = new MainViewListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 900);
		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(wholeIamge, 0, 0, null);
				setOpaque(false);
			}
		};
		contentPane.setOpaque(false);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		join = new UserJoin();
		login = new UserLogin();
		payment = new PaymentView();
		payment.closeButton.setFont(new Font("����", Font.BOLD, 20));
		payment.payButton.setFont(new Font("����", Font.BOLD, 20));
		contentPane.add(payment);
		contentPane.add(login);
		contentPane.add(join);

		mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(1, 3, 40, 10));

		timePanel = new JPanel();
		timePanel.setOpaque(false);
		mainPanel.add(timePanel);
		timePanel.setLayout(new BorderLayout(0, 0));

		timeButtonPanel = new JPanel();
		timeButtonPanel.setOpaque(false);
		timePanel.add(timeButtonPanel, BorderLayout.CENTER);
		timeButtonPanel.setLayout(new GridLayout(4, 2, 30, 30));

		timeButton = new JLabel[TIME_COUNT];
		setButton(timeButton, timeStr, timeButtonPanel, TIME_COUNT);

		timeLabelPanel = new JPanel();
		timeLabelPanel.setOpaque(false);
		timePanel.add(timeLabelPanel, BorderLayout.NORTH);

		timeLabel = new JLabel("      ");
		timeLabel.setFont(new Font("����", Font.PLAIN, 40));
		timeLabelPanel.add(timeLabel);

		pointPanel = new JPanel();
		mainPanel.add(pointPanel);
		pointPanel.setLayout(new BorderLayout(0, 0));

		pointButtonPanel = new JPanel();
		pointButtonPanel.setOpaque(false);
		pointPanel.add(pointButtonPanel);
		pointButtonPanel.setLayout(new GridLayout(4, 2, 30, 30));

		pointButton = new JLabel[POINT_COUNT];
		setButton(pointButton, pointStr, pointButtonPanel, POINT_COUNT);

		pointLabelPanel = new JPanel();
		pointLabelPanel.setOpaque(false);
		pointPanel.setOpaque(false);
		pointPanel.add(pointLabelPanel, BorderLayout.NORTH);

		pointLabel = new JLabel("     ");
		pointLabel.setForeground(Color.BLACK);
		pointLabel.setFont(new Font("����", Font.PLAIN, 40));
		pointLabelPanel.add(pointLabel);

		functionPanel = new JPanel();
		functionPanel.setOpaque(false);
		mainPanel.add(functionPanel);
		functionPanel.setLayout(new BorderLayout(0, 0));

		functionTitlePanel = new JPanel();
		functionTitlePanel.setOpaque(false);
		functionPanel.add(functionTitlePanel, BorderLayout.NORTH);

		functionTitle = new JLabel("       ");
		functionTitle.setFont(new Font("����", Font.PLAIN, 40));
		functionTitlePanel.add(functionTitle);

		functionCenterPanel = new JPanel();
		functionCenterPanel.setOpaque(false);
		functionPanel.add(functionCenterPanel, BorderLayout.CENTER);
		functionCenterPanel.setLayout(new GridLayout(4, 1, 10, 10));

		moneyLabel = new JLabel(money + "��");
		functionCenterPanel.add(moneyLabel);
		moneyLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		moneyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		moneyLabel.setHorizontalAlignment(JLabel.CENTER);
		moneyLabel.setVerticalAlignment(JLabel.CENTER);
		moneyLabel.setFont(new Font("default", Font.BOLD, 40));

		functionButton = new JButton[FUNCTION_COUNT];
		for (int i = 0; i < FUNCTION_COUNT; i++) {
			functionButton[i] = new JButton(functionStr[i]);
			functionButton[i].addActionListener(listener);
			functionButton[i].setFont(new Font("����", Font.PLAIN, 30));
			functionButton[i].setContentAreaFilled(false);
			functionButton[i].setBorderPainted(false);
			functionButton[i].setContentAreaFilled(false);
			functionButton[i].setOpaque(false);
			functionCenterPanel.add(functionButton[i]);
		}

		mainLabelPanel = new JPanel();
		mainLabelPanel.setMinimumSize(new Dimension(10, 100));
		mainLabelPanel.setOpaque(false);
		contentPane.add(mainLabelPanel, BorderLayout.NORTH);

		lblNewLabel = new JLabel("      ");
		lblNewLabel.setFont(new Font("����ǹ��� ����", Font.PLAIN, 99));
		mainLabelPanel.add(lblNewLabel);

		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = environment.getDefaultScreenDevice();
		this.setUndecorated(true);
		device.setFullScreenWindow(this);

		// if (device.isDisplayChangeSupported()) {
		// // refreshRate���� ���� ã�� ������
		// DisplayMode displayMode = new DisplayMode(1024, 768, 32,
		// DisplayMode.REFRESH_RATE_UNKNOWN);
		// device.setDisplayMode(displayMode);
		// }
	}

	private void setButton(JLabel[] label, String[] labelStr, JPanel panel, int count) {

		for (int i = 0; i < count; i++) {
			label[i] = new JLabel(labelStr[i]);
			label[i].setHorizontalAlignment(JLabel.CENTER);
			label[i].setVerticalAlignment(JLabel.CENTER);
			// timeButton[i].setForeground(Color.BLUE);
			label[i].setFont(new Font("default", Font.BOLD, 20));
			label[i].addMouseListener(listener);
			panel.add(label[i]);
		}

	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;

		if (this.money < 0) {
			this.money = 0;
		}
		payment.price = this.money;

		moneyLabel.setText(this.money + "��");
	}

	public static MainView getInstance() {
		return view;
	}

	public void joinSuccess() {
		JOptionPane.showMessageDialog(this, "ȸ�������� ���ϵ帳�ϴ�!!", "ȸ�����Լ���", JOptionPane.WARNING_MESSAGE);

	}

	public void pointException() {
		JOptionPane.showMessageDialog(this, "����Ʈ�� ����Ʈ�� �����ϽǼ� �����ϴ�.", "����Ʈ ���� �Ұ�", JOptionPane.WARNING_MESSAGE);

	}

	public void buySuccess() {
		JOptionPane.showMessageDialog(this, "���� �����߽��ϴ�. �̿����ּż� �����մϴ�.", "���ż���", JOptionPane.WARNING_MESSAGE);

	}

	public void buyFail() {
		JOptionPane.showMessageDialog(this, "���� �����߽��ϴ�. �ٽ� �̿����ֽñ�ٶ��ϴ�.", "���Ž���", JOptionPane.WARNING_MESSAGE);
	}
}
