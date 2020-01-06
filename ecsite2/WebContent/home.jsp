<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset ="utf-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/home.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<title>HOME</title>
</head>

<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="main">
		<img id="img" src="./image/tshirt2.jpg" id="img2"/>
	</div>
	<div id="footer">
	</div>
	<script type="text/javascript">
		$(function() {
			$('img').hover(function() {
				$(this).attr('src', './image/tshirt1.jpg');
			}, function() {
				$(this).attr('src', './image/tshirt2.jpg');
			});
		});
	</script>
</body>
</html>