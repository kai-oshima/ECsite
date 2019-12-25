<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/changePassword.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<title>CHANGE PASSWORD</title>
</head>
<body>
	<div id="header">
	</div>

	<div id= "main">
		<div id="errorPass">
		</div>
		<div id="contents">

			<h3>新しいパスワードを入力してください。</h3>
			<s:form action="PasswordChangeCompleteAction" onsubmit="return check()">
				<table>
					<tr>
						<th>新しいパスワード</th>
						<td><input type="password" id="newPass"/></td>
					</tr>
					<tr>
						<th>パスワード再入力</th>
						<td><input type="password" id="reNewPass"/></td>
					</tr>
				</table>
				<input type="hidden" id="newPassword" name="newPassword"/>
				<s:submit class="button" value="送信"/>
			</s:form>
		</div>

		<div class="link">
			<a href= '<s:url action= "PasswordChangeAction"/>'>戻る</a>
		</div>
	</div>
	<div id= "footer">
	</div>

	<script type="text/javascript">
	function check() {

		var newPass = $("#newPass").val();
		var reNewPass = $("#reNewPass").val();

		if(newPass == reNewPass) {

			var newPassword = $("#newPassword").val(reNewPass);

			return true;
		} else {

			var errorPass = $("#errorPass").html("<p>入力したパスワードが一致しません。再入力してください。</p>");

			return false;
		}
	};
	</script>
</body>
</html>