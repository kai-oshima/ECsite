package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.UserInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class UserInfoDAO {

	public int insertUserInfo(int userMasterId, String userId, String itemName, int totalCount, int totalPrice, int itemPrice, String size, String payment, String firstName, String lastName, String mail, String phone, String address, String image, int itemTransactionId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int resultCount = 0;

		String sql = "INSERT INTO user_info(user_master_id,user_id,item_name,total_count,item_price,size,payment,total_price,first_name,last_name,mail,phone_num,user_address,image,insert_date,item_transaction_id)"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userMasterId);
			ps.setString(2, userId);
			ps.setString(3, itemName);
			ps.setInt(4, totalCount);
			ps.setInt(5, itemPrice);
			ps.setString(6, size);
			ps.setString(7, payment);
			ps.setInt(8, totalPrice);
			ps.setString(9, firstName);
			ps.setString(10, lastName);
			ps.setString(11, mail);
			ps.setString(12, phone);
			ps.setString(13, address);
			ps.setString(14, image);
			ps.setString(15, dateUtil.getDate());
			ps.setInt(16, itemTransactionId);
			resultCount = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return resultCount;
	}

	public int getItemTransaction(String itemName, String image) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int itemTransactionId = 0;

		String sql = "SELECT id FROM item_info WHERE item_name = ? and image = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setString(2, image);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				itemTransactionId = rs.getInt("id");
			}
		}finally {
			con.close();
		}

		return itemTransactionId;
	}

	public List<UserInfoDTO> getUserInfo(String userId) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<UserInfoDTO> userInfoDTO = new ArrayList<UserInfoDTO>();

		String sql = "SELECT * FROM user_info WHERE user_master_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				UserInfoDTO dto = new UserInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemTransactionId(rs.getInt("item_transaction_id"));
				dto.setTotalPrice(rs.getInt("total_price"));
				dto.setTotalCount(rs.getInt("total_count"));
				dto.setUserMasterId(rs.getString("user_master_id"));
				dto.setPay(rs.getString("pay"));
				dto.setBuyDate(rs.getString("insert_date"));
				dto.setItemName(rs.getString("item_name"));
				userInfoDTO.add(dto);
			}
		}finally {
			con.close();
		}
		return userInfoDTO;
	}
}
