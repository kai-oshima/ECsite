<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/header.css">
<link rel="stylesheet" type="text/css" href="./css/itemList.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<title>ALL ITEM</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp" />
	</div>
	<div id="background"></div>
	<div id="main">
		<div id="itemList">
			<s:iterator value="buyItemDTOList">
				<ul id="itemListAll">
					<li><img src='<s:property value="image"/>' width="200" height="200"/></li>
					<li><s:property value="itemName"/></li>
					<li><s:property value="itemPrice"/></li>
					<li style="display:none"><s:property value="releaseDate"/></li>
					<li style="display:none"><s:property value="releaseCompany"/></li>
					<li><input type="button" onclick="detail_button(this)" value="詳細" class="button"/></li>
				</ul>
			</s:iterator>
		</div>

			<s:form action="CartAddAction" id="CartAddAction">
					<input type="button" id="close"  onclick="close_button(this)" value="×"/>
					<div class="img">
						<img id="img" src="" width="400" height="400"/>
					</div>

					<div class="itemList">
						<ul>
							<li></li>
							<li></li>
							<li></li>
							<li></li>
							<li>サイズ:
								<select name= "size">
									<option value="S" selected="selected">S</option>
									<option value="M">M</option>
									<option value="L">L</option>
								</select>
							</li>
							<li>個数：
								<select name= "count">
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</li>
							<li><input type="hidden" name="itemName" value=""/></li>
							<li><input type="hidden" name="price" value=""/></li>
							<li><input type="hidden" name="image" value=""/></li>
							<li><input type="submit" class="button" value="カートに追加"/></li>
						</ul>
					</div>
			</s:form>

		<div class="link">
			<a href= '<s:url action = "GoHomeAction"/>'>HOME</a>
		</div>
	</div>

		<script type="text/javascript">

		var detail_button = function(button) {

			var target = $(button).parent().parent();

			var image = $(target).find('li:nth-child(1)').find('img');
			var imageName = $(image).attr('src');
			var itemName = $(target).find('li:nth-child(2)').text();
			var price = $(target).find('li:nth-child(3)').text();
			var date = $(target).find('li:nth-child(4)').text();
			var company = $(target).find("li:nth-child(5)").text();


			var img = $('#img').attr('src', imageName);
			var Detail1 = $("#CartAddAction li:nth-child(1)").text("商品名："+ itemName);
			var Detail2 = $("#CartAddAction li:nth-child(2)").text("値段：" + price + "円");
			var Detail3 = $("#CartAddAction li:nth-child(3)").text("販売開始日:" + date);
			var Detail4 = $("#CartAddAction li:nth-child(4)").text("デザイン：" + company);

			var hiddenItemName = $('input[name="itemName"]').val(itemName);
			var hiddenPrice = $('input[name="price"]').val(price);
			var hiddenImage = $('input[name="image"]').val(imageName);

			$("#CartAddAction").fadeIn();
			$('#background').fadeIn();
		}


		var close_button = function(button) {

			$("#CartAddAction").fadeOut();
			$('#background').fadeOut();

		}

		</script>
	<div id= "footer">
	</div>
</body>
</html>