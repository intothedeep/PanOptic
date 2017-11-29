package com.kitri.admin.main.employeePanel;

public class EmpDto {
	private int empNum;
	private String empName;
	private String empHp;
	private String empDate;
	private String empId;
	private String empPw;
	private String empEmail;
	private String empBirth;
	private int hourPayRate;
	private String empPosition;
	private String empIsMale;
	
	public EmpDto() {
		super();
	}
	public EmpDto(int empNum, String empName, String empHp, String empDate, String empId, String empPw, String empEmail,
			String empBirth, int hourPayRate, String empPosition, String empIsMale) {
		this.empNum = empNum;
		this.empName = empName;
		this.empHp = empHp;
		this.empDate = empDate;
		this.empId = empId;
		this.empPw = empPw;
		this.empEmail = empEmail;
		this.empBirth = empBirth;
		this.hourPayRate = hourPayRate;
		this.empPosition = empPosition;
		this.empIsMale = empIsMale;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpHp() {
		return empHp;
	}
	public void setEmpHp(String empHp) {
		this.empHp = empHp;
	}
	public String getEmpDate() {
		return empDate;
	}
	public void setEmpDate(String empDate) {
		this.empDate = empDate;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpPw() {
		return empPw;
	}
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpBirth() {
		return empBirth;
	}
	public void setEmpBirth(String empBirth) {
		this.empBirth = empBirth;
	}
	public int getHourPayRate() {
		return hourPayRate;
	}
	public void setHourPayRate(int hourPayRate) {
		this.hourPayRate = hourPayRate;
	}
	public String getEmpPosition() {
		return empPosition;
	}
	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}
	public String getEmpIsMale() {
		return empIsMale;
	}
	public void setEmpIsMale(String empIsMale) {
		this.empIsMale = empIsMale;
	}	
}
