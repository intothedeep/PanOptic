package com.kitri.admin.main.employeePanel;

import java.util.ArrayList;
import java.util.Vector;

import com.kitri.admin.database.dao.Dao;
import com.kitri.admin.main.customerPanel.CusDto;
import com.kitri.admin.main.leftoverPanel.LeftDto;
import com.kitri.admin.server.Main;

public class EmpDaoImpl extends Dao implements EmpDao {
	EmpMain empMain;
	Vector<String> rowData;
	ArrayList<EmpDto> list;
	
	Vector<Vector> rows;

	
	public EmpDaoImpl(EmpMain empMain) {
		super();
		this.empMain = empMain;
	}

	@Override
	public ArrayList<EmpDto> selectAll() {
		list = new ArrayList<>();
		EmpDto dto;
		try {
			sql = "SELECT employee_num num, \n";
			sql += "employee_name name, \n";
			sql += "employee_hp hp, \n";
			sql += "employee_hire_date hiredate, \n";
			sql += "employee_id id, \n";
			sql += "employee_pw pw, \n";
			sql += "EMPLOYEE_EMAIL email, \n";
			sql += "employee_birth birth, \n";
			sql += "employee_position position, \n";
			sql += "employee_hour_pay_rate hourPay, \n";
			sql += "EMPLOYEE_ISMALE gender \n";
			sql += "FROM employees \n";
			sql += "order by 1";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// check
			// Main.log("데이터베이스 연결 됨");
			while (rs.next()) {
				dto = new EmpDto();
				dto.setEmpNum(rs.getInt("num"));
				dto.setEmpName(rs.getString("name"));
				dto.setEmpHp(rs.getString("hp"));
				dto.setEmpDate(rs.getString("hireDate"));
				dto.setEmpId(rs.getString("id"));
				dto.setEmpPw(rs.getString("pw"));
				dto.setEmpEmail(rs.getString("email"));
				dto.setEmpBirth(rs.getString("birth"));
				dto.setHourPayRate(rs.getInt("hourPay"));
				dto.setEmpPosition(rs.getString("position"));
				dto.setEmpIsMale(rs.getString("gender"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return list;
	}

	@Override
	public Vector<String> findUser(String name) {
		rowData = new Vector<>();
		try {
			sql = "SELECT employee_num num, \n";
			sql += "employee_name name, \n";
			sql += "employee_hp hp, \n";
			sql += "employee_hire_date hiredate, \n";
			sql += "employee_id id, \n";
			sql += "employee_pw pw, \n";
			sql += "EMPLOYEE_EMAIL email, \n";
			sql += "employee_birth birth, \n";
			sql += "employee_position position, \n";
			sql += "employee_hour_pay_rate hourPay, \n";
			sql += "EMPLOYEE_ISMALE gender, \n";
			sql += "to_char(employee_hire_date, 'yyyy') yy, \n";
			sql += "to_char(employee_hire_date, 'fmmm') mm, \n";
			sql += "to_char(employee_hire_date, 'fmdd') dd \n";
			sql += "FROM employees \n";
			sql += "where employee_name = '" + name + "' \n";
			sql += "order by 1";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			Main.log("findUser sql");
			if (rs.next()) {		
				rowData.add(rs.getInt("num") + "");
				rowData.add(rs.getString("name"));
				rowData.add(rs.getString("hp"));
				rowData.add(rs.getString("hireDate"));
				rowData.add(rs.getString("id"));
				rowData.add(rs.getString("pw"));
				rowData.add(rs.getString("email"));
				rowData.add(rs.getString("birth"));
				rowData.add(rs.getInt("hourPay") + "");
				rowData.add(rs.getString("position"));
				rowData.add(rs.getString("gender"));
				rowData.add(rs.getString("yy"));
				rowData.add(rs.getString("mm"));
				rowData.add(rs.getString("dd"));
				
//				rows.add(rowData);
			}
//			Main.log(dto.getYy());
//			Main.log("findUser dto 들어가는지?");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return rowData;
	}

	@Override
	public int updateEmpInfo (String id) {
		int count = 0;
		String name = empMain.empDetail.nameTf.getText().trim();
		String hp = empMain.empDetail.hpTf.getText().trim();
		String inId = empMain.empDetail.idTf.getText().trim();
		String hourRate = empMain.empDetail.wageTf.getText().trim();
		
		String position = empMain.empDetail.positionCb.getSelectedItem() + "";
		
//		Object yyyy = empMain.empDetail.yy.getSelectedItem();
//		Object mm = empMain.empDetail.mm.getSelectedItem();
//		Object dd = empMain.empDetail.dd.getSelectedItem();
//		
//		String hireDate = "" + yyyy + mm + dd;
//		Main.log(hireDate);
//		Main.log(position);
//		Main.log(yyyy);
//		Main.log(mm);
//		Main.log(dd);
		
		try {
			sql  = "update employees set \n";
			sql += "employee_name = '" + name + "', \n";
			sql += "employee_hp = '" + hp + "', \n";
			sql += "employee_id = '" + id + "', \n";
			sql += "employee_position = '" + position + "', \n";
			sql += "EMPLOYEE_HOUR_PAY_RATE = '" + hourRate + "' \n";
			sql += "where employee_id = '" + inId + "' \n";

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
	public ArrayList<EmpDto> searchEmp (String name) {
		list = new ArrayList<>();
		EmpDto dto;
		try {
			sql = "SELECT employee_num num, \n";
			sql += "employee_name name, \n";
			sql += "employee_hp hp, \n";
			sql += "employee_hire_date hiredate, \n";
			sql += "employee_id id, \n";
			sql += "employee_pw pw, \n";
			sql += "EMPLOYEE_EMAIL email, \n";
			sql += "employee_birth birth, \n";
			sql += "employee_position position, \n";
			sql += "employee_hour_pay_rate hourPay, \n";
			sql += "EMPLOYEE_ISMALE gender \n";
			sql += "FROM employees \n";
			sql += "where employee_name = '" + name + "' \n";
			sql += "order by 1";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
// check
			// Main.log("데이터베이스 연결 됨");
			while (rs.next()) {
				dto = new EmpDto();
				dto.setEmpNum(rs.getInt("num"));
				dto.setEmpName(rs.getString("name"));
				dto.setEmpHp(rs.getString("hp"));
				dto.setEmpDate(rs.getString("hireDate"));
				dto.setEmpId(rs.getString("id"));
				dto.setEmpPw(rs.getString("pw"));
				dto.setEmpEmail(rs.getString("email"));
				dto.setEmpBirth(rs.getString("birth"));
				dto.setHourPayRate(rs.getInt("hourPay"));
				dto.setEmpPosition(rs.getString("position"));
				dto.setEmpIsMale(rs.getString("gender"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return list;
	}
}