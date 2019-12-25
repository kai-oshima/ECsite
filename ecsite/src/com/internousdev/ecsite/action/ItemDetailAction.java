package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetailDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailAction extends ActionSupport implements SessionAware {

	private int id;
	private Map<String, Object> session;

	ItemInfoDTO itemInfoDTO = new ItemInfoDTO();
	ItemDetailDAO itemDetailDAO = new ItemDetailDAO();

	public String execute() {

		String result = SUCCESS;

		itemInfoDTO = itemDetailDAO.getItemInfo(id);

		session.put("itemInfo", itemInfoDTO);

		session.put("id", itemInfoDTO.getId());
		session.put("itemName", itemInfoDTO.getItemName());
		session.put("itemPrice",itemInfoDTO.getItemPrice());
		session.put("itemStock", itemInfoDTO.getItemStock());
		session.put("date", itemInfoDTO.getInsert_date());

		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Object> getSession() {
		return session;
	}


	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
