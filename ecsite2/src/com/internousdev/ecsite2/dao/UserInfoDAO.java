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

	public int registUserInfo(int itemTransactionId,int totalCount,String userMasterId,String payment,String itemName,String size, int totalPrice, String firstName, String lastName, String mail, String phoneNumber, String address, int itemPrice) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		int resultCount = 0;

		String sql = "INSERT INTO user_info(item_transaction_id,user_master_id,item_name,total_count,size,payment,insert_date,total_price,first_name,last_name,mail,phone_num,user_address,item_price)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemTransactionId);
			ps.setString(2, userMasterId);
			ps.setString(3, itemName);
			ps.setInt(4, totalCount);
			ps.setString(5, size);
			ps.setString(6, payment);
			ps.setString(7, dateUtil.getDate());
			ps.setInt(8,  totalPrice);
			ps.setString(9, firstName);
			ps.setString(10, lastName);
			ps.setString(11, mail);
			ps.setString(12, phoneNumber);
			ps.setString(13, address);
			ps.setInt(14, itemPrice);

			resultCount = ps.executeUpdate();

		}finally {
				con.close();
		}

		return resultCount;
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
