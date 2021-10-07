package xpense;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class xpense {
	//creates an arrayList of user entered input double type values.
	public static ArrayList<Double> expenses = new ArrayList<Double>();
	//creates scanner for taking user input.
	public static Scanner in = new Scanner(System.in).useLocale(Locale.US);
	//boolean to loop program. exit case switches this value to false; ending the program.
	public static Boolean running = true;
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Checking for saved expenses.....");
		try {
			File mySaveFile = new File("E:\\Git\\LocalXpenseTracker\\xpense\\expense.txt");
			if (mySaveFile.createNewFile()) {
				System.out.println("File created: " + mySaveFile.getName());
			} else {
				System.out.println("Save file already exists! Loading in save.");
				//reads save file and saves it into expense arraylist.
				
			}
		}
		catch (IOException e){
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		

		System.out.println("What would you like to do? Type \"opt\" for options.");
		//loops until program finishes.
		
		
		while (true) {
		
			String input = in.next();			
			switch(input) {
			//shows the user the available commands
			case "opt":
				System.out.println("\"add\" - use this to add an expense to the list of expenses.");
				System.out.println("\"remove\" - use this to remove the last added expense.");
				System.out.println("\"view\" - use this to view all of your current expenses.");
				System.out.println("\"reset\" - use this to reset your expense list entirely.");
				System.out.println("\"sum\" - use this to add all of your expenses together.");
				System.out.println("\"exit\" - use this to close the program.");
				break;
				
			//adds double type values from user input into expense arraylist until done or no double entered.	
			case "add":
				Boolean adding = true;
				System.out.println("Please type your expense to add it too the expense list. Done to stop");				
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
				
			//logic for removing the last expene from expense arraylist with user confirmation.	
			case "remove":
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
				System.out.println(expenses);
				saveFile();
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
				//logic to exit the program with user confirmation. closes the scanner and prints message to user.
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
				//default to print if input read is not listed.
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
			//rounds sum of expenses to the nearest hundreth
			double roundedSum = Math.round(sum * 100.0) / 100.0;
			return roundedSum;
		}
		public static ArrayList<String> convertArrayListToStringFromDouble(ArrayList<Double> doubleList) {
			ArrayList<String> stringSave = new ArrayList<String>();
			for (int i = 0; i < doubleList.size(); i++) {
				stringSave.add(doubleList.get(i).toString());
			}
			return stringSave;
		}
		public static ArrayList<Double> convertArrayListToDoubleFromString(ArrayList<String> stringList){
			ArrayList<Double> doubleSave = new ArrayList<Double>();
			for (int i = 0; i < stringList.size(); i++) {
				doubleSave.add(Double.parseDouble(stringList.get(i)));
			}
			return doubleSave;
		}
		
		public static void saveFile() {
			
			ArrayList<String> stringSave = new ArrayList<String>();

			try {
				FileWriter myWriter = new FileWriter("E:\\Git\\LocalXpenseTracker\\xpense\\expense.txt");
				for (int i = 0; i < expenses.size(); i++) {
					stringSave.add(expenses.get(i).toString());
					for (int x = 0; x < stringSave.size(); x++) {
						myWriter.write(stringSave.get(x));
					}
					myWriter.close();
				}
				
				System.out.println("Successfully wrote to the file");
			}
			catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
		
		
	}


