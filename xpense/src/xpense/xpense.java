package xpense;

import java.util.ArrayList;
import java.util.Scanner;
//test second computer
public class xpense {
	public static ArrayList<Double> expenses = new ArrayList<Double>();
	public static Scanner in = new Scanner(System.in);
	public static Boolean running = true;
	public static void main(String[] args) {

		System.out.println("What would you like to do? Type \"cmd\" for options.");
		
		while (running) {
		//shows the user the available commands
			String input = in.next();
			if (input.equals("cmd")){
				if (in.nextLine() == "cmd") {
				System.out.println("\"add\" - use this too add an expense to the list of expenses.");
				System.out.println("\"removelast\" - use this too remove the last added expense.");
				System.out.println("\"view\" - use this too view all of your current expenses.");
				System.out.println("\"reset\" - use this too reset your expense list entirely.");
				System.out.println("\"sum\" - use this to add all of your expenses together.");
				System.out.println("\"exit\" - use this to close the program.");
				}			
			}
			if (input.equals("add")) {
				Boolean adding = false;
				while (!adding) {
					System.out.println("Please type your expense too add it too the expense list.");
					if(in.hasNextDouble()) {
						while(in.hasNextDouble()) {
							addExpense(in.nextDouble());
							System.out.println("Continue adding expenses or type \"done\" to quit.");
							if (in.nextLine().toLowerCase().equals("done")) {
								adding = true;
							} else {
								//System.out.println("You must enter either done or another expense in decimal format to continue.");
							}
						}
						//addExpense(in.nextDouble());
						//System.out.println("Would you like to add another expense? y/n");

						adding = true;
						System.out.println("Now done adding expenses.");
					} else {
						System.out.println("You must enter an expense in \"xx.xx\" format. Please try again.");
						
					}
				}
			}
			if (input.equals("removelast")) {
				Boolean removing = false;
				while (!removing) {
					System.out.println("Are you sure you would like to remove the last entered expense? y/n");
					if (in.nextLine().toLowerCase().equals("y")) {
						removeLast();
						removing = true;
					} else {
						System.out.println("Aborting removal of last entered expense.");
						removing = true;
					}
				}
			}
			if (input.equals("view")) {
				System.out.println(expenses);
			}
			if (in.nextLine().toLowerCase().equals("reset")) {
				System.out.println("Are you sure you want to reset your entire expense list?  There is no restoring it after this. y/n");
				Boolean resetting = false;
				while (!resetting) {
				if (in.nextLine().toLowerCase().equals("y")) {
					expenses.clear();
					System.out.println("All of your expenses have been cleared!");
				}
			}
			}
			
			if (input.equals("sum")) {
				if (expenses.size() != 0) {
					double summed = sumExpenses();
					
					System.out.println("Your total expenses are: " + summed + ".");
					
				} else {
					System.out.println("Your expenses are currently empty.");
				}
			}
			if (input.equals("exit")) {
				System.out.println("Are you sure you want to close the program? y/n");
				if (in.nextLine().toLowerCase().equals("y")) {
					System.out.println("Closing the program.");
					in.close();
					running = false;
				}
				
			}
		}	
		}
		public static void addExpense(double expense) {
			expenses.add(expense);
			System.out.println("Adding " + expense + " to the list of expenses.");
		}
		public static void removeLast() {
			double removal = expenses.get(expenses.size() - 1);
			expenses.remove(expenses.size() - 1);
			System.out.println("Removed " + removal + " from the list of expenses");
		}
		public static double sumExpenses() {
			double sum = 0;
			for (int i = 0; i < expenses.size(); i++) {
				sum += expenses.get(i);
			}
			return sum;
		}
		
		
	}


