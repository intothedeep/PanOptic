package com.kitri.admin.main.storePanel;

public class SettleAccountDto {
	private int settleAccountNum;
	private String settleDate;
	private int orderMoney;
	private int payMoney;
	private int settleTotal;
	private int yyyy;
	private int mm;
	private int dd;

	public SettleAccountDto() {
		super();
	}

	public SettleAccountDto(int settleAccountNum, String settleDate, int orderMoney, int payMoney, int settleTotal) {
		this.settleAccountNum = settleAccountNum;
		this.settleDate = settleDate;
		this.orderMoney = orderMoney;
		this.payMoney = payMoney;
		this.settleTotal = settleTotal;
	}
	public int getSettleAccountNum() {
		return settleAccountNum;
	}
	public void setSettleAccountNum(int settleAccountNum) {
		this.settleAccountNum = settleAccountNum;
	}
	public String getSettleDate() {
		return settleDate;
	}
	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}
	public int getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(int orderMoney) {
		this.orderMoney = orderMoney;
	}
	public int getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}
	public int getSettleTotal() {
		return settleTotal;
	}
	public void setSettleTotal(int settleTotal) {
		this.settleTotal = settleTotal;
	}
}
