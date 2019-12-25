<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset ="utf-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/cart.css">

<title>CART COMPLETE</title>
</head>

<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>

	<div id="main">
		<div id="contents">
			<h3>購入が完了しました。</h3>
			<div class="link">
				<a href='<s:url action="GoHomeAction"/>'>HOME</a>
			</div>
		</div>
	</div>
	<div id="footer">

	</div>

</body>
</html>