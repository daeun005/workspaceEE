package com.itwill.shoecream.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.product.Product;

public class CartDao {
	private DataSource dataSource;
	public CartDao() throws Exception{
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/jdbc.properties"));
		/*** Apache DataSource ***/
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		dataSource = basicDataSource;
	}

	/* countByProductNo > 카트에 존재하는 제품인지 확인 > 존재 시 업데이트로
	 * insert > 새상품담기
	 * delete > 상품 전체 삭제 / 한가지 삭제
	 * update > [이미 카트에 존재하는 상품수량 변경] 상품페이지에서  / 장바구니에서
	 * list >  로그인한 유저의 카트에 담긴 상품 리스트
	 */
	
	// 로그인 한 유저의 카트에 상품 존재여부 확인
	public int  countByProductNo(String sUserId,int p_no) throws Exception{
		int count=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_COUNT_BY_USERID_PRODUCT_NO);
			pstmt.setString(1, sUserId);
			pstmt.setInt(2, p_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
			
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return count;
	}
	
	public int insertCart(Cart cart) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_INSERT);
			pstmt.setString(1,cart.getUser_id());
			pstmt.setInt(2,cart.getCart_qty());
			pstmt.setInt(3,cart.getProduct().getP_no());
			insertRowCount = pstmt.executeUpdate();
			
			}finally {
			if(con!=null) {
				con.close();
			}
		}
		return  insertRowCount;
	}
	
	// 유저 카트 상품 전체 삭제
	public int deleteCartByUserId (String sUserId) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_USERID);
			pstmt.setString(1,sUserId);
			deleteRowCount = pstmt.executeUpdate();
			
			}finally {
			if(con!=null) {
				con.close();
			}
		}
		return  deleteRowCount;
	}
	
	// 유저 카트 상품 선택 삭제
	
	public int deleteCartByCartNo (int cart_no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_CART_NO);
			pstmt.setInt(1,cart_no);
			deleteRowCount = pstmt.executeUpdate();
			}finally {
			if(con!=null) {
				con.close();
			}
		}
		return  deleteRowCount;
	}
	
	// 상품 상세보기에서 업데이트
	public int updateCartByProductNo (Cart cart) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_PRODUCT_NO_USERID);
			pstmt.setInt(1,cart.getCart_qty());
			pstmt.setString(2,cart.getUser_id());
			pstmt.setInt(3,cart.getProduct().getP_no());
			rowCount = pstmt.executeUpdate();
			}finally {
			if(con!=null) {
				con.close();
			}
		}
		return  rowCount;
	}
	
	//장바구니에서 업데이트
	public int updateCartByCartNo (Cart cart) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_UPDATE_BY_CART_NO);
			pstmt.setInt(1,cart.getCart_qty());
			pstmt.setInt(2,cart.getCart_no());
			rowCount = pstmt.executeUpdate();
			}finally {
			if(con!=null) {
				con.close();
			}
		}
		return  rowCount;
	}
	
	// 로그인한 유저의 카트에 담긴 상품 리스트
	
	public List<Cart> findCartByUserId (String user_Id) throws Exception {
		List<Cart> cartList = new ArrayList<Cart>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = dataSource.getConnection();
		pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_USER_ID);
		pstmt.setString(1,user_Id);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			cartList.add(new Cart(rs.getInt("cart_no"),
								  rs.getString("user_Id"),
								  rs.getInt("cart_qty"),
								  new Product(rs.getInt("p_no"),
											  rs.getString("p_name"),
							    		      rs.getInt("p_price"),
							    		      rs.getString("p_image"),
							    		      rs.getString("p_desc"), 
							    		      rs.getInt("p_click_count"))
								    		//rs.getInt("category_no"))
								)
					);
		}
		return cartList;
	}
	
	public Cart findCartByCartNo(int cart_no)throws Exception {
		Cart cart=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		con=dataSource.getConnection();
		pstmt=con.prepareStatement(CartSQL.CART_SELECT_BY_CART_NO);
		pstmt.setInt(1,cart_no);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			cart=new Cart(rs.getInt("cart_no"),
						 rs.getString("user_Id"),
						 rs.getInt("cart_qty"),
						 new Product(rs.getInt("p_no"),
								rs.getString("p_name"),
								rs.getInt("p_price"),
								rs.getString("p_image"),
								rs.getString("p_desc"),
								rs.getInt("p_click_count"))
				    			//rs.getInt("category_no"))
					 );
		}
		return cart;
	}
	
}
