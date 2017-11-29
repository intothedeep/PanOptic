package com.kitri.admin.main.customerPanel;

import java.util.ArrayList;

import com.kitri.admin.main.employeePanel.EmpDto;
import com.kitri.admin.main.leftoverPanel.LeftDto;

public interface CusDao {
	ArrayList<CusDto> selectUser ();
	ArrayList<CusDto> selectBlack ();
	ArrayList<CusDto> searchCustomer (String name);
}
