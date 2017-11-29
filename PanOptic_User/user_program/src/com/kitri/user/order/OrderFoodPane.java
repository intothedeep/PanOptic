package com.kitri.user.order;

import java.awt.*;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.main.Main;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class OrderFoodPane extends JPanel {

    // String foodName[]={"������������","�ҺҰ�ⵤ��","��¡���","ī�����̽�","������ ","ġŲ���䵤��
    // ","��� ","������","����","���","���","�ع����","���ζ��","ġ����","���ζ��","¥����"
    // ,"��ġ������","��ä������","��ū�쵿","���ο쵿","�ſ�쵿","�Ҽ���������","��ġ�","���ܺ���","¥���"};
    // String foodPrice[]
    // ={"5000��","6000��","5000��","5000��","6000��","6500��","6500��","3000��","4000��","2500��","2500��","3000��","4000��","4000��","4000��","3000��"
    // ,"5000��","5000��","5000��","5000��","5000��","6000��","6000��","6000��","6000��"};

    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */

    Vector rowDatas = new Vector<>();
    public JTable table;
    Order order;
    JScrollPane scrollPane;

    public OrderFoodPane(Order order) {
	this.order = order;
	// String columnNames[] = { "����", "���ĸ޴�", "����" };
	// setRowData();
	// setRowData();
	// Vector temp = new Vector();
	// temp.add("img");
	// temp.add("����");
	// temp.add(5000);
	// rowDatas.addElement(temp);
	// temp = new Vector<>();
	// temp.add("img");
	// temp.add("��ġ��");
	// temp.add(25000);
	// rowDatas.addElement(temp);

	// Object rowData[][] = { { "img", "������������", "5000��" }, { "img",
	// "�ҺҰ�ⵤ��", "6000��" } };

	// JTable jTable = new JTable(rowData, columnNames);

	table = new JTable();

    }

    public void setRowData() {
	int size = order.foods.size();
	Main.log("setRowData : " + size);
	rowDatas = new Vector<>();
	Vector temp;
	FoodDto foodTemp;
	for (int i = 0; i < size; i++) {
	    foodTemp = order.foods.get(i);
	    temp = new Vector<>();
	    temp.add(foodTemp.getFoodNum());
	    temp.add("tmp.jpg");
	    temp.add(foodTemp.getFoodName());
	    temp.add(foodTemp.getFoodPrice());
	    rowDatas.addElement(temp);

	}

	DefaultTableModel model = new DefaultTableModel(rowDatas, order.col) {
	    @Override
	    public boolean isCellEditable(int row, int column) {
		return false;
	    }
	};

	table = new JTable(model);
	
	table.getTableHeader().setReorderingAllowed(false);
	table.getTableHeader().setResizingAllowed(false);
	table.addMouseListener(order.mListener);

	scrollPane = new JScrollPane(table);
	scrollPane.getViewport().setBackground(Color.WHITE);

	Dimension d = table.getPreferredSize();
	scrollPane.setPreferredSize(new Dimension(630, 500));
	add(scrollPane);

    }

    // private void setRowData() {
    // int size = 90;
    //
    // Vector temp = new Vector();
    // int count = 0;
    // for (int i = 0; i < size; i++) {
    // if (count < 3) {
    // temp.add(i);
    // count++;
    // } else {
    // rowDatas.addElement(temp);
    // temp = new Vector();
    // count = 0;
    // }
    //
    // }
    //
    // }

}
