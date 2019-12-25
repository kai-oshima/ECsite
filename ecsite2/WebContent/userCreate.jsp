<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/userCreate.css">

<title>CREATE USER</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">
		<div id="error">
			<s:if test="message != ''">
				<s:property value="message"/>
			</s:if>
			<s:if test= "idCheckList.size() > 0">
				<s:iterator value="idCheckList">
					<s:property /><br/>
				</s:iterator>
			</s:if>
			<s:if test="passwordCheckList.size() > 0">
				<s:iterator value="passwordCheckList">
					<s:property /><br/>
				</s:iterator>
			</s:if>
			<s:if test="userNameCheckList.size() > 0">
				<s:iterator value="userNameCheckList">
					<s:property /><br/>
				</s:iterator>
			</s:if>
		</div>
		<div id="contents">
			<h3>ユーザー情報を入力してください</h3>
			<s:form action="UserCreateConfirmAction" id="UserCreateAction" onsubmit="return check();" >
				<table>
					<tr>
						<th>ユーザーID</th>
						<td><s:textfield value="%{loginUserId}" name="loginUserId"/></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><s:password name="loginPassword"/></td>
					</tr>
					<tr>
						<th>ユーザー名</th>
						<td><s:textfield value="%{userName}" name="userName"/></td>
					</tr>
				</table>
				<s:submit value="確認" class="button"/>
			</s:form>
		</div>
	</div>
	<div id= "footer">
	</div>
</body>
</html>