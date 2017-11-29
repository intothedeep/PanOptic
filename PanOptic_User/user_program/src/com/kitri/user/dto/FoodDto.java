package com.kitri.user.dto;

import java.util.StringTokenizer;

public class FoodDto {
    private int foodNum;
    private String foodName;
    private int foodTypeNum;
    private int foodLeftNum;
    private int foodPrice;
    private String foodOrder;

    public int getFoodNum() {
	return foodNum;
    }
    

    public void setFoodNum(int foodNum) {
	this.foodNum = foodNum;
    }

    public String getFoodName() {
	return foodName;
    }

    public void setFoodName(String foodName) {
	this.foodName = foodName;
    }

    public int getFoodTypeNum() {
	return foodTypeNum;
    }

    public void setFoodTypeNum(int foodTypeNum) {
	this.foodTypeNum = foodTypeNum;
    }

    public int getFoodLeftNum() {
	return foodLeftNum;
    }

    public void setFoodLeftNum(int foodLeftNum) {
	this.foodLeftNum = foodLeftNum;
    }

    public int getFoodPrice() {
	return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
	this.foodPrice = foodPrice;
    }

    public String getFoodOrder() {
	return foodOrder;
    }

    public void setFoodOrder(String foodOrder) {
	this.foodOrder = foodOrder;
    }

    public void setFieldToInsert(String data) {
	StringTokenizer token = new StringTokenizer(data, ",");
	String temp;
	int i = 1;
	while (token.hasMoreTokens()) {
	    temp = token.nextToken();
	    switch (i++) {
	    case 1:
		foodName = temp;
		break;
	    case 2:
		foodTypeNum = Integer.parseInt(temp);
		break;
	    case 3:
		foodLeftNum = Integer.parseInt(temp);
	    case 4:
		foodPrice = Integer.parseInt(temp);
		break;
	    case 5:
		foodOrder = temp;
		break;
	    default:
	    }
	}
    }

    public void setField(String data) {
	StringTokenizer token = new StringTokenizer(data, ",");
	String temp;
	int i = 0;
	while (token.hasMoreTokens()) {
	    temp = token.nextToken();
	    switch (i++) {
	    case 0:
		foodNum = Integer.parseInt(temp);
		break;
	    case 1:
		foodName = temp;
		break;
	    case 2:
		foodTypeNum = Integer.parseInt(temp);
		break;
	    case 3:
		foodLeftNum = Integer.parseInt(temp);
	    case 4:
		foodPrice = Integer.parseInt(temp);
		break;
	    case 5:
		foodOrder = temp;
		break;
	    default:
	    }
	}
    }

    public String insertToString() {
	return foodName + "," + foodTypeNum + "," + foodLeftNum + "," + foodPrice + "," + foodOrder;
    }

    @Override
    public String toString() {
	return foodNum + "," + foodName + "," + foodTypeNum + "," + foodLeftNum + "," + foodPrice + "," + foodOrder;
    }

}