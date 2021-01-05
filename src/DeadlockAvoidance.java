import java.util.Scanner;

/**
 * Programmer: Marissa Gonçalves
 * Due Date: December 7, 2018
 */


public class DeadlockAvoidance
{

     //Initialize the needed variables for the algorithm
     private static int i, j, l, r, n;
     private static int c = 0;
     private static int cn = 0;
     private static int cz = 0;
     private static int temp = 0;
     private static final int[][] max = new int[10][10];
     private static final int[][] al = new int[10][10];
     private static final int[][] need = new int[10][10];
     private static final int[][] before = new int[10][10];
     private static final int[][] after = new int[10][10];
     private static final int[] tot = new int[10];
     private static final int[] av = new int[10];
      
    
    
    /**
     * Runs the Simulation of Deadlock Avoidance
     * @param args The classic name defining a String array in the main class.
     */
    public static void main(String[] args) 
    {
        
        
       //Create a new scanner object to read the following inputs
       Scanner keyboard = new Scanner(System.in);
       
       
       
       //Display the title of the deadlock avoidance algorithm
       System.out.println("SIMULATION OF DEADLOCK AVOIDANCE");
       
       
   
       
       //Display a statement telling user to input the number of processes
       System.out.print("\nEnter no. of processes: " );
       

       
       //Prompt the user to input the number of processes
       n = keyboard.nextInt();
       
      
    
       
       //Display a statement telling user to input the number of resources
       System.out.print("\nEnter no. of resources: " );
       
       
       
       //Prompt the user to input the number of resources
       r = keyboard.nextInt();
       
       
       
       //Skip a line
       System.out.println();
       
       
       
       //For every element, up to the inputted number of processes
       for(i = 0; i < n; i++)
       {
           
           //Display statement specifying the process number
           System.out.printf("\nProcess %d \n", i + 1);
      
           
           //For every element, up to the inputted number of resources
           for(j = 0; j < r; j++)
           {
               
               //Print statement to input a maximum value for a specific resource number
               System.out.printf("Maximum Value for Resource %d: ", j + 1); 
               
               //Fill the maximum array index value with an inputted value
               max[i][j] = keyboard.nextInt();
               
           }
           
           
           //For every element, up to the inputted number of resources
           for(j = 0; j < r; j++)
           {
               
               //Print statement to input an allocation value for a specific resource number
               System.out.printf("Allocated from Resource %d: ", j + 1); 
               
               //Fill the allocation array index value with the inputted value
               al[i][j] = keyboard.nextInt();
               
               //Calculate the need array index value, where the maximum and allocation array index values must be subtracted from another
               need[i][j] = max[i][j] - al[i][j];
               
           }
       
       }
       
       
       //For every element, up to the inputted number of resources
       for(i = 0; i < r; i++)
       {
           
           //Print statement to input an total value for a specific resource number
           System.out.printf("Total Value of Resources %d: ", i + 1); 
           
           //Fill the total array index value with an inputted value
           tot[i] = keyboard.nextInt();
           
       }
       
       
       
       //For every element, up to the inputted number of resources
       for(i = 0; i < r; i++) 
       { 
           
           //For every element, up to the inputted number of processes
           for(j = 0; j < n; j++) 
           {
               //Add the allocated array index value to the temporary variable
               temp += al[j][i];
           }
           
           //Allow the avaiable array index equal to the calculation of the total array index subtracted by the temporary variable
           av[i] = tot[i] - temp;
           
           //Set the temporary variable to a value of 0
           temp = 0; 
           
       } 
       
       
       //Print the columns of the table to show the number of recorded devices 
       System.out.println("\n\tMax Allocated Needed Total Available");
       
       
       //For every element, up to the inputted number of processes
       for(i = 0; i < n; i++)
       {
          
          //Print the process number for the specific row in the table
          System.out.printf("\n P%d \t",i + 1); 
          
          
          //For every element, up to the inputted number of resources
          for(j = 0; j < r; j++) 
          {
              //Print the index element from the maximum array
              System.out.print(max[i][j]);
          } 
          
          
          //Implement a tab space
          System.out.printf("\t"); 
          
          
          
           //For every element, up to the inputted number of resources
          for(j = 0; j < r; j++) 
          {
              //Print the index element from the allocated array
              System.out.print(al[i][j]);
              
          }
           
          
          //Implement a tab space
          System.out.printf("\t"); 
          
          
          
          //For every element, up to the inputted number of resources
          for(j = 0;j < r; j++) 
          {  
              //Print the indexed element from the need array
              System.out.print(need[i][j]); 
          }
          
          
          //Implement a tab space
          System.out.printf("\t"); 
          
          
          
          
          //For every element, up to the inputted number of resources
          for(j = 0; j < r; j++)  
          { 
              //If the index is equal to 0, do the following
              if(i == 0)
              {
                  //Print the index element from the total array
                  System.out.print(tot[j]);
              }  
          } 
       

          //Print out a space
          System.out.print(" ");
          
          
          //For every element, up to the inputted number of resources
          for(j = 0; j < r; j++) 
          { 
              
             //If the index is equal to 0, do the following
             if(i == 0) 
             {
                 //Print the index element from the available array
                 System.out.print(av[j]);
             }  
             
          }
       
       }
       
       
       //Print the columns of the table to demonstrate the number of free devices before and after
       System.out.printf("\n\n\t Available Before Available After");
       
       
       //For every element, up to the inputted number of processes
       for(l = 0; l < n; l++)
       {
           
            //For every element, up to the inputted number of processes
           for (i = 0; i < n; i++)
           {
               
               //For every element, up to the inputted number of resources
               for(j = 0; j < r; j++)
               {
                   
                   
                   //If the need array index element is greater than the available array element, proceed with the following code
                   if(need[i][j] > av[j])
                   {
                       //The process check variable increments by 1
                       cn++;
                   }
                   
                   
                   //If the maximum array index element has a value of 0, do this next
                   if(max[i][j] == 0)
                   {
                       //The resource check variable increments by 1
                       cz++;
                   }
                   
                   
               }
               
               
               //If the process check variable is equal to 0 and the resource check variable is not equal to the number of resources
               if(cn == 0 && cz != r)
               {
                   
                   //For every element, up to the inputted number of resources
                   for(j = 0; j < r; j++)
                   {
                       
                       //Set the before index element to the result on the difference of the available array index value and the need array index value
                       before[i][j] = av[j] - need[i][j];
                       
                       //Set the after index element to the result on the sum of the before array index value and the max array index value
                       after[i][j] = before[i][j] + max[i][j]; 
                        
                       //Let the available array index value equal to the after array index element
                       av[j] = after[i][j]; 
                       
                       //Set the maximum array index element to 0
                       max[i][j] = 0;
                       
                   }
                   
                   
                   
                   //Print the process number for the specific row in the table
                   System.out.printf("\n P%d \t\t", i + 1);
                   
                   
                   
                   //For every element, up to the inputted number of resources
                   for(j = 0; j < r; j++)
                   {
                       //Print the index element from the before array
                       System.out.print(before[i][j]);
                       
                   }
                   
                   
                   
                   //Implement two tab spaces
                   System.out.print("\t\t");
                   
                   
                   
                   //For every element, up to the inputted number of resources
                   for(j = 0; j < r; j++)
                   {
                       //Print the index element from the after array
                       System.out.print(after[i][j]);
                       
                   }
                   
                   
                   
                   //Let the process check variable equal to 0
                   cn = 0;
                   
                   //Let the resource check variable equal to 0
                   cz = 0;
                   
                   //Let the check varaible increment by 1
                   c++;
                   
                   //Break out of the if-statement clause
                   break;
                   
                   
               }
               
                //If the if-condition above doesn't follow values, perform the following else statement
                else
                {
                   
                   //Let the process check variable equal to 0
                   cn = 0;
                   
                   //Let the resource check variable equal to 0
                   cz = 0;
                   
                }
               
           }
           
       }
       
       
       
       //If the the check variable is equal to the number of processes, do the following
       if(c == n)
       {
          
           //Display a print statement declaring that the sequence is safe
           System.out.println("\n\n The Above Seqeunce is a Safe Sequence.");
           
       }  
       
       //If the the check variable is not equal to the number of processes, proceed with the following
       else
       {
           
           //Display a print statement mentioning a deadlock occurance
           System.out.println("\n\n Deadlock Occured.");
           
       }
     
       
    }

}
 

