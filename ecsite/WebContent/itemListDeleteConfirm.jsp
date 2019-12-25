<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>ItemListDeleteConfirm画面</title>

</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>ItemListDeleteConfirm</p>
		</div>

		<h3>全ての商品を削除します。よろしいですか？</h3>

		<s:form action="ItemListDeleteCompleteAction">
			<s:submit value="OK"/>
		</s:form>

		<a href='<s:url action="ItemListAction"/>'>キャンセル</a>

	</div>

</body>

</html>