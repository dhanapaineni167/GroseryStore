package com.sql.GroseryStore;

import java.util.Scanner;

import com.sql.GroseryStore.ProductService.ProductService;

public class App {
	public static void main(String[] args) {
		System.out.println("------>>B7262 Online Store Management System<<------");

		Scanner ip = new Scanner(System.in);
		ProductService spsvc = new ProductService();
		char ch;
		double tcost = 0;
		int pid, qty;
		System.out.println("Want to purchase???(Y/N)");
		ch = ip.next().charAt(0);
		while (ch == 'Y') {
			spsvc.displayProducts();
			System.out.println("Enter the Product Number:");
			pid = ip.nextInt();
			System.out.println("Enter the quantity:");
			qty = ip.nextInt();

			tcost = tcost + (spsvc.getAllProducts().get(pid - 1).getPcost()*qty);
			System.out.println("Your Current Bill amount is " + tcost);

			System.out.println("Want to purchase one more product:(Y/N)");
			ch = ip.next().charAt(0);
		}
		System.out.println("Your Total Bill Amount is: " + tcost);
		System.out.println("Thank you for Purchase...");
	}
}
