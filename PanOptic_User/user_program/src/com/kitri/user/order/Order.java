package com.kitri.user.order;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.dto.FoodTypeDto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class Order extends JFrame {

    private JPanel backgroundPane;
    private JPanel orderTitlePane;
    private JLabel orderTitleLabel;
    private JPanel orderMenuPane;
    public JPanel orderContentsPane;
    public JButton orderFoodbtn;
    public JButton orderSnackbtn;
    private JLabel emptyLabel;
    private JLabel emptyLabel1;
    public JButton pointPaybtn;
    public JLabel totalPriceLabel;
    public JButton orderBeveragebtn;
    public OrderSnackPane snackPane;
    public OrderBeveragePane beveragePane;
    public OrderFoodPane foodPane;
    public OrderListener listener;
    public CardLayout clOrderContentsPane = new CardLayout();
    public OrderMouseListener mListener;
    public JButton orderCancelBtn;
    public JPanel orderedListPane;
    public JTextField orderedListTitle;
    public JTextArea orderedList;

    public ArrayList<FoodTypeDto> foodTypes;
    public ArrayList<FoodDto> foods;
    public ArrayList<FoodDto> snacks;
    public ArrayList<FoodDto> beverages;
    public Vector col = new Vector<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Order frame = new Order();
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
    public Order() {
	listener = new OrderListener(this);
	mListener = new OrderMouseListener(this);

	col.add("¹øÈ£");
	col.add("»çÁø");
	col.add("À½·á¸Þ´º");
	col.add("°¡°Ý");

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setBounds(100, 100, 900, 600);
	backgroundPane = new JPanel();
	backgroundPane.setBackground(Color.WHITE);
	backgroundPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(backgroundPane);
	backgroundPane.setLayout(new BorderLayout(0, 0));

	orderTitlePane = new JPanel();
	orderTitlePane.setBackground(new Color(255, 255, 255));
	orderTitlePane.setOpaque(false);
	backgroundPane.add(orderTitlePane, BorderLayout.NORTH);
	orderTitlePane.setLayout(new BorderLayout(100, 100));

	orderTitleLabel = new JLabel("Order\t");
	orderTitleLabel.setIcon(new ImageIcon("UserMainImage\\odermark.png"));
	orderTitleLabel.setFont(new Font("¹è´ÞÀÇ¹ÎÁ· µµÇö", Font.PLAIN, 31));
	orderTitlePane.add(orderTitleLabel);

	orderMenuPane = new JPanel();
	orderMenuPane.setOpaque(false);
	backgroundPane.add(orderMenuPane, BorderLayout.WEST);
	orderMenuPane.setLayout(new GridLayout(7, 1, 0, 0));

	orderContentsPane = new JPanel();
	orderContentsPane.setBorder(new LineBorder(new Color(119, 136, 153)));
	orderContentsPane.setBackground(new Color(255, 255, 255));
	orderContentsPane.setOpaque(false);

	orderContentsPane.setLayout(clOrderContentsPane);
	beveragePane = new OrderBeveragePane(this);
	beveragePane.setOpaque(false);
	beveragePane.setBackground(new Color(255, 255, 255));
	snackPane = new OrderSnackPane(this);
	snackPane.setOpaque(false);
	snackPane.setBackground(new Color(255, 255, 255));
	foodPane = new OrderFoodPane(this);
	foodPane.setOpaque(false);
	foodPane.setBackground(new Color(255, 255, 255));
	orderContentsPane.add(foodPane, "1");
	orderContentsPane.add(beveragePane, "2");
	orderContentsPane.add(snackPane, "3");

	backgroundPane.add(orderContentsPane, BorderLayout.CENTER);

	orderFoodbtn = new JButton("\uC74C\uC2DD");
	orderFoodbtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(248, 248, 255)));
	orderFoodbtn.setForeground(Color.WHITE);
	orderFoodbtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	orderFoodbtn.setBackground(new Color(200, 162, 255));
	orderMenuPane.add(orderFoodbtn);

	orderSnackbtn = new JButton("\uC2A4\uB0B5");
	orderSnackbtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(248, 248, 255)));
	orderSnackbtn.setForeground(Color.WHITE);
	orderSnackbtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	orderSnackbtn.setBackground(new Color(200, 162, 255));
	orderMenuPane.add(orderSnackbtn);

	orderBeveragebtn = new JButton("\uC74C\uB8CC");
	orderBeveragebtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(248, 248, 255)));
	orderBeveragebtn.setForeground(Color.WHITE);
	orderBeveragebtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	orderBeveragebtn.setBackground(new Color(200, 162, 255));
	orderMenuPane.add(orderBeveragebtn);
		
			orderCancelBtn = new JButton("\uC8FC\uBB38\uCDE8\uC18C");
			orderCancelBtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(248, 248, 255)));
			orderCancelBtn.setForeground(Color.WHITE);
			orderCancelBtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
			orderCancelBtn.setBackground(new Color(200, 162, 255));
			orderMenuPane.add(orderCancelBtn);
			orderCancelBtn.addMouseListener(mListener);
	
		pointPaybtn = new JButton("    \uD3EC\uC778\uD2B8\uACB0\uC81C    ");
		pointPaybtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(248, 248, 255)));
		pointPaybtn.setForeground(Color.WHITE);
		pointPaybtn.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		pointPaybtn.setBackground(new Color(200, 162, 255));
		orderMenuPane.add(pointPaybtn);
		pointPaybtn.addMouseListener(mListener);

	emptyLabel = new JLabel("");
	emptyLabel.setBackground(new Color(224, 255, 255));
	emptyLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	orderMenuPane.add(emptyLabel);
	
		totalPriceLabel = new JLabel("\uD569\uACC4:");
		totalPriceLabel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) null));
		totalPriceLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		orderMenuPane.add(totalPriceLabel);

	orderedListPane = new JPanel();
	orderedListPane.setOpaque(false);
	backgroundPane.add(orderedListPane, BorderLayout.EAST);
	orderedListPane.setLayout(new BorderLayout(0, 0));

	orderedListTitle = new JTextField();
	orderedListTitle.setForeground(new Color(255, 255, 255));
	orderedListTitle.setBorder(new LineBorder(new Color(255, 255, 255)));
	orderedListTitle.setBackground(new Color(135, 206, 250));
	orderedListTitle.setEditable(false);
	orderedListTitle.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
	orderedListTitle.setHorizontalAlignment(SwingConstants.CENTER);
	orderedListTitle.setText("\uC8FC\uBB38\uB0B4\uC5ED");
	orderedListPane.add(orderedListTitle, BorderLayout.NORTH);
	orderedListTitle.setColumns(10);

	orderedList = new JTextArea();
	orderedList.setEditable(false);
	orderedListPane.add(orderedList);

	setVisible(false);
	orderFoodbtn.addActionListener(listener);
	orderBeveragebtn.addActionListener(listener);
	orderSnackbtn.addActionListener(listener);
    }

    public void buyFoodSuccess() {
	JOptionPane.showMessageDialog(this, "À½½Ä ±¸¸Å¿¡ ¼º°øÇß½À´Ï´Ù.", "¼º°ø", JOptionPane.WARNING_MESSAGE);

    }

    public void buyFoodFail() {
	JOptionPane.showMessageDialog(this, "À½½Ä ±¸¸Å¿¡ ½ÇÆÐÇß½À´Ï´Ù.", "½ÇÆÐ", JOptionPane.WARNING_MESSAGE);

    }
    // public void setColData(Vector vec, JTable table, ArrayList list, JPanel
    // p, JScrollPane scroll) {
    // int size = vec.size();
    //
    // vec = new Vector<>();
    // Vector temp;
    // FoodDto foodTemp;
    // for (int i = 0; i < size; i++) {
    // foodTemp = (FoodDto) list.get(i);
    // temp = new Vector<>();
    // temp.add(foodTemp.getFoodNum());
    // temp.add("tmp.jpg");
    // temp.add(foodTemp.getFoodName());
    // temp.add(foodTemp.getFoodPrice());
    // vec.addElement(temp);
    // }
    //
    // DefaultTableModel model = new DefaultTableModel(vec, col) {
    // @Override
    // public boolean isCellEditable(int row, int column) {
    // return false;
    // }
    // };
    //
    // table = new JTable(model);
    // table.getTableHeader().setReorderingAllowed(false);
    // table.getTableHeader().setResizingAllowed(false);
    //
    // table.addMouseListener(mListener);
    // scroll = new JScrollPane(table);
    // p.add(scroll);
    // }

}
