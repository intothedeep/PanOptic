package com.kitri.admin.main.managementPanel;

import java.util.ArrayList;
import java.util.Vector;

import com.kitri.admin.main.customerPanel.CusDto;

public interface ManageDao {
	Vector<Vector> selectAll();
	int findId (String id);
	int registerEmp ();
	Vector<Vector> search (String name);
	
}
