package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	public String execute() throws SQLException {

		String result = SUCCESS;

		if(session.containsKey("userAddress")) {
			session.remove("first_name");
			session.remove("last_name");
			session.remove("mail");
			session.remove("phone");
			session.remove("address");
		}

		if(session.containsKey("user_create_flg")) {
			session.remove("login_id");
			session.remove("login_pass");
			session.remove("user_name");
		}

		BuyItemDAO buyItemDAO = new BuyItemDAO();

		try {
			buyItemDTOList = buyItemDAO.getItemInfo();
		}catch(SQLException e) {
			e.printStackTrace();
			result = "DBError";
			return result;
		}


		if(!(buyItemDTOList.size() > 0)) {
			result = ERROR;
			return result;
		}

		return result;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	public List<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}

}
