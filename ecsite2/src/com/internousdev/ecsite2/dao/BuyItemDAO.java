package com.internousdev.ecsite2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.util.DBConnector;

public class BuyItemDAO {

	public ArrayList<BuyItemDTO> getItemInfo() throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<BuyItemDTO> buyItemDTO = new ArrayList<BuyItemDTO>();

		String sql = "SELECT * FROM item_info";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				BuyItemDTO dto = new BuyItemDTO();
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setStock(rs.getInt("item_stock"));
				dto.setImage(rs.getString("image"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				buyItemDTO.add(dto);
			}
		}finally {
			con.close();
		}
		return buyItemDTO;
	}
}
