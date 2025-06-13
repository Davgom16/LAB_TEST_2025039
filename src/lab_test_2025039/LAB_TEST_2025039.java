/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_test_2025039;

// import comands from java in order to read file and user's input

import java.util.Scanner;
import java.io.FileReader;
/**
 *
 * @author dav_g
 */
public class LAB_TEST_2025039 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Declaring variables
        
        //variables used for read the doc. "C:\Users\dav_g\Documents\NetBeansProjects\LAB_TEST_2025039\data.txt"
        
        // Declare a variable to store the document (file) name
        String doc_name;
        // Assign the file name "data.txt" to the variable
        doc_name="data.txt";
        // Declare a Scanner object to read the file, initially set to null
        Scanner doc_data = null;
        // Declare a variable to store the data read from the file
        String data;
        
        // variables used
        
        // Declare a variable to store a numeric value
        double num;
        // Declare a string variable to store user's choice or input
        String choose;
        // Declare an integer variable to represent a numerical choice or selection
        int choice;
        // Initialize a counter to track total number of inputs or iterations
        int count=0;
        // Initialize a counter to track the number of valid entries
        int count_real=0;
        // Initialize a counter to track the number of errors or invalid entries
        int count_error=0;
        // Initialize a variable to hold the sum of values
        double sum=0;
        // Declare a variable to store the average of the numbers
        double avg;
        // Declare an array to store multiple values
        double[] numbers;
        // Declare a variable to store the maximum value among the numbers
        double max;
   
        // try was  used in case the program can not find the document
        
        try {
            // Create a Scanner object to read input from the keyboard
           Scanner myKB = new Scanner (System.in);
            // Outer loop that likely continues until the user chooses to exit
            do {
                // Display the menu of options to the user
                System.out.println("""
                                   Choose 1 if you need the quantity of valid and invalid entries
                                   Choose 2 if you wnat to know the highest salary
                                   Choose 3 if you want to calculate the average weekly salary
                                   Choose 4 if you want to exit""");
                // Inner loop to validate that the user enters a single-digit number (0-9)
                do{

                    System.out.println("You must enter an integer value.");
                    // Read the user's input as a string
                    choose = myKB.nextLine();

                // Repeat if input is not a single digit (0-9)
                }while (!choose.matches("[0-9]"));
                // Initialize the Scanner object to read from the file specified in doc_name   
                doc_data = new Scanner(new FileReader(doc_name));
                // Loop through each line in the file
                    while(doc_data.hasNext()){
                        // Read one line of data from the file
                        data = doc_data.nextLine();
                        // Check if the data is a number (integer or decimal)
                        // Regex [0-9]+ matches whole numbers; contains(".") checks for decimal numbers
                        if (data.matches("[0-9]+")==true || !!data.contains(".")) {
                                //this count is just to know the length of the array in case 2
                                count_real=count_real+1; 
                        }
                    }

                // Convert the valid input string into an integer
                choice = Integer.parseInt(choose);
                
                // Switch statement to handle different menu options based on user's choice
                switch (choice) {
                    // Case 1: Count valid and invalid entries in the file
                    case 1 -> {
                            //reset values
                            count_real=0;
                            count_error=0;
                            // Initialize the Scanner object to read from the file specified in doc_name
                            doc_data = new Scanner(new FileReader(doc_name));
                            // Loop through each line in the file
                            while(doc_data.hasNext()){
                                // Read one line of data from the file
                                data = doc_data.nextLine();

                              // Check if the data is a number (integer or decimal)
                              // Regex [0-9]+ matches whole numbers; contains(".") checks for decimal numbers
                              if (data.matches("[0-9]+")==true || !!data.contains(".")) {

                                  count_real=count_real+1; // counting real numbers

                              }else{

                                  count_error=count_error+1; // counting errors (not number)

                              }

                            } 

                        // Output the results
                        System.out.println("\nValid entries\n" + count_real + "\nInvalid entries \n" + count_error);

                    }
                    // Case 2: find the highest salary in the file
                    case 2 -> {
                        //reset count value
                        count=0;
                        // Initialize the numbers array to hold all valid numeric entries counted previously
                        numbers = new double[count_real];
                        // Re-open the file to read data again
                        doc_data = new Scanner(new FileReader(doc_name));
                        // Loop through each line in the file
                        while(doc_data.hasNext()){
                            // Read one line of data from the file
                            data = doc_data.nextLine();
                            // Check if the data is a valid number (integer or decimal)
                            if (data.matches("[0-9]+")==true || !!data.contains(".")) {
                                // converting string to a number if the statement is true
                                num = Double.parseDouble(data); 
                                // Increment the count of valid numbers read so far
                                count=count+1;
                                // Store the number in the array (adjust index for 0-based)
                                numbers[count-1] = num;

                            }

                        }
                        // Initialize max to the first number in the array
                        max = numbers[0];
                        // Loop through the array starting from the second element
                        for (int i = 1; i < numbers.length; i++) {
                            // Update max if current number is greater
                            if (numbers[i] > max) {
                                max = numbers[i];             
                            }
                        }
                        // Print out the highest salary found
                        System.out.println("Highest salary is \n" + max);

                    }
                    // Case 3: find the average weekly salary in the file
                    case 3 -> {
                        //reset values
                        sum=0;
                        avg=0;
                        count=0;
                        // Re-open the file to read data again
                        doc_data = new Scanner(new FileReader(doc_name));
                        // Loop through each line in the file
                            while(doc_data.hasNext()){
                                // Read a line from the file
                                data = doc_data.nextLine();

                                // taking each value inside the doc and find if it is a number or not
                              if (data.matches("[0-9]+")==true || !!data.contains(".")) {
                                  // converting string to a number if the statement is true
                                  num = Double.parseDouble(data); 
                                  // Add the number to the running total sum
                                  sum=(sum+num); 
                                  // Increment the count of valid numbers read so far
                                  count=count+1;
                              }
                            }
                        if (count_real > 0) {
                             // Calculate the average by dividing the sum by the number of valid entries
                            avg = sum / count;
                            // Print the average salary
                            System.out.println("Average weekly salary is \n" + avg);
                        } else {
                            // Handle case where there are no valid entries to avoid division by zero
                            System.out.println("No valid data to calculate average.");
                        }
                    }
                    case 4 -> {
                        // Set choice to 4 to ensure the loop exits
                        choice=4;
                        // Notify the user that the program is exiting
                        System.out.println("exit program");
                    }
                    default -> {
                        // Handle any input that doesn't match cases 1–4
                        System.out.println("invalid input, pleas try again");
                    }
                }
            // Continue looping until the user selects option 4 to exit    
            }while (!(choice==4));
            
          
 
        }catch (Exception e){
          // Catch any exceptions, such as file not found or input/output errors

           // Print the error message and specify the file that couldn't be accessed
          System.out.println(e.getMessage() + "Error - unable to find file " + doc_name);

    }
    
}
}
