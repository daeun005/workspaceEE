<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("product_list.jsp");
		return;
	}

	String cart_qty = request.getParameter("cart_qty");
	String p_no = request.getParameter("p_no");
	
	CartService cartService = new CartService();


	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<div style="width:180px ;margin:0 auto;padding: 0px">
	<img src="http://pics.gmkt.kr/pc/ko/item/vip/img_cartplus_n.png" width="25px" height="25px"
		alt="장바구니이미지">
	<strong>상품을 담았습니다.</strong>
	<div  style="margin-top: 5px;margin-left: auto;margin-right: auto;padding: 5px" >
		<div  style="margin: 0 auto;padding: 0px 20px">
			<button onclick="window.close();opener.location.reload();" style="font-size: 6pt">
				계속 쇼핑
			</button>
			<!-- 
			<button onclick="window.close();opener.location.href='cart_view_select_update_qyt_image.jsp';">
				장바구니로
			</button> 
			-->
			<button onclick="window.close();opener.location.href='cart_view.jsp';" style="font-size: 6pt">
				장바구니
			</button>
		</div>
	</div>
</div>
</body>
</html>
