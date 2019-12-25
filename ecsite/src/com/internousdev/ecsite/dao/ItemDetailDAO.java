package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemDetailDAO {

	public ItemInfoDTO getItemInfo(int id) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ItemInfoDTO itemInfoDTO = new ItemInfoDTO();


		String sql ="SELECT * FROM item_info_transaction where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {

				itemInfoDTO.setId(rs.getInt("id"));
				itemInfoDTO.setItemName(rs.getString("item_name"));
				itemInfoDTO.setItemPrice(rs.getInt("item_price"));
				itemInfoDTO.setItemStock(rs.getInt("item_stock"));
				itemInfoDTO.setInsert_date(rs.getString("insert_date"));
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

		return itemInfoDTO;

	}

}
