package com.internousdev.ecsite2.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.PasswordChangeCompleteDAO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PasswordChangeCompleteAction extends ActionSupport implements SessionAware {

	private String newPassword;
	private Map<String, Object> session;
	private PasswordChangeCompleteDAO passwordDAO = new PasswordChangeCompleteDAO();
	private LoginDTO loginDTO = new LoginDTO();


	public String execute() {
			String result = SUCCESS;
			String loginUserId = session.get("loginUserId").toString();

			try {
				passwordDAO.changePass(newPassword,loginUserId);
				loginDTO = passwordDAO.getUserInfo();
			}catch(SQLException e) {
				result = "DBError";
			}

			session.put("loginDTO", loginDTO);

			return result;

	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
