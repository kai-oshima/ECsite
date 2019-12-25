package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.itemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class itemCreateCompleteAction extends ActionSupport implements SessionAware {

	private String itemName;
	private int itemPrice;
	private int itemStock;
	private Map<String, Object> session;
	private itemCreateCompleteDAO itemCreateCompleteDAO = new itemCreateCompleteDAO();

	public String execute() {

		itemCreateCompleteDAO.itemCreateDAO(session.get("item_name").toString(),
				Integer.parseInt(session.get("item_price").toString()),
				Integer.parseInt(session.get("item_stock").toString()));

		String result = SUCCESS;

		return result;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
