package com.itwill.shoecream.cart;

import com.itwill.shop.product.Product;

public class Cart {

	/*
			이름       널?       유형            
			-------- -------- ------------- 
			CART_NO  NOT NULL NUMBER(10)    
			USERID            VARCHAR2(100) 
			P_NO              NUMBER(10)    
			CART_QTY          NUMBER(10)    
	*/
	
	private int cart_no;
	private int cart_qty;
	
	/***fk***/
	private String user_id;
	private Product product;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int cart_no,  String user_id, int cart_qty, Product product) {
		super();
		this.cart_no = cart_no;
		this.user_id = user_id;
		this.cart_qty = cart_qty;
		this.product = product;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getCart_qty() {
		return cart_qty;
	}

	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", cart_qty=" + cart_qty + ", user_Id=" + user_id + ", product=" + product
				+ "]";
	}

	
	
}
