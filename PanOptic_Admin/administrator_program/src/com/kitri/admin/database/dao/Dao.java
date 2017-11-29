package com.kitri.admin.database.dao;

import java.sql.*;

public class Dao {
    public final String url = "jdbc:oracle:thin:@localhost:1521:xe";
//    public final String uid = "pc_manager";
//    public final String upw = "pc_manager";
    public final String uid = "test";
    public final String upw = "test";
    public String sql = "";
    protected Connection con;
    protected Statement stmt;
    protected PreparedStatement preStmt;
    protected ResultSet rs;

    public Dao() {
	try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    

    public Connection getConnection() throws SQLException {
	return DriverManager.getConnection(url, uid, upw);
    }

    public void resetStmt() {
	try {
	    if (rs != null) {
		rs.close();
	    }
	    if (stmt != null) {
		stmt.close();
	    }
	    if (con != null) {
		con.close();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void resetPreStmt() {
	try {
	    if (rs != null) {
		rs.close();
	    }
	    if (preStmt != null) {
		preStmt.close();
	    }
	    if (con != null) {
		con.close();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void reset(ResultSet rs, Statement stmt, Connection con) {
	try {
	    if (rs != null) {
		rs.close();
	    }
	    if (stmt != null) {
		stmt.close();
	    }
	    if (con != null) {
		con.close();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void reset(ResultSet rs, PreparedStatement preStmt, Connection con) {
	try {
	    if (rs != null) {
		rs.close();
	    }
	    if (preStmt != null) {
		preStmt.close();
	    }
	    if (con != null) {
		con.close();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
