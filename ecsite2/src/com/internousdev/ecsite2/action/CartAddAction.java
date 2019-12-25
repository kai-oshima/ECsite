package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAddAction extends ActionSupport implements SessionAware {

	//ゲストIDを付与
	//session.userIdにゲストIDかユーザーIDを新規登録

	private String userId = null;
	private String itemName;
	private int price;
	private int count;
	private String size;
	private int totalPrice;
	private String message;

	private List<CartInfoDTO> cartInfoDTOList;
	private Map<String, Object> session;

	public String execute() throws SQLException{

		String result = ERROR;
		totalPrice = count * price;
		int totalPriceSum = 0;

		//ログインしている場合
		if (session.containsKey("logined")) {
			userId  = session.get("login_user_id").toString();

		//ログインしていない場合、かつ仮IDを持っている
		}else if (session.containsKey("guest_id")) {
			userId = session.get("guest_id").toString();

		//ログインしていない場合、かつ仮IDを持っていない
		}else {
			LoginDAO loginDAO = new LoginDAO();
			userId = loginDAO.guestId();
			session.put("guest_id", userId);
		}

		//選択された商品をDBカートに追加していく
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		int resultCount = 0;

		//カートにすでに商品が存在している場合、個数と金額を変更する
		if (cartInfoDAO.existsCartInfo(userId, itemName, size)) {

			try {
				resultCount = cartInfoDAO.updateCount(count, totalPrice, userId, itemName);
			}catch(SQLException e) {
				result = "DBError";
				return result;
			}
		}else {
			//登録されていない場合、商品の新規登録を行う

			try {
				resultCount = cartInfoDAO.registItem(userId, itemName, price, totalPrice, count, size);
			}catch(SQLException e) {
				result = "DBError";
				return result;
			}
		}


		if (resultCount > 0) {

			//カート情報と合計金額の取得

			try {
				cartInfoDTOList = cartInfoDAO.getCartInfo(userId);
				totalPriceSum = cartInfoDAO.getTotalPriceSum(userId);
			}catch(SQLException e) {
				result = "DBError";
				return result;
			}

			//すでに合計金額がセッションに入っている場合は更新する
			if(session.containsKey("totalPriceSum")) {
				session.remove("totalPriceSum");
				session.put("totalPriceSum", totalPriceSum);
			}

			result = SUCCESS;
			return result;
		}

		return result;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<CartInfoDTO> getCartInfoDTOList() {
		return cartInfoDTOList;
	}

	public void setCartInfoDTOList(List<CartInfoDTO> cartInfoDTOList) {
		this.cartInfoDTOList = cartInfoDTOList;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
