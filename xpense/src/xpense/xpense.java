package xpense;

import java.util.ArrayList;
import java.util.Scanner;
//test second computer
public class xpense {
	public static ArrayList<Double> expenses = new ArrayList<Double>();
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("What would you like to do? \"cmd\" for options.");
		//shows the user the available commands
			if (in.nextLine().toLowerCase().equals("cmd")){
				System.out.println("\"add\" - use this too add an expense to the list of expenses.");
				System.out.println("\"removelast\" - use this too remove the last added expense.");
				System.out.println("\"view\" - use this too view all of your current expenses.");
				System.out.println("\"reset\" - use this too reset your expense list entirely.");
				System.out.println("\"sum\" - use this to add all of your expenses together.");
				System.out.println("\"exit\" - use this to close the program.");
			}
			
			//
			if (in.nextLine().toLowerCase().equals("add")) {
				Boolean adding = false;
				while (!adding) {
					System.out.println("Please type your expense too add it too the expense list.");
					if(in.hasNextDouble()) {
						addExpense(in.nextDouble());
						adding = true;
					} else {
						System.out.println("You must enter an expense in \"xx.xx\" format. Please try again.");
						
					}
				}
			}
			if (in.nextLine().toLowerCase().equals("removelast")) {
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
			if (in.nextLine().toLowerCase().equals("view")) {
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
			if (in.nextLine().toLowerCase().equals("exit")) {
				System.out.println("Are you sure you want to close the program? y/n");
				if (in.nextLine().toLowerCase().equals("y")) {
					System.out.println("Closing the program.");
					in.close();
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
		
	}


