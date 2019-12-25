<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>ItemDeleteConfirm画面</title>

</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>ItemDeleteConfirm</p>
		</div>
			<h3>商品ID[<s:property value="session.id"/>]の商品を削除します。よろしいですか？</h3>

			<s:form action="ItemDeleteCompleteAction">
				<s:submit value="OK"/>
			</s:form>

			<a href= '<s:url action="ItemDetailAction"/>'>キャンセル</a>
		</div>



</body>

</html>