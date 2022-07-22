package com.sql.GroseryStore.ProductDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.sql.GroseryStore.entity.Product;

public class ProductDao {
	static HashMap<Integer,String> prdMap = new HashMap<Integer,String>();
	private Connection con;
	private Statement st;
	public ProductDao()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch7262","root","dhana@D12");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("No class found"+e);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Error"+e);
		}
		
	}
	public ArrayList<Product> getProducts()
	{
		ArrayList<Product> plist = new ArrayList<Product>();
		
		try {
			st = con.createStatement();
			String sql = "select * from product";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getFloat(3)));
			}
		} catch (SQLException e) {
			System.out.println("DATABASE ERROR..."+e);
		}
		return plist;
	}
}