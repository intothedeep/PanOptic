package com.kitri.admin.database.dao;

import java.util.ArrayList;

import com.kitri.admin.database.dto.FoodTypeDto;
import com.kitri.admin.database.dto.UserInfoDto;

public class FoodTypeDao extends Dao {

    public ArrayList<FoodTypeDto> selectAll() {
	ArrayList<FoodTypeDto> dtos = new ArrayList<>();

	try {
	    con = getConnection();
	    stmt = con.createStatement();
	    rs = stmt.executeQuery("select * from food_type");

	    // preStmt = con.prepareStatement("select * from user_info where
	    // user_num = ?");
	    // preStmt.setString(1, "0");

	    FoodTypeDto dto;
	    while (rs.next()) {
		dto = new FoodTypeDto();
		dto.setFoodTypeNum(rs.getInt(1));
		dto.setFoodTypeName(rs.getString(2));
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
