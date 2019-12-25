package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport {

	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserListDTO> userListDTO = new ArrayList<UserListDTO>();



	public String execute() throws SQLException {

		userListDTO = userListDAO.getUserList();


		String result = SUCCESS;

		return result;
	}


	public ArrayList<UserListDTO> getUserListDTO() {
		return this.userListDTO;
	}

}

