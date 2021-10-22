package xpense;
//import xpense.Bank;
//import xpense.Categories;
import java.util.Scanner;

public class xpense {

	
	//creates scanner for taking user input.
	public static Scanner in;
	//boolean to loop program. exit case switches this value to false; ending the program.
	public static Boolean running = true;
	public static String filePath = "E:\\Git\\LocalXpenseTracker\\xpense\\expense.txt";
	//budget value;
	//public static double budget = 0;
	
	
	public static void main(String[] args) {
		//Starting prompt with list of modules available to go into.
		System.out.println("Welcome to the console expense tracker!");
		System.out.println("This app has several modules included.");
		System.out.println("Which module would you like to enter?");
		System.out.println("Expenses");
		System.out.println("Bank");
		System.out.println("Budget");
		System.out.println("Investment");
		in = new Scanner(System.in);
		//while loop to continuously run program until exit case in switch for strInput().
		while (running) {
			
		//switch for module selection.
			switch (strInput().toLowerCase()) {
			case "module":
				System.out.println("This app has several modules included.");
				System.out.println("Which module would you like to enter?");
				System.out.println("Expenses");
				System.out.println("Bank");
				System.out.println("Budget");
				System.out.println("Investment");
				break;
//********************************************************************* EXPENSES MODULE ***************************************************************************************
			case "e":
			case "expenses":
				expenses expense = new expenses();
				expense.expenseModule();
				break;
//********************************************************************* BANK MODULE ***************************************************************************************
			case "ba":
			case "bank":
				Bank bank = new Bank();
				bank.bankModule();
				break;
//********************************************************************* BUDGET MODULE ***************************************************************************************
			case "bu":
			case "budget":
				//Categories category = new Categories();
				Budget budget = new Budget();
				budget.budgetModule();
				break;
//********************************************************************* INVESTMENT MODULE ***************************************************************************************
			case "i":
			case "investment":
				Investments investment = new Investments();
				investment.investmentModule();
				break;
//********************************************************************* EXIT PROGRAM ***************************************************************************************					
			case "c":
			case "exit":
				System.out.println("Closing the program.");
				//close reader here
				in.close();
				break;
//********************************************************************* DEFFAULT MODULE SELECTION ***************************************************************************************
			default:
				System.out.println("Unable to determine the proper module to enter.");
				break;
				}
			}
		}
//********************************************************************* METHODS ***************************************************************************************
		public static String strInput() {
			
			if (in.hasNext()) {
				String strInput = in.next();
				return strInput;
			}
			return "String not Found.";
		}
		public static double dblInput() {
			double dblInput = in.nextDouble();
			return dblInput;
		}


	}
