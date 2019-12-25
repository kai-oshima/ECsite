package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private ArrayList<BuyItemDTO> buyItemDTO = new ArrayList<BuyItemDTO>();
	private String message;


	public String execute() throws SQLException {

		String result = SUCCESS;
		String guestId;

		session.remove("logined");
		if(session.containsKey("guest_id")){
			session.remove("guest_id");
		}

		if(session.containsKey("new_address_flg")) {
			session.remove("new_last_name");
			session.remove("new_first_name");
			session.remove("new_mail");
			session.remove("new_phone");
			session.remove("new_address");
			session.remove("new_address_flg");
		}

		if(session.containsKey("regist_address_flg")) {
			session.remove("first_name");
			session.remove("last_name");
			session.remove("mail");
			session.remove("phone");
			session.remove("address");
			session.remove("regist_address_flg");
		}

		if(session.containsKey("user_create_flg")) {
			session.remove("login_id");
			session.remove("login_pass");
			session.remove("user_name");
			session.remove("user_create_flg");
		}

		try {
			LoginDAO dao = new LoginDAO();
			guestId = dao.guestId();
		}catch(SQLException e) {
			result = "DBError";
			return result;
		}

		session.put("guest_id", guestId);

		return result;

	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	public ArrayList<BuyItemDTO> getItemInfo() {
		return this.buyItemDTO;
	}

}
