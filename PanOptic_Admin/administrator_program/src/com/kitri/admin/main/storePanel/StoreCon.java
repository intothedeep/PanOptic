package com.kitri.admin.main.storePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kitri.admin.server.Main;

public class StoreCon implements ActionListener {
	StoreMain storeMain;
	StoreService service;
	public StoreCon(StoreMain storeMain) {
		this.storeMain = storeMain;
		service = new StoreServiceImpl (storeMain);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
//check
////////////////////////////////////////////////////////////////////////////
		String yyyy = storeMain.settleAccount.yy.getSelectedItem() + "";
		String mm = storeMain.settleAccount.mm.getSelectedItem() + "";
		String dd = storeMain.settleAccount.dd.getSelectedItem() + "";
		Main.log(yyyy);
		Main.log(mm);
		Main.log(dd);
/////////////////////////////////////////////////////////////////////////////////
		if (ob == storeMain.settleBtn){
			service.viewSettleAccount ();
		}
		else if (ob == storeMain.settleAccount.searchBtn){
			service.showSearchResult(yyyy, mm, dd);
		}
	}
	
	

}
