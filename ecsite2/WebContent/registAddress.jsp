<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel= "stylesheet" type="text/css" href="./css/header.css">
<link rel= "stylesheet" type="text/css" href="./css/mypage.css">

<title>REGIST ADDRESS</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">

		<div id="error">
			<s:if test="firstNameCheck.size() > 0">
				<s:iterator value = "firstNameCheck">
					 <div><s:property /></div>
				</s:iterator>
			</s:if>
			<s:if test="lastNameCheck.size() > 0">
				<s:iterator value = "lastNameCheck">
					 <div><s:property /></div>
				</s:iterator>
			</s:if>
			<s:if test="phoneCheck.size() > 0">
				<s:iterator value = "phoneCheck">
					 <div><s:property /></div>
				</s:iterator>
			</s:if>
			<s:if test="addressCheck.size() > 0">
				<s:iterator value = "addressCheck">
					 <div><s:property /></div>
				</s:iterator>
			</s:if>
			<s:if test="mailCheck.size() > 0">
				<s:iterator value = "mailCheck">
					 <div><s:property /></div>
				</s:iterator>
			</s:if>
		</div>
		<div id="contents">
			<h3>宛先情報を入力してください</h3>
			<s:form action= "RegistAddressConfirmAction" id="RegistAddress">
				<table id="registForm">
					<tr>
						<th>名字:</th>
						<td><s:textfield name="lastName" class="input" value="%{#session.last_name}"/></td>
					</tr>
					<tr>
						<th>名前:</th>
						<td><s:textfield name="firstName" class="input" value="%{#session.first_name}"/></td>
					</tr>
					<tr>
						<th>メールアドレス:</th>
						<td><s:textfield name="mail" class="input" value="%{#session.mail}"/></td>
					</tr>
					<tr>
						<th>電話番号:</th>
						<td><s:textfield name="phone" class="input" value="%{#session.phone}"/></td>
					</tr>
					<tr>
						<th>住所:</th>
						<td><s:textfield name="address" class="input" value="%{#session.address}"/></td>
					</tr>
				</table>
				<div><input type="submit" value="確認"class="button"/></div>
			</s:form>
		</div>
		<div class="link">
			<a href= '<s:url action="GoHomeAction"/>'>HOME</a>
		</div>
	</div>
	<div id= "footer">
	</div>
</body>
</html>