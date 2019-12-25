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
			<s:if test="itemListDTO == null">
				<h3>登録された商品はありません。</h3>
			</s:if>


			<s:elseif test="message == null">
				<h3>登録された商品は以下になります。</h3>
				<table border="1">
				<tr>
					<th>商品名</th>
					<th>値段</th>
					<th>在庫</th>
					<th>登録日</th>
					<th></th>
				</tr>
				<s:iterator value="itemListDTO">
				<tr>
					<td><s:property value="itemName"/></td>
					<td><s:property value="itemPrice"/><span>円</span></td>
					<td><s:property value="itemStock"/><span>個</span></td>
					<td><s:property value="insert_date"/></td>



					<!-- paramタグをaタグに入れてidの値をActionに送信する -->
					<td>
						<a href= '<s:url action="ItemDetailAction">
							<s:param name="id" value="%{id}"/>
							</s:url>'>詳細</a>
					</td>
				</tr>
				</s:iterator>
				</table>
				<s:form action="itemListDeleteConfirmAction">
					<s:submit value="削除"/>
				</s:form>
			</s:elseif>
		</div>

		</div>



</body>

</html>