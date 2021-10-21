package xpense;

import java.util.Scanner;

public class Budget {
	private Scanner budgetScanner = new Scanner(System.in);
	
	public void budgetModule() {
		System.out.println("Welcome to the budget module of this app! \"opt\" for more options.");
		String budgetIn = budgetScanner.next();
		switch(budgetIn) {
		case "opt":
			System.out.println("\"budget\" - use this to view/edit your max budget.");
			//break;
		case "budget":
			//System.out.println("Your current budget is set to: $" + budget + ". What would you like to set it too?");
			if (budgetScanner.hasNextDouble()) {
				double setBudget = budgetScanner.nextDouble();
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
	}
	//method to calculate what is left in our budget.
	/*public static double budget() {
		double sum = sumExpenses();
		double updatedBudget = budget - sum;
		return updatedBudget;
	}
	*/
}
