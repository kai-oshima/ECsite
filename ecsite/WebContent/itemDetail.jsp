<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset = "utf-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>ItemList画面</title>

</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>ItemList</p>
		</div>

		<div>
				<h3>商品の詳細は以下になります</h3>
				<table border="1">
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>値段</th>
					<th>在庫</th>
					<th>登録日</th>
				</tr>
				<tr>
					<td><s:property value="session.id"/></td>
					<td><s:property value="session.itemName"/></td>
					<td><s:property value="session.itemPrice"/><span>円</span></td>
					<td><s:property value="session.itemStock"/><span>個</span></td>
					<td><s:property value="session.date"/></td>
				</tr>
				</table>

				<s:form action ="ItemDeleteConfirmAction">
					<s:submit value="削除"/>
				</s:form>
		</div>




		</div>



</body>

</html>