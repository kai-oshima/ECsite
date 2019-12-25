package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.LoginDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class PasswordChangeConfirmDAO {

	public LoginDTO getUserInfo(String loginUserId, String loginPassword, String loginUserName) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO loginDTO = new LoginDTO();

		String sql = "SELECT * FROM login_user WHERE login_id=? AND login_pass=? AND user_name=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ps.setString(3, loginUserName);

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
