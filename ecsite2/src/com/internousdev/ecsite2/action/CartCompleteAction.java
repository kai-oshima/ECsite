package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.UserAddressDAO;
import com.internousdev.ecsite2.dto.UserAddressDTO;
import com.opensymphony.xwork2.ActionSupport;


public class CartCompleteAction extends ActionSupport implements SessionAware {

	private boolean resultCount;
	private String userId;
	private Map<String, Object> session;
	private UserAddressDAO userAddressDAO = new UserAddressDAO();
	private List<UserAddressDTO> userAddressDTO = new ArrayList<UserAddressDTO>();

	public String execute() throws SQLException{

		String result = SUCCESS;
		//ログインしている場合
		if (session.containsKey("logined")) {
			userId = session.get("login_user_id").toString();

			try {
				resultCount = userAddressDAO.existUserAdressInfo(userId);
			}catch(SQLException e) {
				result = "DBError";
				return result;
			}

		//ログインしていない場合
		}else {
			result = "login";
			return result;
		}



		//ログインしているが住所登録をしていない場合
		if (!resultCount) {

			result = "registAddress";
			return result;

		//住所登録をすでにしている場合
		}else {

			//ユーザー宛先情報を取得

			try {
				userAddressDTO = userAddressDAO.getUserAddress(userId);
			}catch(SQLException e) {
				result = "DBError";
				return result;
			}

			return result;
		}
	}

	public List<UserAddressDTO> getUserAddressDTO() {
		return userAddressDTO;
	}

	public void setUserAddressDTO(List<UserAddressDTO> userAddressDTO) {
		this.userAddressDTO = userAddressDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
