<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>UserDeleteConfirm</title>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>UserDeleteConfirm</p>
		</div>

		<div>
			<h3>ログインID[<s:property value= "session.Id"/>]のユーザーを削除します。よろしいですか？</h3>

			<s:form action= "UserDeleteCompleteAction">
				<s:submit value="OK"/>
			</s:form>
			<a href= '<s:url action= "UserDetailAction"/>'>キャンセル</a>
		</div>


	</div>


</body>
</html>