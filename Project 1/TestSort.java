/*      Created By:         Matthew A. Krieger
 *      Date:               October 04, 2015
 *      Assignment:         Homework I  
 */

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class TestSort
{
    public static void main (String[] args) throws IOException
    {
        //declarations
        final int size = 2000;
        int orderOfData = 0; 
        int randomNumber = 0;
        Scanner scan = new Scanner(System.in);
        IntegerType[] data = new IntegerType[size];
        
        
        while (orderOfData == 0)
        {
            //asks user to select the order relationship
            System.out.println("1. Ascending Order");
            System.out.println("2. Descending Order");
            System.out.println("\nSelect The Number Of The Ordering Relationship You Wish To Use:");
            orderOfData = scan.nextInt();
            System.out.println();
            System.out.println();
            
            //Ascending Order Selected
            if (orderOfData == 1)
            {
                int caseSelection = 0;
                while (caseSelection == 0)
                {
                    //asks user which case they want to use
                    System.out.println("1. Best Case");
                    System.out.println("2. Average Case");
                    System.out.println("3. Worst Case");
                    System.out.println("\nSelect The Number Of The Case You Wish To Use:");
                    caseSelection = scan.nextInt();
                    System.out.println();
                    System.out.println();
                    
                    //Constructs the .txt file for Best Case
                    if (caseSelection == 1)
                    {
                        //writes to .txt file 1==>2000
                        PrintWriter out = new PrintWriter (new FileWriter ("BestCase.txt"));
                        for (int i = 0; i < size; i++)
                        {
                            out.println(i+1);
                        }
                        out.close();
                        
                        BufferedReader s = new BufferedReader(new FileReader ("BestCase.txt"));
                        for (int x = 0; x < data.length; x++)
                        {
                            String d = s.readLine();
                            data[x] = new IntegerType(Integer.parseInt(d));
                        }
                        s.close();
                
                    }
                    
                    //Constructs the .txt file for Average Case
                    else if (caseSelection == 2)
                    {
                        //writes to .txt file random numbers between 1 ==> 2000
                        PrintWriter out = new PrintWriter (new FileWriter ("AverageCase.txt"));
                        for (int i = 0; i < size; i++)
                        {
                            randomNumber = (int) (Math.random() * 2000);
                            out.println(randomNumber);
                        }
                        out.close();
                        
                        BufferedReader s = new BufferedReader(new FileReader ("AverageCase.txt"));
                        for (int x = 0; x < data.length; x++)
                        {
                            String d = s.readLine();
                            data[x] = new IntegerType(Integer.parseInt(d));
                        }
                        s.close();
                    }
                    
                    //Constructs the .txt file for Worst Case
                    else if (caseSelection == 3)
                    {
                        //writes to .txt file 2000==>1
                        PrintWriter out = new PrintWriter (new FileWriter ("WorstCase.txt"));
                        for (int i = 0; i < size; i++)
                        {
                            out.println(size-(i));
                        }
                        out.close();
                        
                        BufferedReader s = new BufferedReader(new FileReader("WorstCase.txt"));
                            for (int x = 0; x < data.length; x++)
                            {
                            String d = s.readLine();
                            data[x] = new IntegerType(Integer.parseInt(d));
                            }
                            s.close();
                    }
                    
                    //user input is invalid
                    else
                    {
                        System.out.println("Invalid Selection. Try Again");
                        caseSelection = 0;
                    }
                }
                
                int sortStyle = 0;
                while (sortStyle == 0)
                {
                    //select desired sorting technique
                    System.out.println("1. Bubble Sort");
                    System.out.println("2. Insertion Sort");
                    System.out.println("3. Selection Sort");
                    System.out.println("4. Quick Sort");
                    System.out.println("5. Shell Sort");
                    System.out.println("\nPlease Enter The Number Of The Sort You Wish To Use");
                    sortStyle = scan.nextInt();
                    System.out.println();
                    System.out.println();
                    
                    //Bubble Sort - Ascending Order
                    if (sortStyle == 1)
                    {
                        Sort.bubbleSortAscending(data);
                        PrintWriter o = new PrintWriter (new FileWriter("Sorted.txt"));
                            for (int y = 0; y < data.length; y++)
                            {  
                                o.println(data[y].toInteger());
                            }
                            o.close();
                            
                            System.out.println("\nBubble Sort Completed Succesfully");
                            System.out.println("Data Arraged In Ascending Order\n\n");
                    }
                    
                    //Insertion Sort - Ascending Order
                    else if (sortStyle == 2)
                    {
                        Sort.insertionSortAscending(data);
                        PrintWriter o = new PrintWriter (new FileWriter("Sorted.txt"));
                            for (int y = 0; y < data.length; y++)
                            {
                                o.println(data[y].toInteger());
                            }
                            o.close();
                            
                            System.out.println("\nInsertion Sort Completed Succesfully");
                            System.out.println("Data Arraged In Ascending Order\n\n");
                    }
                    
                    //Selection Sort - Ascending Order
                    else if (sortStyle == 3)
                    {
                        Sort.selectionSortAscending(data);
                            PrintWriter o = new PrintWriter (new FileWriter("Sorted.txt"));
                            for (int y = 0; y < data.length; y++)
                            { 
                                o.println(data[y].toInteger());
                            }
                            o.close();
                            
                            System.out.println("\nSelection Sort Completed Succesfully");
                            System.out.println("Data Arraged In Ascending Order\n\n");
                    }
                    
                    //Quick Sort - Ascending Order
                    else if (sortStyle == 4)
                    {
                        Sort.quickSortAscending(data, 0, data.length - 1);
                        PrintWriter o = new PrintWriter (new FileWriter("Sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        {
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        
                        System.out.println("Quick Sort Completed Succesfully");
                        System.out.println("Data Arraged In Ascending Order\n\n");
                    }
                    
                    //Shell Sort - Ascending Order
                    else if (sortStyle == 5)
                    {
                        Sort.shellSortAscending(data);
                        PrintWriter o = new PrintWriter (new FileWriter("Sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        { 
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        
                        System.out.println("Shell Sort Completed Succesfully");
                        System.out.println("Data Arraged In Ascending Order\n\n");
                    }
                    //notifies user that their input is invalid
                    else
                    {
                        System.out.println("\nInvalid Selection. Try Again\n\n");
                        caseSelection = 0;
                    }
                }
            }
            
            //Descending Order Selected
            else if (orderOfData == 2)
            {
                int caseSelection = 0;
                while (caseSelection == 0)
                {
                    //asks user which case they want to use
                    System.out.println("1. Best Case");
                    System.out.println("2. Average Case");
                    System.out.println("3. Worst Case");
                    System.out.println("\nSelect The Number Of The Case You Wish To Use");
                    caseSelection = scan.nextInt();
                    System.out.println();
                    System.out.println();
                    
                    //Constructs the .txt file for Best Case
                    if (caseSelection == 1)
                    {
                        PrintWriter out = new PrintWriter (new FileWriter ("BestCase.txt"));
                        for (int i = 0; i < size; i++)
                        {
                            out.println(size - (i));
                        }
                        out.close();
                        
                        BufferedReader s = new BufferedReader(new FileReader("BestCase.txt"));
                        for (int x = 0; x < data.length; x++)
                        {
                            String d = s.readLine();
                            data[x] = new IntegerType(Integer.parseInt(d));
                        }
                        s.close();
                    }
                    
                    
                    //Constructs the .txt file for Average Case
                    else if (caseSelection == 2)
                    {
                        PrintWriter out = new PrintWriter (new FileWriter("AverageCase.txt"));
                            for (int i = 0; i < size+1; i++)
                            {
                                randomNumber = (int) (Math.random() * 2000);
                                out.println(randomNumber);
                            }
                            out.close();
                            
                            BufferedReader s = new BufferedReader(new FileReader("AverageCase.txt"));
                            for (int x = 0; x < data.length; x++)
                            {
                                String d = s.readLine();
                                data[x] = new IntegerType(Integer.parseInt(d));
                            }
                            s.close();
                    }
                    
                    //Constructs the .txt file for Worst Case
                    else if (caseSelection == 3)
                    {
                        PrintWriter out = new PrintWriter (new FileWriter ("WorstCase.txt"));
                            for (int i = 0; i < size; i++)
                            {
                                out.println(i+1);
                            }
                            out.close();
                            
                            BufferedReader s = new BufferedReader(new FileReader("WorstCase.txt"));
                            for (int x = 0; x < data.length; x++)
                            {
                                String d = s.readLine();
                                data[x] = new IntegerType(Integer.parseInt(d));
                            }
                            s.close();
                    }
                    
                    //notifies user that their input is invalid
                    else
                    {
                        System.out.println("\nInvalid Selection. Try Again\n\n");
                        caseSelection = 0;
                    }
                }
                
                int sortStyle = 0;
                while (sortStyle == 0)
                {
                    System.out.println("1. Bubble Sort");
                    System.out.println("2. Insertion Sort");
                    System.out.println("3. Selection Sort");
                    System.out.println("\nPlease Enter The Number Of The Sort You Wish To Use");
                    sortStyle = scan.nextInt();
                    System.out.println();
                    System.out.println();
                    
                    if (sortStyle == 1)
                    {
                        Sort.bubbleSortDescending(data);
                        PrintWriter o = new PrintWriter (new FileWriter("Sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        {
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        
                        System.out.println("\nBubble Sort Completed Succesfully");
                        System.out.println("Data Arraged In Descending Order\n\n");
                    }
                    
                    else if (sortStyle == 2)
                    {
                        Sort.insertionSortDescending(data);
                        // PRINTS SORTED ARRAY TO NEW TEXT FILE
                        PrintWriter o = new PrintWriter (new FileWriter("Sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        {
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        
                        System.out.println("\nInsertion Sort Completed Succesfully");
                        System.out.println("Data Arraged In Descending Order\n\n");
                    }
                    
                    else if (sortStyle == 3)
                    {
                        Sort.selectionSortDescending(data);
                            PrintWriter o = new PrintWriter (new FileWriter("Sorted.txt"));
                            for (int y = 0; y < data.length; y++)
                            { 
                                o.println(data[y].toInteger());
                            }
                            o.close();
                            
                            System.out.println("\nSelection Sort Completed Succesfully");
                            System.out.println("Data Arraged In Descending Order\n\n");
                    }
                    
                    else if (sortStyle == 4)
                    {
                        Sort.quickSortDescending(data, 0, data.length-1);
                        PrintWriter o = new PrintWriter (new FileWriter("Sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        { 
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        
                        System.out.println("\nQuick Sort Completed Succesfully");
                        System.out.println("Data Arraged In Descending Order\n\n");
                    }
                    
                    else if (sortStyle == 5)
                    {
                        Sort.shellSortDescending(data);
                        PrintWriter o = new PrintWriter (new FileWriter("Sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        { 
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        
                        System.out.println("\nShell Sort Completed Succesfully");
                        System.out.println("Data Arraged In Descending Order\n\n");
                    }
                    
                    else
                    {
                        System.out.println("\nInvalid Selection. Try Again\n\n");
                            sortStyle = 0;
                    }
                }
            }
            
            else
            {
                System.out.println("\nInvalid Selection. Try Again\n\n");
                orderOfData = 0;
            }
        }
        
        /*
        *** In-Development: ***
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.println("Please enter the number of the data type that you wish to produce: ");
        int dataType = scan.nextInt(); 
         */
    }
}
