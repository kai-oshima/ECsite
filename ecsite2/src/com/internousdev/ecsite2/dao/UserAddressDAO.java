package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.UserAddressDTO;
import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class UserAddressDAO {


	//ユーザーアドレス情報の取得
	public List<UserAddressDTO> getUserAddress(String userId) throws SQLException {

		List<UserAddressDTO> userAddressDTO = new ArrayList<UserAddressDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();


		String sql = "SELECT * FROM user_address_info WHERE user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				UserAddressDTO dto = new UserAddressDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setMail(rs.getString("mail"));
				dto.setPhoneNumber(rs.getString("phone_num"));
				dto.setAddress(rs.getString("user_address"));
				userAddressDTO.add(dto);

			}
		}finally {
			con.close();
		}
		return userAddressDTO;
	}


	//ユーザーアドレス情報の登録
	public int registUserAdress(String userId,String firstName, String lastName,String mail, String phoneNumber, String address) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int result = 0;

		String sql="INSERT INTO user_address_info(user_id,first_name,last_name,mail,phone_num,user_address,insert_date)"
				+ "VALUES(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, mail);
			ps.setString(5, phoneNumber);
			ps.setString(6, address);
			ps.setString(7, dateUtil.getDate());

			result = ps.executeUpdate();
		}finally {
			con.close();
		}

		return result;
	}

	//ユーザーアドレス情報が存在するかどうかの確認
	public boolean existUserAdressInfo(String userId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="SELECT COUNT(id) AS COUNT FROM user_address_info WHERE user_id=?";

		boolean result = false;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				if(rs.getInt("COUNT") > 0) {
					result = true;
				}
			}
		}finally {
			con.close();
		}
		return result;
	}

	//ユーザーアドレス情報の削除
	public int deleteUserAddress(String userId, String firstName, String lastName, String mail, String phoneNumber, String address) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql = "DELETE FROM user_address_info WHERE user_id=? AND first_name=? AND last_name=? AND "
				+ "mail=? AND phone_num=? AND user_address=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, mail);
			ps.setString(5, phoneNumber);
			ps.setString(6, address);
			result = ps.executeUpdate();

		}finally {
			con.close();
		}
		return result;
	}
}
