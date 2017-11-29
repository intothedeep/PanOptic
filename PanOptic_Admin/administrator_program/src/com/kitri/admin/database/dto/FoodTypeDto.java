package com.kitri.admin.database.dto;

import java.util.StringTokenizer;

public class FoodTypeDto {
    private int foodTypeNum;
    private String foodTypeName;

    public int getFoodTypeNum() {
	return foodTypeNum;
    }

    public void setFoodTypeNum(int foodTypeNum) {
	this.foodTypeNum = foodTypeNum;
    }

    public String getFoodTypeName() {
	return foodTypeName;
    }

    public void setFoodTypeName(String foodTypeName) {
	this.foodTypeName = foodTypeName;
    }

    public void setField(String data){
	StringTokenizer token = new StringTokenizer(data, ",");
	int i = 0;
	String temp;
	while(token.hasMoreTokens()){
	    temp = token.nextToken();
	    switch(i++){
	    case 0:
		foodTypeNum = Integer.parseInt(temp);
		break;
	    case 1:
		foodTypeName = temp;
		break;
		default:
	    }
	}
    }

    @Override
    public String toString() {
	return foodTypeNum + "," + foodTypeName;
    }

}