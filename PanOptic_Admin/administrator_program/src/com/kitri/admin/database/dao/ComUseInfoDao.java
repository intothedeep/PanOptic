package com.kitri.admin.database.dao;

import java.sql.SQLException;
import java.util.prefs.PreferenceChangeEvent;

import com.kitri.admin.database.dto.ComUseInfoDto;

public class ComUseInfoDao extends Dao {

    public boolean insert(ComUseInfoDto dto) {
	int result = 0;

	try {
	    con = getConnection();
	    preStmt = con
		    .prepareStatement("insert into com_use_info values(com_use_info_seq.nextval,?,?,SYSDATE,null,null)");
	    preStmt.setInt(1, dto.getUserNum());
	    preStmt.setInt(2, dto.getComNum());

	    result = preStmt.executeUpdate();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return result == 1 ? true : false;
    }

    public int selectNum(int comNum, int userNum) {
	int result = -1;
	
	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("select com_use_num from com_use_info where com_num = ? and user_num = ? order by com_start_time desc");
	    preStmt.setInt(1, comNum);
	    preStmt.setInt(2, userNum);
	    rs = preStmt.executeQuery();
	    
	    if(rs.next()){
		result = rs.getInt(1);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	
	return result;
    }

    public boolean update(int comUseNum){
	int result = 0;
//	, com_use_time = SYSDATE - (select com_start_time from com_use_info where com_use_num = ?) 
	try {
	    con = getConnection();
	    StringBuilder sql = new StringBuilder("");
	    preStmt = con.prepareStatement("update com_use_info set com_finish_time = SYSDATE where com_use_num = ?");
	    preStmt.setInt(1, comUseNum);
//	    preStmt.setInt(2, comUseNum);
	    
	    result = preStmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
	return result == 1 ? true : false;
    }
}
