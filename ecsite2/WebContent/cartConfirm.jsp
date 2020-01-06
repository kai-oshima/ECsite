<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset ="utf-8">
<link rel="stylesheet" type= "text/css" href="./css/cart.css">
<link rel="stylesheet" type="text/css" href="./css/header.css">

<title>CART CONFIRM</title>
</head>

<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="main">
		<div id="contents">
			<s:form action="CartCompleteAction">
				<table>
					<thead>
						<tr>
							<th>商品名</th>
							<th>商品写真</th>
							<th>商品価格</th>
							<th>サイズ</th>
							<th>個数</th>
							<th>合計金額</th>
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
							</tr>
						</s:iterator>
					</tbody>
				</table>

				<div id="payment">
					<p>支払方法:<span><s:property value="#session.payment"/></span></p>
				</div>
				<div id="payInfo">
					<p>合計:<span><s:property value="#session.totalPriceSum"/></span>円</p>
				</div>
				<input type="submit" value="宛先情報選択へ" class="button"/>
			</s:form>
		<div class="link">
			<a href='<s:url action="CartAction"/>'>戻る</a>
		</div>
		</div>
	</div>

	<div id="footer">

	</div>

</body>
</html>