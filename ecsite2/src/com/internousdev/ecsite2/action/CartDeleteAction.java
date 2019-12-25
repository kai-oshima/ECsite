package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartDeleteAction extends ActionSupport implements SessionAware{

	private String userId;
	private String totalPriceSum;
	private String itemName;
	private String size;
	private Map<String, Object> session;
	int resultCount = 0;

	private List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

	public String execute() throws SQLException {


		CartInfoDAO cartInfoDAO = new CartInfoDAO();

		if(session.containsKey("logined")) {
			userId = session.get("login_user_id").toString();
		}else {
			userId = session.get("guest_id").toString();
		}


		try {
			resultCount = cartInfoDAO.deleteCartInfo(userId, itemName, size);
		}catch(SQLException e) {
			return "DBError";
		}

		if(resultCount > 0){

			try {
				cartInfoDTOList = cartInfoDAO.getCartInfo(userId);
			}catch(SQLException e) {
				return "DBError";
			}
			session.remove("totalPriceSum");
			session.put("totalPriceSum", totalPriceSum);


			return SUCCESS;

		}else {

			return ERROR;
		}


	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getTotalPriceSum() {
		return totalPriceSum;
	}

	public void setTotalPriceSum(String totalPriceSum) {
		this.totalPriceSum = totalPriceSum;
	}

	public List<CartInfoDTO> getCartInfoDTOList() {
		return cartInfoDTOList;
	}

	public void setCartInfoDTO(List<CartInfoDTO> cartInfoDTOList) {
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
