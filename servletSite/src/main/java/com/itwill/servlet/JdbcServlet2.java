package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

@WebServlet("/Jdbc2.do")
public class JdbcServlet2 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			AddressService addressService = new AddressService();
			List<Address> addressrist = addressService.findAll();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"com.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<br>");
		out.println("<p align=center><font size=5 color=#0000FF>◈◈ JDBC 테스트 1◈◈</font><br>");
		out.println(
				"<table width=80% align=center border=1 cellspacing=0 bordercolordark=white bordercolorlight=#ADADAD>");
		out.println("<tr bgcolor=#000000 class=t1>");
		out.println("<td align=center height=20 width=5%><font color=#FFFFFF>번호</font></td>");
		out.println("<td align=center height=20 width=25%><font color=#FFFFFF>이름</font></td>");
		out.println("<td align=center height=20 width=25%><font color=#FFFFFF>전화번호</font></td>");
		out.println("<td align=center height=20 width=45%><font color=#FFFFFF>주소</font></td>");
		out.println("</tr>");
		
		for(Address address : addressrist) {
		/***address start***/
			out.println("<tr class=t1>");
			out.println("<td align=center width=5% height=20>"+address.getNo()+"</td>");
			out.println("<td align=center width=25% height=20>"+address.getName()+"</td>");
			out.println("<td align=center width=25% height=20>"+address.getPhone()+"</td>");
			out.println("<td align=center width=45% height=20>"+address.getAddress()+"</td>");
			out.println("</tr>");
		/***address end***/
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html> ");
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}