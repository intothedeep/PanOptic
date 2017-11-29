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
			if (str.equals("������Ʈ"))
				service.updateUserJTable();
			else if (str.equals("������Ʈ"))
				service.showBlack();
		} 
//		else if (ob == cusMain.cusList.searchCombo) {
//			String str = "";
//			str = (String) cusMain.cusList.searchCombo.getSelectedItem();
//			if (str.equals("��ü"))
//				service.updateUserJTable();
//			else if (str.equals("�̸�"))
//				service.showBlack();
//		}
		
	}

}
