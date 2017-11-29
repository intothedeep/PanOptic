package com.kitri.admin.main.storePanel;

import java.util.ArrayList;
import java.util.Vector;

import com.kitri.admin.database.dao.Dao;

public class StoreDaoImpl extends Dao implements StoreDao {
	StoreMain storeMain;
	ArrayList<SettleAccountDto> list;

	public StoreDaoImpl(StoreMain storeMain) {
		this.storeMain = storeMain;
	}

	@Override
	public ArrayList<SettleAccountDto> selectAll() {
		list = new ArrayList<>();
		SettleAccountDto dto;
		try {
			sql = "SELECT settle_account_num num, \n";
			sql += "settle_date dateT, \n";
			sql += "order_money orderMoney, \n";
			sql += "pay_money payMoney, \n";
			sql += "settle_total total \n";
			sql += "from Settle_Account_Info \n";
			sql += "order by 1";
			System.out.println(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// check
			// System.out.println("데이터베이스 연결 됨");
			while (rs.next()) {
				dto = new SettleAccountDto();
				dto.setSettleAccountNum(rs.getInt("num"));
				dto.setSettleDate(rs.getString("dateT"));
				dto.setOrderMoney(rs.getInt("orderMoney"));
				dto.setPayMoney(rs.getInt("payMoney"));
				dto.setSettleTotal(rs.getInt("total"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return list;
	}

	@Override
	public Vector<Vector> search(String yyyy, String mm, String dd) {
		Vector<String> rowData;
		Vector<Vector> dateSearch = new Vector<>();
		try {
			sql = "SELECT settle_account_num num, \n";
			sql += "settle_date dateT, \n";
			sql += "order_money orderMoney, \n";
			sql += "pay_money payMoney, \n";
			sql += "settle_total total, \n";
			sql += "to_char(to_date(settle_date), 'fmyyyy') yyyy, \n";
			sql += "to_char(to_date(settle_date), 'fmmm') mm, \n";
			sql += "to_char(to_date(settle_date), 'fmdd') dd \n";
			sql += "from Settle_Account_Info \n";
			sql += "order by 1";
			System.out.println(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// check dateSearch
			int i = 0;
			while (rs.next()) {
				rowData = new Vector<String>();
				String year = rs.getString("yyyy");
				String month = rs.getString("mm");
				String date = rs.getString("dd");
				if (yyyy.equals(year) && mm.equals(month) && dd.equals(date)) {
					rowData.add(rs.getInt("num") + "");
					rowData.add(rs.getString("dateT"));
					rowData.add(rs.getInt("orderMoney") + "");
					rowData.add(rs.getInt("payMoney") + "");
					rowData.add(rs.getInt("total") + "");
					// rowData.add(rs.getString("yyyy"));
					// rowData.add(rs.getString("mm"));
					// rowData.add(rs.getString("dd"));
					System.out.println("한 레코드씩 rowData " + rowData);
					dateSearch.add(rowData);
					System.out.println("dateSearch : " + dateSearch.get(i++));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return dateSearch;
	}

	@Override
	public Vector<Vector> search(String yyyy, String mm) {
		Vector<String> rowData;
		Vector<Vector> dateSearch = new Vector<>();
		try {
			sql = "SELECT settle_account_num num, \n";
			sql += "settle_date dateT, \n";
			sql += "order_money orderMoney, \n";
			sql += "pay_money payMoney, \n";
			sql += "settle_total total, \n";
			sql += "to_char(to_date(settle_date), 'fmyyyy') yyyy, \n";
			sql += "to_char(to_date(settle_date), 'fmmm') mm, \n";
			sql += "to_char(to_date(settle_date), 'fmdd') dd \n";
			sql += "from Settle_Account_Info \n";
			sql += "where to_char(to_date(settle_date), 'fmyyyy') = '" + yyyy + "' \n";
			sql += "and to_char(to_date(settle_date), 'fmmm') = '" + mm + "' \n";
			sql += "order by 1";
			System.out.println(sql);
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// check dateSearch//////
			int i = 0;
			/////////////////////////
			while (rs.next()) {
				rowData = new Vector<String>();
				rowData.add(rs.getInt("num") + "");
				rowData.add(rs.getString("dateT"));
				rowData.add(rs.getInt("orderMoney") + "");
				rowData.add(rs.getInt("payMoney") + "");
				rowData.add(rs.getInt("total") + "");
				System.out.println("한 레코드씩 rowData " + rowData);
				dateSearch.add(rowData);
				System.out.println("dateSearch : " + dateSearch.get(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resetStmt();
		}
		return dateSearch;
	}

}