package com.shop.domain;

import java.util.List;

public class PageInfo {

	private String cid;
	private String currectPage;
	private String allPage;
	private List<Product> productList;
	
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCurrectPage() {
		return currectPage;
	}
	public void setCurrectPage(String currectPage) {
		this.currectPage = currectPage;
	}
	public String getAllPage() {
		return allPage;
	}
	public void setAllPage(String allPage) {
		this.allPage = allPage;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
}
