package com.kitri.admin.database.dto;

import java.util.StringTokenizer;

public class ComPrepaidInfoDto {
    private int prepaidNum;
    private int prepaidTime;
    private int prepaidPrice;

    public int getPrepaidNum() {
	return prepaidNum;
    }

    public void setPrepaidNum(int prepaidNum) {
	this.prepaidNum = prepaidNum;
    }

    public int getPrepaidTime() {
	return prepaidTime;
    }

    public void setPrepaidTime(int prepaidTime) {
	this.prepaidTime = prepaidTime;
    }

    public int getPrepaidPrice() {
	return prepaidPrice;
    }

    public void setPrepaidPrice(int prepaidPrice) {
	this.prepaidPrice = prepaidPrice;
    }

    public void setField(String data) {
	StringTokenizer fieldToken = new StringTokenizer(data, ",");

	int i = 0;
	String temp;
	while (fieldToken.hasMoreTokens()) {
	    temp = fieldToken.nextToken();
	    switch (i++) {
	    case 0:
		prepaidNum = Integer.parseInt(temp);
		break;
	    case 1:
		prepaidTime = Integer.parseInt(temp);
		break;
	    case 2:
		prepaidPrice = Integer.parseInt(temp);
		break;
	    default:
	    }
	}
    }

    @Override
    public String toString() {
	return prepaidNum + "," + prepaidTime + "," + prepaidPrice;
    }

}
