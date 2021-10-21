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
			/*
			 * 
			 * 
			 * EXPENSES MODULE
			 * 
			 * 
			 * 
			 * 
			 */
			case "expenses":
				expenses expense = new expenses();
				expense.expenseModule();
				
				
	//start			
					
					
						//logic for removing the last expene from expense arraylist with user confirmation.	
					/*case "remove":
						System.out.println("Are you sure you would like to remove the last entered expense? y/n");
						String removeConfirm = in.next().toLowerCase();
						
						if ((removeConfirm.equals("y") || removeConfirm.equals("yes")) && expenses.size() != 0) {
							removeLast();
						} else if ((removeConfirm.equals("n") || removeConfirm.equals("no")) || expenses.size() <= 0) {
							
							System.out.println("Aborting removal of last entered expense.");					
						} else {
							System.out.println("If you really would liek to remove the last expense type \"remove\" again and follow the prompts.");
						}
						
						break;
						//views the current list of expenses in arrayform.
					case "view":
						System.out.println("Here is a list of your expenses: " + expenses);
						Double h = budget();
						System.out.println("Budget - Expenses = " + h);
						System.out.println("DEBUG - Size of expenses: " + expenses.size() + ".");
						break;
						//logic to reset they expenses arraylist with user confirmation.
					case "reset":
						System.out.println("Are you sure you want to reset your entire expense list?  There is no restoring it after this. y/n");				
						String confirmExpenseReset = in.next();
						if (confirmExpenseReset.toLowerCase().equals("y")) {
								expenses.clear();
								System.out.println("All of your expenses have been cleared!");
							} else if (confirmExpenseReset.toLowerCase().equals("n")){
								System.out.println("Aborting reset of expenses!");
							} else {
								System.out.println("If you really would like to reset your expense list type \"reset\" again.");
							}				
						break;
						//logic to sum all the expenses added into expense list together.
					case "sum":
						if (expenses.size() != 0) {
							double summed = sumExpenses();
							System.out.println("Your total expenses are: " + summed + ".");
							
						} else {
							System.out.println("Your expenses are currently empty.");
						}
						break;
						//runs savefile. writes current expense list to specified filePath.
					case "save":
						saveFile();
						break;
						//imports an expenseList if one exists.
					case "import":
						importSave();
						break;
						//logic to exit the program with user confirmation. closes the expense loop and prints message to user.
					case "exit":
						System.out.println("Are you sure you want to close the program? \"y/n\"");
						String confirmExit = in.next();
						switch (confirmExit) {
						case "y":
							System.out.println("Closing the expenses module.");
							expensesLoop = false;
							//in.close();
							break;
						case "n":
							System.out.println("Aborting expense module closure.");
							break;
						default:
							System.out.println("If you really wish to exit the expenses module then type \"exit\" and follow the prompts again.");
							break;
						}
						break;
					default:
						//default to print if input read is not listed.
						System.out.println("Invalid input, Type opt for help.");
						break;
					
	end			*/
					
				
			
				//}
				/*
				 * 
				 * 
				 * 
				 * BANK MODULE
				 * 
				 * 
				 * 
				 */
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
				/*
				 * 
				 * 
				 * 
				 * BUDGET MODULE
				 * 
				 * 
				 */
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
				/*
				 * 
				 * 
				 * 
				 * INVESTMENT MODULE
				 * 
				 * 
				 * 
				 */
				case "investment":
					break;
				case "exit":
					System.out.println("Closing the program.");
				//close reader here
				
					break;
				/*
				 * 
				 * 
				 * 
				 * 
				 * DEFAULT
				 * 
				 * 
				 * 
				 * 
				 */
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
