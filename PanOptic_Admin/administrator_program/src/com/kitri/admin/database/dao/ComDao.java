package com.kitri.admin.database.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.kitri.admin.database.dto.ComDto;

public class ComDao extends Dao {
    // private Dao dao;

    public ComDao() {

    }

    public ArrayList<ComDto> selectAll() {
	ArrayList<ComDto> dtos = new ArrayList<>();

	try {
	    con = getConnection();
	    stmt = con.createStatement();
	    rs = stmt.executeQuery("select * from com");

	    ComDto dto;
	    while (rs.next()) {
		dto = new ComDto();
		dto.setComNum(rs.getInt("com_num"));
		dto.setUserNum(rs.getInt("user_num"));
		dto.setIsUse(rs.getString("is_use"));
		dto.setIsBooking(rs.getString("is_booking"));

		dtos.add(dto);
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    resetStmt();
	}

	return dtos;
    }

    public boolean update(ComDto dto) {
	int result = 0;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("update com set user_num = ?, is_booking = ?, is_use = ? where com_num = ?");
	    preStmt.setInt(1, dto.getUserNum());
	    preStmt.setString(2, dto.getIsBooking());
	    preStmt.setString(3, dto.getIsUse());
	    preStmt.setInt(4, dto.getComNum());

	    result = preStmt.executeUpdate();

	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return result == 1 ? true : false;
    }

    public void insert(int count){
	
	try {
	    con = getConnection();
	    
	    for(int i = 0; i < count; i++){
		preStmt = con.prepareStatement("insert into com values(?,-1,'0','0')");
		preStmt.setInt(1, i);
		preStmt.executeQuery();
	    }
	    
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public boolean insert(ComDto dto) {
	int result = 0;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("insert into com values(?,?, '0','0')");
	    preStmt.setInt(1, dto.getComNum());
	    preStmt.setInt(2, dto.getUserNum());

	    result = preStmt.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}

	return result == 0 ? false : true;
    }

    public static void main(String[] args) {
	ComDao dao = new ComDao();

	// System.out.println(Arrays.toString(dao.selectAllCom().toArray()));
	//// dao.insertCom(4, 4);
	// System.out.println(Arrays.toString(dao.selectAllCom().toArray()));
    }
}
