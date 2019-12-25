package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetailDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailAction extends ActionSupport implements SessionAware {

	private int id;
	private Map<String, Object> session;

	UserDetailDAO userDetailDAO = new UserDetailDAO();
	UserInfoDTO userInfoDTO = new UserInfoDTO();

	public String execute() {
		String result = SUCCESS;

		userInfoDTO = userDetailDAO.getUserInfo(id);

		session.put("userInfo", userInfoDTO);

		session.put("Id", userInfoDTO.getId());
		session.put("userId", userInfoDTO.getUserId());
		session.put("userPass", userInfoDTO.getUserPass());
		session.put("userName", userInfoDTO.getUserName());
		session.put("userDate", userInfoDTO.getDate());

		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
