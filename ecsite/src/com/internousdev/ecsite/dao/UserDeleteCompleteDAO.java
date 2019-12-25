package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserDeleteCompleteDAO {

	public int userDelete(int intId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql = "DELETE FROM login_user_transaction WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, intId);
			result  = ps.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
