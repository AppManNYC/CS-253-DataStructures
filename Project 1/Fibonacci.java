/*      Created By:         Matthew A. Krieger
 *      Date:               October 04, 2015
 *      Assignment:         Homework I  
 */

import java.util.*;
import java.io.*;

public class Fibonacci
{
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int n = 0, fib;
        while (n != -1)
        {
            System.out.println("Enter N: ");
            n = scan.nextInt();
            if (n == -1)
            {
                System.out.println("Program Finished.");
            }
            else
            {
                fib = Fibonacci(n);
                System.out.println(fib);
                System.out.println();
            }
        }

    }

    static int Fibonacci(int n)
    {
        if (n<=1)
        {
            return n;
        }
        else 
        {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}
