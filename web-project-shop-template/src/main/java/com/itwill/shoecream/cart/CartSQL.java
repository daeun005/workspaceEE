package com.itwill.shoecream.cart;

public class CartSQL {
	
	/* countByProductNo > 카트에 존재하는 제품인지 확인 > 존재 시 업데이트로
	 * insert > 새상품담기
	 * delete > 상품 전체 삭제 / 한가지 삭제
	 * update > [이미 카트에 존재하는 상품수량 변경] 상품페이지에서  / 장바구니에서
	 * list >  로그인한 유저의 카트에 담긴 상품 리스트
	 */
	
	public static final String CART_COUNT_BY_USERID_PRODUCT_NO = "select count(*) p_count from cart c join userinfo u on c.user_id = u.user_id where u.user_id = ? and c.p_no=?";
	public static final String CART_INSERT = "insert into cart(cart_no,user_id,cart_qty,p_no) values(cart_cart_no_SEQ.nextval,?,?,?)";
	
	public static final String CART_DELETE_BY_USERID = "delete from cart where user_id = ?";
	public static final String CART_DELETE_BY_CART_NO = "delete from cart where cart_no = ?";
	
	public static final String CART_UPDATE_BY_CART_NO = "update cart set car_qty = ? where cart_no = ? ";
	public static final String CART_UPDATE_BY_PRODUCT_NO_USERID ="update cart set cart_qty = cart_qty+? where user_id = ? and p_no = ?"; 
	
	public static final String CART_SELECT_BY_CART_NO = "select * from cart c join product p on c.p_no = p.p_no where cart_no = ?";
	public static final String CART_SELECT_BY_USER_ID = "select * from cart c join userinfo u on c.user_id = u.user_id join product p on c.p_no = p.p_no where u.user_id = ?"; 
}
