package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;


public class ItemListDAO {

	public ArrayList<ItemListDTO> getItemList() throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ItemListDTO> itemListDTO = new ArrayList<ItemListDTO>();

		String sql= "SELECT item_name,item_price,item_stock,id,insert_date FROM item_info_transaction";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ItemListDTO dto = new ItemListDTO();
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setItemStock(rs.getInt("item_stock"));
				dto.setId(rs.getInt("id"));
				dto.setInsert_date(rs.getInt("insert_date"));
				itemListDTO.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return itemListDTO;

	}
	}




