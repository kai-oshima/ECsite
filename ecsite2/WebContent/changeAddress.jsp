<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/mypage.css">
<title>CHANGE ADDRESS</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">
		<h3>任意のユーザー情報を変更してください</h3>
		<s:form action= "ChangeAddressConfirmAction" id="RegistAddress">
				<table id="registForm">
					<tr>
						<th>名字:</th>
						<td><s:textfield name="lastName" class="input" value="%{lastName}"/></td>
					</tr>
					<tr>
						<th>名前:</th>
						<td><s:textfield name="firstName" class="input" value="%{firstName}"/></td>
					</tr>
					<tr>
						<th>メールアドレス:</th>
						<td><s:textfield name="mail" class="input" value="%{mail}"/></td>
					</tr>
					<tr>
						<th>電話番号:</th>
						<td><s:textfield name="phoneNumber" class="input" value="%{phoneNumber}"/></td>
					</tr>
					<tr>
						<th>住所:</th>
						<td><s:textfield name="address" class="input" value="%{address}"/></td>
					</tr>
				</table>
				<div><input type="submit" value="確認"class="button"/></div>
			</s:form>
			<div class="link">
				<a href= '<s:url action="GoHomeAction"/>'>HOME</a>
			</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>