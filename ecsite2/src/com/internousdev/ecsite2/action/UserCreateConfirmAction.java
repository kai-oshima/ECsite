package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.internousdev.ecsite2.util.InputCheck;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String message;
	private Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private List<String> idCheckList = new ArrayList<String>();
	private List<String> passwordCheckList = new ArrayList<String>();
	private List<String> userNameCheckList = new ArrayList<String>();

	public String execute() {

		String result = ERROR;

		InputCheck inputCheck = new InputCheck();

		idCheckList = inputCheck.inputCheck("ユーザーID", loginUserId, 1, 16, true, false, false, false, true, false);
		passwordCheckList = inputCheck.inputCheck("パスワード", loginPassword, 8, 16, true, false, false, false, true, false);
		userNameCheckList = inputCheck.inputCheck("ユーザー名", userName, 1, 16, true, true, true, true, true, false);

		if (idCheckList.size() > 0 || passwordCheckList.size() > 0 || userNameCheckList.size() > 0) {

			return result;
		}

		try {
			loginDTO = loginDAO.CreateUserCheck(loginUserId);
		}catch(SQLException e) {
			result = "DBError";
			return result;
		}

		if(loginUserId.equals(loginDTO.getLoginId())) {
			setMessage("このIDは既に存在しています。別のIDに変更してください。");
			return result;

		}else {

			session.put("login_id", loginUserId);
			session.put("login_pass", loginPassword);
			session.put("user_name", userName);
			session.put("user_create_flg", 1);

			result = SUCCESS;
			return result;
		}
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getIdCheckList() {
		return idCheckList;
	}

	public void setIdCheckList(List<String> idCheckList) {
		this.idCheckList = idCheckList;
	}

	public List<String> getPasswordCheckList() {
		return passwordCheckList;
	}

	public void setPasswordCheckList(List<String> passwordCheckList) {
		this.passwordCheckList = passwordCheckList;
	}

	public List<String> getUserNameCheckList() {
		return userNameCheckList;
	}

	public void setUserNameCheckList(List<String> userNameCheckList) {
		this.userNameCheckList = userNameCheckList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
