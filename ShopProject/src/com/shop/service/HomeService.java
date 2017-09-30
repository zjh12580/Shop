package com.shop.service;

import java.sql.SQLException;
import java.util.List;

import com.shop.dao.HomeDao;
import com.shop.domain.MuneModel;
import com.shop.domain.Product;

public class HomeService {

	public List<MuneModel> searchNaviMenuList() {

		HomeDao dao = new HomeDao();
		List<MuneModel> list = null;
		try {
			list = dao.searchMenuFroDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getHotProductDatas() {
		HomeDao dao = new HomeDao();
		List<Product> list = null;
	    try {
			list = dao.searchHotProductFromDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Product> getNewProductDatas() {
		HomeDao dao = new HomeDao();
		List<Product> list = null;
	    try {
			list = dao.searchNewProductFromDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Product getProductInfo(String pid) {
		HomeDao dao = new HomeDao();
		Product p = null;
		try {
			p = dao.getProductInfo(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public List<Product> getProductById(String cid, int i) {
		
		HomeDao dao = new HomeDao();
		List<Product> list = null;
	    try {
			list = dao.getProductById(cid,i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public long getProductCountById(String cid) {
		HomeDao dao = new HomeDao();
		long count = 0;
	    try {
	      	count = dao.getProductCountById(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	
	
}
