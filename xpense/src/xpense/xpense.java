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
                    System.out.println("Which module would you like to enter? \n");
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
                    System.out.print("Where would you like to go? \n");
                    System.out.println("Add Stock");
                    System.out.println("Cost Basis");
                    System.out.println("Exit to close the module.");
                    while (investModule) {
                        String input = in.nextLine().toLowerCase();
                        switch (input) {
                            case "opt":
                                System.out.println("\"add\" - to add a stock purchase to the list of purchases.");
                                System.out.println("\"cost\" - to calculate your current cost basis from the list of stocks.");
                                break;
                            case "a":
                            case "add stock":
                                System.out.println("Add a stock to the list.");
                                System.out.println("Which symbol to add?");
                                String symbol = in.nextLine().toLowerCase();
                                System.out.println("How many shares were bought?");
                                Double userBoughtCount = in.nextDouble();
                                System.out.println("How much paid per share?");
                                Double userBoughtPrice = in.nextDouble();
                                Investments addStock = new Investments(symbol, userBoughtCount, userBoughtPrice);


                                break;
                            case "c":
                            case "cost":
                                System.out.println("Which symbol would you like to calculate cost basis for?");
                                String userSymbolToCalculate = in.nextLine();
                                
                                break;
                            case "exit":

                                investModule = false;
                                System.out.println("You are now in module selection.  Which module would you like to enter?");
                                moduleListing();
                                break;
                            default:
                                System.out.println("Sorry unable to determine where you wanted to go in this module. Please type \"opt\" for help.");
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
    public static void moduleListing() {
        System.out.println("Expenses");
        System.out.println("Bank");
        System.out.println("Budget");
        System.out.println("Investments");
        System.out.println("Exit to close program.");
    }

}

