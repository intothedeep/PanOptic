package com.kitri.admin.main.storePanel;

import java.util.ArrayList;
import java.util.Vector;

public interface StoreDao {
	Vector<Vector> search(String yyyy, String mm, String dd);
	Vector<Vector> search(String yyyy, String mm);

	ArrayList<SettleAccountDto> selectAll();

}
