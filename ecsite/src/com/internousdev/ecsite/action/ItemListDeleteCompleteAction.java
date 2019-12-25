package com.internousdev.ecsite.action;


import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport {

	private ItemListDeleteCompleteDAO itemListDeleteDAO = new ItemListDeleteCompleteDAO();

	public String execute() {

		delete();

		String result = SUCCESS;

		return result;
	}


	public void delete() {

		itemListDeleteDAO.itemListDelete();

	}
}
