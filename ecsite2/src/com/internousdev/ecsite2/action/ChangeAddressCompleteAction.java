package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserAddressDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeAddressCompleteAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {

		String result = SUCCESS;
		int resultCount = 0;
		int resultCount2 = 0;

		if(!session.containsKey("logined")) {
			result = "loginError";
			return result;
		}

		UserAddressDAO userAddressDAO = new UserAddressDAO();
		String userId = session.get("login_user_id").toString();
		String firstName = session.get("first_name").toString();
		String lastName = session.get("last_name").toString();
		String mail = session.get("mail").toString();
		String phoneNumber = session.get("phoneNumber").toString();
		String address = session.get("address").toString();

		try {
			resultCount = userAddressDAO.deleteUserAddress(userId, firstName, lastName, mail, phoneNumber, address);

			firstName = session.get("new_first_name").toString();
			lastName = session.get("new_last_name").toString();
			mail = session.get("new_mail").toString();
			phoneNumber = session.get("new_phone").toString();
			address = session.get("new_address").toString();
			resultCount2 = userAddressDAO.registUserAdress(userId, firstName, lastName, mail, phoneNumber, address);

		}catch (SQLException e) {
			result = "DBError";
			return result;
		}

		if(resultCount == 0 || resultCount2 == 0) {
			result = ERROR;
			return result;
		}

		session.remove("new_address_flg");
		session.remove("new_last_name");
		session.remove("new_first_name");
		session.remove("new_mail");
		session.remove("new_phone");
		session.remove("new_address");
		session.remove("first_name");
		session.remove("last_name");
		session.remove("mail");
		session.remove("phoneNumber");
		session.remove("address");
		session.remove("change_address_flg");

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
