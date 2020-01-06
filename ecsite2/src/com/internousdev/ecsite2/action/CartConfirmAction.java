package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartConfirmAction extends ActionSupport implements SessionAware {

	private String userId;
//	private String itemName;
	private String totalPriceSum;
	private String pay;
	private Map<String, Object> session;
	int resultCount = 0;

	private List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

	public String execute() throws SQLException {
		String result = SUCCESS;

		//ユーザーID識別
		if(session.containsKey("login_user_id")) {
			userId = session.get("login_user_id").toString();
		}else {
			userId = session.get("guest_id").toString();
		}

		//カート情報取得
		try {
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			cartInfoDTOList = cartInfoDAO.getCartInfo(userId);
		}catch(SQLException e) {
			result = "DBError";
			return result;
		}

		if (session.containsKey("payment")) {
			session.remove("payment");
		}

		//支払い方法を格納
		String payment;
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("payment", payment);
			session.put("totalPriceSum", totalPriceSum);
		}else {
			payment = "クレジットカード";
			session.put("payment", payment);
			session.put("totalPriceSum", totalPriceSum);
		}

		return result;
	}

//	public String getItemName() {
//		return itemName;
//	}
//
//	public void setItemName(String itemName) {
//		this.itemName = itemName;
//	}

	public String getTotalPriceSum() {
		return totalPriceSum;
	}

	public void setTotalPriceSum(String totalPriceSum) {
		this.totalPriceSum = totalPriceSum;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public List<CartInfoDTO> getCartInfoDTOList() {
		return cartInfoDTOList;
	}

	public void setCartInfoDTOList(List<CartInfoDTO> cartInfoDTOList) {
		this.cartInfoDTOList = cartInfoDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
