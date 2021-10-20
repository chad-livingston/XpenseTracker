package xpense;




class test {
	public void testing () {
/*switch(expensesIn) {
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
								Double add = in.nextDouble();
								addExpense(add);
								//if done is entered then done adding expenses. close loop.
							}else if (in.hasNext()) {
								String done = in.next().toLowerCase();
								if (done.equals("done")) {
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
						System.out.println("Here is a list of your expenses: " + expenses);
						Double h = budget();
						System.out.println("Budget - Expenses = " + h);
						System.out.println("DEBUG - Size of expenses: " + expenses.size() + ".");
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
						String confirmExit = in.next();
						switch (confirmExit) {
						case "y":
							System.out.println("Closing the expenses module.");
							expensesLoop = false;
							//in.close();
							break;
						case "n":
							System.out.println("Aborting expense module closure.");
							break;
						default:
							System.out.println("If you really wish to exit the expenses module then type \"exit\" and follow the prompts again.");
							break;
						}
						break;
					default:
						//default to print if input read is not listed.
						System.out.println("Invalid input, Type opt for help.");
						break;
					}
			
}*/
}
}