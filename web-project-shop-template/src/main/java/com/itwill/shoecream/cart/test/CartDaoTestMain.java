package com.itwill.shoecream.cart.test;

import com.itwill.shoecream.cart.Cart;
import com.itwill.shoecream.cart.CartDao;
import com.itwill.shop.product.ProductDao;

public class CartDaoTestMain {
	
	public static void main(String[] args) throws Exception{
		CartDao cartDao = new CartDao();
		ProductDao productDao = new ProductDao();
		
		System.out.println("1.countByProductNo");
		System.out.println(cartDao.countByProductNo("cream1", 50));
		
		System.out.println("2.insertCart");
		System.out.println(cartDao.insertCart(new Cart(0, "cream2" , 2, productDao.findByPrimaryKey(1))));
		

		System.out.println("3.update");
		Cart  updateCartByProductNo = new Cart(0,  "cream2", 5, productDao.findByPrimaryKey(1));
		System.out.println(cartDao.updateCartByProductNo(updateCartByProductNo));
		

		System.out.println("4.updateByCartNo");
		System.out.println(cartDao.updateCartByCartNo(new Cart(0,"cream2",2 ,productDao.findByPrimaryKey(1))));
		
		System.out.println("4. deleteByUserId");
		System.out.println(cartDao.deleteCartByUserId("cream2"));
		
		System.out.println("4. deleteByCartNo-");
		System.out.println(cartDao.deleteCartByCartNo(1));

		System.out.println("7. findByUserId");
		System.out.println(cartDao.findCartByUserId("cream1"));

		System.out.println("8. findByCartNo");
		System.out.println(cartDao.findCartByCartNo(1));
		
		
	}
	
	

}
