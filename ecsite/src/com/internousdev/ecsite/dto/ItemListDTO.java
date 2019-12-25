package com.internousdev.ecsite.dto;

public class ItemListDTO {

	private String itemName;
	private int itemPrice;
	private int itemStock;
	private int id;
	private int insert_date;


	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemStock() {
		return itemStock;
	}

	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(int insert_date) {
		this.insert_date = insert_date;
	}
}
