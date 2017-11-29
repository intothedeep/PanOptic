package com.kitri.admin.main.customerPanel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import com.kitri.admin.database.dao.Dao;
import com.kitri.admin.main.controlPanel.BlockedsiteDto;
import com.kitri.admin.main.employeePanel.EmpDto;
import com.kitri.admin.main.leftoverPanel.LeftDto;
import com.kitri.admin.server.Main;

public class CusDaoImpl extends Dao implements CusDao {

	public CusDto dto;
	public CusMain cusMain;
	Vector<String> rowData;
	ArrayList<CusDto> list;

	public CusDaoImpl() {
	}

	public CusDaoImpl(CusMain cusMain) {
		this.cusMain = cusMain;
	}

	@Override
	public ArrayList<CusDto> selectUser() {
		list = new ArrayList<>();
		CusDto dto;
		try {
			sql = "SELECT USER_NUM num, \n";
			sql += "USER_NAME name, \n";
			sql += "USER_ID id, \n";
			sql += "USER_PW pw, \n";
			sql += "USER_HP hp, \n";
			sql += "USER_EMAIL email, \n";
			sql += "USER_ACCU_TIME accuTime, \n";
			sql += "USER_LEFT_TIME leftTime, \n";
			sql += "USER_JOIN_DATE joinDate, \n";
			sql += "USER_BIRTH birth, \n";
			sql += "IS_MALE isMale \n";
			sql += "FROM user_info \n";
			sql += "order by 1";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// check
			// Main.log("데이터베이스 연결 됨");
			while (rs.next()) {
				dto = new CusDto();
				dto.setUserNum(rs.getInt("num"));
				dto.setUserName(rs.getString("name"));
				dto.setUserId(rs.getString("id"));
				dto.setUserPw(rs.getString("pw"));
				dto.setUserHp(rs.getString("hp"));
				dto.setUserEmail(rs.getString("email"));
				dto.setUserAccuTime(rs.getString("accuTime"));
				dto.setUserLeftTime(rs.getString("leftTime"));
				dto.setUserJoinDate(rs.getString("joinDate"));
				dto.setUserBirth(rs.getString("birth"));
				dto.setIsMail(rs.getString("isMale"));
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
	public ArrayList<CusDto> selectBlack() {
		list = new ArrayList<>();
		CusDto dto;
		try {
			sql = "SELECT u.USER_NUM num, \n";
			sql += "USER_NAME name, \n";
			sql += "USER_ID id, \n";
			sql += "USER_PW pw, \n";
			sql += "USER_HP hp, \n";
			sql += "USER_EMAIL email, \n";
			sql += "USER_ACCU_TIME accuTime, \n";
			sql += "USER_LEFT_TIME leftTime, \n";
			sql += "USER_JOIN_DATE joinDate, \n";
			sql += "USER_BIRTH birth, \n";
			sql += "IS_MALE isMale \n";
			sql += "FROM user_info u, user_blacklist b  \n";
			sql += "where u.user_num = b.user_num  \n";		
			sql += "order by 1";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// check
			// Main.log("데이터베이스 연결 됨");
			while (rs.next()) {
				dto = new CusDto();
					dto.setUserNum(rs.getInt("num"));
					dto.setUserName(rs.getString("name"));
					dto.setUserId(rs.getString("id"));
					dto.setUserPw(rs.getString("pw"));
					dto.setUserHp(rs.getString("hp"));
					dto.setUserEmail(rs.getString("email"));
					dto.setUserAccuTime(rs.getString("accuTime"));
					dto.setUserLeftTime(rs.getString("leftTime"));
					dto.setUserJoinDate(rs.getString("joinDate"));
					dto.setUserBirth(rs.getString("birth"));
					dto.setIsMail(rs.getString("isMale"));
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
	public ArrayList<CusDto> searchCustomer(String name) {
		list = new ArrayList<>();
		CusDto dto;
		try {
			sql = "SELECT USER_NUM num, \n";
			sql += "USER_NAME name, \n";
			sql += "USER_ID id, \n";
			sql += "USER_PW pw, \n";
			sql += "USER_HP hp, \n";
			sql += "USER_EMAIL email, \n";
			sql += "USER_ACCU_TIME accuTime, \n";
			sql += "USER_LEFT_TIME leftTime, \n";
			sql += "USER_JOIN_DATE joinDate, \n";
			sql += "USER_BIRTH birth, \n";
			sql += "IS_MALE isMale \n";
			sql += "FROM user_info \n";
			sql += "where user_name = '" + name + "' \n";
			sql += "order by 1";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// check
			// Main.log("데이터베이스 연결 됨");
			while (rs.next()) {
				dto = new CusDto();
				dto.setUserNum(rs.getInt("num"));
				dto.setUserName(rs.getString("name"));
				dto.setUserId(rs.getString("id"));
				dto.setUserPw(rs.getString("pw"));
				dto.setUserHp(rs.getString("hp"));
				dto.setUserEmail(rs.getString("email"));
				dto.setUserAccuTime(rs.getString("accuTime"));
				dto.setUserLeftTime(rs.getString("leftTime"));
				dto.setUserJoinDate(rs.getString("joinDate"));
				dto.setUserBirth(rs.getString("birth"));
				dto.setIsMail(rs.getString("isMale"));
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