package com.kitri.admin.main.leftoverPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTable;

public class LeftCon  implements ActionListener {
	public LeftMain leftMain;
	public LeftService service;
	
	public LeftCon() {
		super();
	}

	public LeftCon (LeftMain leftMain) {
		super();
		this.leftMain = leftMain;
		service = new LeftServiceImpl(leftMain);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == leftMain.leftOverBtn) {
			service.updateLeftListJTable();
			leftMain.leftList.setVisible(true);
		}
		else if (ob == leftMain.leftList.searchBtn || ob == leftMain.leftList.searchTf){
			service.search(leftMain.leftList.searchTf.getText());
		}
	}
}
