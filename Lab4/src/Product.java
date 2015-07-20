import java.io.*;;

public class Product {
	private static String productName;
	private static int quantity;
	private static double price;
	
	Product(){
		
	}
	Product(String n, int q, double p){
		productName = n;
		quantity = q;
		price = p;
	}
	public void setProductName(String productName){
		this.productName = productName; 
	}
	public String getProductName(){
		
		return productName;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	public int getQuantity(){
		
		return quantity;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public double getPrice(){
		return price;
	}
}
