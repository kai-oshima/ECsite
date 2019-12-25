package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite2.dto.LoginDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class LoginDAO {

	//ログイン認証
	public LoginDTO loginUserInfo(String loginUserId, String loginPassword) throws SQLException {

		DBConnector db  = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO loginDTO = new LoginDTO();

		String sql = "SELECT * FROM login_user WHERE login_id=? AND login_pass=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));

				if(rs.getString("login_id" )!=null) {
					loginDTO.setLoginFlg(true);
				}
			}
		}finally {
			con.close();
		}
		return loginDTO;
	}

	//ログインした際、cart_infoにguestの状態で情報が格納されている場合
	//ユーザーIDをログイン時のものにする。
	public int updateUserId(String loginUserId ,String guestId) throws SQLException {

		DBConnector db  = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql = "UPDATE cart_info SET user_id=? WHERE user_id=?";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, guestId);
			result = ps.executeUpdate();
		}finally {
			con.close();
		}
		return result;
	}

	//新規ユーザー登録をする際にユーザーIDが既に登録されているかどうかを調べる
	public LoginDTO CreateUserCheck(String loginUserId) throws SQLException {

		DBConnector db  = new DBConnector();
		Connection con = db.getConnection();
		LoginDTO loginDTO = new LoginDTO();

		String sql = "SELECT * FROM login_user WHERE login_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				loginDTO.setLoginId(rs.getString("login_id"));

				if(rs.getString("login_id" )!=null) {
					loginDTO.setLoginFlg(true);
				}
			}
		}finally {
			con.close();
			}
		return loginDTO;
	}

	//ゲストIDの取得
		public String guestId() throws SQLException {

			DBConnector db = new DBConnector();
			Connection con = db.getConnection();

			int result = 0;
			String guest = "";

			String sql = "SELECT max(id) AS MAXID from cart_info";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				if(rs.next()) {
					result = rs.getInt("MAXID");
					guest = "guest" + String.valueOf(result);
				}
			}finally {
				con.close();
			}
			return guest;
		}
}
