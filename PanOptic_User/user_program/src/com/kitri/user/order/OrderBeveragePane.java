package com.kitri.user.order;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.main.Main;
import java.awt.Color;

public class OrderBeveragePane extends JPanel {
    // private String beverageName[] ={"아메리카노","카푸치노","카페라떼","카라멜마끼아또","까페모카",
    // "초코라뗴","녹차라떼","고구마라뗴","유자차","복숭아아이스티","레몬아이스티","콜라","사이다","환타","스프라이트","마운틴듀"};
    // private String beveragePrice[]
    // ={"3000원","4000원","3500원","5000원","5000원","3500원","3500원",
    // "3500원","3500원","3500원","4000원","4000원","4000원","4000원","3000원","3000원","3000원"};
    //
    Vector<Object> rowDatas = new Vector<>();
    JTable table;
    Order order;
    JScrollPane scrollPane;

    /**
     * Create the panel.
     */
    public OrderBeveragePane(Order order) {
	this.order = order;

	// Vector temp = new Vector();
	// temp.add("img");
	// temp.add("아메리카노");
	// temp.add(3000);
	// rowDatas.addElement(temp);
	// temp = new Vector<>();
	// temp.add("img");
	// temp.add("카페라떼");
	// temp.add(4000);
	// rowDatas.addElement(temp);

	table = new JTable();

    }

    public void setRowData() {
	int size = order.beverages.size();
	Main.log("setRowData : " + size);
	rowDatas = new Vector<>();
	Vector<Object> temp;
	FoodDto foodTemp;
	for (int i = 0; i < size; i++) {
	    foodTemp = order.beverages.get(i);
	    temp = new Vector<>();
	    temp.add(foodTemp.getFoodNum());
	    temp.add("temp.jpg");
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

    private ImageIcon createImage(String string) {
	// TODO Auto-generated method stub
	return null;
    }

}
