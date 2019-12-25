package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.internousdev.ecsite2.util.DBConnector;
import com.internousdev.ecsite2.util.DateUtil;

public class CartInfoDAO {


	//カート情報取得
	public List<CartInfoDTO> getCartInfo(String userId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

		String sql = "SELECT * FROM cart_info WHERE user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO dto = new CartInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setCount(rs.getInt("item_count"));
				dto.setSize(rs.getString("size"));
				dto.setTotalPrice(rs.getInt("total_price"));

				cartInfoDTOList.add(dto);
			}
		}finally {
			con.close();
		}
		return cartInfoDTOList;
	}

	//カートに商品を追加
	public int registItem(String userId,String itemName,int price,int totalPrice, int count, String size) throws SQLException {

		int psCount = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();

		String sql = "INSERT INTO cart_info(user_id,item_name,item_price,item_count,total_price,size,insert_date)"
					+ "VALUES(?,?,?,?,?,?,?)";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2,itemName);
			ps.setInt(3, price);
			ps.setInt(4, count);
			ps.setInt(5, totalPrice);
			ps.setString(6, size);
			ps.setString(7, dateUtil.getDate());

			psCount = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}

		return psCount;
	}

	//カートに存在する商品の個数情報を変更
	public int updateCount(int count,int totalPrice,String userId,String itemName) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "UPDATE cart_info SET item_count=(item_count + ?),total_price=(total_price + ?), update_date = now() WHERE user_id=? AND item_name=?";

		int result = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setInt(2, totalPrice);
			ps.setString(3, userId);
			ps.setString(4, itemName);
			result = ps.executeUpdate();
		}finally {
			con.close();
		}
		return result;
	}

	//カートに商品が存在するかどうか
	public boolean existsCartInfo(String userId, String itemName, String size) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="SELECT COUNT(id) AS COUNT FROM cart_info WHERE user_id=? AND item_name=? AND size=?";

		boolean result = false;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, itemName);
			ps.setString(3,  size);
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

	//総計計算
	public int getTotalPriceSum(String userId) throws SQLException {

		int totalPriceSum = 0;
		int totalPrice = 0;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT total_price FROM cart_info WHERE user_id=?";

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

	//カート情報から一つのアイテムを削除

	public int deleteCartInfo(String userId, String itemName, String size) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;

		String sql ="DELETE FROM cart_info WHERE item_name=? AND user_id=? AND size=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setString(2, userId);
			ps.setString(3, size);
			result = ps.executeUpdate();
		}finally {
			con.close();
		}
		return result;
	}

	//カート情報からすべてのアイテムを削除(ログアウト時）
	public int deleteAllCartInfo(String userId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int resultCount = 0;

		String sql ="DELETE FROM cart_info WHERE user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			resultCount = ps.executeUpdate();
		}finally {
			con.close();
		}
		return resultCount;
	}

}
