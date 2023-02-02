package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MIMETypeImageResponseServlet
 */
@WebServlet("/response_image.do")
public class MIMETypeImageResponseServlet extends HttpServlet {

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *  1. 응답 객체MIME 타입 설정
		 */
		response.setContentType("image/gif");
		/*
		 *  2. 브라우저와 연결된 출력 스트림 설정
		 */
		OutputStream out = response.getOutputStream();
		ServletContext context = this.getServletContext();
		String imageFilePath = context.getRealPath("/images/androids.gif");
		FileInputStream imageFileIn = new FileInputStream(imageFilePath);
		
		while (true) {
			int readByte = imageFileIn.read();
			if(readByte == -1)break;
			out.write(readByte);
		}
		imageFileIn.close();
		out.close();
		
	}

}
