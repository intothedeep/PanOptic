package com.kitri.admin.main.employeePanel;

public interface EmpService {
	void showDetail ();
	void closeDetail ();
	void viewEmpList();
	
	void searchEmp (String name);
	void updateEmpJTable ();
	void updateEmpInfo (String name);
}
