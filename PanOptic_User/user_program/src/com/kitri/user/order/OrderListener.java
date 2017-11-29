package com.kitri.user.order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.user.dto.OrderInfoDto;

public class OrderListener implements ActionListener {
    Order order;

    public OrderListener(Order order) {
	this.order = order;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	int sum = 0;
	Object o = e.getSource();
	if (o == order.orderFoodbtn) {
	    order.clOrderContentsPane.show(order.orderContentsPane, "1");
	} else if (o == order.orderSnackbtn) {
	    order.clOrderContentsPane.show(order.orderContentsPane, "3");
	} else if (o == order.orderBeveragebtn) {
	    order.clOrderContentsPane.show(order.orderContentsPane, "2");
	}
	// if (o == order.BeveragePane.beverageNamebtn) {
	// sum += dto.getBeveragePrice();
	// order.totalPriceLabel.setText(sum.toString());
	// }
	// if (o == order.FoodPane.foodNamebtn) {
	// sum += dto.getFoodPrice();
	// order.totalPriceLabel.setText(sum);
	// }
	// if (o == order.SnackPane.SnackNamebtn) {
	// sum += dto.getSnackPrice();
	// order.totalPriceLabel.setText(sum);
	// }

    }
    

}
