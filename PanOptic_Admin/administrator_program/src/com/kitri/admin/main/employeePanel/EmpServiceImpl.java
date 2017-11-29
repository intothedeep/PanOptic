package com.kitri.admin.main.employeePanel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.kitri.admin.main.customerPanel.CusConstant;
import com.kitri.admin.main.customerPanel.CusDto;
import com.kitri.admin.main.leftoverPanel.LeftDto;

public class EmpServiceImpl implements EmpService {
    EmpMain empMain;
    EmpDao dao;

    Vector<String> rowData;

    public EmpServiceImpl(EmpMain empMain) {
	super();
	this.empMain = empMain;
	dao = new EmpDaoImpl(empMain);
    }

    @Override
    public void viewEmpList() {
	updateEmpJTable();
	empMain.empList.setVisible(true);
    }

    @Override
    public void updateEmpJTable() {

	insertColumnNames();

	ArrayList<EmpDto> dtos = dao.selectAll();
	Vector<Vector> rows = new Vector<>();
	int size = dtos.size();
	Vector temp;
	EmpDto tempDto;
	for (int i = 0; i < size; i++) {
	    tempDto = dtos.get(i);
	    temp = new Vector<>();
	    temp.add(tempDto.getEmpNum());
	    temp.add(tempDto.getEmpName());
	    temp.add(tempDto.getEmpHp());
	    // temp.add(tempDto.getEmpDate());
	    temp.add(tempDto.getEmpId());
	    // temp.add(tempDto.getEmpPw());
	    temp.add(tempDto.getEmpEmail());
	    // temp.add(tempDto.getEmpBirth());
	    // temp.add(tempDto.getHourPayRate());
	    // temp.add(tempDto.getEmpPosition());
	    // temp.add(tempDto.getEmpIsMale());

	    rows.addElement(temp);
	}
	empMain.empList.rows = rows;
	DefaultTableModel model = new DefaultTableModel(empMain.empList.rows, empMain.empList.column) {
	    @Override
	    public boolean isCellEditable(int row, int column) {
		return false;
	    }
	};
	// conMain.blockedsite.jTable = new JTable(model);
	empMain.empList.jTable.removeAll();
	// conMain.blockedsite.jTable.remove
	empMain.empList.jTable.setModel(model);
	model.fireTableDataChanged();
    }

    private void insertColumnNames() {
	int len = EmpConstant.COLUMN.length;
	Vector<String> column = new Vector<>();
	for (int i = 0; i < len; i++) {
	    column.add(EmpConstant.COLUMN[i]);
	}
	empMain.empList.column = column;
    }

    @Override
    public void showDetail() {
	// 지금 클릭한 테이블의 행의 이름을 가져와서 그 이름을 가져와서 그 이름을 가진 유저의 객체를 불러와서
	// 그 정보를 상세창에 뿌려주는 로직을 짜라
	if (empMain.empList.jTable.getSelectedRow() > -1) {
	    empMain.empDetail.setVisible(true);
	} else
	    return;
	rowData = new Vector<>();
	int row = empMain.empList.jTable.getSelectedRow();
	int col = empMain.empList.jTable.getSelectedColumn();
	Object selItem = empMain.empList.jTable.getValueAt(row, 1);
	String temp = (String) selItem;
	// check!!
	// System.out.println(temp);
	rowData = dao.findUser(temp);
	if (!rowData.isEmpty()) {

	    empMain.empDetail.nameTf.setText(rowData.get(1));
	    empMain.empDetail.hpTf.setText(rowData.get(2));
	    empMain.empDetail.idTf.setText(rowData.get(4));


	    empMain.empDetail.positionCb.setSelectedItem(rowData.get(9) + "");
	    empMain.empDetail.wageTf.setText(rowData.get(8) + "");
	    empMain.empDetail.yy.setSelectedItem(rowData.get(11) + "");
	    empMain.empDetail.mm.setSelectedItem(rowData.get(12) + "");
	    empMain.empDetail.dd.setSelectedItem(rowData.get(13) + "");
	} else
	    JOptionPane.showMessageDialog(empMain.empDetail, "일치하는 직원이 없습니다.");
    }

    @Override
    public void closeDetail() {
	clearTextFields();
	empMain.empDetail.setVisible(false);
    }

    private void clearTextFields() {
	empMain.empDetail.hpTf.setText("");
	empMain.empDetail.nameTf.setText("");
	empMain.empDetail.idTf.setText("");
	empMain.empDetail.wageTf.setText("");

	empMain.empDetail.yy.setSelectedIndex(0);
	empMain.empDetail.mm.setSelectedIndex(0);
	empMain.empDetail.dd.setSelectedIndex(0);
    }

    @Override
    public void updateEmpInfo(String name) {
	int count = 0;
	count = dao.updateEmpInfo(name);
	if (count != 0)
	    JOptionPane.showMessageDialog(empMain.empDetail, (count + "이 수정 돘습니다."));
	else {
	    JOptionPane.showMessageDialog(empMain.empDetail, "잘못 된 정보 입니다.");
	    return;
	}
	updateEmpJTable();
    }

    @Override
    public void searchEmp(String name) {
	ArrayList<EmpDto> dtos = new ArrayList<>();
	dtos = dao.searchEmp(name);
	if (name.trim().isEmpty()) {
	    updateEmpJTable();
	    JOptionPane.showMessageDialog(empMain.empList, "값을 입력하세요");
	} else {
	    if (dtos == null) {
		JOptionPane.showMessageDialog(empMain.empList, "존재하지 않습니다.");
	    } else {
		showSearchResult(dtos);
	    }
	}
	empMain.empList.searchTf.setText("");
    }

    private void showSearchResult(ArrayList<EmpDto> dtos) {

	insertColumnNames();
	Vector<Vector> rows = new Vector<>();
	int size = dtos.size();
	Vector temp;
	EmpDto tempDto;
	for (int i = 0; i < size; i++) {
	    tempDto = dtos.get(i);
	    temp = new Vector<>();
	    temp.add(tempDto.getEmpNum());
	    temp.add(tempDto.getEmpName());
	    temp.add(tempDto.getEmpHp());
	    // temp.add(tempDto.getEmpDate());
	    temp.add(tempDto.getEmpId());
	    // temp.add(tempDto.getEmpPw());
	    temp.add(tempDto.getEmpEmail());
	    // temp.add(tempDto.getEmpBirth());
	    // temp.add(tempDto.getHourPayRate());
	    // temp.add(tempDto.getEmpPosition());
	    // temp.add(tempDto.getEmpIsMale());

	    rows.addElement(temp);
	}
	empMain.empList.rows = rows;
	DefaultTableModel model = new DefaultTableModel(empMain.empList.rows, empMain.empList.column) {
	    @Override
	    public boolean isCellEditable(int row, int column) {
		return false;
	    }
	};
	// conMain.blockedsite.jTable = new JTable(model);
	empMain.empList.jTable.removeAll();
	// conMain.blockedsite.jTable.remove
	empMain.empList.jTable.setModel(model);
	model.fireTableDataChanged();
    }
}
