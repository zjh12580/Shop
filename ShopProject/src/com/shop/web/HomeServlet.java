package com.shop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.domain.MuneModel;
import com.shop.domain.Product;
import com.shop.service.HomeService;

public class HomeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HomeService service = new HomeService();
		
         //导航条
		List<MuneModel> list = service.searchNaviMenuList();
		this.getServletContext().setAttribute("menuListDatas", list);
		
		//热门商品
		List<Product> hotProductDatas = service.getHotProductDatas();
		request.setAttribute("hotProductDatas", hotProductDatas);
//		System.out.println("hotProductDatas:" + hotProductDatas);
		
		//最新商品
		List<Product> newProducts = service.getNewProductDatas();
		request.setAttribute("newProductDatas", newProducts);
//		System.out.println("newProductDatas:" + newProducts);
		
		//移除高亮索引
		request.removeAttribute("currectSelectCid");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}