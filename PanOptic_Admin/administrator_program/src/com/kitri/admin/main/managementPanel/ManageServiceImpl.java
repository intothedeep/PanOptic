package com.kitri.admin.main.managementPanel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.kitri.admin.main.customerPanel.CusConstant;
import com.kitri.admin.main.customerPanel.CusDto;
import com.kitri.admin.main.employeePanel.EmpDto;

public class ManageServiceImpl implements ManageService {
	private ManageMain manageMain;
	private ManageDao dao;

	public ManageServiceImpl(ManageMain manageMain) {
		super();
		this.manageMain = manageMain;
		dao = new ManageDaoImpl(manageMain);
	}
	// update Jtable을 하나만 만들고 매개변수로 다른 값을 만들어서 서로 다른 테이블을 채우는 함수를 만들 수는 없을까?
	// 인터페이스나 추상클래스 또는 상위 클래스를 만들어서 쓸 수 있나?

	@Override
	public void viewRegEmp() {
		clearRegEmpFields();
		manageMain.regEmp.setVisible(true);
	}

	@Override
	public void viewWageInfo() {
		manageMain.wageInfo.setVisible(true);
		updateWageJTable();
	}

	@Override
	public void checkId(String id) {
		int count = 0;
		if (isIdTfEmpty(id)) {
			return;
		}
		count = dao.findId(id);
		if (count == 0) {
			JOptionPane.showMessageDialog(manageMain.regEmp, "사용 가능한 ID 입니다.");
		} else {
			manageMain.regEmp.idTf.setText("");
			JOptionPane.showMessageDialog(manageMain.regEmp, "중복된 ID, 다른 ID를 입력 하세요.");
		}
	}

	@Override
	public void registerEmp() {
		int count = 0;
		count = dao.findId(manageMain.regEmp.idTf.getText().trim());
		if (count != 0) {
			JOptionPane.showMessageDialog(manageMain.regEmp, "ID가 이미 존재합니다.");
			manageMain.regEmp.idTf.setText("");
			return;
		}
		if (checkPwEqual()) {
			return;
		} else {
			count = dao.registerEmp();
			if (count != 0) {
				JOptionPane.showMessageDialog(manageMain.regEmp, count + "가 등록 되었습니다.");
				clearRegEmpFields();
				closeRegEmp();
			} else
				JOptionPane.showMessageDialog(manageMain.regEmp, "등록 실패 했습니다.");
		}
	}

	@Override
	public void closeRegEmp() {
		clearRegEmpFields();
		manageMain.regEmp.setVisible(false);
	}

	@Override
	public void updateWageJTable() {
		insertColumnNames();
		manageMain.wageInfo.rows = dao.selectAll();
		updateTable();
	}
	@Override
	public void search (String name) {
		Vector<Vector> rows = dao.search(name);
		if (name.trim().isEmpty()) {
			updateWageJTable();
			JOptionPane.showMessageDialog(manageMain.wageInfo, "값을 입력하세요");
		} else {
			if (rows == null) {
				JOptionPane.showMessageDialog(manageMain.wageInfo, "존재하지 않습니다.");
			} else {
				insertColumnNames();
				manageMain.wageInfo.rows = rows;
				updateTable();
			}
		}
		manageMain.wageInfo.searchTf.setText("");
		manageMain.wageInfo.searchTf.requestFocus();
	}
	private void insertColumnNames() {
		int len = ManageConstant.COLUMN.length;
		Vector<String> column = new Vector<>();
		for (int i = 0; i < len; i++) {
			column.add(ManageConstant.COLUMN[i]);
		}
		manageMain.wageInfo.column = column;
	}

	private void updateTable() {
		DefaultTableModel model = new DefaultTableModel(manageMain.wageInfo.rows, manageMain.wageInfo.column) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// conMain.blockedsite.jTable = new JTable(model);
		manageMain.wageInfo.jTable.removeAll();
		// conMain.blockedsite.jTable.remove
		manageMain.wageInfo.jTable.setModel(model);
		model.fireTableDataChanged();
	}

	private void clearRegEmpFields() {
		manageMain.regEmp.eMailTf.setText("");
		manageMain.regEmp.idTf.setText("");
		manageMain.regEmp.nameTf.setText("");
		manageMain.regEmp.pwCheckTf.setText("");
		manageMain.regEmp.pwTf.setText("");
		manageMain.regEmp.hpTf.setText("");
		manageMain.regEmp.hourPayTf.setText("");
		manageMain.regEmp.manCheck.setState(false);
		manageMain.regEmp.womanCheck.setState(false);

		manageMain.regEmp.yy.setSelectedItem(null);
		manageMain.regEmp.mm.setSelectedItem(null);
		manageMain.regEmp.dd.setSelectedItem(null);
		manageMain.regEmp.position.setSelectedItem(null);
		manageMain.regEmp.hireYear.setSelectedItem(null);
		manageMain.regEmp.hireMonth.setSelectedItem(null);
		manageMain.regEmp.hireDay.setSelectedItem(null);
	}

	private boolean checkPwEqual() {
//		false => 비밀번호가 일치할 때
		boolean flag = true;
		String pw = manageMain.regEmp.pwTf.getText().trim();
		String pwCheck = manageMain.regEmp.pwCheckTf.getText().trim();

		if (!pw.equals(pwCheck)) {
			JOptionPane.showMessageDialog(manageMain.regEmp, "비밀번호가 일지하지 않습니다.");
			manageMain.regEmp.pwCheckTf.setText("");
			manageMain.regEmp.pwTf.setText("");
			return flag;
		}
		flag = false;
		return flag;
	}

	private boolean isIdTfEmpty(String str) {
		boolean flag = true;
		if (str.isEmpty()) {
			JOptionPane.showMessageDialog(manageMain.regEmp, "입력이 필요합니다.");
			return flag;
		} else {
			flag = false;
			return flag;
		}
	}
}
