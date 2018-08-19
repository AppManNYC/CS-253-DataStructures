import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException{
        final int size = 2000;
        int randomNum, orderRelationship = 0;
        Scanner scan = new Scanner(System.in);
        IntegerType[] data = new IntegerType[size];

        while (orderRelationship == 0)
        {
            // USER INPUT FOR ORDER RELATIONSHIP
            System.out.println("1. Ascending");
            System.out.println("2. Descending");
            System.out.println("Please enter the number of the ordering relationship to be used: ");
            orderRelationship = scan.nextInt();
            System.out.println();

            if (orderRelationship == 1){
                int caseType = 0;
                while(caseType == 0)
                {
                    // PROMPTS USER FOR DATA TYPE TO SORT
                    System.out.println("1. Best case");
                    System.out.println("2. Average case");
                    System.out.println("3. Worst case");
                    System.out.println("Please enter the number associated with the case that you wish to sort: ");
                    caseType = scan.nextInt();
                    System.out.println();
                    // BEST CASE SITAUTION
                    if (caseType == 1)
                    {
                        // WRITES 1-2000 TO TEXT FILE
                        PrintWriter out = new PrintWriter (new FileWriter ("bestCase.txt"));
                        for (int i = 0; i < size; i++)
                        {
                            out.println(i+1);
                        }
                        out.close();

                        // CONVERTS TEXT FILE TO ANYTYPE ARRAY
                        BufferedReader s = new BufferedReader(new FileReader("bestCase.txt"));
                        for (int x = 0; x < data.length; x++)
                        {
                            String d = s.readLine();
                            data[x] = new IntegerType(Integer.parseInt(d));
                        }
                        s.close();
                    }

                    // AVERAGE CASE
                    else if (caseType == 2)
                    {
                        PrintWriter out = new PrintWriter (new FileWriter("averageCase.txt"));
                        for (int i = 0; i < size; i++)
                        {
                            randomNum = (int) (Math.random() * 2000);
                            out.println(randomNum);
                        }
                        out.close();
                        BufferedReader s = new BufferedReader(new FileReader("averageCase.txt"));
                        for (int x = 0; x < data.length; x++)
                        {
                            String d = s.readLine();
                            data[x] = new IntegerType(Integer.parseInt(d));
                        }
                        s.close();
                    }

                    // WORST CASE
                    else if (caseType == 3)
                    {      
                        PrintWriter out = new PrintWriter (new FileWriter ("worstCase.txt"));
                        for (int i = 0; i < size; i++)
                        {
                            out.println(size-(i));
                        }
                        out.close();
                        BufferedReader s = new BufferedReader(new FileReader("worstCase.txt"));
                        for (int x = 0; x < data.length; x++)
                        {
                            String d = s.readLine();
                            data[x] = new IntegerType(Integer.parseInt(d));
                        }
                        s.close();
                    }

                    // INCORRECT INPUT
                    else
                    {
                        System.out.println("Incorrect input choice. Please try again.");
                        System.out.println();
                        caseType = 0;
                    }
                }

                int sortMethod = 0;
                while (sortMethod == 0)
                {
                    // USER INPUT FOR SORTING ALGORITHM
                    System.out.println("1. Inserstion Sort");
                    System.out.println("2. Bubble Sort");
                    System.out.println("3. Selection Sort");
                    System.out.println("4. Shell Sort");
                    System.out.println("5. Quick Sort");
                    System.out.println("Please enter the number of the sorting algorithm that you wish to analyze: ");
                    sortMethod = scan.nextInt();
                    System.out.println();

                    // INSERTION SORT
                    if (sortMethod == 1)
                    {
                        Sort.insertionSort(data);

                        // PRINTS SORTED ARRAY TO NEW TEXT FILE
                        PrintWriter o = new PrintWriter (new FileWriter("sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        {
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        System.out.println("Insertion sorting completed.");
                    }

                    // BUBBLE SORT
                    else if (sortMethod == 2)
                    {
                        Sort.bubbleSort(data);
                        PrintWriter o = new PrintWriter (new FileWriter("sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        {  
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        System.out.println("Bubble sorting completed.");
                    }

                    // SELECTION SORT
                    else if (sortMethod == 3)
                    {
                        Sort.selectionSort(data);
                        PrintWriter o = new PrintWriter (new FileWriter("sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        { 
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        System.out.println("Selection sorting completed.");
                    }

                    else if (sortMethod == 4)
                    {
                        Sort.shellSort(data);
                        PrintWriter o = new PrintWriter (new FileWriter("sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        { 
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        System.out.println("Shell sorting completed.");
                    }
                    else if (sortMethod == 5)
                    {
                        Sort.quickSort(data, 0, data.length-1);
                        PrintWriter o = new PrintWriter (new FileWriter("sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        { 
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        System.out.println("Quick sorting completed.");
                    }

                    // INCORRECT INPUT
                    else
                    {
                        System.out.println("Incorrect input choice. Please try again.");
                        System.out.println();
                        sortMethod = 0;
                    }
                }
            }
else if (orderRelationship == 2)
            {
                int caseType = 0;
                while (caseType == 0)
                {
                    System.out.println("1. Best case");
                    System.out.println("2. Average case");
                    System.out.println("3. Worst case");
                    System.out.println("Please enter the number associated with the case that you wish to sort: ");
                    caseType = scan.nextInt();
                    System.out.println();

                    // BEST CASE SITAUTION
                    if (caseType == 1)
                    {
                        // WRITES 1-2000 TO TEXT FILE
                        PrintWriter out = new PrintWriter (new FileWriter ("bestCase.txt"));
                        for (int i = 0; i < size; i++)
                        {
                            out.println(size-(i));
                        }
                        out.close();

                        // CONVERTS TEXT FILE TO ANYTYPE ARRAY
                        BufferedReader s = new BufferedReader(new FileReader("bestCase.txt"));
                        for (int x = 0; x < data.length; x++)
                        {
                            String d = s.readLine();
                            data[x] = new IntegerType(Integer.parseInt(d));
                        }
                        s.close();
                    }

                    // AVERAGE CASE
                    else if (caseType == 2)
                    {
                        PrintWriter out = new PrintWriter (new FileWriter("averageCase.txt"));
                        for (int i = 0; i < size+1; i++)
                        {
                            randomNum = (int) (Math.random() * 2000);
                            out.println(randomNum);
                        }
                        out.close();
                        BufferedReader s = new BufferedReader(new FileReader("averageCase.txt"));
                        for (int x = 0; x < data.length; x++)
                        {
                            String d = s.readLine();
                            data[x] = new IntegerType(Integer.parseInt(d));
                        }
                        s.close();
                    }

                    // WORST CASE
                    else if (caseType == 3)
                    {      
                        PrintWriter out = new PrintWriter (new FileWriter ("worstCase.txt"));
                        for (int i = 0; i < size; i++)
                        {
                            out.println(i+1);
                        }
                        out.close();
                        BufferedReader s = new BufferedReader(new FileReader("worstCase.txt"));
                        for (int x = 0; x < data.length; x++)
                        {
                            String d = s.readLine();
                            data[x] = new IntegerType(Integer.parseInt(d));
                        }
                        s.close();
                    }

                    // INCORRECT INPUT
                    else
                    {
                        System.out.println("Incorrect input choice. Please try again.");
                        System.out.println();
                        caseType = 0;
                    }
                }

                int sortMethod = 0;
                while (sortMethod == 0)
                {
                    // USER INPUT FOR SORTING ALGORITHM
                    System.out.println("1. Inserstion Sort");
                    System.out.println("2. Bubble Sort");
                    System.out.println("3. Selection Sort");
                    System.out.println("4. Shell Sort");
                    System.out.println("5. Quick Sort");
                    System.out.println("Please enter the number of the sorting algorithm that you wish to analyze: ");
                    sortMethod = scan.nextInt();
                    System.out.println();

                    // INSERTION SORT DESCENDING
                    if (sortMethod == 1)
                    {
                        Sort.insertionSortD(data);
// PRINTS SORTED ARRAY TO NEW TEXT FILE
                        PrintWriter o = new PrintWriter (new FileWriter("sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        {
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        System.out.println("Insertion sorting completed.");
                    }

                    // BUBBLE SORT
                    else if (sortMethod == 2)
                    {
                        Sort.bubbleSortD(data);
                        PrintWriter o = new PrintWriter (new FileWriter("sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        {  
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        System.out.println("Bubble sorting completed.");
                    }

                    // SELECTION SORT
                    else if (sortMethod == 3)
                    {
                        Sort.selectionSortD(data);
                        PrintWriter o = new PrintWriter (new FileWriter("sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        { 
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        System.out.println("Selection sorting completed.");
                    }

                    else if (sortMethod == 4)
                    {
                        Sort.shellSortD(data);
                        PrintWriter o = new PrintWriter (new FileWriter("sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        { 
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        System.out.println("Shell sorting completed.");
                    }
                    else if (sortMethod == 5)
                    {
                        Sort.quickSortD(data, 0, data.length-1);
                        PrintWriter o = new PrintWriter (new FileWriter("sorted.txt"));
                        for (int y = 0; y < data.length; y++)
                        { 
                            o.println(data[y].toInteger());
                        }
                        o.close();
                        System.out.println("Quick sorting completed.");
                    }

                    // INCORRECT INPUT
                    else
                    {
                        System.out.println("Incorrect input choice. Please try again.");
                        System.out.println();
                        sortMethod = 0;
                    }
                }
            }
            else
            {
                System.out.println("Incorrect input choice. Please try again.");
                System.out.println();
                orderRelationship = 0;
            }
        }
        /*
        // Possible later addition of data type based off user input
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.println("Please enter the number of the data type that you wish to produce: ");
        int dataType = scan.nextInt(); 
         */
    }  
}

