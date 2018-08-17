/*      Created By:         Matthew A. Krieger
 *      Date:               October 04, 2015
 *      Assignment:         Homework I
 */

import java.util.*;
import java.io.*;

class Sort 
{
    
    private int exchanges = 0;
    private int compares = 0;
    
    public static void bubbleSortAscending(AnyType[] array) 
    {
        AnyType temp;
        int numberOfItems = array.length;
        boolean cont = true;
        int comparisons = 0;
        int exchanges = 0;
            
        for (int pass=1; pass != numberOfItems; pass++) 
        { 
            if (cont) 
            {    
              cont = false;  
               for (int index=0; index != numberOfItems-pass; index++) 
               {
                   comparisons++;
                   if (array[index].isBetterThan(array[index+1])) 
                   {
                       temp = array[index];
                       array[index] = array[index+1];
                       array[index+1] = temp;
                       exchanges++;
                       cont = true;
                    }  // end inner if              
                }  // end inner for            
            }
           
            else
            break;  // end outer if
        }
        
        System.out.println("Number of comparisons: " + comparisons);
        System.out.println("Number of exchanges: " + exchanges);
    }      




    
    public static void bubbleSortDescending(AnyType[] array) {
        AnyType temp;
        int numberOfItems = array.length;
        int comparisons = 0;
        int exchanges = 0;

        for (int pass=1; pass != numberOfItems; pass++) {
            int count = 0;
            for (int index=0; index != numberOfItems-pass; index++) {
                comparisons++;
                if (array[index].isLessThan(array[index+1])) {
                    temp = array[index];
                    array[index] = array[index+1];
                    array[index+1] = temp;
                    exchanges++;
                    count++;
                }
            }
            if (count == 0)
            {
                break;
            }
        }
        System.out.println("Number of comparisons: "+ comparisons);
        System.out.println("Number of exchanges: "+ exchanges);
    }
    
    public static void insertionSortAscending(AnyType[] array) {
        AnyType temp;
        int comparisons = 0;
        int exchanges = 0;

        for (int i=0; i < array.length; i++) {
                
            AnyType v;
            v=array[i];
            int j;
                for (j = i - 1; j >= 0; j--) {
                    comparisons++;
                    if (v.isBetterThan(array[j])) break;
                    array[j + 1] = array[j];
                    exchanges++;
                }
                array[j + 1] = v;
            }

        System.out.println("Number of comparisons: "+ comparisons);
        System.out.println("Number of exchanges: "+ exchanges);
    }

    // INSERTION SORT DESCENDING
    public static void insertionSortDescending(AnyType[] array) {
        AnyType temp;
        int comparisons = 0;
        int exchanges = 0;

        for (int j = 1; j < array.length; j++)
        {
            temp = array[j];
            int i = j;
            if (i > 0 && array[i-1].isLessThan(temp))
            {
                do
                {
                    array[i] = array[i-1];
                    exchanges++;
                    comparisons++;
                    i--;
                } while (i > 0 && array[i-1].isLessThan(temp));
            }
            else if (i > 0 && array[i-1].isBetterThan(temp))
            {
                comparisons++;
            }
            array[i] = temp;
        }
        System.out.println("Number of comparisons: "+ comparisons);
        System.out.println("Number of exchanges: "+ exchanges);
    }
    
    
    
    // SELECTION SORT
    public static void selectionSortAscending(AnyType[] array)
    {
        int comparisons = 0;
        int exchanges = 0;
        for (int i = 0; i < array.length-1 ; i++)
        {
            int min = i;
            int count = 0;
            for (int j=i+1;j<array.length;j++)
            {
                comparisons++;
                if(array[min].isBetterThan(array[j]))
                {
                    min=j;
                }
            }
            if (min != i)
            {
                AnyType temp = array[i];
                array[i]=array[min];
                array[min]=temp;
                exchanges++;
                count++;
            }

        }
        System.out.println("Number of comparisons: "+ comparisons);
        System.out.println("Number of exchanges: "+ exchanges);
    }




    // SELECTION SORT DESCENDING
    public static void selectionSortDescending(AnyType[] array)
    {
        int comparisons = 0;
        int exchanges = 0;
        for (int i = 0; i < array.length-1 ; i++){
            int min = i;
            for (int j=i+1;j<array.length;j++)
            {
                comparisons++;
                if(array[min].isLessThan(array[j]))
                {
                    min=j;
                }
            }
            if (min != i)
            {
                AnyType temp = array[i];
                array[i]=array[min];
                array[min]=temp;
                exchanges++;
            }
        }
        System.out.println("Number of comparisons: "+ comparisons);
        System.out.println("Number of exchanges: "+ exchanges);
    }
    
    
    // SHELL SORT
    public static void shellSortAscending(AnyType[] array)
    {
        int comparisons = 0;
        int exchanges = 0;
        int increment = array.length/2;
        int j;
        
        while (increment > 0)
        {
            for (int i = increment; i < array.length; i++)
            {
                AnyType temp = array[i];
                comparisons++;
                for(j = i; j >= increment && array[j-increment].isBetterThan(temp); j -= increment)
                {
                    array[j] = array[j-increment];
                    exchanges++;
                }
                array[j] = temp;
            }
            increment = (int) Math.round(increment/2.2);
        }
        
        System.out.println("Number of comparisons: "+ comparisons);
        System.out.println("Number of exchanges: "+ exchanges);
    }

    // SHELL SORT DESCENDING
    public static void shellSortDescending(AnyType[] array)
    {
        int comparisons = 0;
        int exchanges = 0;
        int increment = array.length/2;
        int j;
        while (increment > 0)
        {
            int count = 0;
            for (int i = increment; i < array.length; i++)
            {
                AnyType temp = array[i];
                comparisons++;
                for(j = i; j >= increment && array[j-increment].isLessThan(temp); j -= increment)
                {
                    array[j] = array[j-increment];
                    exchanges++;
                }
                array[j] = temp;
            }
            increment = (int) Math.round(increment/2.2);
        }
        
        System.out.println("Number of comparisons: "+ comparisons);
        System.out.println("Number of exchanges: "+ exchanges);
    }
    
    
    // QUICK SORT
    public static void quickSortAscending(AnyType[] array, int low, int high)
    {
        int i = low, j = high, comparisons = 0, exchanges = 0;
        AnyType temp, pivot = array[(low + high)/2];

        while (i <= j)
        {
            while(array[i].isLessThan(pivot))
            {
                i++;
                comparisons++;
            }
            while(array[j].isBetterThan(pivot))
            {
                j--;
                comparisons++;
            }
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
                exchanges++;
            }
        }

        if (low < j) 
        {
            quickSortAscending(array, low, j);
        }
        if (i < high) 
        {
            quickSortAscending(array, i, high);
        }
        
        
    }   

        
    // QUICK SORT DESCENDING
    public static void quickSortDescending(AnyType[] array, int low, int high)
    {
        int i = low, j = high, comparisons = 0, exchanges = 0;
        AnyType temp, pivot = array[(low + high)/2];

        while (i <= j)
        {
            while(array[i].isBetterThan(pivot))
            {
                i++;
                comparisons++;
            }
            while(array[j].isLessThan(pivot))
            {
                j--;
                comparisons++;
            }
            if (i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
                exchanges++;
            }
        }

        if (low < j) 
        {
            quickSortDescending(array, low, j);   
        }
        if (i < high) 
        {
            quickSortDescending(array, i, high);
        }
    }
    
    
}
