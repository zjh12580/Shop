package com.shop.filter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.customClass.EnHanceRequest;

public class BaseFilter implements Filter {

    public BaseFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest myRequest = (HttpServletRequest) request;
		HttpServletResponse myResponse = (HttpServletResponse) response;		
		//解决中文乱码
		HttpServletRequest enRequest = hendleChineseWord(myRequest,myResponse);
		chain.doFilter(request, response);
	}

	
	private HttpServletRequest hendleChineseWord(HttpServletRequest myRequest, HttpServletResponse myResponse) {
		
		EnHanceRequest enRequest = null;
		if (myRequest.getMethod().equals("POST")||myRequest.getMethod().equals("post")) { //post
			try {
				myRequest.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			myResponse.setContentType("text/html;charset=UTF-8");
			return myRequest; 
		}else { //get
			enRequest = new EnHanceRequest(myRequest); //装饰者
		}
		return enRequest; 
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}


