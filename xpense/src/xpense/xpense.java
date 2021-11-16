package xpense;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class xpense {

	
	//creates scanner for taking user input.
	public static Scanner in;
	//boolean to loop program. exit case switches this value to false; ending the program.
	public static Boolean running = true;
	
	public static void main(String[] args) {
		//Starting prompt with list of modules available to go into.
		System.out.println("Welcome to the console expense tracker. ");
		System.out.print("This app has several modules included. ");
		System.out.print("Which module would you like to enter?");
		System.out.println("Expenses");
		System.out.println("Bank");
		System.out.println("Budget");
		System.out.println("Investment");
		in = new Scanner(System.in);
		//while loop to continuously run program until exit case in switch for strInput().
		while (running) {
			
		//switch for module selection.
			switch (in.nextLine().toLowerCase()) {
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
				break;
//********************************************************************* BANK MODULE ***************************************************************************************
			case "ba":
			case "bank":
				break;
//********************************************************************* BUDGET MODULE ***************************************************************************************
			case "bu":
			case "budget":

				break;
//********************************************************************* INVESTMENT MODULE ***************************************************************************************
			case "i":
			case "investment":
				//toggle for investment module. switches to false when exit is typed in.
				boolean investModule = true;
				System.out.println("Welcome to the investments module! ");
				System.out.print("Where would you like to go?");
				System.out.println("Cost Basis");
				System.out.println("Exit to close the module.");
				while(investModule) {
					String input = in.nextLine().toLowerCase();
					switch(input){
						case "cost basis":
							break;
						case "exit":
							investModule = false;
							break;
						default:
							break;

					}
				}


				break;
//********************************************************************* EXIT PROGRAM ***************************************************************************************					
			case "c":
			case "exit":
				System.out.println("Closing the program.");
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
	}
