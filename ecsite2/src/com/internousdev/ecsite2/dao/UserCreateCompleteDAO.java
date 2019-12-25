package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite2.util.DBConnector;

public class UserCreateCompleteDAO {

	public int CreateUserComplete(String loginId,String loginPassword,String userName) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql = "INSERT INTO login_user(login_id,login_pass,user_name) VALUES(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginId);
			ps.setString(2,loginPassword);
			ps.setString(3,userName);

			result = ps.executeUpdate();

		}finally {
				con.close();
		}
		return result;
	}
}
