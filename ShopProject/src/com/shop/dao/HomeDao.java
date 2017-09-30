package com.shop.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.shop.domain.MuneModel;
import com.shop.domain.Product;
import com.shop.utils.DataSourceUtils;

public class HomeDao {

	public List searchMenuFroDB() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<MuneModel> list = runner.query(sql, new BeanListHandler<MuneModel>(MuneModel.class));

		return list;
	}

	public List<Product> searchHotProductFromDB() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where is_hot=? limit 0,10";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class),1);

		return list;
	}

	public List<Product> searchNewProductFromDB() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product order by pdate desc limit 0,10";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class));

		return list;
	}

	public Product getProductInfo(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
	    Product p = runner.query(sql, new BeanHandler<Product>(Product.class), pid);
		return p;
	}

	public List<Product> getProductById(String cid, int i) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where cid=? limit "+(i-1)*12+",12";
		List<Product> list = runner.query(sql, new BeanListHandler<Product>(Product.class),cid);

		return list;
	}

	public long getProductCountById(String cid) throws SQLException {
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where cid=?";
		Long count = (Long) runner.query(sql, new ScalarHandler(),cid);
		return count.longValue();
	}

}
