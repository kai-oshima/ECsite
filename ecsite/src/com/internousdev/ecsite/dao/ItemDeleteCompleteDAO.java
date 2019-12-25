package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemDeleteCompleteDAO {

	public int itemDelete(int intId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM item_info_transaction WHERE id = ?";
		int result = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, intId);
			result = ps.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
