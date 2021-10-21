package xpense;
import xpense.Bank;
import xpense.Categories;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class xpense {

	
	//creates scanner for taking user input.
	public static Scanner in;
	//boolean to loop program. exit case switches this value to false; ending the program.
	public static Boolean running = true;
	public static String filePath = "E:\\Git\\LocalXpenseTracker\\xpense\\expense.txt";
	//budget value;
	//public static double budget = 0;
	
	
	public static void main(String[] args) {
		/*
		 * 
		 * 
		 * 
		 * * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		System.out.println("Welcome to the console expense tracker!");
		System.out.println("This app has several modules included.");
		System.out.println("Which module would you like to enter?");
		System.out.println("Expenses");
		System.out.println("Bank");
		System.out.println("Budget");
		System.out.println("Investment");
		in = new Scanner(System.in);
		
		while (true) {
			switch (strInput()) {

//********************************************************************* EXPENSES MODULE ***************************************************************************************

			case "expenses":
				expenses expense = new expenses();
				expense.expenseModule();
				
//********************************************************************* BANK MODULE ***************************************************************************************

			case "bank":
				Bank bank = new Bank();
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
						if (in.hasNextDouble()) {
							double bal;
							bank.addFunds(dblInput());
							bal = bank.getBalance();
							System.out.println("Successfully added $" + " to your bank account. Your new balance is $" + bal + ".");
						} else {
							System.out.println("Sorry you didn't enter a correct value type. Aborting bank.");
							//banking = false;
						}
						break;
					case "remove":
						System.out.println("How much would you like to remove from the bank account?");
						if (in.hasNextDouble()) {
							double remove = in.nextDouble();
							bank.removeFunds(remove);
						} else {
							System.out.println("Sorry you didn't enter a correct value type. Aborting bank.");
							//banking = false;
						}
						break;
					case "balance":
						double bal = bank.getBalance();
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
					}
					//break;
					break;
				}
					//break;
				break;
//********************************************************************* BUDGET MODULE ***************************************************************************************
				//logic to set a budget in the console. --Needs work done.
			case "budget":
				//Categories category = new Categories();
				System.out.println("Welcome to the budget module of this app! \"opt\" for more options.");
				String budgetIn = in.next();
				switch(budgetIn) {
				case "opt":
					System.out.println("\"budget\" - use this to view/edit your max budget.");
					//break;
				case "budget":
					//System.out.println("Your current budget is set to: $" + budget + ". What would you like to set it too?");
					if (in.hasNextDouble()) {
						double setBudget = in.nextDouble();
						//budget = setBudget;
						//System.out.println("Your budget has been set to: $" + budget);
					} else {
						System.out.println("You must enter a valid double to set your budget.");
					}
					//break;
				case "addc":
					System.out.println("What category would you like to add?");
					Categories.addCategory(budgetIn);
					//break;
				default:
					break;
				}
				break;
//********************************************************************* INVESTMENT MODULE ***************************************************************************************
				case "investment":
					break;
					
				case "exit":
					System.out.println("Closing the program.");
				//close reader here
					in.close();
					break;
					//********************************************************************* DEFFAULT MODULE SELECTION ***************************************************************************************
				default:
					break;
				}
			}
		}
	/*
	 * 
	 * 
	 * 
	 * 
	 * METHODS
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */


		

		//method to calculate what is left in our budget.
		/*public static double budget() {
			double sum = sumExpenses();
			double updatedBudget = budget - sum;
			return updatedBudget;
		}
*/

		public static String strInput() {
			
			if (in.hasNext()) {
				String strInput = in.next();
				return strInput;
			}
			return "String not Found.";
		}
		public static Double dblInput() {
			double dblInput = in.nextDouble();
			return dblInput;
		}


	}
