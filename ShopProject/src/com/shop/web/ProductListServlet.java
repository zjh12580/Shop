package com.shop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.domain.PageInfo;
import com.shop.domain.Product;
import com.shop.service.HomeService;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cid = request.getParameter("cid");
		String pageIndex = request.getParameter("pageIndex");
		int index = 1;
		if (pageIndex != null) {
		   index = Integer.parseInt(pageIndex);	
		} 
		HomeService service = new HomeService();
		
		List<Product> productList = service.getProductById(cid,index);

		//获取对应类别的全部商品数
		long count = service.getProductCountById(cid);
		count =  count%12==0?  count/12 : count/12 + 1;
		
		PageInfo page = new PageInfo();
		page.setCid(cid);    //存类别id 高亮header中的对应按钮
		page.setProductList(productList);//获取对应类别的商品列表 
		page.setAllPage(""+count+"");
		page.setCurrectPage(""+index); //当前商品页index
		
		request.setAttribute("pageInfo", page);
		
		//转到jsp前台界面
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}