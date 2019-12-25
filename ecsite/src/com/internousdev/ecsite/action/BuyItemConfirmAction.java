package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private BuyItemCompleteDAO buyItemCompleteDAO =new BuyItemCompleteDAO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();


	public String execute() throws SQLException {


		buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("total_price").toString(),
				session.get("count").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());


		buyItemCompleteDAO.buyItemInfoUpdate(
				session.get("buyItem_stock").toString(),
				session.get("buyItem_name").toString());

		buyItemDTO = buyItemDAO.getBuyItemInfo();
		session.put("buyItem_stock", buyItemDTO.getStock());

		String result = SUCCESS;
		return result;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
