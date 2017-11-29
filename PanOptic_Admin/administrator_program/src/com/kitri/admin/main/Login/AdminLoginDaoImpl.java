package com.kitri.admin.main.Login;

import com.kitri.admin.database.dao.Dao;
import com.kitri.admin.server.Main;

public class AdminLoginDaoImpl extends Dao implements AdminLoginDao {
	AdminLogin login;

	public AdminLoginDaoImpl(AdminLogin login) {
		super();
		this.login = login;
	}

	@Override
	public boolean matchId(String id) {
//		false => 아이디가 존재 할 때 
		boolean flag = true;
		try {
			Main.log("여긴 오나?");
			sql = "select employee_id id from employees \n";
			sql += "where employee_id = '" + id + "'";
			Main.log(sql);

			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				flag = false;
				Main.log("rs가 존재할 때");
			} else
				flag = true;
//			Main.log(flag);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return flag;
	}

	@Override
	public boolean matchIdPw(String id, String pw) {
//		false => id가 존재하고 pw가 일치 할 때
		boolean flag = true;
		String tempId = "";
		String tempPw = null;
		try {
			sql = "select employee_pw pw from employees \n";
			sql += "where employee_id = '" + id + "'";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) 
				tempPw = rs.getString("pw");
			if (tempPw != null) {
				if (tempPw.equals(pw)) {
					flag = false;
				} 
				else {
					flag = true;
				}
			}
//			Main.log(flag);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return flag;
	}

}
