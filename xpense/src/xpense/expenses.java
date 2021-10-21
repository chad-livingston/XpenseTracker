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
	//loops until program finishes.
	
	Boolean expensesLoop = true;
	String expensesInput = strInput();
	while (expensesLoop) {
		//stores the value of the next input.
		
		switch(expensesInput) {
		//shows the user the available commands
		case "opt":
			
			expenseOptions();
			break;
			//adds double type values from user input into expense arraylist until done or no double entered.	
		case "add":
			//loop to add repeatedly instead of one by one.
			Boolean adding = true;
			System.out.println("Please type your expense to add it too the expense list. Done to stop");				
			while (adding) {
				//checks if scanner in has a double value if yes, adds the double entered into expense arraylist.
				if (input.hasNextDouble()){
					//Double add = in.nextDouble();
					addExpense(dblInput());
					//if done is entered then done adding expenses. close loop.
				}else if (input.hasNext()) {
					String done = strInput().toLowerCase();
					if (done.equals("done")) {
						System.out.println("Now done adding expenses.");
						adding = false;
						break;
					} else {
						System.out.println("Aborting expense adding. Unknown character.");
						adding = false;
						break;
					}
				}else {
					System.out.println("Please try entering your value in \"xx.xx\" format.");
				}
			}			
			break;
			default:
				break;
		} //closes expenses switch
	}//closes while expensesLoop
	expensesLoop = false;
	
	}
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
							
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	public static String strInput() {
		String strInput;
		if (input.hasNext()) {
			strInput = input.next();
			return strInput;
		}
		return "Error: No strInput";
		
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
