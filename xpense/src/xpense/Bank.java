package xpense;
import java.util.ArrayList;

public class Bank {
	private double balance = 0;
	private ArrayList<String> accounts = new ArrayList<String>();
	
	public double setBalance(double amountToAdd) {
		double setBalance = balance + amountToAdd;
		setBalance = balance;
		return setBalance;
	}
	public double getBalance() {
		double getBalance = balance;
		//System.out.print("Your bank balance is: $" + getBalance);
		return getBalance;
	}
	public void addFunds(double amountToAdd) {
		 balance += amountToAdd;
	}
	public void removeFunds(double amountToRemove) {
		balance -= amountToRemove;
	}
	public String createAccount(String accountName) {
		accounts.add(accountName);
		System.out.println("Account successfully created with the name: " + accountName);
		return accountName;
	}
	public void getAccounts() {
		System.out.println("This is your current list of accounts: " + accounts);
	}
	public void setAccount() {
		
	}
	public void getAccount() {
		
	}
}
