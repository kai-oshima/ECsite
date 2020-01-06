<%@ page language= "java" contentType= "text/html; charset=UTF-8"
	pageEncoding= "UTF-8"%>
<%@ taglib prefix= "s" uri= "/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type= "text/css" href="./css/cart.css">
<link rel="stylesheet" type= "text/css" href="./css/header.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<title>CART</title>
</head>

<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="main">
		<div id="contents">
		<s:if test="#session.logined==1">
			<h3><s:property value="#session.login_user_id"/>さんのカートの内容は以下になります。</h3>
		</s:if>

		<s:else>
			<h3><s:property value="#session.guest_id"/>さんのカートの内容は以下になります。</h3>
		</s:else>

		<s:if test="cartInfoDTOList.size()>0">
			<form action="CartDeleteAction" id="CartDeleteAction">
				<input type="hidden" id="itemName" name="itemName" value=""/>
				<input type="hidden" id="size" name="size" value=""/>
				<input type="hidden" id="totalPriceSum" name="totalPriceSum" value=""/>
				<table id="item_info_table">
					<thead>
						<tr>
							<th>商品名</th>
							<th>商品写真</th>
							<th>商品価格</th>
							<th>サイズ</th>
							<th>個数</th>
							<th>合計金額</th>
							<th></th>
						</tr>
					</thead>

					<tbody>
						<s:iterator value="cartInfoDTOList">
							<tr>
								<td><s:property value="itemName"/></td>
								<td><img src='<s:property value="image"/>' width="50" height="50"/></td>
								<td><s:property value="itemPrice"/></td>
								<td><s:property value="size"/></td>
								<td><s:property value="count"/></td>
								<td><s:property value="totalPrice"/></td>
								<td><input type= "submit" onclick="delete_button(this)" value= "削除" class="button"></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</form>


			<form action= "CartConfirmAction" id="CartConfirmAction">
				<div id="payInfo">
					<p>合計:<span><s:property value="#session.totalPriceSum"/></span>円</p>
					<!-- hiddenで引き算した合計数と、消した情報のitemNameを送る（後でdbの更新に使う) -->
					<input type="hidden" id="sendTotalPriceSum" name="totalPriceSum" value=""/>

					<input type="radio" name="pay" value="1" checked="checked">現金払い
					<input type="radio" name="pay" value="2">クレジットカード
				</div>
				<input type="submit" onclick="cart_confirm_button(this)" value= "決済確認"class="button"/>
			</form>
			</s:if>

			<s:else>
				<p>カートに商品はありません。</p>
			</s:else>
			<div class="link">
				<div id="link">
					<a href= '<s:url action="ItemListAction"/>'>買い物を続ける</a>
				</div>
				<div>
					<a href= '<s:url action="GoHomeAction"/>'>HOME</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">

		var delete_button = function(submit) {

			var item_info_table = document.getElementById("item_info_table");

			var targetRow = $(submit).parent().parent();

			var colum = $(targetRow).find('td');
			var minus_price = $(targetRow).find('td:nth-child(6)').text();
			var minus_itemName = $(targetRow).find('td:nth-child(1)').text();
			var minus_size = $(targetRow).find('td:nth-child(4)').text();
			var delete_Row = targetRow.index() + 1;

			var pay_info = $("#payInfo").find('span');
			var price = pay_info.text();
			var totalPrice = Number(price) - Number(minus_price);

			var span = pay_info.html(totalPrice);

			var hiddenTotalPriceSum = $('#totalPriceSum').val(totalPrice);
			var hiddenItemName = $('#itemName').val(minus_itemName);
			var hiddenSize = $('#size').val(minus_size);

			item_info_table.deleteRow(delete_Row);


			$('#CartDeleteAction').submit();
		}

		var cart_confirm_button = function(submit) {

			var pay_info = $("#payInfo").find('span');
			var price = pay_info.text();
			var priceNum = Number(price);

			var hiddenTotalPriceSum = $('#sendTotalPriceSum').val(price);


			$('CartConfirmAction').submit();
		}

	</script>
	<div id= "footer">

	</div>

</body>
</html>