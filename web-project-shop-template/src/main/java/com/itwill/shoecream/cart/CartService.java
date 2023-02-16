package com.itwill.shoecream.cart;

import java.util.List;

public class CartService {
	private CartDao cartDao;
	
	public CartService () throws Exception{
		cartDao = new CartDao();
	}
	
	// insert or update 
	public int addCart(Cart cart) throws Exception{
		if(cartDao.countByProductNo(cart.getUser_id(), cart.getProduct().getP_no()) > 0) {
			return cartDao.updateCartByProductNo(cart);
		}else {
			return cartDao.insertCart(cart);
		}
	}
	// update 카트에서 변경 / 상세보기에서 변경 
	public int updateCarBytNo(Cart cart) throws Exception {
		return cartDao.updateCartByCartNo(cart);
	}
	
	public int updateCartByProductNo(Cart cart) throws Exception {
		return cartDao.updateCartByProductNo(cart);
	}
	
	// delete 상품하나 / 전체 삭제 
	public int deleteCartItemByCartNo (int cart_no) throws Exception {
		return cartDao.deleteCartByCartNo(cart_no);
	}
	
	public int deleteCart (String sUserId) throws Exception {
		return cartDao.deleteCartByUserId(sUserId);
	}
	
	// 카트리스트 보기 
	public List<Cart> findbyAll (String sUserId) throws Exception {
		return cartDao.findCartByUserId(sUserId);
	}

	public Cart findbyCartno (int cart_no) throws Exception {
		return cartDao.findCartByCartNo(cart_no);
	}
}
