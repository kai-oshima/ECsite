package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

	public int userListDelete() {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM login_user_transaction WHERE admin_frg IS NULL ";

		PreparedStatement ps;
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}
}
