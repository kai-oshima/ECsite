package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport {

	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemListDTO> itemListDTO = new ArrayList<ItemListDTO>();



	public String execute() throws SQLException {

		itemListDTO = itemListDAO.getItemList();


		String result = SUCCESS;

		return result;
	}


	public ArrayList<ItemListDTO> getItemListDTO() {
		return this.itemListDTO;
	}

}

