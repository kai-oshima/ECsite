<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/mypage.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<title>SELECT ADDRESS</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">
		<h3>お届け先を選択してください</h3>
		<form action="BuyItemCompleteAction">
			<table>
					<tr>
						<th></th>
						<th>姓</th>
						<th>名</th>
						<th>メールアドレス</th>
						<th>電話番号</th>
						<th>住所</th>
					</tr>
					<s:iterator value="userAddressDTO">
					<tr>
						<td><input type="checkbox" class="checkBox"/></td>
						<td><s:property value="lastName"/></td>
						<td><s:property value="firstName"/></td>
						<td><s:property value="mail"/></td>
						<td><s:property value="phoneNumber"/></td>
						<td><s:property value="address"/></td>
					</tr>
					</s:iterator>
				</table>
				<input type="hidden" value="" name="firstName"/>
				<input type="hidden" value="" name="lastName"/>
				<input type="hidden" value="" name="mail"/>
				<input type="hidden" value="" name="phoneNumber"/>
				<input type="hidden" value="" name="address"/>
				<input type="submit" value="購入" class="button" disabled="disabled"/>
		</form>
		<div class="link">
			<a href= '<s:url action = "GoHomeAction"/>'>HOME</a>
		</div>
	</div>
	<div id="footer">
	</div>
	<script type="text/javascript">
		$('.checkBox').on("click", function(){

			if($(this).prop('checked',true)) {
				$('.checkBox').prop('checked', false);
				$(this).prop('checked', true);
				$('input[type="submit"]').prop('disabled', false);
				var radio = $('.checkBox:checked').parent().parent();
				var lastName = $(radio).find('td:nth-child(2)').text();
				var firstName = $(radio).find('td:nth-child(3)').text();
				var mail = $(radio).find('td:nth-child(4)').text();
				var phoneNumber = $(radio).find('td:nth-child(5)').text();
				var address = $(radio).find('td:nth-child(6)').text();

				var firstName2 = $('input[name="firstName"]').val(firstName);
				var lastName2 = $('input[name="lastName"]').val(lastName);
				var mail2 = $('input[name="mail"]').val(mail);
				var phoneNumber2 = $('input[name="phoneNumber"]').val(phoneNumber);
				var address2 = $('input[name="address"]').val(address);
			} else if ($(this).prop('checked',false)){
				$('.checkBox').prop('checked', false);
				$('input[type="submit"]').prop('disabled', true);
			}
		})
	</script>
</body>
</html>