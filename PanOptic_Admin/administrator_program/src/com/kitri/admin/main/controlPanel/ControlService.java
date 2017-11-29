package com.kitri.admin.main.controlPanel;

public interface ControlService {
	void viewRegisterBS();
	void closeRegisterBS();
	void viewDeleteBS();
	void closeDeleteBS();

	void updateBlockedSiteJTable();
	void registerBlockedSite(String url, String name);
	void deleteBlockedSite(String name);
	void updateBlockedSiteData (int num);
}
