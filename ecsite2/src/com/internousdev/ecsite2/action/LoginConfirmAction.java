package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dao.CartInfoDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.CartInfoDTO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String message;
	private String guestId;
	private boolean saveUserId;


	private Map<String, Object> session;
	private List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
	private List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
	private CartInfoDAO cartInfoDAO = new CartInfoDAO();

	public String execute() throws SQLException {
		String result = ERROR;
		boolean existItem;
		int totalPrice;

		//ログイン認証
		LoginDTO loginDTO = new LoginDTO();
		LoginDAO loginDAO = new LoginDAO();

		try {
			loginDTO = loginDAO.loginUserInfo(loginUserId, loginPassword);
		}catch(SQLException e) {
			result = "DBError";
			return result;
		}
		session.put("loginUser", loginDTO);
		session.put("login_user_id", loginUserId);
		session.remove("save_user_id");

		if (((LoginDTO)session.get("loginUser")).getLoginFlg()) {

			if (!(session.containsKey("guest_id"))) {
				String	getGuestId = loginDAO.guestId();
				session.put("guest_id", getGuestId);
			}

			if (saveUserId) {
				session.put("save_user_id", true);
			}

			session.put("logined",1);
			guestId = session.get("guest_id").toString();

			if(session.containsKey("guest_id")) {

				//ゲストのカートとの紐づけ
				CartInfoDTO dto = new CartInfoDTO();

				try {
					cartInfoDTOList = cartInfoDAO.getCartInfo(guestId);
				}catch(SQLException e) {
					result = "DBError";
					return result;
				}

				if (cartInfoDTOList.size()>0) {
					int resultCount = 0;

					//ゲストカートが存在する場合の処理
					for(int i = 0; i < cartInfoDTOList.size(); i++) {
						dto = cartInfoDTOList.get(i);
						//ユーザーのカートに同アイテムがあるかチェック
						try {
							existItem = cartInfoDAO.existsCartInfo(loginUserId,dto.getItemName(),dto.getSize());
						}catch(SQLException e) {
							result = "DBError";
							return result;
						}

						if (existItem) {
							//カートの商品のカウントを変更
							try {
								resultCount = cartInfoDAO.updateCount(dto.getCount(),dto.getTotalPrice(),loginUserId,dto.getItemName());
							}catch(SQLException e) {
								result = "DBError";
								return result;
							}

						} else {
							//カートに商品を追加
							try {
								resultCount = cartInfoDAO.registItem(loginUserId, dto.getItemName(), dto.getItemPrice(), dto.getTotalPrice(), dto.getCount(), dto.getSize());
							}catch(SQLException e) {
								result = "DBError";
								return result;
							}
						}

						if (resultCount == 0) {
							return result;
						}
					}
					//ゲストのカート情報を削除
					try {
						resultCount = cartInfoDAO.deleteAllCartInfo(guestId);
					}catch(SQLException e) {
						result = "DBError";
						return result;
					}

					if (resultCount == 0) {
						return result;
					}
				}
			}

			//ユーザーのカート情報を取得
			try {
				cartInfoDTOList = cartInfoDAO.getCartInfo(loginUserId);
				totalPrice = cartInfoDAO.getTotalPriceSum(loginUserId);
			}catch(SQLException e) {
				result = "DBError";
				return result;
			}

			if (session.containsKey("totalPriceSum")) {
				session.remove("totalPriceSum");
				session.put("totalPriceSum", totalPrice);
			}else {
				session.put("totalPriceSum", totalPrice);
			}

			if (cartInfoDTOList.size()>0) {

				result = "cart";
				return result;
			} else {

				BuyItemDAO buyItemDAO = new BuyItemDAO();

				try {
					buyItemDTOList = buyItemDAO.getItemInfo();
				}catch(SQLException e) {
					result = "DBError";
					return result;
				}

				result = SUCCESS;
				return result;
			}

		} else {
			//認証に失敗した場合
			setMessage("ユーザーIDかパスワードが間違っています");
		}

		return result;
	}


	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getSaveUserId() {
		return saveUserId;
	}

	public void setSaveUserId(boolean saveUserId) {
		this.saveUserId = saveUserId;
	}

	public List<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}

	public List<CartInfoDTO> getCartInfoDTOList() {
		return cartInfoDTOList;
	}

	public void setCartInfoDTOList(List<CartInfoDTO> cartInfoDTOList) {
		this.cartInfoDTOList = cartInfoDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
