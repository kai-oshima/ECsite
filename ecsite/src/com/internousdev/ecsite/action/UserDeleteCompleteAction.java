package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class UserDeleteCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private UserDeleteCompleteDAO delete = new UserDeleteCompleteDAO();


	public String execute() {

		int intId = Integer.parseInt(session.get("Id").toString());

		delete.userDelete(intId);

		String result = SUCCESS;

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
