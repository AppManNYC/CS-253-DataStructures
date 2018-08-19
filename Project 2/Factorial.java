import java.util.*;
import java.io.*;

public class Factorial {
    public static void main (String[] args) {

        int theNum, theFact;
        Scanner scan = new Scanner(System.in);

        System.out.println("This program computes the factorial " +
            "of a number.");
        System.out.print("Enter a number: ");
        theNum = scan.nextInt();

        theFact = fact(theNum);

        System.out.println(theNum + "! = " + theFact + ".");
    }

    static int fact(int n) {
        // Base Case: 
        //    If n <= 1 then n! = 1.
        if (n <= 1) {
            return 1;
        }
        // Recursive Case:  
        //    If n > 1 then n! = n * (n-1)!
        else {
            return n * fact(n-1);
        }
    }
}

/*
factorial(N)
f=1
for i = 2 to N
f=f*i

return f
  */
