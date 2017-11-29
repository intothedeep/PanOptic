package com.kitri.admin.database.dao;

import java.sql.*;
import java.util.ArrayList;

import com.kitri.admin.database.dto.UserInfoDto;
import com.kitri.admin.server.Main;

public class UserInfoDao extends Dao {
    // private Dao dao;

    public UserInfoDao() {

    }

    public ArrayList<UserInfoDto> selectAll() {
	ArrayList<UserInfoDto> dtos = new ArrayList<>();

	try {
	    con = getConnection();
	    stmt = con.createStatement();
	    rs = stmt.executeQuery("select * from user_info");

	    // preStmt = con.prepareStatement("select * from user_info where
	    // user_num = ?");
	    // preStmt.setString(1, "0");

	    UserInfoDto dto;
	    while (rs.next()) {
		dto = new UserInfoDto();
		dto.setUserNum(rs.getInt(1));
		dto.setUserName(rs.getString(2));
		dto.setUserId(rs.getString(3));
		dto.setUserPw(rs.getString(4));
		dto.setUserHp(rs.getString(5));
		dto.setUserEmail(rs.getString(6));
		dto.setUserAccuTime(rs.getString(7));
		dto.setUserLeftTime(rs.getString(8));
		dto.setUserJoinDate(rs.getString(9));
		dto.setUserBirth(rs.getString(10));
		dto.setIsMale(rs.getString(11));

		dtos.add(dto);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetStmt();
	}

	return dtos;
    }

    public boolean insert(String name, String id, String pw, String hp, String email, String birth, String isMale) {
	int result = 0;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement(
		    "insert into user_info(user_num, user_name, user_id, user_pw, user_hp, user_email, user_birth, is_male) values(user_num_seq.nextval,?,?,?,?,?,?,?)");
	    preStmt.setString(1, name);
	    preStmt.setString(2, id);
	    preStmt.setString(3, pw);
	    preStmt.setString(4, hp);
	    preStmt.setString(5, email);
	    preStmt.setString(6, birth);
	    preStmt.setString(7, isMale);
	    result = preStmt.executeUpdate();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}

	return result == 0 ? false : true;

    }

    public boolean insert(UserInfoDto dto) {
	int result = 0;
	Main.log("insert(dto)");
	Main.log(dto.joinToString());
	try {
	    con = getConnection();
	    preStmt = con
		    .prepareStatement("insert into user_info values(user_num_seq.nextval,?,?,?,?,?,?,?,SYSDATE,?,?)");
	    preStmt.setString(1, dto.getUserName());
	    preStmt.setString(2, dto.getUserId());
	    preStmt.setString(3, dto.getUserPw());
	    preStmt.setString(4, dto.getUserHp());
	    preStmt.setString(5, dto.getUserEmail());
	    preStmt.setString(6, dto.getUserAccuTime());
	    preStmt.setString(7, dto.getUserLeftTime());
	    preStmt.setString(8, dto.getUserBirth());
	    preStmt.setString(9, dto.getIsMale());
	    result = preStmt.executeUpdate();

	} catch (Exception e) {
	    e.printStackTrace();
	    Main.log(e.toString());
	} finally {
	    resetPreStmt();
	}

	return result == 0 ? false : true;

    }

    public boolean updateLeftTime(int num, String leftTime) {
	int result = 0;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("update user_info set user_left_time = ? where user_num = ?");
	    preStmt.setString(1, leftTime);
	    preStmt.setInt(2, num);
	    result = preStmt.executeUpdate();

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}

	return result == 1 ? true : false;
    }

    public String selectUserAccuTime(int num) {
	String time = null;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("select user_accu_time from user_info where user_num = ?");
	    preStmt.setInt(1, num);
	    rs = preStmt.executeQuery();

	    if (rs.next()) {
		time = rs.getString(1);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return time;
    }

    public boolean updateLogout(UserInfoDto dto) {
	int result = 0;
	
	try {
	    
	    con = getConnection();
	    preStmt = con
		    .prepareStatement("update user_info set user_accu_time = ?, user_left_time = ? where user_num = ?");
	    preStmt.setString(1, dto.getUserAccuTime());
	    preStmt.setString(2, dto.getUserLeftTime());
	    preStmt.setInt(3, dto.getUserNum());
	    
	    result = preStmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return result == 1 ? true : false;
    }

    public UserInfoDto select(int num) {
	UserInfoDto dto = null;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("select * from user_info where user_num = ?");
	    preStmt.setInt(1, num);
	    rs = preStmt.executeQuery();

	    // preStmt = con.prepareStatement("select * from user_info where
	    // user_num = ?");
	    // preStmt.setString(1, "0");

	    while (rs.next()) {
		dto = new UserInfoDto();
		dto = new UserInfoDto();
		dto.setUserNum(rs.getInt(1));
		dto.setUserName(rs.getString(2));
		dto.setUserId(rs.getString(3));
		dto.setUserPw(rs.getString(4));
		dto.setUserHp(rs.getString(5));
		dto.setUserEmail(rs.getString(6));
		dto.setUserAccuTime(rs.getString(7));
		dto.setUserLeftTime(rs.getString(8));
		dto.setUserJoinDate(rs.getString(9));
		dto.setUserBirth(rs.getString(10));
		dto.setIsMale(rs.getString(11));

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetStmt();
	}

	return dto;
    }

    public String checkId(String id) {
	String result = "";

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("select user_num, user_pw, user_left_time from user_info where user_id = ?");
	    preStmt.setString(1, id);
	    rs = preStmt.executeQuery();

	    if (rs.next()) {
		result += rs.getInt(1);
		result += ",";
		result += rs.getString(2);
		result += ",";
		result += rs.getString(3);
	    }

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}

	return result;
    }

    // public static void main(String[] args) {
    // UserInfoDao u = new UserInfoDao();
    //
    // ArrayList<UserInfoDto> dtos = u.selectAllUserInfo();
    //// Main.log(u.insertUserInfo(4, "321312231", "32332", "32w2ew",
    // "32we2432", "qweq5wr@qwqwe"));
    //
    // int size = dtos.size();
    // for (int i = 0; i < size; i++) {
    // Main.log(dtos.get(i).toString());
    // }
    //
    // }

}
