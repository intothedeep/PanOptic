package com.kitri.admin.main.customerPanel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.kitri.admin.main.employeePanel.EmpDto;
import com.kitri.admin.main.leftoverPanel.LeftConstant;
import com.kitri.admin.main.leftoverPanel.LeftDto;

public class CusServiceImpl implements CusService {
	CusMain cusMain;
	CusDao dao;

	public CusServiceImpl(CusMain cusMain) {
		super();
		this.cusMain = cusMain;
		dao = new CusDaoImpl(cusMain);
	}

	@Override
	public void updateUserJTable() {
		insertColumnNames();

		ArrayList<CusDto> dtos = dao.selectUser();
		Vector<Vector> rows = new Vector<>();
		int size = dtos.size();
		Vector temp;
		CusDto tempDto;
		for (int i = 0; i < size; i++) {
			tempDto = dtos.get(i);
			temp = new Vector<>();
			temp.add(tempDto.getUserNum());
			temp.add(tempDto.getUserName());
			temp.add(tempDto.getUserId());
			// temp.add(tempDto.getUserPw());
			temp.add(tempDto.getUserHp());
			temp.add(tempDto.getUserEmail());
			// temp.add(tempDto.getUserAccuTime());
			// temp.add(tempDto.getUserLeftTime());
			// temp.add(tempDto.getUserJoinDate());
			// temp.add(tempDto.getUserBirth());
			// temp.add(tempDto.getIsMail());
			// temp.add(tempDto.getUserBlacklist());

			rows.addElement(temp);
		}
		cusMain.cusList.rows = rows;
		updateJTable();
	}

	@Override
	public void showBlack() {
		insertColumnNames();

		ArrayList<CusDto> dtos = dao.selectBlack();
		Vector<Vector> rows = new Vector<>();
		int size = dtos.size();
		Vector temp;
		CusDto tempDto;
		for (int i = 0; i < size; i++) {
			tempDto = dtos.get(i);
			temp = new Vector<>();
			temp.add(tempDto.getUserNum());
			temp.add(tempDto.getUserName());
			temp.add(tempDto.getUserId());
			// temp.add(tempDto.getUserPw());
			temp.add(tempDto.getUserHp());
			temp.add(tempDto.getUserEmail());
			// temp.add(tempDto.getUserAccuTime());
			// temp.add(tempDto.getUserLeftTime());
			// temp.add(tempDto.getUserJoinDate());
			// temp.add(tempDto.getUserBirth());
			// temp.add(tempDto.getIsMail());
			// temp.add(tempDto.getUserBlacklist());

			rows.addElement(temp);
		}
		cusMain.cusList.rows = rows;
		updateJTable();
	}


	@Override
	public void viewCusList() {
		cusMain.cusList.setVisible(true);
	}

	@Override
	public void searchCustomer(String name) {
		ArrayList<CusDto> dtos = new ArrayList<>();
		dtos = dao.searchCustomer(name);
		if (name.trim().isEmpty()) {
			updateUserJTable();
			JOptionPane.showMessageDialog(cusMain.cusList, "값을 입력하세요");
		} else {
			if (dtos == null) {
				JOptionPane.showMessageDialog(cusMain.cusList, "존재하지 않습니다.");
			} else {
				showSearchResult(dtos);
			}
		}
		cusMain.cusList.searchTf.setText("");
	}

	private void showSearchResult(ArrayList<CusDto> dtos) {

		insertColumnNames();
		Vector<Vector> rows = new Vector<>();
		int size = dtos.size();
		Vector temp;
		CusDto tempDto;
		for (int i = 0; i < size; i++) {
			tempDto = dtos.get(i);
			temp = new Vector<>();
			temp.add(tempDto.getUserNum());
			temp.add(tempDto.getUserName());
			temp.add(tempDto.getUserId());
			// temp.add(tempDto.getUserPw());
			temp.add(tempDto.getUserHp());
			temp.add(tempDto.getUserEmail());
			// temp.add(tempDto.getUserAccuTime());
			// temp.add(tempDto.getUserLeftTime());
			// temp.add(tempDto.getUserJoinDate());
			// temp.add(tempDto.getUserBirth());
			// temp.add(tempDto.getIsMail());
			// temp.add(tempDto.getUserBlacklist());
			rows.addElement(temp);
		}
		cusMain.cusList.rows = rows;
		updateJTable();
	}
	
	private void insertColumnNames() {
		int len = CusConstant.COLUMN.length;
		Vector<String> column = new Vector<>();
		for (int i = 0; i < len; i++) {
			column.add(CusConstant.COLUMN[i]);
		}
		cusMain.cusList.column = column;
	}

	private void updateJTable() {
		DefaultTableModel model = new DefaultTableModel(cusMain.cusList.rows, cusMain.cusList.column) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// conMain.blockedsite.jTable = new JTable(model);
		cusMain.cusList.jTable.removeAll();
		// conMain.blockedsite.jTable.remove
		cusMain.cusList.jTable.setModel(model);
		model.fireTableDataChanged();
	}


}
