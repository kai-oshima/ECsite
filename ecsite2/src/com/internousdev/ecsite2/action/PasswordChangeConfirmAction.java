package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.PasswordChangeConfirmDAO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PasswordChangeConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String loginUserName;
	private String errorMessage;
	private Map<String, Object> session;

	private LoginDTO loginDTO = new LoginDTO();
	private PasswordChangeConfirmDAO passwordDAO = new PasswordChangeConfirmDAO();

	public String execute() {

		String result = SUCCESS;

		try {
			loginDTO = passwordDAO.getUserInfo(loginUserId, loginPassword, loginUserName);
		}catch(SQLException e) {
			result = "DBError";
			return result;
		}
		session.put("loginUserId", loginDTO.getLoginId());


		if(!(loginUserId.equals(loginDTO.getLoginId()))
			&&(!(loginPassword.equals(loginDTO.getLoginPassword())))
			&&(!(loginUserName.equals(loginDTO.getUserName())))) {

			setErrorMessage("ユーザーID、パスワード、ユーザー名のいずれかが間違っています。");

			result = ERROR;

			return result;

		}

		return result;
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

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
