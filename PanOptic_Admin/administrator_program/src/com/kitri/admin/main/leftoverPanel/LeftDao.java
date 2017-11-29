package com.kitri.admin.main.leftoverPanel;

import java.util.ArrayList;

public interface LeftDao {
	ArrayList<LeftDto> selectAll();
	ArrayList<LeftDto> searchFood (String name);
}
