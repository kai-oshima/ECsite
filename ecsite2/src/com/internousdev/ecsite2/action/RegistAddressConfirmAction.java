package com.internousdev.ecsite2.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.util.InputCheck;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAddressConfirmAction extends ActionSupport implements SessionAware {

	private String firstName;
	private String lastName;
	private String mail;
	private String phone;
	private String address;

	private Map<String, Object> session;

	private List<String> firstNameCheck = new ArrayList<String>();
	private List<String> lastNameCheck = new ArrayList<String>();
	private List<String> mailCheck = new ArrayList<String>();
	private List<String> addressCheck = new ArrayList<String>();
	private List<String> phoneCheck = new ArrayList<String>();


	public String execute() {

		String result = SUCCESS;

		if(session.containsKey("regist_address_flg")) {
			session.remove("first_name");
			session.remove("last_name");
			session.remove("mail");
			session.remove("phone");
			session.remove("address");
			session.remove("regist_address_flg");
		}

		session.put("first_name",firstName);
		session.put("last_name",lastName);
		session.put("mail",mail);
		session.put("phone",phone);
		session.put("address",address);
		session.put("regist_address_flg", 1);

		InputCheck inputCheck = new InputCheck();

		firstNameCheck = inputCheck.inputCheck("姓", firstName, 1, 16, true, true, true, true, false, false);
		lastNameCheck = inputCheck.inputCheck("名", lastName, 1, 16, true, true, true, true, false, false);
		phoneCheck = inputCheck.inputCheck("電話番号", phone, 10, 16, false, false, false, false, true, true);
		addressCheck = inputCheck.inputCheck("住所", address, 10, 30, true, true, true, true, true, true);
		mailCheck = inputCheck.doCheckForEmail(mail);


		if(firstNameCheck.size() > 0 || lastNameCheck.size() >0
			|| mailCheck.size() > 0 || addressCheck.size() > 0 || phoneCheck.size() > 0) {

			result = ERROR;
			return result;
		}

		return result;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public List<String> getFirstNameCheck() {
		return firstNameCheck;
	}

	public void setFirstNameCheck(List<String> firstNameCheck) {
		this.firstNameCheck = firstNameCheck;
	}

	public List<String> getLastNameCheck() {
		return lastNameCheck;
	}

	public void setLastNameCheck(List<String> lastNameCheck) {
		this.lastNameCheck = lastNameCheck;
	}

	public List<String> getMailCheck() {
		return mailCheck;
	}

	public void setMailCheck(List<String> mailCheck) {
		this.mailCheck = mailCheck;
	}

	public List<String> getAddressCheck() {
		return addressCheck;
	}

	public void setAddressCheck(List<String> addressCheck) {
		this.addressCheck = addressCheck;
	}

	public List<String> getPhoneCheck() {
		return phoneCheck;
	}

	public void setPhoneCheck(List<String> phoneCheck) {
		this.phoneCheck = phoneCheck;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
