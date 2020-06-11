/*
    Author: Myles Garcia
    Date:
    Description:
    This program will allow the user to create a table
    of data where they can ADD in new entries of data,
    READ the entries of data, UPDATE any entry of data,
    and DELETE and entry of data. 
    The program will store the data in an arraylist.
*/

import java.util.Scanner;
import java.util.ArrayList;

class CRUD {

        public ArrayList<String> newList = new ArrayList<String>();
        String stopCondition = "exit";

        //The create operation of CRUD
        //Adds the 'input' string to the arraylist
        public void Create(String input) {
            if (!input.equals(stopCondition)) {
                newList.add(input);
                System.out.println("You added " + "[" + input + "], type 'exit' to stop adding dish's to the list.");
            }
            else {
                System.out.println("You have exited the creation operation.\n");
                System.out.println("Here is your list: " + newList);
            }
        }

        //Reads the arrayList
        public void Read() {
            System.out.println("Here is your list: " + newList);
        }

        //The update operation of CRUD 
        //Sets index 'position' to the 'input' string
        public void Update(String input, String dish) {
            int position = newList.indexOf(dish);
            if (position <= newList.size()) {
                newList.set(position, input);
                System.out.println("\nYour new list is: " + newList);
            }
            else {
                System.out.println("That index is out of range for the list size.");
            }
        }

        //The remove operation of CRUD
        //Removes the declared input string from the arraylist
        public void Delete(String input) {
            if (newList.contains(input)){
                newList.remove(input);
                System.out.println("You deleted " + input + ", the new list is: " + newList);
            }
            else {
                System.out.println("That dish is not on the list already.");
            }
        } 

        public static void main(String[] args) {
            Scanner obj1 = new Scanner(System.in);
            Scanner obj2 = new Scanner(System.in);

            CRUD operation = new CRUD();
            boolean options = true;

            while (options) {
                System.out.println("Here are your operations to choose from:\n" + "0) Create a list or add to the list\n" + "1) Read the list\n" + "2) Update an item in the list\n" + "3) Delete an item from the list\n" + "4) Exit the program");
                System.out.println("<-------------------------------------------------------------------->");
                System.out.println("Choose an operation:");
                int userInt = obj1.nextInt();
                switch (userInt) {
                    //This calls the Create method
                    case 0:
                        System.out.println("Type in the type of food you want to add to the list: ");
                        String test = "";
                        String stopCondition = "exit";
                        while (!test.equals(stopCondition)) { 
                            String userString1 = obj2.nextLine();
                            test = userString1;
                            operation.Create(userString1);
                        }
                        System.out.println("<-------------------------------------------------------------------->");
                        break;
                    //This calls the Read method
                    case 1:
                        operation.Read();
                        System.out.println("<-------------------------------------------------------------------->");
                        break;
                    //THis calls the Update method
                    case 2:
                        System.out.println("What is the entry's new dish name?");
                        String userString2 = obj2.nextLine();

                        System.out.println("Which dish in the list would you like to update: " + operation.newList);
                        String position = obj2.nextLine();
                        operation.Update(userString2, position);
                        System.out.println("<-------------------------------------------------------------------->");
                        break;
                    //This calls the Delete method    
                    case 3:
                        System.out.println("Which food in the list do you wish to delete?");
                        String userString3 = obj2.nextLine();
                        operation.Delete(userString3);
                        System.out.println("<-------------------------------------------------------------------->");
                        break;
                    //This exits the while loop
                    case 4:
                        options = false;
                        break;
                    default:
                        System.out.println("You can only choose option 0-4, input your option again.\n");
                        break;
                }
            }
        }
}