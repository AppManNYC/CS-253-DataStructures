import java.util.*;
import java.io.*;

public class Fibonacci
{
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 0, fib;
        while (n != -1)
        {
            System.out.println("Enter N: ");
            n = scan.nextInt();
            if (n == -1)
            {
                System.out.println("Program terminated.");
            }
            else
            {
                fib = Fib(n);
                System.out.println(fib);
                System.out.println();
            }
        }

    }

    static int Fib(int n)
    {
        if (n<=1)
        {
            return n;
        }
        else 
        {
            return Fib(n-1)+Fib(n-2);
        }
    }
}
