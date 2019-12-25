package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private String itemName;
	private int count;
	private String pay;
	private String errorMessage;

	public String execute() {

		session.put("count", count);
		int intCount = Integer.parseInt(session.get("count").toString());
		int intStock = Integer.parseInt(session.get("buyItem_stock").toString());

		if(!(intStock < intCount)) {

			String result = SUCCESS;

			//-----値をsessionに代入------//
			session.put("itemName", itemName);
			session.put("buyItem_stock", intStock - intCount);

			int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
			session.put("total_price", intCount * intPrice);

			String payment;
			if(pay.equals("1")){
				payment="現金払い";
				session.put("pay", payment);
			}else {
				payment="クレジットカード";
				session.put("pay", payment);
			}

			//------------------------------//



			return result;

		}else {

			String result = ERROR;

			setErrorMessage("在庫が足りません。");

			return result;

			}
		}



	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
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

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
