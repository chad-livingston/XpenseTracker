package xpense;

import java.util.ArrayList;
import java.util.Scanner;

public class xpense {
	public static ArrayList<Double> expenses = new ArrayList<Double>();
	public static Scanner in = new Scanner(System.in);
	public static Boolean running = true;
	public static void main(String[] args) {

		System.out.println("What would you like to do? Type \"cmd\" for options.");
		
		while (running) {
		//shows the user the available commands
			String input = in.next();
			Double value = in.nextDouble();
			if (input.equals("cmd")){
				System.out.println("\"add\" - use this too add an expense to the list of expenses.");
				System.out.println("\"removelast\" - use this too remove the last added expense.");
				System.out.println("\"view\" - use this too view all of your current expenses.");
				System.out.println("\"reset\" - use this too reset your expense list entirely.");
				System.out.println("\"sum\" - use this to add all of your expenses together.");
				System.out.println("\"exit\" - use this to close the program.");		
			}
			
			//logic loop to add expenses until user confirms they are done
			if (input.equals("add")) {
				Boolean adding = false;
				while (!adding) {
					System.out.println("Please type your expense too add it too the expense list.");
					if(in.hasNextDouble()){
						while(in.hasNextDouble()) {
							addExpense(value);
							System.out.println("Continue adding expenses or type \"done\" to quit.");
							if (input.equals("done")) {
								break;
								//adding = true;
							} else {
								System.out.println("You must enter either done or another expense in decimal format to continue.");
							}
						}

						//adding = true;
						System.out.println("Now done adding expenses.");
					} else {
						System.out.println("You must enter an expense in \"xx.xx\" format. Please try again.");
						
					}
				}
			}
			
			//logic for removal of the last expense with user confirmation
			if (input.equals("removelast")) {
					System.out.println("Are you sure you would like to remove the last entered expense? y/n");
					if (input.equals("y")) {
						removeLast();
					} else if (input.equals("n")) {
						System.out.println("Aborting removal of last entered expense.");					
				}
			}
			//views the list of expenses.
			if (input.equals("view")) {
				System.out.println(expenses);
			}
			//resets expense list with user confirmation
			if (input.equals("reset")) {
				System.out.println("Are you sure you want to reset your entire expense list?  There is no restoring it after this. y/n");				
				if (input.equals("y")) {
					expenses.clear();
					System.out.println("All of your expenses have been cleared!");
				} else if (input.equals("n")){
					System.out.println("Aborting reset of expenses!");
				}
			}
			//logic for summing all expenses together
			if (input.equals("sum")) {
				if (expenses.size() != 0) {
					double summed = sumExpenses();
					
					System.out.println("Your total expenses are: " + summed + ".");
					
				} else {
					System.out.println("Your expenses are currently empty.");
				}
			}
			//logic to close the program with user confirmation
			if (input.equals("exit")) {
				System.out.println("Are you sure you want to close the program? y/n");
				if (input.equals("y")) {
					System.out.println("Closing the program.");
					in.close();
					running = false;
				}
				
			}
		}	
		}
	//method to add expenses to the expense list
		public static void addExpense(double expense) {
			expenses.add(expense);
			System.out.println("Adding " + expense + " to the list of expenses.");
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


