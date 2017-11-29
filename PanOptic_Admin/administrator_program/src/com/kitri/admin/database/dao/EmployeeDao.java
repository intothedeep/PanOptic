package com.kitri.admin.database.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kitri.admin.database.dto.EmployeeDto;
import com.kitri.admin.join.EmployeeJoin;


public class EmployeeDao extends Dao {
	EmployeeJoin join;

	public EmployeeDao(EmployeeJoin join) {
		this.join = join;
	}

//	public ArrayList <EmployeeJoinDao> selectAll(){

	public boolean insert(String name, String hp, String hireDate, String id, String pw, String eMail, String birth,
			int pay, String position, String isMale) {
		int result = 0;
		try {
			con = getConnection();
			preStmt = con.prepareStatement(
					"insert into user_info(employee_num,employee_name,employee_hp,employee_hire_date,employee_id,employee_pw,employee_email, employee_birth, employee_position, employee_hour_pay_rate, employee_ismale) values(employee_num_seq.nextval,?,?,?,?,?,?,?)");
			preStmt.setString(1, name);
			preStmt.setString(2, hp);
			preStmt.setString(3, hireDate);
			preStmt.setString(4, id);
			preStmt.setString(5, pw);
			preStmt.setString(6, eMail);
			preStmt.setString(7, birth);
			preStmt.setString(8, position);
			preStmt.setInt(9, pay);
			preStmt.setString(10, isMale);
			result = preStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetPreStmt();
		}

		return result == 0 ? false : true;

	}
	
	public boolean insert(EmployeeDto dto) {
		int result = 0;
		try {
			con = getConnection();
			preStmt = con.prepareStatement(
					"insert into user_info(employee_num,employee_name,employee_hp,employee_hire_date,employee_id,employee_pw,employee_email, employee_birth, employee_position, employee_hour_pay_rate, employee_ismale) values(employee_num_seq.nextval,?,?,?,?,?,?,?)");
			preStmt.setString(1, dto.getEmployeeName());
			preStmt.setString(2, dto.getEmployeeHp());
			preStmt.setString(3, dto.getEmployeeHireDate());
			preStmt.setString(4, dto.getEmployeeId());
			preStmt.setString(5, dto.getEmployeePw());
			preStmt.setString(6, dto.getEmployeeEmail());
			preStmt.setString(7, dto.getEmployeeBirth());
			preStmt.setString(8, dto.getEmployeePosition());
			preStmt.setInt(9, dto.getHourPayRate());
			preStmt.setString(10, dto.getEmployeeIsMale());
			result = preStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetPreStmt();
		}

		return result == 0 ? false : true;
		

	}


}

//}
