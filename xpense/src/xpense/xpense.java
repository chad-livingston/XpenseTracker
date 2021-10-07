package xpense;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class xpense {
	//creates an arrayList of user entered input double type values.
	public static ArrayList<Double> expenses = new ArrayList<Double>();
	//creates scanner for taking user input.
	public static Scanner in = new Scanner(System.in).useLocale(Locale.US);
	//boolean to loop program. exit case switches this value to false; ending the program.
	public static Boolean running = true;
	
	
	
	
	
	public static void main(String[] args) {

		System.out.println("What would you like to do? Type \"opt\" for options.");
		
		while (true) {
		//shows the user the available commands
			String input = in.next();			
			switch(input) {
			case "opt":
				System.out.println("\"add\" - use this too add an expense to the list of expenses.");
				System.out.println("\"remove\" - use this too remove the last added expense.");
				System.out.println("\"view\" - use this too view all of your current expenses.");
				System.out.println("\"reset\" - use this too reset your expense list entirely.");
				System.out.println("\"sum\" - use this to add all of your expenses together.");
				System.out.println("\"exit\" - use this to close the program.");
				break;			
			case "add":
				Boolean adding = true;
				System.out.println("Please type your expense too add it too the expense list. Done to stop");				
				while (adding) {
					if (in.hasNextDouble()){
						Double add = in.nextDouble();
						addExpense(add);
					}else if (in.hasNext()) {
						String done = in.next().toLowerCase();
						if (done.equals("done")) {
							System.out.println("Now done adding expenses.");
							adding = false;
						} else {
							System.out.println("Aborting expense adding. Unknown character.");
							adding = false;
						}
					}
				}			
				break;
			case "remove":
				System.out.println("Are you sure you would like to remove the last entered expense? y/n");
				String removeConfirm = in.next().toLowerCase();
				
				if (removeConfirm.equals("y") && expenses.size() != 0) {
					removeLast();
				} else if (removeConfirm.equals("n") || expenses.size() <= 0) {
					System.out.println("Aborting removal of last entered expense.");					
				} else {
					System.out.println("If you really would liek to remove the last expense type \"remove\" again and follow the prompts.");
				}
				
				break;
			case "view":
				System.out.println(expenses);
				break;
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
			case "sum":
				if (expenses.size() != 0) {
					double summed = sumExpenses();
					System.out.println("Your total expenses are: " + summed + ".");
					
				} else {
					System.out.println("Your expenses are currently empty.");
				}
				break;
			case "exit":
				System.out.println("Are you sure you want to close the program? \"y/n\"");
				String confirmExit = in.next();
				switch (confirmExit) {
				case "y":
					System.out.println("Closing the program.");
					in.close();
					break;
				case "n":
					System.out.println("Aborting closing of the program.");
					break;
				default:
					System.out.println("If you really wish to exit then type \"exit\" and follow the prompts again.");
					break;
				}
				break;
			default:
				System.out.println("Invalid input, Type opt for help.");
				break;
					
			}
		}	
	}
	//method to add expenses to the expense list
		public static void addExpense(double expense) {
			expenses.add(expense);
			System.out.println("Adding " + expense + " to the list of expenses. Enter another expense if you have one or \"done\" to stop.");
		}
		//method to remove the last expense added from the expense list.
		public static void removeLast() {
			double removal = expenses.get(expenses.size() - 1);
			expenses.remove(expenses.size() - 1);
			System.out.println("Removed " + removal + " from the list of expenses");
		}
		//method to sum all expenses from the expense list
		public static double sumExpenses() {
			double sum = 0;
			for (int i = 0; i < expenses.size(); i++) {
				sum += expenses.get(i);
			}
			return sum;
		}
		
		
	}


