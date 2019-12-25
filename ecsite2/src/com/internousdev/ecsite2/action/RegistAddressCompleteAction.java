package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserAddressDAO;
import com.internousdev.ecsite2.dto.UserAddressDTO;
import com.opensymphony.xwork2.ActionSupport;


public class RegistAddressCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private UserAddressDAO userAddressDAO = new UserAddressDAO();

	public String execute() throws SQLException {

		String result = ERROR;
		int resultCount = 0;


		String userId = session.get("login_user_id").toString();
		String firstName = session.get("first_name").toString();
		String lastName = session.get("last_name").toString();
		String mail = session.get("mail").toString();
		String phoneNummber = session.get("phone").toString();
		String address = session.get("address").toString();

		try {
			resultCount = userAddressDAO.registUserAdress(userId, firstName, lastName, mail, phoneNummber, address);
		}catch(SQLException e) {
			result = "DBError";
			return result;
		}

		if(resultCount!=0) {


			List<UserAddressDTO> userAddressDTO = new ArrayList<UserAddressDTO>();

			try {
				userAddressDTO = userAddressDAO.getUserAddress(userId);
			}catch(SQLException e) {
				result = "DBError";
				return result;
			}
			session.put("userAdress", userAddressDTO);

			session.remove("first_name");
			session.remove("last_name");
			session.remove("mail");
			session.remove("phone");
			session.remove("address");

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
