/*      Created By:         Matthew A. Krieger
 *      Date:               October 04, 2015
 *      Assignment:         Homework I  
 */

import java.io.*;
import java.util.*;

public class BinarySearchR 
{

    public static int BinarySearchR(int[] sortedArray, int start, int end, int key) 
    {
        if (start < end) 
        {
            int mid = start + (end - start) / 2; 
            if (key < sortedArray[mid]) 
            {
                return binarySearchR(sortedArray, start, mid, key);
            } 
            else if (key > sortedArray[mid]) 
            {
                return binarySearchR(sortedArray, mid+1, end , key);
            } 
            else 
            {
                return mid;  
            }
        }
        return -(start + 1); 
    }

    public static void main(String[] args) throws IOException 
    {
        int size = 2000, key = 1, randomNum;
        Random generator = new Random();
        int[] data = new int[size];
        Scanner scan = new Scanner(System.in); 

        BufferedReader s = new BufferedReader(new FileReader("sorted.txt"));
        for (int x = 0; x < data.length; x++)
        {
            String d = s.readLine();
            data[x] = Integer.parseInt(d);
        }
        s.close();

        while (key != -1)
        {
            System.out.println("Enter the number to be found (1-2000): ");
            key = scan.nextInt();
            int index = binarySearchR(data,0,data.length,key);
            if (index >= 0)
            {
                System.out.println("Found "+key+" at "+index+" index");
            }
            else if (key == -1)
            {
                System.out.println("Program terminated.");
            }
            else
            {
                System.out.println(key+" was not found in this list.");
            }
        }
    }
}
