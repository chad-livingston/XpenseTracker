package xpense;

import java.util.Scanner;

public class Bank {
	private double balance = 0;
	private static Scanner bankScanner = new Scanner(System.in);
	
	public double setBalance(double amountToAdd) {
		double setBalance = balance + amountToAdd;
		balance = setBalance;
		return setBalance;
	}
	
	public double getBalance() {
		double getBalance = balance;
		System.out.print("Your bank balance is: $" + getBalance);
		return getBalance;
		
	}
	
	
	
	public void addFunds(double amountToAdd) {
		 balance += amountToAdd;
		
	}
	public void removeFunds(double amountToRemove) {
		balance -= amountToRemove;
	}
	public void bankModule() {
		
		System.out.println("Welcome to your bank! What would you like to do? \"opt\" for options.");
		Boolean banking = true;
		while (banking) {
			switch (strInput()) {
			case "opt":
				System.out.println("\"balance\" - use this to check your current account balances.");
				System.out.println("\"create\" - use this to create a new bank account.");
				System.out.println("\"add\" - use this to add funds into bank account.");
				System.out.println("\"remove\" - use this to remove funds from bank account.");
				System.out.println("\"delete\" - use this to delete an account.");
				System.out.println("\"exit\" - use this to close the bank section.");
				break;
			case "add":
				System.out.println("How much would you like to add to the bank account?");
				if (bankScanner.hasNextDouble()) {
					double bal;
					addFunds(dblInput());
					bal = getBalance();
					System.out.println("Successfully added $" + " to your bank account. Your new balance is $" + bal + ".");
				} else {
					System.out.println("Sorry you didn't enter a correct value type. Aborting bank.");
					//banking = false;
				}
				break;
			case "remove":
				System.out.println("How much would you like to remove from the bank account?");
				if (bankScanner.hasNextDouble()) {
					double remove = bankScanner.nextDouble();
					removeFunds(remove);
				} else {
					System.out.println("Sorry you didn't enter a correct value type. Aborting bank.");
					//banking = false;
				}
				break;
			case "balance":
				double bal = getBalance();
				System.out.println("You account balance is $" + bal + ".");
				break;
			case "create":
				System.out.println("work in progress!");
				break;
			case "delete":
				System.out.println("work in progress!");
				break;
			case "exit":
				System.out.println("Exiting banking section.");
				banking = false;
				break;
			default:
				System.out.println("Sorry you didn't enter a valid bank command. Aborting bank.");
				banking = false;
				break;
			}//closes strInput switch statement
			//breaks while banking loop.
			break;//breaks banking while loop
		}//closes banking while loop
	}//closes bankModule() method.
	public static String strInput() {
		String next;
		if (bankScanner.hasNext()) {
			next = bankScanner.next();
			return next;
		}
		return "Error: No strInput. use a valid parameter.";
		
	}
	public static Double dblInput() {
		double dblInput = bankScanner.nextDouble();
		return dblInput;
	}
	
	
	
}
