package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private UserCreateCompleteDAO dao = new UserCreateCompleteDAO();

	public String execute() {

		String result = ERROR;

		String loginId = session.get("login_id").toString();
		String loginPassword = session.get("login_pass").toString();
		String userName = session.get("user_name").toString();
		int resultCount = 0;

		try {
			resultCount = dao.CreateUserComplete(loginId, loginPassword, userName);
		}catch (SQLException e) {
			return "DBError";
		}

		if(resultCount!=0) {

			session.remove("login_id");
			session.remove("login_pass");
			session.remove("user_name");
			session.remove("user_create_flg");

			result = SUCCESS;
			return result;
		}

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
