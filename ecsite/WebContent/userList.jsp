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

		<h3>登録ユーザーは以下になります。</h3>
		<table border="1">
		<tr>
			<th>ユーザーID</th>
			<th>パスワード</th>
			<th>ユーザー名</th>
			<th></th>
		</tr>
		<s:iterator value="userListDTO">
		<tr>
			<td><s:property value="loginUserId"/></td>
			<td><s:property value="loginPassword"/></td>
			<td><s:property value="userName"/></td>
			<td>
				<a href= '<s:url action="UserDetailAction">
					<s:param name="id" value="%{id}"/>
					</s:url>'>詳細</a>
			</td>
		</tr>
		</s:iterator>
		</table>

		<s:form action="UserListDeleteConfirmAction">
			<s:submit value="削除"/>
		</s:form>
		<div>

		</div>
	</div>



</body>

</html>