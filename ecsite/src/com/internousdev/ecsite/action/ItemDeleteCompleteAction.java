package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDeleteCompleteAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private ItemDeleteCompleteDAO delete = new ItemDeleteCompleteDAO();

	public String execute() {

		int intId = Integer.parseInt(session.get("id").toString());

		delete.itemDelete(intId);

		String result = SUCCESS;

		return result;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
