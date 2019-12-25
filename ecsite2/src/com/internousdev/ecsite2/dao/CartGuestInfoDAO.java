package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class CartGuestInfoDAO {


	//カートにguestの情報が格納されているか
	public boolean existGuestCart() throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT COUNT(user_id) AS COUNT FROM cart_info WHERE user_id='guest' ";

		boolean result = false;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				if(rs.getInt("COUNT") > 0) {
					result = true;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
				con.close();
		}
		return result;
	}
}
