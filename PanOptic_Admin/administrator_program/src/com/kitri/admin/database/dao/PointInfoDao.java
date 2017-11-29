package com.kitri.admin.database.dao;

import java.util.ArrayList;

import com.kitri.admin.database.dto.ComPrepaidInfoDto;
import com.kitri.admin.database.dto.PointInfoDto;
import com.kitri.admin.server.Main;

public class PointInfoDao extends Dao {

    public ArrayList<PointInfoDto> selectAll() {
	ArrayList<PointInfoDto> dtos = new ArrayList<>();

	try {
	    con = getConnection();
	    stmt = con.createStatement();
	    rs = stmt.executeQuery("select * from point_info");

	    PointInfoDto dto;
	    while (rs.next()) {
		dto = new PointInfoDto();
		dto.setNum(rs.getInt(1));
		dto.setValue(rs.getInt(2));
		dto.setPrice(rs.getInt(3));

		dtos.add(dto);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetStmt();
	}

	return dtos;
    }

    public PointInfoDto select(int num) {
	PointInfoDto dto = new PointInfoDto();
	Main.log("select(num)");
	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("select * from point_info where num = ?");
	    preStmt.setInt(1, num);
	    rs = preStmt.executeQuery();
	    
//	    stmt = con.createStatement();
//	    rs = stmt.executeQuery("select * from point_info where ");

	    while (rs.next()) {
		dto = new PointInfoDto();
		dto.setNum(rs.getInt(1));
		dto.setValue(rs.getInt(2));
		dto.setPrice(rs.getInt(3));

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetStmt();
	}
	return dto;

    }

    public boolean insert(int num, float time, int price) {
	int result = 0;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("insert into com_prepaid_info values(?,?,?)");
	    preStmt.setInt(1, num);
	    preStmt.setFloat(2, time);
	    preStmt.setInt(3, price);

	    result = preStmt.executeUpdate();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}

	return result == 0 ? false : true;

    }
    
    public static void main(String[] args) {
	PointInfoDao dao = new PointInfoDao();
	PointInfoDto dto = dao.select(0);
	Main.log(dto.toString());
    }
}
