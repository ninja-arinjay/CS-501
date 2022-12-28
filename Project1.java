// Name - Arinjay(Jay) Panwar

//Class - CS 501_WS3

//Project Description - The Project is to develop a Delivery Calculator for the user that takes Username, Subtotal and Tip percent as input. 
//                      It then calculates and displays to the user Tax amount, Delivery Fee, Tip amount and Total Amount Due.

import javax.swing.JOptionPane;
public class Invoice {

	public static void main(String[] args) {
		String userName; //variables
		userName = JOptionPane.showInputDialog("Welcome to the Delivery Calculator! \n\n Enter your name:"); //reading input from user
		
		String inp;
		//Asking user to input Subtotal amount
		inp = JOptionPane.showInputDialog(String.format("Hello %s \n\n Enter the subtotal amount: $", userName));
		double subTotal = Double.parseDouble(inp);// Converting string to double
		
		
		// Calculating Tax on Subtotal
		double tax = (6.5 * subTotal)/100; 
		double deliveryFee = (10 * subTotal)/100; // Calculating Delivery Fee on Subtotal
		
		
		// Calculating predefined tip on 15%, 20%, 25%
		double tip15 = (15 * subTotal)/100; 
		double tip20 = (20 * subTotal)/100;
		double tip25 = (25 * subTotal)/100;
		
		
		// Asking user to enter Tip percent
		inp = JOptionPane.showInputDialog(String.format("Suggested Tip Amounts: \n\n 15%% = $%.2f \n 20%% = $%.2f \n 25%% = $%.2f \n\n"
				+ "Enter tip percent:", tip15,tip20,tip25));
		int tipPercent = Integer.parseInt(inp); //Converting String Tip percent to double
		double tip = (tipPercent * subTotal)/100; //Calculating Exact Tip
		
		
		// Calculating Total Due amount to the user
		double totalDue = subTotal + tax + deliveryFee + tip;
		
		
		// Printing Final message to user including Subtotal, Tax, Delivery Fee, Tip and Total Due
		JOptionPane.showMessageDialog(null, String.format("Your Delivery Cost \n\n Subtotal = $%10.2f \n Tax = %20.2f \n Delivery fee = %7.2f"
				+ "\n Tip amount = %7.2f \n --------- \n Total Due = $ %.2f",subTotal,tax,deliveryFee,tip,totalDue));
	}
}
