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
                    boolean expenseModule = true;
                    System.out.println("Welcome to the expenses module! ");
                    System.out.print("Where would you like to begin?");
                    expenseModuleListing();
                    ArrayList<expenses> expenses = new ArrayList<>();
                    while (expenseModule){
                        String input = in.nextLine().toLowerCase();
                        switch (input) {
                            case "opt":
                                expenseModuleListing();
                                break;
                            case "a":
                            case "add":
                                while (true){
                                    System.out.println("Where was the purchase made?");
                                    String storeName = in.nextLine();
                                    if (storeName.equals("")){
                                        break;
                                    }
                                    System.out.println("How much was the purchase?");
                                    Double expenseVal = Double.parseDouble(in.nextLine());

                                    expenses.add(new expenses(storeName, expenseVal));
                                }
                                break;
                            default:
                                System.out.println("Invalid input entered. \"opt\" for help.");
                                break;
                        }
                    }
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
                    //creates arraylist of Investment Transactions containing Symbol, Count, and Price
                    ArrayList<Investments> stockTransactions = new ArrayList<>();
                    ArrayList<String> stockList= new ArrayList<>();
                    while (investModule) {
                        String input = in.nextLine().toLowerCase();
                        switch (input) {
                            case "opt":
                                System.out.println("\"add\" - to add a stock transaction to the list.");
                                System.out.println("\"cost\" - to calculate your current cost basis from the list of stockTransactions.");
                                System.out.println("\"remove\" - to remove the last transaction from the list.");
                                System.out.println("\"view\" - to view the list of transactions currently stored in the list.");
                                break;
                            case "a":
                            case "add":
                            case "add trans":
                                //boolean adding = true;
                                System.out.println("Add a stock to the list.");
                                //ArrayList<Investments> stockTransactions = new ArrayList<>();
                                while (true) {
                                    System.out.println("Which symbol to add? To exit enter a blank line.");
                                    String symbol = in.nextLine().toLowerCase();
                                    if (symbol.equals("")){
                                        break;
                                    }
                                    System.out.println("How many shares were bought?");
                                    double userBoughtCount = Double.parseDouble(in.nextLine());
                                    System.out.println("How much paid per share?");
                                    double userBoughtPrice = Double.parseDouble(in.nextLine());
                                    stockTransactions.add(new Investments(symbol, userBoughtCount, userBoughtPrice));
                                }
                                System.out.println("Done adding Transactions to the list. You are now back to the home screen of investments module.");
                                break;
                            case "c":
                            case "cost":

                                double sumOfUserInputedStockPrice = 0;
                                double sumOfUserInputedStockCount = 0;

                                System.out.println(stockList);
                                System.out.println("Which symbol would you like to calculate cost basis for?");
                                String userSymbolToCalculate = in.nextLine();

                                for (Investments list : stockTransactions){
                                    if (list.getStockSymbol().equals(userSymbolToCalculate)){
                                        //adds all symbols to their own list of strings


                                        stockList.add(list.getStockSymbol());
                                        //sums together the total price of all stocks purchased for the userInputtedStock
                                        sumOfUserInputedStockPrice += list.getBoughtPrice() * list.getBoughtCount();
                                        //sums together the total count of all stocks purchased for the userInputtedStock
                                        sumOfUserInputedStockCount += list.getBoughtCount();
                                    }


                                }
                                if (userSymbolToCalculate.equals("")){
                                    System.out.println("Closing cost section.");
                                    break;
                                }
                                if (sumOfUserInputedStockPrice > 0) {
                                    System.out.println("The total of price paid for " + userSymbolToCalculate + " is: " + sumOfUserInputedStockPrice);
                                } else {
                                    System.out.println("You don't have any stocks in the list matching the symbol you entered.");
                                }
                                if (sumOfUserInputedStockCount > 0){
                                    System.out.println("The total number of shares owned for " + userSymbolToCalculate + " is " + sumOfUserInputedStockCount);
                                } else {
                                    System.out.println("You don't have any shares in the symbol entered.");
                                }
                                if (sumOfUserInputedStockCount > 0 && sumOfUserInputedStockPrice > 0) {
                                    System.out.println("Average cost per share: " + costBasis(sumOfUserInputedStockCount,sumOfUserInputedStockPrice));
                                }
                                break;
                            case "r":
                            case "remove":
                            case "remove last":
                                System.out.println("Are you sure you want to remove the last stock added to the list? \"y\" to remove.");
                                String userInputRemoval = in.nextLine();
                                if (userInputRemoval.toLowerCase().equals("y") && stockTransactions.size() > 0) {
                                    System.out.println("You have removed " + stockTransactions.get(stockTransactions.size() - 1) + " from the list of stock.");
                                    stockTransactions.remove(stockTransactions.size() - 1);
                                } else {
                                    System.out.println("Nothing to remove from the list of stock transactions.");
                                }
                                break;
                            case "v":
                            case "view":
                                //System.out.println(stockTransactions.size());
                                //System.out.println(stockTransactions);
                                if (stockTransactions.size() > 0) {
                                    System.out.println("These are the stockTransactions that are currently in the list:");
                                    for (Investments stock : stockTransactions) {
                                        System.out.println(stock);
                                        for (String element : stockList){
                                            if (!stockList.contains(element)){
                                                stockList.add(stock.getStockSymbol());
                                            }
                                        }
                                    }
                                    System.out.println("The symbols you own are: ");
                                    System.out.println(stockList);
                                } else {
                                    System.out.println("You currently have no transactions added to the list.");
                                }
                                break;
                            case "clear":
                                System.out.println("Clearing all transactions from the list.");
                                stockTransactions.clear();
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
                    running = false;
                    in.close();
                    break;
//********************************************************************* DEFAULT MODULE SELECTION ***************************************************************************************
                default:
                    System.out.println("Unable to determine the proper module to enter. Please try another command or \"module\" for help.");
                    break;
            }
        }
    }

    //********************************************************************* METHODS ***************************************************************************************
    public static void moduleListing() {
        System.out.println("\"expenses\" - The expenses module for tracking and monitoring your expense habits.");
        System.out.println("\"bank\" - The banking module for viewing your bank accounts and seeing your financial health.");
        System.out.println("\"budget\" - The budget module for creating, viewing a budget to keep you on track for your financial goals.");
        System.out.println("\"investments\" - The investment module for viewing your investments, and calculating your average cost for stock.");
        System.out.println("Exit to close program.");
    }
    public static void expenseModuleListing(){
        System.out.println("\"import\" - use this to import your expenses from a CSV file.");
        System.out.println("\"add\" - use this to add an expense to the list of expenses.");
        System.out.println("\"view\" - use this to view the expenses in your list of expenses.");
    }
    public static void investmentModuleListing(){
        System.out.println("");
        System.out.println("");
    }
    public static double costBasis(double shareCount, double sharePrice){
        double costBasis = sharePrice / shareCount;
        return costBasis;
    }

}
