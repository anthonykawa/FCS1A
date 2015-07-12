
import java.io.*;
import  java.text.*;
import  java.util.*;

public class dailyCommissionReport {
	public static void main(String[] args){
		
		int x = 0;
		char getAgentChoice = '\0';
		int agentID = 0;
		String agentName = "";
		double totalSales = 0.0;
		String[] salesData = {};
		double totalSalesCommission = 0.0;
	
		agentID = getAgentID();
		agentName = getAgentName();
		
		while (x==0){
			reportMenu();
			getAgentChoice = getAgentChoice();
			switch(getAgentChoice){
			case 'r':
			case 'R':
				salesData = getSalesData();
				totalSales = computeTotalSales(salesData);
				totalSalesCommission = computeSalesCommission(totalSales, totalSalesCommission);
				showAgentCommission(totalSalesCommission, agentName);
				break;
			case 'q':
			case 'Q':
				showAgentCommission(totalSalesCommission, agentName);
				x = 1;
				break;
			default:
				handleInvalidData();
			}
		}			
	}
	// ask for Agent ID from the agent
	public static int getAgentID(){
		BufferedReader br = null;
		String buffer = "";
		int agentID = 0;
		// use BufferedReader to get i
		try {
			br = new BufferedReader (new InputStreamReader (System.in));
			System.out.print("Enter your agent ID: ");
			buffer = br.readLine();
			agentID = Integer.parseInt(buffer);
		} catch (Exception e){
			e.printStackTrace();
			System.exit(0);
		}
		
		return agentID;
	}
	// ask for the name of the agent
	public static String getAgentName(){
		BufferedReader br = null;
		String agentName = "";
		// use BufferReader to ask user to input agent ID. 
		try {
			br = new BufferedReader (new InputStreamReader (System.in));
			System.out.print("Enter your name: ");
			agentName = br.readLine();
			} catch (Exception e){
			e.printStackTrace();
			System.exit(0);
		}
		
		return agentName;
	}
	// Menu header
	public static void menuHeader(){
		String printDate = getCurrentDate();
		
		System.out.println("WELCOME TO SALES REPORT");
		System.out.println(printDate);
		
		
	}
	// Print the initial menu items
	public static void reportMenu(){
		menuHeader();
		System.out.println("R (Report Sales)");
		System.out.println("Q (Quit)");
	}
	// get menu choice from Agent
	public static char getAgentChoice(){
		BufferedReader br = null; 
		String buffer = "";
		char agentChoice = '\0';
		// use BufferReader to ask user to input menu choice (report and quit)
		try {
			br = new BufferedReader (new InputStreamReader (System.in));
			System.out.print("Enter your choice: ");
			buffer = br.readLine();
			agentChoice = buffer.charAt(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return agentChoice;
	}
	// get tickets sold and price of each ticket from Agent
	public static String[] getSalesData(){
		String[]data = new String[2];
		BufferedReader br = null; 
		
		// use BufferedReader to ask user to input number of ticket sold as a String and store it in data [0]
		try {
			br = new BufferedReader (new InputStreamReader (System.in));
			System.out.print("Enter amount of tickets sold: ");
			data[0] = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		 // use BufferedReader to ask user to input ticket price as a String a store it in data [1]
		
		try {
			System.out.print("Enter ticket price: ");
			data[1] = br.readLine();
		} catch (Exception e){
			e.printStackTrace();
			System.exit(0);
		}
		
		return data;
	}
	// get the current date
	public static String getCurrentDate ( ) {
        return new SimpleDateFormat("EEE MMM dd,yyyy hh:mm:ss a").format (Calendar.getInstance ( ).getTime ( )) ;
	}
	// computer the total sales made for each session
	public static double computeTotalSales(String[] data){
		double totalSales = 0.0;
		int ticketsSold = 0;
		double ticketPrice = 0.0;
		
		ticketsSold = Integer.parseInt(data[0]);
		ticketPrice = Double.parseDouble(data[1]);
		
		totalSales = ticketsSold*ticketPrice;
			
		return totalSales;
	}
	// use totalSales and totalSalesCommission to calculate sales commission
	public static double computeSalesCommission(double totalSales, double totalSalesCommission){
		double salesCommission = 0.0;
		final double COMM_RATE_LEVEL_1 = 0.025;
		final double COMM_RATE_LEVEL_2 = 0.0375;
		final double COMM_RATE_LEVEL_3 = 0.0425;
		final double TOTAL_SALES_1 = 2000.00;
		final double TOTAL_SALES_2 = 4000.00;
		
		if (totalSales >= TOTAL_SALES_1){
			salesCommission = totalSales*COMM_RATE_LEVEL_1;
		}
		else if ((totalSales < TOTAL_SALES_1) && (totalSales >= TOTAL_SALES_2)){
			salesCommission = totalSales*COMM_RATE_LEVEL_2;
		}
		else if (totalSales < TOTAL_SALES_2){
			salesCommission = totalSales*COMM_RATE_LEVEL_3;
		}
		else {
			System.out.println("You entered an incorrect amount. Please try again.");
		}
		totalSalesCommission += salesCommission;
		return totalSalesCommission;
	}
	// display the sales commission earned by the agent
	public static void showAgentCommission(double salesCommission, String agentName){
		System.out.format("Congratulations agent " + agentName  + ", your current daily commission is: $ %9.2f%n", salesCommission);
		
	}
	// display a message when incorrect input is made in the menu
	public static void handleInvalidData(){
		System.out.println("�*** Enter R,r or Q,q only please ***�");
	}
}
