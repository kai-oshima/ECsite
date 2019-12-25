package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserAddressDAO;
import com.internousdev.ecsite2.dto.UserAddressDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAddressAction extends ActionSupport implements SessionAware {

	private List<UserAddressDTO> userAddressDTOList = new ArrayList<UserAddressDTO>();
	private Map<String, Object> session;
	private String message;

	public String execute() {
		String result = SUCCESS;

		if (session.containsKey("logined")) {

			UserAddressDAO userAddressDAO = new UserAddressDAO();

			try {
				userAddressDTOList = userAddressDAO.getUserAddress(session.get("login_user_id").toString());
			}catch (SQLException e) {
				result = "DBError";
				return result;
			}

			if (!(userAddressDTOList.size() > 0)) {
				setMessage("登録されているユーザー情報はありません。");

				return result;
			} else {

				return result;
			}
		} else {
			setMessage("登録されているユーザー情報はありません。");

			return result;
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<UserAddressDTO> getUserAddressDTOList() {
		return userAddressDTOList;
	}

	public void setUserAddressDTOList(List<UserAddressDTO> userAddressDTOList) {
		this.userAddressDTOList = userAddressDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
