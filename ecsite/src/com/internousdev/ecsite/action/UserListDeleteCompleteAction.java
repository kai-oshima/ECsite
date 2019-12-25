package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport {

	private UserListDeleteCompleteDAO userListDeleteDAO = new UserListDeleteCompleteDAO();

	public String execute() {

		delete();

		String result = SUCCESS;

		return result;
	}

	public void delete() {
		userListDeleteDAO.userListDelete();
	}
}
