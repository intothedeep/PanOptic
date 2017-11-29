package com.kitri.admin.database.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kitri.admin.database.dto.UserInfoDto;
import com.kitri.admin.database.dto.UserPointInfoDto;
import com.kitri.admin.server.Main;

public class UserPointInfoDao extends Dao {

    public ArrayList<UserPointInfoDto> selectAll() {
	ArrayList<UserPointInfoDto> dtos = new ArrayList<>();

	try {
	    con = getConnection();
	    stmt = con.createStatement();
	    rs = stmt.executeQuery("select * from user_point_info");

	    // preStmt = con.prepareStatement("select * from user_info where
	    // user_num = ?");
	    // preStmt.setString(1, "0");

	    UserPointInfoDto dto;
	    while (rs.next()) {
		dto = new UserPointInfoDto();
		dto.setUserNum(rs.getInt(1));
		dto.setPoint(rs.getInt(2));
		dtos.add(dto);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetStmt();
	}

	return dtos;
    }

    public UserPointInfoDto select(int num) {
	UserPointInfoDto dto = null;
	Main.log("UserPointInfoDao::select(num) : " + num);
	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("select * from user_point_info where user_num = ?");
	    preStmt.setInt(1, num);
	    rs = preStmt.executeQuery();

	    // preStmt = con.prepareStatement("select * from user_info where
	    // user_num = ?");
	    // preStmt.setString(1, "0");

	    while (rs.next()) {
		dto = new UserPointInfoDto();
		dto.setUserNum(rs.getInt(1));
		dto.setPoint(rs.getInt(2));
	    }
//	    Main.log(dto.toString());

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}

	return dto;
    }

    public boolean insert(UserPointInfoDto dto) {
	int result = 0;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("insert into user_point_info values(?,?)");
	    preStmt.setInt(1, dto.getUserNum());
	    preStmt.setInt(2, dto.getPoint());
	    result = preStmt.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}

	return result == 1 ? true : false;
    }

    public boolean update(UserPointInfoDto dto) {
	int result = 0;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("update user_point_info set point = ? where user_num = ?");
	    preStmt.setInt(1, dto.getPoint());
	    preStmt.setInt(2, dto.getUserNum());
	    result = preStmt.executeUpdate();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}

	return result == 1 ? true : false;
    }

}
