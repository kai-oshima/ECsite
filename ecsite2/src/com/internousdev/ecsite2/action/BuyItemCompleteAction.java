package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.internousdev.ecsite2.dao.UserInfoDAO;
import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {
	private String firstName;
	private String lastName;
	private String mail;
	private String phoneNumber;
	private String address;
	private Map<String, Object> session;

	public String execute() {

		String result = SUCCESS;
		int resultCount = 0;
		int resultCount2 = 0;

		if (!session.containsKey("logined")) {
			result = "loginError";
			return result;
		}

		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();

		try {
			cartInfoDTOList = cartInfoDAO.getCartInfo(session.get("login_user_id").toString());
		}catch(SQLException e) {
			result = "DBError";
			return result;
		}

		for(int i = 0; i < cartInfoDTOList.size(); i++) {
			CartInfoDTO dto = new CartInfoDTO();
			dto = cartInfoDTOList.get(i);

			UserInfoDAO dao = new UserInfoDAO();
			int userMasterId = Integer.parseInt(session.get("userMasterId").toString());
			String userId = session.get("login_user_id").toString();
			String itemName = dto.getItemName();
			int totalCount = dto.getCount();
			int totalPrice = dto.getTotalPrice();
			int itemPrice = dto.getItemPrice();
			String size = dto.getSize();
			String payment = session.get("payment").toString();
			String image = dto.getImage();
			int itemTransactionId = 0;
			try {
				itemTransactionId = dao.getItemTransaction(itemName, image);
			}catch(SQLException e){
				result = "DBError";
				return result;
			}

			resultCount = dao.insertUserInfo(userMasterId,userId,itemName,totalCount,totalPrice,itemPrice,size,payment,firstName,lastName,mail,phoneNumber,address,image,itemTransactionId);

		}
			try {
				resultCount2 = cartInfoDAO.deleteAllCartInfo(session.get("login_user_id").toString());
			}catch(SQLException e){
				result = "DBError";
				return result;
			}

			if(resultCount == 0 || resultCount2 == 0) {
				result = ERROR;
				return result;
			}

		return result;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
