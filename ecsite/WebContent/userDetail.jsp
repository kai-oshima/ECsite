<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>UserList画面</title>

</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>

		<div>
				<h3>商品の詳細は以下になります</h3>
				<table border="1">
				<tr>
					<th>ユーザーID</th>
					<th>ログインID</th>
					<th>パスワード</th>
					<th>ユーザー名</th>
					<th>登録日</th>
				</tr>
				<tr>
					<td><s:property value="session.Id"/></td>
					<td><s:property value="session.userId"/></td>
					<td><s:property value="session.userPass"/></td>
					<td><s:property value="session.userName"/></td>
					<td><s:property value="session.userDate"/></td>
				</tr>
				</table>

				<s:form action ="UserDeleteConfirmAction">
					<s:submit value="削除"/>
				</s:form>
		</div>




		</div>



</body>

</html>