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

    // String snack_name[]={"새우깡 ","카스타드 ","버터링
    // ","마켓오","마가렛트","로아커","초코송이","쿠쿠다스","제크","구운감자","초코칩","뽀또","칸쵸","오레오","미주라","미주라"};
    // String snack_price[]
    // ={"2500원","2500원","3000원","4000원","4000원","4000원","3000원"
    // ,"2500원","2500원","2500원","2500원","3000원","3000원","3000원","4000원","3000원"};
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
	// temp.add("새우깡");
	// temp.add(2500);
	// rowDatas.addElement(temp);
	//
	// temp = new Vector<>();
	// temp.add("img");
	// temp.add("쿠크다스");
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
