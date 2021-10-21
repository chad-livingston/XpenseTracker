package xpense;

import java.util.ArrayList;
import java.util.Scanner;

public class Investments {
	private static ArrayList<String> investmentSymbols = new ArrayList<String>();
	private Scanner investmentScanner = new Scanner(System.in);
	
	public void investmentModule() {
		Boolean investing = true;
		
		System.out.println("\nWelcome to the investment module. What would you like to do?");
		investmentOptions();
		
		while(investing) {
			String investmentInput = investmentScanner.next();
			switch(investmentInput) {
			case "opt":
				investmentOptions();
				break;
			case "add":
				Boolean adding = true;
				System.out.println("What symbol would you like to add to your list?");
				
				while (adding) {
						//int charCount = checkCharCount(investmentScanner.next()); 
						if (!investmentScanner.next().toLowerCase().equals("done") && investmentScanner.next() != "") {
							//String add = strInput().toLowerCase().trim();
							addSymbol(strInput().toUpperCase().trim());
						}else if (strInput().toLowerCase().equals("done")) {
							System.out.println("You are now finished adding symbols.");
							adding = false;
						} else { 					
						System.out.println("You must enter a 3 or 4 digit symbol to add it to the list or \"done\" to stop adding symbols.");	
						}
					} //closes adding loop.
				break;
			case "remove":
				break;
			case "view":
				System.out.println("Here is a list of your symbols: " + investmentSymbols);
				
				break;
			case "reset":
				break;
			case "save":
				break;
			case "import":
				break;
			case "test":
				System.out.println("DEBUG - Size of investmentSymbols: " + investmentSymbols.size() + ".");
				checkCharCount(investmentInput);
				break;
			case "exit":
				System.out.println("Are you sure you want to close the investment module?? \"y/n\"");
				String confirmExit = investmentScanner.next();
				if (confirmExit.toLowerCase().equals("y")){
					System.out.println("Closing the expenses module.");
					investmentScanner.close();
					investing = false;
				} else if (confirmExit.toLowerCase().equals("n")) {
					System.out.println("Aborting expense module closure.");
				} else {
					System.out.println("If you really wish to exit the investment module then type \"exit\" and follow the prompts again.");
				}
				break;
			default:
				break;
			}
		}//closes while investing loop;
	}//closes investmentModule() method;
	
	
	public static void addSymbol(String symbol) {	
			investmentSymbols.add(symbol);
			System.out.println("Adding " + symbol + " to the list of symbols. Enter another symbol if you have one or \"done\" to stop.");
		
	}
	public static void removeSymbol() {
		
	}
	public static void viewSymbols() {
		
	}
	public int checkCharCount(String string) {
		if (string.length() > 0) {
			return 0;
		} else {
			return string.length();
		}

		//System.out.println("The current character count stored in investmentInput Scanner is: " + count);
		//System.out.println("The current string stored in investmentInput Scanner is: " + string);
	}
	public static void investmentOptions() {
		System.out.println("\"add\" - use this to add a symbol to the list of investments.");
		System.out.println("\"remove\" - use this to remove a symbol from the list of investments by using the name of the symbol. ex:\"amc\"");
		System.out.println("\"view\" - use this to view all of your current symbols and their cost basis.");
		System.out.println("\"reset\" - use this to reset your list of symbols and your stock purchase history entirely.");
		System.out.println("\"save\" - use this to save your symbols and purchase history to a file on your computer.");
		System.out.println("\"import\" - use this to import the symbol and purchase history from a previously saved file.");
		System.out.println("\"exit\" - use this to close the investment module.");
	}
	public String strInput() {
		String next;
		if (investmentScanner.hasNext()) {
			next = investmentScanner.next();
			return next;
		} else {
			return "Error: No strInput. use a valid parameter.";
		}
	}
	
}
