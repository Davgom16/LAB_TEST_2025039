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
        
        String doc_name;
        doc_name="data.txt";
        Scanner doc_data = null;
        String data;
        
        // variables used to calculate average and store numbers
        
        double num;
        String choose;
        int choice;
        int count=0;
        int count_real=0;
        int count_error=0;
        double sum=0;
        double avg;
        double[] numbers;
        double max;
   
        // try was  used in case the program can not find the document
        
        try {
           Scanner myKB = new Scanner (System.in);
 
            do {
                
                System.out.println("""
                                   Choose 1 if you need the quantity of valid and invalid entries
                                   Choose 2 if you wnat to know the highest salary
                                   Choose 3 if you want to calculate the average weekly salary
                                   Choose 4 if you want to exit""");
                
                do{
          

                    System.out.println("You must enter an integer value.");
                    choose = myKB.nextLine();


                }while (!choose.matches("[0-9]"));
                
                choice = Integer.parseInt(choose);
                
                // working on each case 
            switch (choice) {
                
                case 1 -> {
                    
                        doc_data = new Scanner(new FileReader(doc_name));
                        while(doc_data.hasNext()){

                            data = doc_data.nextLine();

                            // taking each value inside the doc and find if it is a number or not
                          if (data.matches("[0-9]+")==true || !!data.contains(".")) {

                              count_real=count_real+1; // counting real numbers

                          }else{

                              count_error=count_error+1; // counting errors (not number)
                              
                          }

                        } 
                    
                    
                    System.out.println("\nValid entries\n" + count_real + "\nInvalid entries \n" + count_error);
                    
                }
                
                case 2 -> {
                    
                    numbers = new double[count_real];
                    doc_data = new Scanner(new FileReader(doc_name));
                    while(doc_data.hasNext()){
                
                        data = doc_data.nextLine();
                
                        if (data.matches("[0-9]+")==true || !!data.contains(".")) {

                            num = Double.parseDouble(data); // converting string to a number if the statement is true
                            count=count+1; // counting real numbers
                            numbers[count-1] = num;

                        }
                
                    }
                                      
                    max = numbers[0];
                    for (int i = 1; i < numbers.length; i++) {
                        if (numbers[i] > max) {
                            max = numbers[i];             
                        }
                    }

                    System.out.println("Highest salary is \n" + max);

                }
                case 3 -> {
                    
                    doc_data = new Scanner(new FileReader(doc_name));
                        while(doc_data.hasNext()){

                            data = doc_data.nextLine();

                            // taking each value inside the doc and find if it is a number or not
                          if (data.matches("[0-9]+")==true || !!data.contains(".")) {

                              num = Double.parseDouble(data); // converting string to a number if the statement is true

                              sum=(sum+num); // calculate the average

                          }

                        } 

                    avg=sum/count_real;
                    System.out.println("Average weekly salary is \n" + avg);
                }
                case 4 -> {
                    
                    choice=4;
                    System.out.println("exit program");
                }
                default -> {
                    System.out.println("invalid input, pleas try again");
                }
            }
            }while (!(choice==4));
            
          
 
        }catch (Exception e){
          //error opening file
          System.out.println(e.getMessage() + "Error - unable to find file " + doc_name);

    }
    
}
}
