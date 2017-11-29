package com.kitri.admin.main.employeePanel;

import java.util.ArrayList;
import java.util.Vector;

public interface EmpDao {
	ArrayList<EmpDto> selectAll();
	Vector<String> findUser(String name);
	int updateEmpInfo (String id);
	ArrayList<EmpDto> searchEmp (String name);
}
