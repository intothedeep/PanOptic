package com.kitri.admin.main.leftoverPanel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kitri.admin.main.controlPanel.BlockedsiteDto;
import com.kitri.admin.main.controlPanel.ControlConstant;

public class LeftServiceImpl implements LeftService {
	LeftMain leftMain;
	LeftDao dao;

	public LeftServiceImpl() {
		super();
	}

	public LeftServiceImpl(LeftMain leftMain) {
		super();
		this.leftMain = leftMain;
		dao = new LeftDaoImpl(leftMain);
	}

	@Override
	public void updateLeftListJTable() {
		insertColumnNames();
		ArrayList<LeftDto> dtos = dao.selectAll();
		Vector<Vector> rows = new Vector<>();
		int size = dtos.size();
		Vector temp;
		LeftDto tempDto;
		for (int i = 0; i < size; i++) {
			tempDto = dtos.get(i);
			temp = new Vector<>();
			temp.add(tempDto.getFoodNum());
			temp.add(tempDto.getFoodName());
			temp.add(tempDto.getFoodTypeNum());
			temp.add(tempDto.getFoodleftNum());
			temp.add(tempDto.getFoodPrice());
			temp.add(tempDto.getFoodOrder());
			rows.addElement(temp);
		}
		leftMain.leftList.rows = rows;
		updateTable();
	}

	@Override
	public void viewLeftList() {
		clearText();
		leftMain.leftList.setVisible(true);
	}

	@Override
	public void closeLeftList() {
		clearText();
		leftMain.leftList.setVisible(false);
	}

	@Override
	public void search(String name) {
		ArrayList<LeftDto> dtos = new ArrayList<>();
		dtos = dao.searchFood(name.trim());
		if (name.trim().isEmpty()) {
			updateLeftListJTable();
			JOptionPane.showMessageDialog(leftMain.leftList, "값을 입력하세요");
		}
		else {
			if (dtos == null) {
				JOptionPane.showMessageDialog(leftMain.leftList, "존재하지 않습니다.");
			} else {
				showSearchResult(dtos);
			}
		}
		clearText();
	}

	private void showSearchResult(ArrayList<LeftDto> dtos) {
		insertColumnNames();
		getRows(dtos);
		updateTable();
	}

	private void insertColumnNames() {
		int len = LeftConstant.COLUMN.length;
		Vector<String> column = new Vector<>();
		for (int i = 0; i < len; i++) {
			column.add(LeftConstant.COLUMN[i]);
		}
		leftMain.leftList.column = column;
	}

	private void getRows(ArrayList<LeftDto> dtos) {
		if (dtos == null)
			dtos = dao.selectAll();
		Vector<Vector> rows = new Vector<>();
		int size = dtos.size();
		Vector temp;
		LeftDto tempDto;
		for (int i = 0; i < size; i++) {
			tempDto = dtos.get(i);
			temp = new Vector<>();
			temp.add(tempDto.getFoodNum());
			temp.add(tempDto.getFoodName());
			temp.add(tempDto.getFoodTypeNum());
			temp.add(tempDto.getFoodleftNum());
			temp.add(tempDto.getFoodPrice());
			temp.add(tempDto.getFoodOrder());
			rows.addElement(temp);
		}
		leftMain.leftList.rows = rows;
	}

	private void updateTable() {
		DefaultTableModel model = new DefaultTableModel(leftMain.leftList.rows, leftMain.leftList.column) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// conMain.blockedsite.jTable = new JTable(model);
		leftMain.leftList.leftJtable.removeAll();
		// conMain.blockedsite.jTable.remove
		leftMain.leftList.leftJtable.setModel(model);
		model.fireTableDataChanged();
	}

	private void clearText() {
		leftMain.leftList.searchTf.setText("");
		leftMain.leftList.searchTf.requestFocus();
	}
}