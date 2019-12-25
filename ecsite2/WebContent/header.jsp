<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">

<title>MY PAGE</title>
</head>
<body>
	<div id="header">
<!-- 		<img src=""/> -->
		<div id= "header_menu">
			<s:if test= "#session.logined == null">
				<a class="menu-button" href='<s:url action="LoginAction"/>'>LOGIN</a>
			</s:if>
			<s:else>
				<a class="menu-button" href='<s:url action="LogoutAction"/>'>LOGOUT</a>
			</s:else>
			<a class="menu-button" href='<s:url action="GoMyPageAction"/>'>MY PAGE</a>
			<a class="menu-button" href='<s:url action="CartAction"/>'>CART</a>
			<a class="menu-button" href='<s:url action="ItemListAction"/>'>ITEM LIST</a>
		</div>
	</div>
</body>
</html>