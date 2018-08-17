/*      Created By:         Matthew A. Krieger
 *      Date:               October 04, 2015
 *      Assignment:         Homework II  
 */

import java.util.*;
import java.io.*;

public class Factorial {
    public static void main (String[] args) {

        int num, fact;
        Scanner scan = new Scanner(System.in);

        System.out.println("Factorial Program");
        System.out.print("Enter a number: ");
        num = scan.nextInt();

        fact = fact(num);

        System.out.println(num + "! = " + fact + ".");
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
