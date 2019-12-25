<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>UserListDeleteConfirm画面</title>

</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>UserListDeleteConfirm</p>
		</div>

		<h3>管理者以外のユーザーを削除します。よろしいですか？</h3>

		<s:form action="UserListDeleteCompleteAction">
			<s:submit value="OK"/>
		</s:form>

		<a href='<s:url action="UserListAction"/>'>キャンセル</a>

	</div>

</body>

</html>