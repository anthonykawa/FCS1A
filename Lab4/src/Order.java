import java.io.*;
import java.util.*;

public class Order {
	private static int orderID = 0;
	private static char orderStatus = '\0';
	private static String customerName = new String();
	private static double orderCost = 0.0;
	private static Product[] products = new Product[3];
	
	Order(){
		orderID = genOrderID();
		products[0].setProductName("Smart Wifi Routers");
		products[1].setProductName("42-inch Smart TV");
		products[2].setProductName("Smart Cameras");
		String productName = products[1].getProductName();
	}
	Order(int ID, char status, String name, double cost, Product product[]){
		orderID = ID;
		orderStatus = status;
		customerName = name;
		orderCost = cost;
		products = product;
	}

	// define the below method in Order class
	private static int genOrderID(){
        Random  rand = new Random ( ) ;
        int  ID = rand.nextInt (90001) + 9999;   // generate a number between 9999-99999
        return ID;
	}
	public static int getOrderID(){
		return orderID;
	}
	public static void setOrderStatus(char status){
		orderStatus = status;
	}
	public static char getOrderStatus(){
		
		return orderStatus;
	}
	public static void setCustomerName(String name){
		customerName = name;
	}
	public static String getCustomerName(){
		
		return customerName;
	}
	public static void setProduct(int array, String product, int quantity, double price){
		
		products[array] = new Product(product, quantity, price);
	}
	public static Product[] getProduct(){
		return products;
	}
	public void setOrderCost (){
		
	}
	public double getOrderCost(){
		
		return orderCost;
	}
	public String toString(){
		//ID~status~name~cost:productname~quantity~price
		
		return String.format("%d~%c~%s~%f:%s~%d~%d",orderID,orderStatus,customerName,orderCost,products[0].getProductName(),products[0].getPrice());
	}
	
	
		
}