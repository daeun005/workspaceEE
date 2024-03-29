	package com.itwill.address.servlet2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itwill.address.AddressService;
@WebServlet("/address_delete_action2.do")
public class AddressDeleteActionServlet2 extends HttpServlet {
	/*
	 * POST 방식으로 요청시 삭제(O)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/*
			 요청라인
			 POST /addressSite/address_delete_action.do HTTP/1.1
			 요청헤더
			 요청바디
			 no=1
			 */
			/*
			 * 0.요청객체encoding설정
			 * 1.파라메타받기
			 * 2.AddressService객체생성
			 * 3.AddressService.deleteByNo()메쏘드실행
			 * 4.클라이언트로 redirection 응답--> address_list.do 로 redirection
			 */
			
		    // 0.요청객체encoding설정
			response.setCharacterEncoding("UTF-8");
			// 1.파라메타받기
			String noStr = request.getParameter("no");
			
			// 2.AddressService객체생성
			AddressService addressService = new AddressService();
			
			// 3.AddressService.deleteByNo()메쏘드실행
			addressService.delete(Integer.parseInt(noStr));
			
			
			// 4.클라이언트로 redirection 응답--> address_list.do 로 redirection
			response.sendRedirect("address_list2.do");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("address_error.html");
		}
	}
	/*
	 * GET 방식으로 요청시 address_list.do로 redirect
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("address_list.do");
	}
}