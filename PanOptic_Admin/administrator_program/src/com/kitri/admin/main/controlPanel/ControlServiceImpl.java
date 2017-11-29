package com.kitri.admin.main.controlPanel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlServiceImpl implements ControlService {
	// �ʿ��� �޼ҵ� ����
	ControlMain conMain;
	ControlDao dao;

	public ControlServiceImpl(ControlMain conMain) {
		super();
		this.conMain = conMain;
		dao = new ControlDaoImpl(conMain);
	}

	@Override
	public void updateBlockedSiteJTable() {
		int len = ControlConstant.TITLE.length;
		Vector<String> column = new Vector<>();
		for (int i = 0; i < len; i++) {
			column.add(ControlConstant.TITLE[i]);
		}
		conMain.blockedsite.column = column;

		ArrayList<BlockedsiteDto> dtos = dao.selectAll();
		Vector<Vector> rows = new Vector<>();
		int size = dtos.size();
		Vector temp;
		BlockedsiteDto tempDto;
		for (int i = 0; i < size; i++) {
			tempDto = dtos.get(i);
			temp = new Vector<>();
			temp.add(tempDto.getBlockedsiteNum());
			temp.add(tempDto.getBlockedsiteUrl());
			temp.add(tempDto.getBlockedsiteName());
			rows.addElement(temp);
		}
		conMain.blockedsite.rows = rows;
// check
		// System.out.println(conMain.blockedsite.rows);
		// System.out.println(conMain.blockedsite.column);

		DefaultTableModel model = new DefaultTableModel(conMain.blockedsite.rows, conMain.blockedsite.column) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
// conMain.blockedsite.jTable = new JTable(model);
		conMain.blockedsite.jTable.removeAll();
// conMain.blockedsite.jTable.remove
		conMain.blockedsite.jTable.setModel(model);
		model.fireTableDataChanged();
	}

	@Override
	public void viewRegisterBS() {
		conMain.regBlockedsite.siteNameTF.requestFocus();
		conMain.regBlockedsite.setVisible(true);
	}

	@Override
	public void closeRegisterBS() {
		conMain.regBlockedsite.siteNameTF.setText("");
		conMain.regBlockedsite.urlTF.setText("");
		conMain.regBlockedsite.setVisible(false);
	}

	@Override
	public void registerBlockedSite(String url, String name) {
		if (url.isEmpty() || name.isEmpty()) {
			JOptionPane.showMessageDialog(conMain.regBlockedsite, "���� �Է��ϼ���");
			conMain.regBlockedsite.siteNameTF.requestFocus();
			return;
		} else {
			int count = 0;
			count = dao.registerBlockedSite(url, name);
			if (count == 0) {
				JOptionPane.showMessageDialog(conMain.regBlockedsite, "��Ͽ� ���� �߽��ϴ�.");
				conMain.regBlockedsite.siteNameTF.setText("");
				conMain.regBlockedsite.siteNameTF.requestFocus();
				return;
			} else {
				JOptionPane.showMessageDialog(conMain.regBlockedsite, "��Ͽ� ���� �߽��ϴ�.");
				updateBlockedSiteJTable();
				closeRegisterBS();
			}
		}
	}

	@Override
	public void viewDeleteBS() {
		conMain.delBlockedsite.siteNameTF.requestFocus();
		conMain.delBlockedsite.setVisible(true);

	}

	@Override
	public void closeDeleteBS() {
		conMain.delBlockedsite.siteNameTF.setText("");
		conMain.delBlockedsite.setVisible(false);
	}

	@Override
	public void deleteBlockedSite(String name) {
		int count = 0;
		count = dao.deleteBlockedSite(name);
		if (count == 0) {
			JOptionPane.showMessageDialog(conMain.delBlockedsite, "������ ���� �߽��ϴ�.");
			conMain.delBlockedsite.siteNameTF.setText("");
			conMain.delBlockedsite.siteNameTF.requestFocus();
			return;
		} else {
			JOptionPane.showMessageDialog(conMain.delBlockedsite, "������ ���� �߽��ϴ�.");
			updateBlockedSiteJTable();
			closeDeleteBS();
		}
	}

	@Override
	public void updateBlockedSiteData(int num) {
		// int count = 0;
		// System.out.println(num);
		//// count = dao.updateBlockedSite (num);
		// if (count == 0) {
		// JOptionPane.showMessageDialog(conMain.blockedsite, "���� ���� �߽��ϴ�.");
		// return;
		// }
		// else {
		// JOptionPane.showMessageDialog(conMain.blockedsite, "���� ���� �߽��ϴ�.");
		// updateBlockedSiteJTable();
		// }
	}
}