import java.util.Scanner;

/**
 * Programmer: Marissa Gonçalves
 * Due Date: December 7, 2018
 */


public class DeadlockPrevention 
{

    //Initialize the needed variables for the algorithm
    private static int i, j, p, r;
    private static int flag = 0;
    private static final int[] finish = new int[10];
    private static final int[] avail = new int[10];
    private static final int[][] max = new int[10][10];
    private static final int[][] alloc = new int[10][10];
    private static final int[][] need = new int[10][10];
    
    
    
    /**
     * Runs the Simulation of the Deadlock Prevention.
     * @param args The classic name defining a String array in the main class.
     */
    public static void main(String[] args) 
    {
        
        
       //Create a new scanner object to read the following inputs
       Scanner keyboard = new Scanner(System.in);
       
       
       //Display the title of the deadlock prevention algorithm
       System.out.println("SIMULATION OF DEADLOCK PREVENTION");
       
       
   
       
       //Display a statement telling user to input the number of processes
       System.out.print("\nEnter no. of processes: " );
       

       //Prompt the user to input the number of processes
       p = keyboard.nextInt();
       
      

       
       //Display a statement telling user to input the number of resources
       System.out.print("\nEnter no. of resources: " );
       

       //Prompt the user to input the number of resources
       r = keyboard.nextInt();
       
       
    
       
       //Display a statement telling user to input an allocation matrix
       System.out.print("\nEnter the allocation matrix: ");
       
       
       
       //For every element, up to the inputted number of processes
       for(i = 0; i < p; i++)
       {
           
           //For every element, up to the inputted number of resources
           for(j = 0; j < r; j++)
           {
               
              //Fill the allocated array index value with inputted values of the matrix
              alloc[i][j] = keyboard.nextInt();
              
           } 
           
       }
       
       
     
       //Skip a line
       System.out.println();
       
       
       
       //Display a statement telling user to input a maximum matrix
       System.out.print("Enter the maximum matrix: ");
       
       
       
       //For every element, up to the inputted number of processes
       for(i = 0; i < p; i++)
       {
           
            //For every element, up to the inputted number of resources
	    for(j = 0; j < r; j++)
            {
                
                //Fill the maximum array index value with inputted values of the matrix
	        max[i][j] = keyboard.nextInt();
                
            }
            
       }
       
       
       
       //Skip a line
       System.out.println();
       
       
       
       //Display a statement telling user to input an available matrix
       System.out.print("Enter the available matrix: ");
        
       
       
        //For every element, up to the inputted number of resources
        for(i = 0; i < r; i++) 
        {
            
            //Fill the avaiable array index value with inputted values of the matrix
	    avail[i] = keyboard.nextInt();
            
	}
	
        
        //For every element, up to the inputted number of processes
        for(i = 0; i < p; i++) 
        {
            
            
            //For every element, up to the inputted number of resources
	    for(j = 0; j < r; j++) 
            {
                
                //Calculate the need array index value, where the maximum and allocation array index values must be subtracted from another
	        need[i][j] = max[i][j] - alloc[i][j];
            }
            
        
            

        //Call the method to keep track of processes
        fun();
                
        
        
        //When the flag variable remains equal to 0, proceed into the statement
        if(flag == 0) 
        {
            
            
            //If the finish array index value is not equal to 1
	    if(finish[i] != 1) 
            {
               
               //Display statement to mention about the matrices having a failing mutual exclusion condition
	       System.out.println("\nFailing: Mutual Exclusion Condition");
              
               
               
               //Eliminate the mutual exclusion condition, making sure that resources are not dedicated to one process
               //For every element, up to the inputted number of resources
               for(j = 0; j < r; j++) 
               {
                   //When the available array index value is less than the need array index value
	           if(avail[j] < need[i][j]) 
                   {
                       
                        //Then the the available array index value will be equal to the need array index value
			avail[j] = need[i][j];
                        
	           } 
               } 
               
               
               
               //Call the method to keep track of processes
               fun();
               
               
               //Display statement telling which process prevents a deadlock
               System.out.println("Deadlock is Prevented By Allocating Required Resources to Process " + i);
                
               
               
               
               
               
                
               //Display statement demonstrating that there is a failing non-preemption condition
               System.out.println("Failing: Non-Preemption Condition");
        
               
               //Eliminate the premption condition, as resources are only allocated as processes come
               //For every element, up to the inputted number of resources
               for(j = 0; j < r; j++) 
               {
                    
	          //When the available array index value is less than the need array index value
	          if(avail[j] < need[i][j]) 
                  {
                      
                      //Then the the available array index value will be equal to the need array index value
		      avail[j] = need[i][j];
                      
	          } 
	
                   //Let the allocated array index value equal to 0
                   alloc[i][j] = 0;
                   
               }
		
               
              //Call the method to keep track of processes
              fun();
        
              
              //Display statement demonstrating how a deadlock can be prevented
              System.out.println("Deadlock is Prevented by Allocating Needed Resources");
              
             
              
              
              
              
              
              //Display statement to mention about the matrices having a failing hold and wait condition
              System.out.println("Failing: Hold and Wait Condition");
        
               
               //Eliminate the hold and wait condition, preventing the processes from requesting additional resources
               //For every element, up to the inputted number of resources
               for(j = 0; j < r; j++) 
               {
                   
                   //When the available array index value is less than the need array index value
	           if(avail[j] < need[i][j]) 
                   {
                        //Then the the available array index value will be equal to the need array index value
			avail[j] = need[i][j];
	           } 
                   
               } 
        
               
              //Call the method to keep track of processes
              fun();
        
              
              //Display statement demonstrating how a deadlock can be prevented
              System.out.println("Deadlock is Prevented by Figuring Out Necessary Requests at Process Creation Time");
              
              
              
              
              
              
              
              
              //Display statement to mention about the matrices having a failing hold and wait condition
              System.out.println("Failing: Circular Wait Condition");
        
              

               //Eliminate the circular wait condition, preventing cycles and every process to request another resource other than theirs
               //For every element, up to the inputted number of resources
               for(j = 0; j < r; j++) 
               {
                   
                   //When the available array index value is less than the need array index value
	           if(avail[j] < need[i][j]) 
                   {
                        //Then the the available array index value will be equal to the need array index value
			avail[j] = need[i][j];
	           } 
                   
               } 
        
               
              //Call the method to keep track of processes
              fun();
              

              
              //Display statement demonstrating how a deadlock can be prevented
              System.out.println("Deadlock is Prevented by Removing Cycles and Eliminating Resource Request Ordering");
              
              
              
              
              
              //Print statement recalling that avoiding one of the conditions above can prevent deadlocks from occuring
              System.out.println("Avoiding Any One of the Conditions, You Can Prevent Deadlock");
       
           }
            
        }
        
     }
    
  }
        
 
    /**
     * Keeps track of finished processes and allocate resources to new processes, until all processes are complete
     */
    public static void fun()
    {
        
        
        //Proceed into the while loop, performing the following steps
        while(true)
        {
            
            //For every element, up to the inputted number of processes
            for(flag = 0,i = 0; i < p; i++)
            {
                
                //When the finish array index value is equal to 0
                if(finish[i] == 0)
                {
                    
                    //For every element, up to the inputted number of resources
                    for(j = 0; j < r; j++)
                    {
                        
                        //If the need array index value are less than or equal to the available array index value, do the following
                        if(need[i][j] <= avail[j])
                        {
                            //Proceed into the while-loop
                            continue;
                        }
                        
                        //Contrasting the if-statement above, do the following
                        else
                        {
                            //Break out of the while-loop
                            break;
                        }
                        
                    }
                    
                    //If the element index is equal to the number of resources, proceed with the following statement
                    if(j == r - 1)
                    {
                        //For every element, up to the inputted number of resources
                        for(j = 0; j < r; j++)
                        {
                            //Add an element values from the allocated array to the available array index element
                            avail[j] += alloc[i][j];
                        }
                        
                        //Let the flag variable equal to 1
                        flag = 1;
                        
                        //Let the finish array index value equal to 1
                        finish[i] = 1;
                        
                    }
                    
                }
                
            }
            
            
            //If the flag variable is equal to 0, proceed with the following code
            if(flag == 0)
            {
                //Break out of the while-loop
                break;
            }
                    
        }
   
    }    
    
}


