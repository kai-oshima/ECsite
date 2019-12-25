package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.MyPageDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class MyPageDAO {

	public List<MyPageDTO> getMyPageInfo(String userMasterId) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<MyPageDTO> myPageDTOList = new ArrayList<MyPageDTO>();

		String sql = "SELECT * FROM user_info WHERE user_master_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userMasterId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setId(rs.getInt("id"));
				dto.setInsertDate(rs.getString("insert_date"));
				dto.setItemName(rs.getString("item_name"));
				dto.setCount(rs.getInt("total_count"));
				dto.setSize(rs.getString("size"));
				dto.setPay(rs.getString("payment"));
				dto.setTotalPrice(rs.getInt("total_price"));
				dto.setUserMasterId(rs.getString("user_master_id"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setAddress(rs.getString("user_address"));
				myPageDTOList.add(dto);

			}

		}finally {
			con.close();
		}

		return myPageDTOList;
	}

	//総計計算
		public int getTotalPriceSum(String userId) throws SQLException{

			int totalPriceSum = 0;
			int totalPrice = 0;
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();

			String sql = "SELECT total_price FROM user_info WHERE user_master_id=?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userId);
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					totalPrice = rs.getInt("total_price");

					totalPriceSum += totalPrice;
				}
				}finally {
					con.close();
				}
			return totalPriceSum;
		}

	//履歴削除
		public int deleteItem(String userMasterId) throws SQLException {

			DBConnector db = new DBConnector();
			Connection con = db.getConnection();
			int result = 0;

			String sql = "DELETE FROM user_info WHERE user_master_id=?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, userMasterId);

				result = ps.executeUpdate();
			} finally {
				con.close();
			}
			return result;
		}

}
