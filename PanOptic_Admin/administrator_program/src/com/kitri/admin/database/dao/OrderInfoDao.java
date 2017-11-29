package com.kitri.admin.database.dao;

import java.sql.SQLException;

import com.kitri.admin.database.dto.OrderInfoDto;

public class OrderInfoDao extends Dao {

    public boolean insert(OrderInfoDto dto) {
	int result = 0;

	try {
	    con = getConnection();
	    preStmt = con.prepareStatement("insert into order_info values(order_info_seq.nextval,?,?,?,?,SYSDATE,?)");
	    preStmt.setInt(1, dto.getUserNum());
	    preStmt.setInt(2, dto.getFoodNum());
	    preStmt.setInt(3, dto.getOrderMoney());
	    preStmt.setInt(4, dto.getOrderCount());
	    preStmt.setInt(5, dto.getComNum());
	    
	    result = preStmt.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    resetPreStmt();
	}
	return result == 1 ? true : false;
    }

}
