package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class RegistAddressAction extends ActionSupport implements SessionAware {

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

		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
