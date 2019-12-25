<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/changePassword.css">

<title>CHANGE PASSWORD</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="error">
		<s:if test="Message != ''">
			<s:property value="message" escape="false"/>
		</s:if>
		</div>

		<div id="contents">

			<s:if test="errorMessage != ''">
				<s:property value="errorMessage"/>
			</s:if>

			<h2>現在のユーザー情報を入力してください。</h2>
			<s:form action= "PasswordChangeConfirmAction">
				<table>
					<tr>
						<th>ユーザーID</th>
						<td><s:textfield name="loginUserId"/></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><s:password name="loginPassword"/></td>
					</tr>
					<tr>
						<th>ユーザー名</th>
						<td><s:textfield name="loginUserName"/></td>
					</tr>
				</table>
				<div><s:submit value="変更画面" class="button"/></div>
			</s:form>
		</div>

		<div class="link">
			<a href='<s:url action= "GoHomeAction"/>'>HOME</a>
		</div>

	</div>

	<div id= "footer">
	</div>
</body>
</html>