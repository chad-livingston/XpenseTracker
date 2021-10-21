package xpense;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class expenses {
	//file path to expense list
	private static String filePath = "E:\\Git\\LocalXpenseTracker\\xpense\\expense.txt";
	//creates an arrayList of user entered input double type values.
	public static ArrayList<Double> expenses = new ArrayList<Double>();
	//creates an arrayList of imported string values
	public static ArrayList<String> importList = new ArrayList<String>();
	
	public static Scanner input = new Scanner(System.in);
	
	
	
	
	public void expenseModule() {
	System.out.println("\nWelcome to the expense module. What would you like to do? ");
	expenseOptions();
	//loops until exit case in expensesInput switch is satisfied.
	Boolean expensesLoop = true;
	
	
	while (expensesLoop) {
			//stores the value of the next input.
			String expensesInput = strInput();
			switch(expensesInput) {
			//shows the user the available commands
			case "opt":
				expenseOptions();
				break;
				//adds double type values from user input into expense arraylist until done or no double entered.	
			case "add":
				System.out.println("Please type your expense to add it too the expense list. Done to stop");
				Boolean adding = true;
				//loop to add repeatedly instead of one by one.
				while (adding) {	
					
					//if done is entered then done adding expenses. close loop.
					if (input.hasNextDouble()){
						//Double add = in.nextDouble();
						addExpense(dblInput());
						
					}else if (input.hasNext()) {
						String done = strInput().toLowerCase();
						if (done.toLowerCase().equals("done")) {
							System.out.println("Now done adding expenses.");
							adding = false;
						} else {
							System.out.println("Aborting expense adding. Unknown character.");
							adding = false;	
						}
						//checks if scanner in has a double value if yes, adds the double entered into expense arraylist.
					}else {
						System.out.println("Please try entering your value in \"xx.xx\" format.");
					}
				}
				adding = false;
				break;
				//logic for removing the last expene from expense arraylist with user confirmation.	
				case "remove":
					System.out.println("Are you sure you would like to remove the last entered expense? y/n");
					String removeConfirm = input.next().toLowerCase();
					
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
					System.out.println("DEBUG - Size of expenses: " + expenses.size() + ".");
					break;
					//logic to reset they expenses arraylist with user confirmation.
				case "reset":
					System.out.println("Are you sure you want to reset your entire expense list?  There is no restoring it after this. y/n");				
					String confirmExpenseReset = input.next();
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
					String confirmExit = input.next();
					if (confirmExit.toLowerCase().equals("y")){
						System.out.println("Closing the expenses module.");
						expensesLoop = false;
					} else if (confirmExit.toLowerCase().equals("n")) {
						System.out.println("Aborting expense module closure.");
					} else {
						System.out.println("If you really wish to exit the expenses module then type \"exit\" and follow the prompts again.");
					}
					break;
				default:
					System.out.println("Invalid command used. Please try again.");
					break;
			} //closes expenses switch
	}//closes while expensesLoop
	//expensesLoop = false;
}//closes expenseModule()
	//checks if expense file exists. if not it creates one.
	public static void checkForSave() {
	System.out.println("Checking for saved expenses.....");
	try {
		File mySaveFile = new File(filePath);
		if (mySaveFile.createNewFile()) {
			System.out.println("File created: " + mySaveFile.getName());
		} else {
			System.out.println("Save file already exists! Loading in save.");
			//reads save file and saves it into expense arraylist.
			importSave();
		}
	}
	catch (IOException e){
		System.out.println("An error occurred.");
		e.printStackTrace();
	}
	}
	public static void expenseOptions() {
		System.out.println("\"add\" - use this to add an expense to the list of expenses.");
		System.out.println("\"remove\" - use this to remove the last added expense.");
		System.out.println("\"view\" - use this to view all of your current expenses.");
		System.out.println("\"reset\" - use this to reset your expense list entirely.");
		System.out.println("\"sum\" - use this to add all of your expenses together.");
		System.out.println("\"save\" - use this to save your expense list to a file on your computer.");
		System.out.println("\"import\" - use this to import the expense list from a previously saved file.");
		System.out.println("\"exit\" - use this to close the expense program.");
	}
	
	//imports save from specified filePath then reads the strings in file and copies strings into expenses ArrayList. Calls convert string to double to convert input at the same time.
	public static void importSave() {
		try {
			File mySave = new File(filePath);
			input = new Scanner(mySave);
			while (input.hasNextLine()) {
				importList.add(input.nextLine());
			}
			expenses = convertArrayListToDoubleFromString(importList);
			
			System.out.println("You\'ve imported an expense list with " + expenses);
			//closes input
			//input.close();
							
		} catch (IOException e) {
			System.out.println("\n\n\nAn error occurred while trying to import save file.\n\n\n");
			e.printStackTrace();
		}
	}
	public static String strInput() {
		String next;
		if (input.hasNext()) {
			next = input.next();
			return next;
		}
		return "Error: No strInput. use a valid parameter.";
		
	}
	public static Double dblInput() {
		double dblInput = input.nextDouble();
		return dblInput;
	}
	//takes in a Double ArrayList and converts it to a String ArrayList.
	public static ArrayList<String> convertArrayListToStringFromDouble(ArrayList<Double> doubleList) {
		ArrayList<String> stringSave = new ArrayList<String>();
		for (Double d : doubleList) {
			stringSave.add(d.toString());
		}
		//System.out.println("Successfully converted DoubleArray to a StringArray.");
		return stringSave;
	}
	//takes in a String ArrayList and converts it to a Double ArrayList
	public static ArrayList<Double> convertArrayListToDoubleFromString(ArrayList<String> stringList){
		ArrayList<Double> doubleSave = new ArrayList<Double>();
		for (String d : stringList) {
			doubleSave.add(Double.parseDouble(d));
		}
		//System.out.println("Successfully converted StringArray to a DoubleArray.");
		return doubleSave;
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
	//Saves the ArrayList of expenses to specified filePath in string format, each entry is on a newline.  If nothing is in the expense array then write nothing.
	public static void saveFile() {
		try {
			FileWriter myWriter = new FileWriter(filePath);
			ArrayList<String> expensee = convertArrayListToStringFromDouble(expenses);
			for (int i = 0; i < expensee.size(); i++) {
				if (expenses.size() == 0) {
					myWriter.write("");
				}else {
					myWriter.write(expensee.get(i)+ "\n");	
				}
			}
			myWriter.close();				
			System.out.println("Successfully saved to " + filePath);
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}



}
