<%@ page language= "java" contentType= "text/html; charset=UTF-8"
	pageEncoding= "UTF-8"%>
<%@ taglib prefix= "s" uri= "/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset= "UTF-8">
<link rel="stylesheet" type="text/css" href= "./css/style.css">

<title>ItemCreateConfirm画面</title>
</head>

<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>ItemCreateConfirm</p>
		</div>

		<table>
		<s:form action="itemCreateCompleteAction">
		<tr>
			<td><label>商品名:</label></td>
			<td><s:property value="session.item_name"/></td>
		</tr>
		<tr>
			<td><label>金額:</label></td>
			<td><s:property value="session.item_price"/></td>
		</tr>
		<tr>
			<td><label>在庫:</label></td>
			<td><s:property value="session.item_stock"/></td>
		</tr>
		<tr>
			<td><s:submit value="完了"/></td>
		</tr>
		</s:form>
		</table>

	</div>
</body>
</html>