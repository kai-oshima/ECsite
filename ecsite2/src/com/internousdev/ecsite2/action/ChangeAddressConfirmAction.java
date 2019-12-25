package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ChangeAddressConfirmAction extends ActionSupport implements SessionAware {

	private String lastName;
	private String firstName;
	private String mail;
	private String phoneNumber;
	private String address;
	private Map<String, Object> session;

	public String execute() {
		String result = SUCCESS;

		if(!session.containsKey("logined")) {
			result = "loginError";
			return result;
		}

		session.put("new_last_name", lastName);
		session.put("new_first_name", firstName);
		session.put("new_mail", mail);
		session.put("new_phone", phoneNumber);
		session.put("new_address", address);

		if(!(session.containsKey("new_address_flg"))) {
			session.put("new_address_flg", 1);
		}
		return result;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
