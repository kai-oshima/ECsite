package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.LoginDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class PasswordChangeCompleteDAO {

	public void changePass(String newPassword, String loginUserId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="UPDATE login_user SET login_pass=? WHERE login_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, loginUserId);
			ps.executeUpdate();
		}finally {
				con.close();
		}
	}

	public LoginDTO getUserInfo() throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO loginDTO = new LoginDTO();

		String sql ="SELECT * FROM login_user";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));
			}
		}finally {
				con.close();
		}
		return loginDTO;
	}
}
