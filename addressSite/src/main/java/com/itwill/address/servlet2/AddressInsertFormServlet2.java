package com.itwill.address.servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddressInsertFormServlet
 */
@WebServlet("/address_insert_form2.do")
public class AddressInsertFormServlet2 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>[주소록쓰기폼]</h1>");
		out.println("<hr>");
		
		out.println("	<div>");
		out.println("		<a href='address_main2.do'>[메인]</a>");
		out.println("		<a href='address_list2.do'>[주소록리스트]</a>");
		out.println("	</div>");
		
		out.println("	<form method='post' action='address_insert_action2.do'>");
		
		out.println("		이름----<input type='text' name='name'><br> ");
		out.println("		전화번호<input type='text' name='phone'><br> ");
		out.println("		주소----<input type='text' name='address'><br><br>");
		
		out.println("		<input type='submit' value='주소록쓰기'>");
		out.println("		<input type='reset' value='주소록쓰기폼지우기'>");
		
		out.println("	</form>");
		out.println("</body>");
		out.println("</html>");
	}

}