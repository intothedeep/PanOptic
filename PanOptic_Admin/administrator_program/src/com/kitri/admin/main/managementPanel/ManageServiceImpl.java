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
	// update Jtable�� �ϳ��� ����� �Ű������� �ٸ� ���� ���� ���� �ٸ� ���̺��� ä��� �Լ��� ���� ���� ������?
	// �������̽��� �߻�Ŭ���� �Ǵ� ���� Ŭ������ ���� �� �� �ֳ�?

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
			JOptionPane.showMessageDialog(manageMain.regEmp, "��� ������ ID �Դϴ�.");
		} else {
			manageMain.regEmp.idTf.setText("");
			JOptionPane.showMessageDialog(manageMain.regEmp, "�ߺ��� ID, �ٸ� ID�� �Է� �ϼ���.");
		}
	}

	@Override
	public void registerEmp() {
		int count = 0;
		count = dao.findId(manageMain.regEmp.idTf.getText().trim());
		if (count != 0) {
			JOptionPane.showMessageDialog(manageMain.regEmp, "ID�� �̹� �����մϴ�.");
			manageMain.regEmp.idTf.setText("");
			return;
		}
		if (checkPwEqual()) {
			return;
		} else {
			count = dao.registerEmp();
			if (count != 0) {
				JOptionPane.showMessageDialog(manageMain.regEmp, count + "�� ��� �Ǿ����ϴ�.");
				clearRegEmpFields();
				closeRegEmp();
			} else
				JOptionPane.showMessageDialog(manageMain.regEmp, "��� ���� �߽��ϴ�.");
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
			JOptionPane.showMessageDialog(manageMain.wageInfo, "���� �Է��ϼ���");
		} else {
			if (rows == null) {
				JOptionPane.showMessageDialog(manageMain.wageInfo, "�������� �ʽ��ϴ�.");
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
//		false => ��й�ȣ�� ��ġ�� ��
		boolean flag = true;
		String pw = manageMain.regEmp.pwTf.getText().trim();
		String pwCheck = manageMain.regEmp.pwCheckTf.getText().trim();

		if (!pw.equals(pwCheck)) {
			JOptionPane.showMessageDialog(manageMain.regEmp, "��й�ȣ�� �������� �ʽ��ϴ�.");
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
			JOptionPane.showMessageDialog(manageMain.regEmp, "�Է��� �ʿ��մϴ�.");
			return flag;
		} else {
			flag = false;
			return flag;
		}
	}
}
