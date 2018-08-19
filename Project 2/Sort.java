import java.util.*;
import java.io.*;

class Sort {
    int qsComparisons = 0;
    int qsExchanges = 0;
    //INSERTION SORT
    public static void insertionSort(AnyType[] array) {
        AnyType temp;
        int comparisons = 0;
        int exchanges = 0;

        for (int j = 1; j < array.length; j++)
        {
            temp = array[j];
            int i = j;
            if (i > 0 && array[i-1].isBetterThan(temp))
            {
                do
                {
                    array[i] = array[i-1];
                    exchanges++;
                    comparisons++;
                    i--;
                } while (i > 0 && array[i-1].isBetterThan(temp));
            }
            else if (i > 0 && array[i-1].isLessThan(temp))
            {
                comparisons++;
            }
            array[i] = temp;
        }
        System.out.println("Number of comparisons: "+ comparisons);
        System.out.println("Number of exchanges: "+ exchanges);
    }

    // INSERTION SORT DESCENDING
    public static void insertionSortD(AnyType[] array) {
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
// BUBBLE SORT
    public static void bubbleSort(AnyType[] array) {
        AnyType temp;
        int numberOfItems = array.length;
        int comparisons = 0;
        int exchanges = 0;

        for (int pass=1; pass != numberOfItems; pass++) {
            int count = 0;
            for (int index=0; index != numberOfItems-pass; index++) {
                comparisons++;
                if (array[index].isBetterThan(array[index+1])) {
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

    // BUBBLE SORT DESCENDING
    public static void bubbleSortD(AnyType[] array) {
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

    //PAOLO'S METHOD
    /*public static void selectionSortP(AnyType[] array)
    {
    int sorted = 0;
    int comparison = 0;
    int x = 0;
    AnyType min;
    int i, j, exchange = 0;
    for (i = 0; i < array.length; i++)
    {
    min = array[i];
    for (j = i +1;j<array.length;j++)
    {
    comparison++;
    System.out.println("Array[j] = " + array[j]);
    System.out.println("Array[j-1] = " + array[j-1]);
    System.out.println("Array[i] = " + array[i]);
    System.out.println("min = " + min);
    System.out.println("----- Break ------");

    if (min.isBetterThan(array[j]))
    {
    min = array[j];
    x = j;
    }
    comparison++;
    if (array[j-1].isBetterThan(array[j]))
    {
    sorted++;
    }

    }

    if (min != array[i])
    {
    AnyType temp = array[i];
    array[i] = min;
    array[x] = temp;
    exchange++;

    }
    if (sorted == 0)
    {
    i = array.length;
    }
    sorted = 0;
    }
    }
     */
    
    // SELECTION SORT
    public static void selectionSort(AnyType[] array)
    {
        int comparisons = 0;
        int exchanges = 0;
        for (int i = 0; i < array.length-1 ; i++){
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
    public static void selectionSortD(AnyType[] array)
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
    public static void shellSort(AnyType[] array)
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
    public static void shellSortD(AnyType[] array)
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
    public static void quickSort(AnyType[] array, int low, int high)
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
            quickSort(array, low, j);
        }
        if (i < high) 
        {
            quickSort(array, i, high);
        }
        
        
    }

    // QUICK SORT DESCENDING
    public static void quickSortD(AnyType[] array, int low, int high)
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
            quickSortD(array, low, j);   
        }
        if (i < high) 
        {
            quickSortD(array, i, high);
        }
    }
}


