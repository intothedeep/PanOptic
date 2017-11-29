package com.kitri.admin.main.controlPanel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import com.kitri.admin.database.dao.Dao;
import com.kitri.admin.server.Main;

public class ControlDaoImpl extends Dao implements ControlDao {
	public ControlMain conMain;
	ArrayList<BlockedsiteDto> list;

	public ControlDaoImpl() {
		super();
	}

	public ControlDaoImpl(ControlMain conMain) {
		super();
		this.conMain = conMain;
	}

	public ArrayList<BlockedsiteDto> selectAll() {
		list = new ArrayList<>();
		BlockedsiteDto dto;
		try {
			sql = "SELECT blockedsite_num num, blockedsite_url url, blockedsite_name name \n";
			sql += "FROM blockedsite \n";
			sql += "order by 1";
			Main.log(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
// check
			// Main.log("데이터베이스 연결 됨");
			while (rs.next()) {
				dto = new BlockedsiteDto();
				dto.setBlockedsiteNum(rs.getInt("num"));
				dto.setBlockedsiteUrl(rs.getString("url"));
				dto.setBlockedsiteName(rs.getString("name"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return list;
	}

	public int registerBlockedSite(String url, String name) {
		int count = 0;
		try {
			con = getConnection();
			String sql = "insert into blockedsite (blockedsite_num, blockedsite_url, blockedsite_name) \n";
			sql += "values(blockedsite_seq.nextval, '" + url + "' , '" + name + "')";
			Main.log(sql);
			stmt = con.createStatement();
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return count;
	}

	@Override
	public int deleteBlockedSite(String name) {
		int count = 0;
		try {
			sql = "delete from blockedsite \n";
			sql += "where blockedsite_name = '" + name + "'";
			Main.log(sql);
			con = getConnection();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			count = stmt.executeUpdate(sql);
			// check
			Main.log(sql);
			Main.log("deleteBS count = " + count);
			con.commit(); // 문장 수행이 끝났으면 commit 시킨다.
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			} // error가 발생하면 rollback 시킨다.
		} finally {
			try {
				con.setAutoCommit(true);
			} catch (Exception e) {
				e.printStackTrace();
			} // 다른 프로그램을 위해 auto commit을 true로 세팅
			resetStmt();
		}
		return count;
	}

	@Override
	public int updateBlockedSite(int num) {
		int count = 0;
		try {
			sql = "update blockedsites \n";
			sql += "set \n";
			sql += "blockedsite_num = " + num + ", \n";
//			sql += "blockedsite_url = '" + dto.getBlockedsite_url() + "', \n";
//			sql += "blockedsite_name = '" + dto.getBlockedsite_name() + "'";
			Main.log(sql);
			con = getConnection();
//			con.setAutoCommit(false);
			stmt = con.createStatement();
			count = stmt.executeUpdate(sql);
			Main.log(sql);

			// if (row > 0)
			// result = true;
			// con.commit(); // 문장 수행이 끝났으면 commit 시킨다.
		} catch (Exception e) {
			e.printStackTrace();
			// try {
			// con.rollback();
			// } catch (Exception e1) {
			// e1.printStackTrace();
			// } // error가 발생하면 rollback 시킨다.
		} finally {
			// try {
			// con.setAutoCommit(true);
			// } catch (Exception e) {
			// e.printStackTrace();
			// } // 다른 프로그램을 위해 auto commit을 true로 세팅
			resetStmt();
		}
		return count;
	}
}