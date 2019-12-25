package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute() {
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

		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
