package xpense;

import java.io.File;
import java.io.IOException;

public class expenses {
	
	//checks if expense file exists. if not it creates one.

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
				if (in.hasNextDouble()){
					//Double add = in.nextDouble();
					addExpense(dblInput());
					//if done is entered then done adding expenses. close loop.
				}else if (in.hasNext()) {
					//String done = in.next().toLowerCase();
					if (strInput().equals("done")) {
						System.out.println("Now done adding expenses.");
						adding = false;
					} else {
						System.out.println("Aborting expense adding. Unknown character.");
						adding = false;
					}
				}else {
					System.out.println("Please try entering your value in \"xx.xx\" format.");
				}
			}			
			break;
		} //closes expenses switch
	}//closes while expensesLoop
	
		
		
}	
}
