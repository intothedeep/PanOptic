package com.kitri.admin.database.dao;

import java.util.ArrayList;

import com.kitri.admin.database.dto.FoodDto;
import com.kitri.admin.database.dto.UserInfoDto;
import com.kitri.admin.server.Main;

public class FoodDao extends Dao {

    public ArrayList<FoodDto> selectAll() {
	ArrayList<FoodDto> dtos = new ArrayList<>();
	Main.log("FoodDao::selectAll()");
	
	try {
	    con = getConnection();
	    stmt = con.createStatement();
	    rs = stmt.executeQuery("select * from food");

	    // preStmt = con.prepareStatement("select * from user_info where
	    // user_num = ?");
	    // preStmt.setString(1, "0");

	    FoodDto dto;
	    while (rs.next()) {
		dto = new FoodDto();
		dto.setFoodNum(rs.getInt(1));
		dto.setFoodName(rs.getString(2));
		dto.setFoodTypeNum(rs.getInt(3));
		dto.setFoodLeftNum(rs.getInt(4));
		dto.setFoodPrice(rs.getInt(5));
		dto.setFoodOrder(rs.getString(6));
		dtos.add(dto);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    resetStmt();
	}
	
	return dtos;
    }
}
