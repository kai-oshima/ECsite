package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	private Map<String,Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if(!session.containsKey("login_user_id")) {
			return ERROR;
		}

		//履歴が削除されているかどうかのチェック
		//deleteFlg == nullは削除ボタンを押していないということ
		if(deleteFlg == null) {
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();

		//DBから取得した履歴情報をmyPageListに格納
			myPageList = myPageDAO.getMyPageInfo(item_transaction_id,user_master_id);

		//削除ボタンが押された時(deleteFlgが1の時)deleteメソッドを呼び出し削除処理を行う
		}else if(deleteFlg.equals("1")) {
			delete();
		}

		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {
		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		int res = myPageDAO.buyItemHistoryDelete(item_transaction_id,user_master_id);

		if(res > 0) {
			myPageList = null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res == 0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public ArrayList<MyPageDTO> getMyPageList() {
		return this.myPageList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String,Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
