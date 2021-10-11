package xpense;

public class Bank {
	private double balance = 0;
	
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
	
	
	
}
