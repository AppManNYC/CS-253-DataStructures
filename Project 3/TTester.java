/*      Created By:         Matthew Krieger
 *      Date:               October 25, 2015
 *      Assignment:         Homework III  
 */


import java.util.*;

public class TTester
{
    public static void main (String[] args)
    {
        boolean tautology;
        LLQueue infix, postfix;
        Scanner scan = new Scanner(System.in);
        String input;
        infix = new LLQueue();
        postfix = new LLQueue();
        
        System.out.println ("Enter a logical expression to be evaluated, using the following notation:\n\t~ for \"not\"\n\t& for \"and\"\n\t" +
            "v for \"or\"\n\t> for \"if-then (-->)\"\n\t< for \"if and only if (<-->)\"");
            
        input = scan.nextLine().toLowerCase();
        
        for (int i=0; i<input.length(); i++)
        {
            char item = input.charAt(i);
            if (item != ' ')
                infix.enqueue(item);
        }
        
        infix.enqueue('#');
        
        postfix = LTester.postfix(infix);
        
        System.out.print("Postfix form:  ");
        postfix.printQueue();
        
        tautology = LTester.isTautology(postfix);
        
        if (tautology)
            System.out.println("\nThis is tautology.");
        else
            System.out.println("\nThis is NOT tautology.");
    }
}
