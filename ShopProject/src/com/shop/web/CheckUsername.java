package com.shop.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.service.RegisterService;

public class CheckUsername extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String userName = request.getParameter("username");
		
		RegisterService service = new RegisterService();
		boolean bool = service.queryUserNameIsExist(userName);
		response.getWriter().write("{\"isExist\":"+bool+"}"); //带参数的不要加\转义
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}