package com.kitri.user.order;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.main.Main;

public class OrderSnackPane extends JPanel {

    // String snack_name[]={"����� ","ī��Ÿ�� ","���͸�
    // ","���Ͽ�","������Ʈ","�ξ�Ŀ","���ڼ���","����ٽ�","��ũ","�����","����Ĩ","�Ƕ�","ĭ��","������","���ֶ�","���ֶ�"};
    // String snack_price[]
    // ={"2500��","2500��","3000��","4000��","4000��","4000��","3000��"
    // ,"2500��","2500��","2500��","2500��","3000��","3000��","3000��","4000��","3000��"};
    /**
     * Create the panel.
     */

    Vector rowDatas = new Vector<>();
    JTable table;
    Order order;
    JScrollPane scrollPane;

    public OrderSnackPane(Order order) {
	this.order = order;

	// Vector temp = new Vector<>();
	// temp.add("img");
	// temp.add("�����");
	// temp.add(2500);
	// rowDatas.addElement(temp);
	//
	// temp = new Vector<>();
	// temp.add("img");
	// temp.add("��ũ�ٽ�");
	// temp.add(3000);
	//
	// rowDatas.addElement(temp);

	table = new JTable();
    }

    public void setRowData() {
	int size = order.snacks.size();
	Main.log("setRowData : " + size);
	rowDatas = new Vector<>();
	Vector temp;
	FoodDto foodTemp;
	for (int i = 0; i < size; i++) {
	    foodTemp = order.snacks.get(i);
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

}
