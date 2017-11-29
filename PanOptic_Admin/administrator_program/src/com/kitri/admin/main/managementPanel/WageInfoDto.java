package com.kitri.admin.main.managementPanel;

public class WageInfoDto {
	
	private int wageInfoNum;
	private int workHourTotal;
	private int workWageTotal;

	public WageInfoDto() {
	}
	public WageInfoDto(int wageInfoNum, int workHourTotal, int workWageTotal) {
		super();
		this.wageInfoNum = wageInfoNum;
		this.workHourTotal = workHourTotal;
		this.workWageTotal = workWageTotal;
	}
	public int getWageInfoNum() {
		return wageInfoNum;
	}
	public void setWageInfoNum(int wageInfoNum) {
		this.wageInfoNum = wageInfoNum;
	}
	public int getWorkHourTotal() {
		return workHourTotal;
	}
	public void setWorkHourTotal(int workHourTotal) {
		this.workHourTotal = workHourTotal;
	}
	public int getWorkWageTotal() {
		return workWageTotal;
	}
	public void setWorkWageTotal(int workWageTotal) {
		this.workWageTotal = workWageTotal;
	}
	
	
}
