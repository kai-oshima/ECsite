package com.internousdev.ecsite2.dto;

public class UserInfoDTO {

	private int id;
	private int itemTransactionId;
	private int totalPrice;
	private int totalCount;
	private String userMasterId;
	private String pay;
	private String buyDate;
	private String itemName;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemTransactionId() {
		return itemTransactionId;
	}

	public void setItemTransactionId(int itemTransactionId) {
		this.itemTransactionId = itemTransactionId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getUserMasterId() {
		return userMasterId;
	}

	public void setUserMasterId(String userMasterId) {
		this.userMasterId = userMasterId;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
