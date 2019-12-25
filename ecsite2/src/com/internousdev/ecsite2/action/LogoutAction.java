package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware  {

	private String userId;
	private Map<String, Object> session;
	private String message;

	public String execute() {

		if (session.containsKey("save_user_id")) {
			String userId = session.get("login_user_id").toString();
			session.clear();
			session.put("save_user_id", true);
			session.put("login_user_id", userId);
		} else {
			session.clear();
		}

		return SUCCESS;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
