import java.io.*;
public class OrderSystem {
	private static String storeName = new String();
	private static String storeCity = new String();
	private static Order[] orderList = new Order[10];
	private static int lastOrderIndex = 0;
	
	// this method will manually create an array of 10 Orders. 
	// You can make up the Orders’ data. Assign the orderList to this array
	public static void initialize(){
		
		orderList[0].setProduct(0, "Smart Wifi Routers", 2, 35.99);
		orderList[0] = new Order(orderList[0].getOrderID(), 'N',"Frederick", 25.99, orderList[0].getProduct());
		System.out.print(orderList[0].getOrderCost());
		
	}
	
	public static void run(){
		int choice = 0;
		setStoreName();
		storeName = getStoreName();
		setStoreCity();
		storeCity = getStoreCity();
		do{
			menu();
			choice = getChoice();
		}while(choice != 6);
	}
	
	public static void setStoreName(){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please enter your store name: ");
			storeName = br.readLine();
		}catch (Exception e){}
	}
	public static String getStoreName(){
		
		return storeName;
	}
	public static void setStoreCity(){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please enter the city of your store's location: ");
			storeCity = br.readLine();
		}catch (Exception e){}
	}
	public static String getStoreCity(){
		return storeCity;
	}
	private static void menu(){
		System.out.print("Please wait for system to initialize");
		for(int i=0;i<60;i++){
			System.out.print(".");
			 try {
		         Thread.sleep(20);   // suspend for 3 seconds
			 }catch (Exception e) {}
		}
		System.out.println("\n\n          Welcome to " + storeName + " at " + storeCity);
		System.out.println("                              MENU");
		System.out.println("1. Place an order");
		System.out.println("2. Change an order");
		System.out.println("3. View an order");
		System.out.println("4. Process an order");
		System.out.println("5. List all orders");
		System.out.println("6. Exit");
	}
	private static int getChoice(){
		int choice = 0;
		BufferedReader br = null;
		String buffer = new String();
		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("          Please select your choice: ");
			buffer = br.readLine();
			choice = Integer.parseInt(buffer);
		}catch(Exception e){
			
		}
		switch(choice){
		case 1:
			placeOrder();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		default:
				
		}
		return choice;
	}
	public static void placeOrder(){
		BufferedReader br = null;
		String buffer = new String();
		int orderID=0;
		char orderStatus='\0';
		String orderString = null;
		String customerName = new String();
		Product[] product = null;
		int choice = 0;
		if(lastOrderIndex < orderList.length){
			//orderList[lastOrderIndex] = orderList[lastOrderIndex].getOrderID();
			orderList[lastOrderIndex].setOrderStatus('N');
			//orderList[lastOrderIndex].getOrderStatus();
			try{
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Enter the customer's name: ");
				customerName = br.readLine();
			}catch (Exception e){}
			orderList[lastOrderIndex].setCustomerName(customerName);
			System.out.println("0. Smart Wifi Routers");
			System.out.println("1. 46-inch Smart TV");
			System.out.println("2. Smart Cameras");
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Please select the product: ");
				buffer = br.readLine();
				choice = Integer.parseInt(buffer);
			}catch (Exception e){}
			//product[choice] = product;
			orderList[lastOrderIndex]= new Order(orderList[lastOrderIndex].getOrderID(), orderList[lastOrderIndex].getOrderStatus(), orderList[lastOrderIndex].getCustomerName(), orderList[lastOrderIndex].getOrderCost(), orderList[lastOrderIndex].getProduct());
			orderString = orderList[lastOrderIndex].toString();
			System.out.println();
			System.out.println(orderList[0].getOrderID());
			System.out.println(orderList[0].getCustomerName());
			System.out.println(orderList[0].getOrderStatus());
		}
		else{
			System.out.println("You have reached the maximum number of orders!");
		}
		lastOrderIndex++;
		
	}
	
}