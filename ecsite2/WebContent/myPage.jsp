<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/mypage.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<title>MY PAGE</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">
		<s:if test="message != ''">
			<p><s:property value="message"/></p>
		</s:if>
		<s:else>
			<form action="DeleteItemAction">
			<table>
				<tr>
					<th>商品名</th>
					<th>商品写真</th>
					<th>商品価格</th>
					<th>サイズ</th>
					<th>個数</th>
					<th>支払方法</th>
					<th>宛先氏名</th>
					<th>宛先住所</th>
					<th>購入日時</th>
					<th>合計金額</th>
				</tr>
				<s:iterator value="myPageDTOList">
					<tr>
						<td><s:property value="itemName"/></td>
						<td><img src='<s:property value="image"/>' width="40" height="40"/></td>
						<td><s:property value="itemPrice"/></td>
						<td><s:property value="size"/></td>
						<td><s:property value="count"/></td>
						<td><s:property value="pay"/></td>
						<td><s:property value="lastName"/><s:property value="firstName"/></td>
						<td><s:property value="address"/></td>
						<td><s:property value="insertDate"/></td>
						<td><s:property value="totalPrice"/></td>
					</tr>
				</s:iterator>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><s:property value="#session.totalPriceSum"/></td>
				</tr>
			</table>
			<input type="submit" value="履歴削除" class="button"/>
		</form>
		<form action="MyPageAddressAction">
			<input type="submit" value="ユーザーアドレス一覧" class="button"/>
		</form>
		</s:else>
		<div class="link"><a href= '<s:url action = "GoHomeAction"/>'>HOME</a></div>
	</div>

	<div id="footer">
	</div>
</body>
</html>