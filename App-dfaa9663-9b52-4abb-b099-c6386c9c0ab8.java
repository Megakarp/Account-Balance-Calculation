/******************************************************************* 
 * Name: Zachary Doubikin
 * Date: 05/1/2022
 * Assignment CIS218 Week 4 PA Account Balance Calculations
 *  
 * Main application (program) class. 
 * In this application we will demonstrate the use of exception handling 
 * to generate and properly handle both a user-generated and a system- 
 * generated exception, allowing the program to continue operating after  
 * an exception is thrown. 
 */ 
import java.util.InputMismatchException; 
import java.util.Scanner; 
 
public class App { 
    public static void main(String[] args) throws Exception { 
        // Print a header line 
        System.out.println("Doubikin - Week 4 PA Account Balance Calculations");
        System.out.println("");
        
 
        try (Scanner scanner = new Scanner(System.in)) { 
            System.out.printf("Please enter the starting balance: ");
            double curBal = scanner.nextDouble();
            double addBal = -1;
            //sets the loop to end if 0 is entered
            while(addBal != 0) { 
                try { 
                    System.out.printf("%nPlease enter a credit or debit amount (0 to quit): "); 
                    addBal = scanner.nextDouble();
                    //creates a fake estimate balance for the if statement
                    double estBal = addBal + curBal;
                    if(estBal < 0)
                        throw new InputMismatchException("Amount entered will cause account to be negative.");                    
                    else
                        curBal = addBal + curBal;
                        System.out.printf("%nThe updated balance is: %.2f", curBal);   
                } catch (InputMismatchException e) { 
                    //print the exception that was caught 
                    System.err.printf("%s%n", e); 
                    //discard the input so the user can try again 
                    scanner.nextLine(); 
                }
 
            }
        } 
    } 
} 