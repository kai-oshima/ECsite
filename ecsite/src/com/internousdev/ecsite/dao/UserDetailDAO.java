package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserDetailDAO {

	public UserInfoDTO getUserInfo(int id) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		String sql = "SELECT * FROM login_user_transaction WHERE id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("login_id"));
				userInfoDTO.setUserPass(rs.getString("login_pass"));
				userInfoDTO.setUserName(rs.getString("user_name"));
				userInfoDTO.setDate(rs.getString("insert_date"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userInfoDTO;
	}
}
