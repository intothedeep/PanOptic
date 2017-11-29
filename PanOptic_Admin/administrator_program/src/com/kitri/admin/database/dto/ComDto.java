package com.kitri.admin.database.dto;

public class ComDto {
	private int comNum;
	private int userNum;
	private String isUse;
	private String isBooking;
	
	public ComDto() {
	    isUse = "0";
	    isBooking = "0";
	}
	

	public int getComNum() {
		return comNum;
	}

	public void setComNum(int comNum) {
		this.comNum = comNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public String getIsBooking() {
		return isBooking;
	}

	public void setIsBooking(String isBooking) {
		this.isBooking = isBooking;
	}
	

	@Override
	public String toString() {
		return comNum + "," + userNum + "," + isUse + "," + isBooking;
	}

}
