package com.kitri.user.dto;

import java.util.StringTokenizer;


public class OrderInfoDto {
    private int orderNum;
    private int userNum;
    private int foodNum;
    private int orderMoney;
    private int orderCount;
    private String orderTime;
    private int comNum;

    public int getOrderNum() {
	return orderNum;
    }

    public void setOrderNum(int orderNum) {
	this.orderNum = orderNum;
    }

    public int getUserNum() {
	return userNum;
    }

    public void setUserNum(int userNum) {
	this.userNum = userNum;
    }

    public int getFoodNum() {
	return foodNum;
    }

    public void setFoodNum(int foodNum) {
	this.foodNum = foodNum;
    }

    public int getOrderMoney() {
	return orderMoney;
    }

    public void setOrderMoney(int orderMoney) {
	this.orderMoney = orderMoney;
    }

    public int getOrderCount() {
	return orderCount;
    }

    public void setOrderCount(int orderCount) {
	this.orderCount = orderCount;
    }

    public String getOrderTime() {
	return orderTime;
    }

    public void setOrderTime(String orderTime) {
	this.orderTime = orderTime;
    }

    public int getComNum() {
	return comNum;
    }

    public void setComNum(int comNum) {
	this.comNum = comNum;
    }

    public void setFieldToInsert(String data) {
	StringTokenizer token = new StringTokenizer(data, ",");
	int i = 1;
	String temp;

	while (token.hasMoreTokens()) {
	    temp = token.nextToken();
	    switch (i++) {
	    case 1:
		userNum = Integer.parseInt(temp);
		break;
	    case 2:
		foodNum = Integer.parseInt(temp);
		break;
	    case 3:
		orderMoney = Integer.parseInt(temp);
		break;
	    case 4:
		orderCount = Integer.parseInt(temp);
	    case 5:
		orderTime = temp;
		break;
	    case 6:
		comNum = Integer.parseInt(temp);
		break;
	    default:
	    }
	}
    }

    public void setField(String data) {
	StringTokenizer token = new StringTokenizer(data, ",");
	int i = 0;
	String temp;

	while (token.hasMoreTokens()) {
	    temp = token.nextToken();
	    switch (i++) {
	    case 0:
		orderNum = Integer.parseInt(temp);
		break;
	    case 1:
		userNum = Integer.parseInt(temp);
		break;
	    case 2:
		foodNum = Integer.parseInt(temp);
		break;
	    case 3:
		orderMoney = Integer.parseInt(temp);
		break;
	    case 4:
		orderCount = Integer.parseInt(temp);
	    case 5:
		orderTime = temp;
		break;
	    case 6:
		comNum = Integer.parseInt(temp);
		break;
	    default:
	    }
	}
    }

    public String insertToString() {
	return userNum + "," + foodNum + "," + orderMoney + "," + orderCount + "," + orderTime + "," + comNum;
    }

    @Override
    public String toString() {
	return orderNum + "," + userNum + "," + foodNum + "," + orderMoney + "," + orderCount + "," + orderTime + ","
		+ comNum;
    }

}
