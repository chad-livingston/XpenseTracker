package xpense;

import java.util.Scanner;

public class Budget {
	private int budget;

	public Budget(){
		this.budget = 0;
	}
	public int getBudget(){
		return budget;
	}
	public void setBudget(int budgetValue){
		this.budget = budgetValue;
	}
}
