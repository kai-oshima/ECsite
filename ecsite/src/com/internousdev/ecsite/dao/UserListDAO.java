package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	public ArrayList<UserListDTO> getUserList() throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<UserListDTO> userListDTO = new ArrayList<UserListDTO>();

		String sql = "SELECT id,login_id,login_pass,user_name FROM login_user_transaction";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				UserListDTO dto = new UserListDTO();
				dto.setId(rs.getInt("id"));
				dto.setLoginUserId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				userListDTO.add(dto);
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

		return userListDTO;
	}
}
