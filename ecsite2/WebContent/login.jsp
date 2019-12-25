<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/login.css">

<title>LOGIN</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id= "main">

		<div id="error">
		<s:if test ="Message != ''">
			<s:property value="message" escape="false"/>
		</s:if>
		</div>

		<div id="contents">
			<h3>商品を購入する際はログインをお願いします。</h3><br/>
			<s:form action="LoginConfirmAction">
				<s:if test="#session.save_user_id == true">
					<table>
						<tr>
							<th>ユーザーID</th>
							<td><s:textfield name="loginUserId" value="%{#session.login_user_id}"/></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><s:password name="loginPassword"/></td>
						</tr>
					</table>
					<div class="checkBox"><input type="checkbox" value="true" name="saveUserId" checked="checked"/>ユーザーID保存</div>
				</s:if>
				<s:else>
					<table>
						<tr>
							<th>ユーザーID</th>
							<td><s:textfield name="loginUserId"/></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><s:password name="loginPassword"/></td>
						</tr>
					</table>
					<div class="checkBox"><input type="checkbox" value="true" name="saveUserId"/>ユーザーID保存</div>
				</s:else>
				<div><s:submit value="LOGIN" class="button"/></div>
			</s:form>
		</div>

		<div class="link">
			<p>新規ユーザー登録は
			<a href='<s:url action="UserCreateAction"/>'>こちら</a></p>

			<p>パスワードを変更したい場合は
			<a href='<s:url action="PasswordChangeAction"/>'>こちら</a></p>

			<a href='<s:url action="GoHomeAction"/>'>HOME</a>
		</div>

	</div>

	<div id="footer">
	</div>
</body>
</html>