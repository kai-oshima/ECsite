package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.MyPageDAO;
import com.internousdev.ecsite2.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoMyPageAction extends ActionSupport implements SessionAware{
	private String message ="";
	private Map<String, Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private List<MyPageDTO> myPageDTOList = new ArrayList<MyPageDTO>();


	public String execute() {

		String result = SUCCESS;
		int totalPrice = 0;

		if(session.containsKey("logined")) {

			try {
			myPageDTOList = myPageDAO.getMyPageInfo(session.get("login_user_id").toString());
			totalPrice = myPageDAO.getTotalPriceSum(session.get("login_user_id").toString());
		}catch (SQLException e) {
			result = "DBError";
			return result;
		}



			if(session.containsKey("totalPriceSum")) {
				session.remove("totalPriceSum");
				session.put("totalPriceSum", totalPrice);
			}else {
				session.put("totalPriceSum", totalPrice);
			}

			if(!(myPageDTOList.size() > 0)) {

				setMessage("購入履歴はありません。");
			}

			return result;

		}else {

			setMessage("購入履歴はありません。");
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

		return result;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<MyPageDTO> getMyPageDTOList() {
		return myPageDTOList;
	}

	public void setMyPageDTOList(List<MyPageDTO> myPageDTOList) {
		this.myPageDTOList = myPageDTOList;
	}
}
