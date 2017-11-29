package com.kitri.admin.main.employeePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EmpCon extends MouseAdapter implements ActionListener {
	EmpMain empMain;
	EmpService service;
	EmpDao dao;

	public EmpCon(EmpMain empMain) {
		this.empMain = empMain;
		service = new EmpServiceImpl(empMain);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == empMain.empListBtn) {
			service.viewEmpList();
		} 
//		else if (ob == empMain.empList.detail) {
//			service.showDetail();
//		} 
		else if (ob == empMain.empDetail.closeBtn) {
			service.closeDetail();
		}
		else if (ob == empMain.empDetail.updateBtn) {
			service.updateEmpInfo (empMain.empDetail.idTf.getText().trim());
		}
		else if (ob == empMain.empList.searchBtn || ob == empMain.empList.searchTf) {
			service.searchEmp (empMain.empList.searchTf.getText().trim());
		}
	}

	public void mouseClicked(MouseEvent e) {
		service.showDetail ();		
	}

}
