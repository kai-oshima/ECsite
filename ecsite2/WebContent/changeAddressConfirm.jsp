<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/mypage.css">

<title>CHANGE ADRESS</title>
</head>
<body>
	<div id="header">
	</div>

	<div id="main">
		<div id="contents">
			<h3>宛先情報を確認してください。変更がある場合は変更してください。</h3>
			<s:form action="ChangeAddressCompleteAction" id="RegistAdressComplete">
				<table>
					<tr>
						<th>名字</th>
						<td><s:property value="#session.new_last_name"/></td>
					</tr>
					<tr>
						<th>名前</th>
						<td><s:property value="#session.new_first_name"/></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><s:property value="#session.new_mail"/></td>
					</tr>
					<tr>
						<th>電話番号</th>
						<td><s:property value="#session.new_phone"/></td>
					</tr>
					<tr>
						<th>住所</th>
						<td><s:property value="#session.new_address"/></td>
					</tr>
				</table>
				<div><input type="submit" value="登録"  class="button"/></div>
			</s:form>
		</div>
		<div class="link">
			<a href='<s:url action="ChangeAddressAction"/>'>修正する</a>
		</div>
	</div>
	<div id= "footer">
	</div>
</body>
</html>