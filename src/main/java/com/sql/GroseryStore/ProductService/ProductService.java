package com.sql.GroseryStore.ProductService;

import java.util.ArrayList;

import com.sql.GroseryStore.ProductDao.ProductDao;
import com.sql.GroseryStore.entity.Product;

public class ProductService {
	private ProductDao pdao = new ProductDao();
	
	public void displayProducts()
	{
		for(Product p:pdao.getProducts())
		{
			System.out.println(p);
		}
	}

	public ArrayList<Product> getAllProducts()
	{
		return pdao.getProducts();
	}
	
}