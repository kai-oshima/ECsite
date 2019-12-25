<%@ page language= "java" contentType= "text/html; charset=UTF-8"
	pageEncoding= "UTF-8"%>
<%@ taglib prefix= "s" uri= "/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset= "UTF-8">
<link rel="stylesheet" type="text/css" href= "./css/style.css">

<title>BuyItem画面</title>
</head>

<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div >
			<s:if test="errorMessage != ''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<s:form action="BuyItemAction">
			<table>
			<tr>
				<td><span>商品名</span></td>
				<td><s:property value="session.buyItem_name"/></td>
			</tr>
			<tr>
				<td><span>商品個数</span></td>
				<td><select name= "count">
					<option value="1" selected= "selected">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					</select></td>
			</tr>
			<tr>
				<td><span>支払方法</span></td>
				<td>
					<input type="radio" name="pay" value="1" checked="checked">現金払い
					<input type="radio" name="pay" value="2">クレジットカード
				</td>
			</tr>
			<tr>
				<td><s:submit value="購入"/></td>
			</tr>
			<s:property value="session.test"/>
			</table>
			</s:form>
			<div>
				<p>前画面に戻る場合は<a href= '<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページは<a href= '<s:url action="MyPageAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
</body>
</html>