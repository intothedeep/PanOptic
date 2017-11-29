package com.kitri.admin.main.Login;

public class LoginDto {
	private String employeeId;
	private String employeePw;
	
	public LoginDto (String id, String pw) {
		employeeId = id;
		employeePw = pw;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeePw() {
		return employeePw;
	}
	public void setEmployeePw(String employeePw) {
		this.employeePw = employeePw;
	}	
}
