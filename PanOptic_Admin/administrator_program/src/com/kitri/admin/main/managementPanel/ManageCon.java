package com.kitri.admin.main.managementPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageCon implements ActionListener {
	private ManageMain manageMain;
	private ManageService service;
	private ManageDao dao;

	public ManageCon(ManageMain manageMain) {
		super();
		this.manageMain = manageMain;
		service = new ManageServiceImpl(manageMain);
		dao = new ManageDaoImpl(manageMain);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = manageMain.regEmp.idTf.getText().trim();
		Object ob = e.getSource();
		if (ob == manageMain.regEmpBtn) {
			service.viewRegEmp ();
		} else if (ob == manageMain.wageInfoBtn) {
			service.viewWageInfo();
		} else if (ob == manageMain.regEmp.checkBtn) {
			service.checkId(id);
		} else if (ob == manageMain.regEmp.closeBtn) {
			service.closeRegEmp();
		} else if (ob == manageMain.regEmp.joinBtn) {
			service.registerEmp ();
		} else if (ob == manageMain.wageInfo.searchBtn || ob == manageMain.wageInfo.searchTf) {
			service.search (manageMain.wageInfo.searchTf.getText().trim());

		} 
	}
}
