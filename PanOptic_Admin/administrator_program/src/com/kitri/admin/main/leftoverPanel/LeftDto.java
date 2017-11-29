package com.kitri.admin.main.leftoverPanel;

public class LeftDto {
	private int foodNum;
	private String foodName;
	private int foodTypeNum;
	private int foodleftNum;
	private int foodPrice;
	private String foodOrder;
	
	public LeftDto() {
		super();
	}

	public LeftDto(int foodNum, String foodName, int foodTypeNum, int foodleftNum, int foodPrice, String foodOrder) {
		super();
		this.foodNum = foodNum;
		this.foodName = foodName;
		this.foodTypeNum = foodTypeNum;
		this.foodleftNum = foodleftNum;
		this.foodPrice = foodPrice;
		this.foodOrder = foodOrder;
	}

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

	public int getFoodleftNum() {
		return foodleftNum;
	}

	public void setFoodleftNum(int foodleftNum) {
		this.foodleftNum = foodleftNum;
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
}
