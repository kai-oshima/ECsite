package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.MyPageDAO;
import com.opensymphony.xwork2.ActionSupport;


public class DeleteItemAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private String message ="";

	public String execute() {
		String result = ERROR;

		MyPageDAO myPageDAO = new MyPageDAO();
		int resultCount = 0;
		session.remove("totalPriceSum");

		if (!session.containsKey("login_user_id")) {
			return result;
		}

		try {
			resultCount = myPageDAO.updateItem(session.get("login_user_id").toString());
		} catch (SQLException e) {
			return "DBError";
		}

		if (resultCount != 0) {

			setMessage("購入履歴はありません。");
			result = SUCCESS;
			return result;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
