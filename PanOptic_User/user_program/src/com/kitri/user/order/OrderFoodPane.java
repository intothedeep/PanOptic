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

    // String foodName[]={"¸ÅÄÞÁ¦À°µ¤¹ä","¼ÒºÒ°í±âµ¤¹ä","¿ÀÂ¡¾îµ¤¹ä","Ä«·¹¶óÀÌ½º","À°°³Àå ","Ä¡Å²¸¶¿äµ¤¹ä
    // ","µ·±î½º ","¶±ººÀÌ","¶óººÀÌ","±è¹ä","¶ó¸é","ÇØ¹°¶ó¸é","¸¸µÎ¶ó¸é","Ä¡Áî¶ó¸é","¸¸µÎ¶ó¸é","Â¥Àå¶ó¸é"
    // ,"±èÄ¡ººÀ½¹ä","¾ßÃ¤ººÀ½¹ä","¾óÅ«¿ìµ¿","À¯ºÎ¿ìµ¿","¸Å¿î¿ìµ¿","¼Ò¼¼ÁöººÀ½¹ä","±èÄ¡Âî°³","µ¹¼Üºñºñ¹ã","Â¥Àå¹ä"};
    // String foodPrice[]
    // ={"5000¿ø","6000¿ø","5000¿ø","5000¿ø","6000¿ø","6500¿ø","6500¿ø","3000¿ø","4000¿ø","2500¿ø","2500¿ø","3000¿ø","4000¿ø","4000¿ø","4000¿ø","3000¿ø"
    // ,"5000¿ø","5000¿ø","5000¿ø","5000¿ø","5000¿ø","6000¿ø","6000¿ø","6000¿ø","6000¿ø"};

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
	// String columnNames[] = { "»çÁø", "À½½Ä¸Þ´º", "°¡°Ý" };
	// setRowData();
	// setRowData();
	// Vector temp = new Vector();
	// temp.add("img");
	// temp.add("¸ÅÁ¦");
	// temp.add(5000);
	// rowDatas.addElement(temp);
	// temp = new Vector<>();
	// temp.add("img");
	// temp.add("±èÄ¡Âò");
	// temp.add(25000);
	// rowDatas.addElement(temp);

	// Object rowData[][] = { { "img", "¸ÅÄÞÁ¦À°µ¤¹ä", "5000¿ø" }, { "img",
	// "¼ÒºÒ°í±âµ¤¹ä", "6000¿ø" } };

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
