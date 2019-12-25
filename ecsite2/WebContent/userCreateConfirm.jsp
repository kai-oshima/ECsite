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
		<div id="contents">
			<h3>ユーザー情報を確認してください</h3>
			<s:form action="UserCreateCompleteAction" id="UserCreateComplete">
				<table>
					<tr>
						<th>ユーザーID</th>
						<td><s:property value="#session.login_id"/></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><s:property value="#session.login_pass"/></td>
					</tr>
					<tr>
						<th>ユーザー名</th>
						<td><s:property value="#session.user_name"/></td>
					</tr>
				</table>
				<div><input type="submit" value="完了" class="button"/></div>
			</s:form>
		</div>

		<div id="link">
		</div>
	</div>
	<div id="footer">
	</div>
</body>
</html>