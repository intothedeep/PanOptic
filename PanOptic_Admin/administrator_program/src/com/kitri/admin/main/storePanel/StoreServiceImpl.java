package com.kitri.admin.main.storePanel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StoreServiceImpl implements StoreService {
	StoreMain storeMain;
	StoreDao dao;

	public StoreServiceImpl(StoreMain storeMain) {
		this.storeMain = storeMain;
		dao = new StoreDaoImpl(storeMain);
	}

	@Override
	public void viewSettleAccount() {
		updateSettleJTable();
		storeMain.settleAccount.setVisible(true);
	}

	@Override
	public void updateSettleJTable() {

		insertColumnNames();

		ArrayList<SettleAccountDto> dtos = dao.selectAll();
		Vector<Vector> rows = new Vector<>();
		int size = dtos.size();
		Vector temp;
		SettleAccountDto tempDto;
		for (int i = 0; i < size; i++) {
			tempDto = dtos.get(i);
			temp = new Vector<>();
			temp.add(tempDto.getSettleAccountNum());
			temp.add(tempDto.getSettleDate());
			temp.add(tempDto.getOrderMoney());
			temp.add(tempDto.getPayMoney());
			temp.add(tempDto.getSettleTotal());
			rows.addElement(temp);
		}
		storeMain.settleAccount.rows = rows;
		updateJTable();
	}

	private void updateJTable() {
		DefaultTableModel model = new DefaultTableModel(storeMain.settleAccount.rows, storeMain.settleAccount.column) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		storeMain.settleAccount.jTable.removeAll();
		storeMain.settleAccount.jTable.setModel(model);
		model.fireTableDataChanged();
	}

	@Override
	public void showSearchResult(String yyyy, String mm, String dd) {
		Vector<Vector> rows =new Vector<>();
		if (!dd.equals("0"))
			rows = dao.search(yyyy, mm, dd);
		else
			rows = dao.search(yyyy, mm);
		if (rows.isEmpty()) {
			JOptionPane.showMessageDialog(storeMain.settleAccount, "일치하는 데이터가 없습니다.");
			return;
		}
		insertColumnNames();
		storeMain.settleAccount.rows = rows;
		updateJTable();
	}

	private void insertColumnNames() {
		int len = StoreConstant.COLUMN.length;
		Vector<String> column = new Vector<>();
		for (int i = 0; i < len; i++) {
			column.add(StoreConstant.COLUMN[i]);
		}
		storeMain.settleAccount.column = column;
	}

	private Vector<Vector> search(String yyyy, String mm, String dd) {
		Vector<Vector> dateSearch;
		dateSearch = dao.search(yyyy, mm, dd);
		return dateSearch;
	}

	private Vector<Vector> search(String yyyy, String mm) {
		Vector<Vector> dateSearch;
		dateSearch = dao.search(yyyy, mm);
		return dateSearch;
	}
}