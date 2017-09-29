package com.shop.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.shop.domain.RegisterUser;
import com.shop.service.RegisterService;

public class RegisterServ extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(request.getParameterMap());	
		
		RegisterUser user = new RegisterUser();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		user.setUid(UUID.randomUUID().toString().replaceAll("-", ""));
		RegisterService service = new RegisterService();
		boolean isSucceed = service.registerUser(user);
	    System.out.println(isSucceed);
		if (isSucceed) {
//			request.getRequestDispatcher(request.getContextPath() + "/registerSucceed.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/login.jsp");
		}else {
			response.sendRedirect(request.getContextPath() + "/registerFail.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}