package com.kitri.admin.main.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ControlCon extends MouseAdapter implements ActionListener{
	
	public ControlMain conMain;
	public ControlService service;
	
	public ControlCon(ControlMain conMain) {
		super();
		this.conMain = conMain;
		service = new ControlServiceImpl(conMain);
	}

	// 필요한 listener 정리
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == conMain.blockedSitesBtn) {
			service.updateBlockedSiteJTable();
			conMain.blockedsite.setVisible(true);
		}
		else if (ob == conMain.ageRestrictionBtn) {
			conMain.ageRestirction.setVisible(true);
		}
		else if (ob == conMain.blockedsite.regBtn) {
			service.viewRegisterBS ();
		} 
		else if (ob == conMain.blockedsite.delBtn) {
			service.viewDeleteBS();
		}
		else if (ob == conMain.regBlockedsite.ok || ob == conMain.regBlockedsite.siteNameTF || ob == conMain.regBlockedsite.urlTF) {
			service.registerBlockedSite (
					conMain.regBlockedsite.siteNameTF.getText(), 
					conMain.regBlockedsite.urlTF.getText());
		}
		else if (ob == conMain.delBlockedsite.ok || ob == conMain.delBlockedsite.siteNameTF) {
			service.deleteBlockedSite(conMain.delBlockedsite.siteNameTF.getText());
		}
		else if (ob == conMain.blockedsite.edit) {
//			conSer.updateBlockedSiteData((int)conMain.blockedsite.jTable.getValueAt(conMain.blockedsite.jTable.getSelectedRow(), 1));
		}
	}

	@Override
	public void mouseEntered (MouseEvent e) {
		super.mouseClicked(e);
//		conSer.updateBlockedSiteData((int)conMain.blockedsite.jTable.getValueAt(conMain.blockedsite.jTable.getSelectedRow(), 1));
	}
}
