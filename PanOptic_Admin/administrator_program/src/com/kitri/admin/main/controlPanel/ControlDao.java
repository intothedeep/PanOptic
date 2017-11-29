package com.kitri.admin.main.controlPanel;

import java.util.ArrayList;
import java.util.Vector;

public interface ControlDao {
	ArrayList<BlockedsiteDto> selectAll();
	int registerBlockedSite (String url, String name);
	int deleteBlockedSite (String name);
	int updateBlockedSite (int num);
//	public boolean register(int num, String url, String name) ;
//	public boolean update(ControlDto dto);
//	public boolean delete(String name);
//	public ControlDto getSite (String name);
}
