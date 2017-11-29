package com.kitri.user.order;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTable;

import com.kitri.user.dto.FoodDto;
import com.kitri.user.dto.OrderInfoDto;
import com.kitri.user.main.Main;
import com.kitri.user.network.PacketInformation;

public class OrderMouseListener extends MouseAdapter {

    Order order;
    int selectedRow;
    public int sum;
    String sum1;
    final int PRICE_COL = 3;
    final int NUM_COL = 0;
    final int MENU_COL = 2;
    int selectedMenu;
    String menu;

    ArrayList<OrderInfoDto> orderFoods;
    ArrayList<OrderList> orderLists;

    public OrderMouseListener(Order order) {
	this.order = order;
	orderFoods = new ArrayList<>();
	orderLists = new ArrayList<>();
	menu = "";
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	super.mouseClicked(e);

	Main.log("click!!");
	Object o = e.getSource();
	if (o == order.beveragePane.table) {
	    
	    if (order.beveragePane.table.getSelectedRow() >= 0) {

//		addOrderInfo((int) order.foodPane.table.getValueAt(selectedRow, NUM_COL), order.beverages);
		selectMenu(order.beveragePane.table, order.beverages);

	    }
	} else if (o == order.foodPane.table) {
	    if (order.foodPane.table.getSelectedRow() >= 0) {
		// selectedRow = order.foodPane.table.getSelectedRow();
		// sum += (int) order.foodPane.table.getValueAt(selectedRow,
		// PRICE_COL);
//		addOrderInfo((int) order.foodPane.table.getValueAt(selectedRow, NUM_COL), order.foods);
		//
		// order.totalPriceLabel.setText("합계 : " + sum);
		selectMenu(order.foodPane.table, order.foods);
	    }

	} else if (o == order.snackPane.table) {
	    if (order.snackPane.table.getSelectedRow() >= 0) {
		// selectedRow = order.snackPane.table.getSelectedRow();
		// sum += (int) order.snackPane.table.getValueAt(selectedRow,
		// PRICE_COL);
//		addOrderInfo((int) order.snackPane.table.getValueAt(selectedRow, NUM_COL), order.snacks);
		//
		// order.totalPriceLabel.setText("합계 : " + sum);
		selectMenu(order.snackPane.table, order.snacks);
	    }

	} else if (o == order.orderCancelBtn) {
	    resetOrder();
	} else if (o == order.pointPaybtn) {
	    orderByPoint();
	}

    }

    private void selectMenu(JTable table, ArrayList foodList) {
	selectedRow = table.getSelectedRow();
	Main.log("selectedRow : " + selectedRow);
	addOrderInfo(selectedRow, foodList);
	sum += (int) table.getValueAt(selectedRow, PRICE_COL);
//	addOrderInfo((int) table.getValueAt(selectedRow, NUM_COL), order.beverages);
	// menu += (String) table.getValueAt(selectedRow, MENU_COL) + "\n";

	// String foodName = (String) table.getValueAt(selectedRow, MENU_COL);
	menu = "";
	order.orderedList.setText("");
	
	int size = orderLists.size();
	for (int i = 0; i < size; i++) {
	    menu += orderLists.get(i).toString();
	}

	order.totalPriceLabel.setText("합계 : " + sum);
	order.orderedList.setText(menu);
    }

    private void resetOrder() {
	sum = 0;
	Main.log(Arrays.toString(orderFoods.toArray()));
	orderFoods = new ArrayList<>();
	orderLists = new ArrayList<>();
	menu = "";
	order.orderedList.setText("");
	System.out.println("합계 : " + sum);
	order.totalPriceLabel.setText("합계 : " + sum);
    }

    public void orderByPoint() {
	OrderInfoDto dto = new OrderInfoDto();

	int size = orderFoods.size();

	Main.network.sendPacket(PacketInformation.Operation.START, PacketInformation.PacketType.FOOD,
		PacketInformation.PacketType.IS_START);
	for (int i = 0; i < size; i++) {
	    Main.network.sendPacket(PacketInformation.Operation.BUY, PacketInformation.PacketType.FOOD,
		    orderFoods.get(i).toString());
	}
	Main.network.sendPacket(PacketInformation.Operation.END, PacketInformation.PacketType.FOOD,
		PacketInformation.PacketType.IS_END);

	resetOrder();

    }

    public void addOrderInfo(int num, ArrayList foodList) {
//	Main.log("addOrderInfo : " + num);
	int size = orderFoods.size();
	Main.log("orderFoods Size : " + size);
	OrderInfoDto dto = new OrderInfoDto();
	if (size == 0) {
	    setOrderInfo(num, dto, foodList);

	} else {
	    boolean isFind = false;
	    Main.log("orderFood : " + size);
	    for (int i = 0; i < size; i++) {
		dto = orderFoods.get(i);
		if (dto.getFoodNum() == ((FoodDto)foodList.get(num)).getFoodNum()) {
		    dto.setOrderCount(dto.getOrderCount() + 1);
		    orderLists.get(i).count = dto.getOrderCount();
		    Main.log("orderCount : " + orderLists.get(i).count);
		    isFind = true;
		    break;
		}
	    }

	    dto = new OrderInfoDto();

	    if (!isFind) {
		setOrderInfo(num, dto, foodList);
	    }
	}
	

	Main.log("addOrderInfo size : " + size);

    }

    private void setOrderInfo(int num, OrderInfoDto dto, ArrayList list) {
//	FoodDto foodDto = findFood(num, list);
	FoodDto foodDto = (FoodDto)list.get(num);
	Main.log("foodNum : " + dto.getFoodNum());
	dto.setUserNum(Main.network.view.userNum);
	dto.setFoodNum(foodDto.getFoodNum());
	dto.setOrderMoney(foodDto.getFoodPrice());
	dto.setOrderCount(1);
	dto.setComNum(Main.network.comNum);
	orderFoods.add(dto);
	Main.log("orderDto : " + dto.toString());
	orderLists.add(new OrderList(foodDto.getFoodName(), dto.getOrderCount()));
    }

    public FoodDto findFood(int num, ArrayList list) {
	FoodDto dto = null;
	int size = list.size();

	for (int i = 0; i < size; i++) {
	    dto = (FoodDto) list.get(i);
	    if (num == dto.getFoodNum()) {
		break;
	    }
	}
	Main.log("findFood : " + dto.toString());
	return dto;

    }
}

class OrderList {
    String foodName;
    int count;

    public OrderList() {
	// TODO Auto-generated constructor stub
    }

    public OrderList(String foodName, int count) {
	this.foodName = foodName;
	this.count = count;

    }

    @Override
    public String toString() {
	return foodName + "\t" + count + "개\n";
    }
}
