package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search.do")
public class SearchServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		/*
		 *  클라이언트 요청 URL
		 *  -http://192.168.15.6/servletSite/search.do?searchkeyword=java
		 *  -http://192.168.15.6/servletSite/search.do?searchkeyword=
		 *  -http://192.168.15.6/servletSite/search.do
		 */
		String searchkeyword = request.getParameter("searchkeyword");
		if(searchkeyword == null || searchkeyword.equals("")) {
			/*
			 *  searchkeyword 가 null -> search.do
			 *  searchkeyword 가 ""   -> searchkeyword=
			 * 
			 */
			out.println("검색어를 입력해 주세요.<br/>");
			out.println("<a href = '05-00.search_form.html' > 검색페이지 </a>");			
			return;
		}
		/*
		 * 2.검색업무실행 -> Service 객체 사용
		 */
		/*
		 * 3.클라이언트로 검색결과 전송(HTML)
		 */
		out.println("<h1>" + searchkeyword + " 검색결과 </h1>");
		out.println("<ol>");
		
		int searchResultNo = (int)(Math.random()*10);
		for (int i = 0; i < searchResultNo; i++) {
			out.print("<li>" + searchkeyword + "검색결과</li>");
		}
		out.println("</ol>");
		out.println("<a href = '05-00.search_form.html' >검색페이지</a>");
	}

}
