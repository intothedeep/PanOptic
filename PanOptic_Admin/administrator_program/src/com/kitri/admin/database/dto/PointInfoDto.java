package com.kitri.admin.database.dto;

public class PointInfoDto {
    private int num;
    private int value;
    private int price;

    public int getNum() {
	return num;
    }

    public void setNum(int num) {
	this.num = num;
    }

    public int getValue() {
	return value;
    }

    public void setValue(int value) {
	this.value = value;
    }

    public int getPrice() {
	return price;
    }

    public void setPrice(int price) {
	this.price = price;
    }

    @Override
    public String toString() {
	return num + "," + value + "," + price;
    }

}
