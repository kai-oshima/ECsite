package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {

	private String message;
	private String userId;
	private List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
	private Map<String, Object> session;

	public String execute() throws SQLException {

		String result = ERROR;
		int totalPriceSum = 0;

		//ログインしている場合
		if (session.containsKey("logined")) {
			userId = session.get("login_user_id").toString();

		//ログインしていないがゲストIDは持っている
		}else if (session.containsKey("guest_id")){
			userId = session.get("guest_id").toString();

		//ログインしていない,かつゲストIDを持っていない
		}else {
			LoginDAO loginDAO = new LoginDAO();
			userId = loginDAO.guestId();
			session.put("guest_id", userId);
		}

		CartInfoDAO cartInfoDAO = new CartInfoDAO();

		//カート情報と合計金額を取得
		try {
			cartInfoDTOList = cartInfoDAO.getCartInfo(userId);
			totalPriceSum = cartInfoDAO.getTotalPriceSum(userId);
		}catch(SQLException e) {
			result = "DBError";
			return result;
		}
		if (session.containsKey("totalPriceSum")) {
			session.remove("totalPriceSum");
			session.put("totalPriceSum", totalPriceSum);
		}else {
			session.put("totalPriceSum", totalPriceSum);
		}

		if (cartInfoDTOList.size()>0) {
			session.put("cart_flg", 1);
		}


		if(session.containsKey("userAddress")) {
			session.remove("first_name");
			session.remove("last_name");
			session.remove("mail");
			session.remove("phone");
			session.remove("address");
		}

		if(session.containsKey("user_create_flg")) {
			session.remove("login_id");
			session.remove("login_pass");
			session.remove("user_name");
		}

		if(session.containsKey("payment")) {
			session.remove("payment");
		}

		result = SUCCESS;
		return result;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
