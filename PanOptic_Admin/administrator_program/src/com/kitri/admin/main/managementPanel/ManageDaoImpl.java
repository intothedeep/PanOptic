package com.kitri.admin.main.managementPanel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import com.kitri.admin.database.dao.Dao;
import com.kitri.admin.main.controlPanel.BlockedsiteDto;
import com.kitri.admin.server.Main;

public class ManageDaoImpl extends Dao implements ManageDao {
	private ManageMain manageMain;
	Vector<Vector> rows;
	Vector<String> rowData;
	public ManageDaoImpl() {
	}

	public ManageDaoImpl(ManageMain manageMain) {
		this.manageMain = manageMain;
	}

	@Override
	public Vector<Vector> selectAll() {
		rows = new Vector<>();
		try {
			sql = "SELECT e.employee_name name, e.employee_num num, work_hour_total hourTotal, work_wage_total wageTotal \n";
			sql += "FROM wage_info w, employees e \n";
			sql += "where w.employee_num = e.employee_num \n";
			sql += "order by 1";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// check
			// Main.log("데이터베이스 연결 됨");
			while (rs.next()) {
				rowData = new Vector<String>();
				rowData.addElement(rs.getString("name"));
				rowData.add(rs.getInt("num") + "");
				rowData.add(rs.getInt("hourTotal") + "");
				rowData.add(rs.getInt("wageTotal") + "");
				rows.add(rowData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return rows;
	}

	@Override
	public int findId(String id) {
		int count = 0;
		String tempId = "";
		try {
			sql = "SELECT employee_id id \n";
			sql += "FROM employees \n";
			sql += "where employee_id = '" + id + "' \n";
			sql += "order by 1";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// check
			// Main.log("데이터베이스 연결 됨");
			if (rs.next()) {
				tempId = rs.getString("id");
				count = 1;
			} else
				count = 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return count;
	}

	@Override
	public int registerEmp() {
		int count = 0;
		String inId = manageMain.regEmp.idTf.getText().trim();
		String name = manageMain.regEmp.nameTf.getText().trim();
		String pw = manageMain.regEmp.pwTf.getText().trim();
		String email = manageMain.regEmp.eMailTf.getText().trim();
		String hourPay = manageMain.regEmp.hourPayTf.getText().trim();
		String hp = manageMain.regEmp.hpTf.getText().trim();

		String gender;
		if (manageMain.regEmp.manCheck.getState())
			gender = "1";
		else
			gender = "2";

		String position = (String) manageMain.regEmp.position.getSelectedItem();
		String birth = "to_date('" + manageMain.regEmp.yy.getSelectedItem() + "/" + manageMain.regEmp.mm.getSelectedItem()
				+ "/" + manageMain.regEmp.dd.getSelectedItem() + "')";
		String hireDate = "to_date('" + manageMain.regEmp.hireYear.getSelectedItem() + "/" +  manageMain.regEmp.hireMonth.getSelectedItem()
				+ "/" +  manageMain.regEmp.hireDay.getSelectedItem() + "')";

		try {
			sql = "insert into employees values(employees_seq.nextval, \n";
			sql += "'" + name + "', \n";
			sql += "'" + hp + "', \n";
			sql += "" + birth + ", \n";
			sql += "'" + inId + "', \n";
			sql += "'" + pw + "', \n";
			sql += "'" + email + "', \n";
			sql += "" + hireDate + ", \n";
			sql += "'" + position + "', \n";
			sql += "'" + hourPay + "', \n";
			sql += "'" + gender + "') \n";
			
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			count = stmt.executeUpdate(sql);
			Main.log("===== update sql =====");
			if (count != 0)
				count = 1;
			Main.log("update 되는지? " + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return count;
	}

	@Override
	public Vector<Vector> search(String name) {
		rows = new Vector<>();
		try {
			sql = "SELECT e.employee_name name, e.employee_num num, work_hour_total hourTotal, work_wage_total wageTotal \n";
			sql += "FROM wage_info w, employees e \n";
			sql += "where w.employee_num = e.employee_num \n";
			sql += "and e.employee_name = '" + name + "'";
			sql += "order by 1";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// check
			// Main.log("데이터베이스 연결 됨");
			while (rs.next()) {
				rowData = new Vector<String>();
				rowData.addElement(rs.getString("name"));
				rowData.add(rs.getInt("num") + "");
				rowData.add(rs.getInt("hourTotal") + "");
				rowData.add(rs.getInt("wageTotal") + "");
				rows.add(rowData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return rows;
	}

}