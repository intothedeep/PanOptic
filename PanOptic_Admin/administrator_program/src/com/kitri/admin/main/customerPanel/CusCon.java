package com.kitri.admin.main.customerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CusCon implements ActionListener {
	CusMain cusMain;
	CusService service;

	public CusCon(CusMain cusMain) {
		this.cusMain = cusMain;
		service = new CusServiceImpl(cusMain);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == cusMain.cusListBtn) {
			service.updateUserJTable();
			service.viewCusList();
		} else if (ob == cusMain.cusList.searchTf || ob == cusMain.cusList.searchBut) {
			service.searchCustomer(cusMain.cusList.searchTf.getText().trim());

		} else if (ob == cusMain.cusList.listCombo) {
			String str = "";
			str = (String) cusMain.cusList.listCombo.getSelectedItem();
			if (str.equals("고객리스트"))
				service.updateUserJTable();
			else if (str.equals("블랙리스트"))
				service.showBlack();
		} 
//		else if (ob == cusMain.cusList.searchCombo) {
//			String str = "";
//			str = (String) cusMain.cusList.searchCombo.getSelectedItem();
//			if (str.equals("전체"))
//				service.updateUserJTable();
//			else if (str.equals("이름"))
//				service.showBlack();
//		}
		
	}

}
