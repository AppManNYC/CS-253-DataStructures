/*      Created By:         Matthew Krieger
 *      Date:               October 25, 2015
 *      Assignment:         Homework III  
 */


public class LTester
{
    
    public static int priority(char item)
    {
        if (item == '<')
            return 1;
            
        if (item == '>')
            return 2;
            
        if (item == '&')
            return 4;
            
        if (item == 'v')
            return 3;
            
        if (item == '~')
            return 5;
            
        if (item == '(')
            return 6;
            
        return 0;
    }
    
    
    public static LLQueue postfix(LLQueue input)
    {
        LLQueue output = new LLQueue();
        LLStack operators = new LLStack();
        char item;
        int size = input.size();
        operators.push('#');
        for (int i = 0; i<size; i++)
        {
            item = input.dequeueChar();
            
            if (item == 'p' || item == 'q' || item == 'r')
                output.enqueue(item);
            else if (item == '#')
            {
                int stackSize = operators.size();
                for (int j = 0; j<stackSize; j++)
                    output.enqueue(operators.popChar());
            }
            else if (item == ')' )
            {
                while(operators.onTopChar() != '(')
                    output.enqueue(operators.popChar());
                operators.popChar();
            }
            else if (priority(item) > priority(operators.onTopChar()) || operators.onTopChar() =='(')
                operators.push(item);
            else 
            {
                while(priority(item)<=priority(operators.onTopChar()) && operators.onTopChar() !='(')
                    output.enqueue(operators.popChar());
                    operators.push(item);
            }
        }
        return output;
    }
    
    
    public static boolean isTautology(LLQueue postfixInput)
    {
        boolean test1, test2, test3, test4, test5, test6, test7, test8;
        boolean v1, v2;
        char item;
        int size = postfixInput.size();
        LLQueue temp = new LLQueue();
        LLStack value = new LLStack();
        
        for (int i = 0; i<size; i++)
        {
            item = postfixInput.dequeueChar();
            temp.enqueue(item);
            
            if (item == 'p' || item == 'q' || item == 'r')
                value.push(true);
            else if (item == '~')
            {
                v1 = value.popBool();
                value.push(!v1);
            }
            else if (item == 'v')
            {
                v1 = value.popBool();
                v2 = value.popBool();
                value.push(v1||v2);
            }
            else if (item == '&')
            {
                v1 = value.popBool();
                v2 = value.popBool();
                value.push(v1&&v2);
            }
            else if(item == '>')
            {
                v1 = value.popBool();
                v2 = value.popBool();
                value.push(!v2 || v1);
            }
            else if (item == '<')
            {
                v1 = value.popBool();
                v2 = value.popBool();
                value.push((v1 && v2) || (!v1 && !v2));
            }
        }
        test1 = value.popBool();
        
        if(test1)
        {
            for (int i = 0; i<size; i++)
            {
                item = temp.dequeueChar();
                postfixInput.enqueue(item);
            
                if (item == 'p' || item == 'q')
                    value.push(true);
                else if (item == 'r')
                    value.push(false);
                else if (item == '~')
                {
                    v1 = value.popBool();
                    value.push(!v1);
                }
                else if (item == 'v')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(v1||v2);
                }
                else if (item == '&')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(v1&&v2);
                }
                else if(item == '>')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(!v2 || v1);
                }
                else if (item == '<')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push((v1 && v2) || (!v1 && !v2));
                }
            }
        }
        else
            return false;
        test2 = value.popBool();
        
        if(test2)
        {
            for (int i = 0; i<size; i++)
            {
                item = postfixInput.dequeueChar();
                temp.enqueue(item);
            
                if (item == 'p' || item == 'r')
                    value.push(true);
                else if (item == 'q')
                    value.push(false);
                else if (item == '~')
                {
                    v1 = value.popBool();
                    value.push(!v1);
                }
                else if (item == 'v')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(v1||v2);
                }
                else if (item == '&')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(v1&&v2);
                }
                else if(item == '>')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(!v2 || v1);
                }
                else if (item == '<')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push((v1 && v2) || (!v1 && !v2));
                }
            }
        }
        else
            return false;
        test3 = value.popBool();
        
        if(test3)
        {
            for (int i = 0; i<size; i++)
            {
                item = temp.dequeueChar();
                postfixInput.enqueue(item);
            
                if (item == 'p')
                    value.push(true);
                else if (item == 'r' || item == 'q')
                    value.push(false);
                else if (item == '~')
                {
                    v1 = value.popBool();
                    value.push(!v1);
                }
                else if (item == 'v')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(v1||v2);
                }
                else if (item == '&')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(v1&&v2);
                }
                else if(item == '>')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(!v2 || v1);
                }
                else if (item == '<')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push((v1 && v2) || (!v1 && !v2));
                }
            }
        }
        else
            return false;
        test4 = value.popBool();
        
        if(test4)
        {
            for (int i = 0; i<size; i++)
            {
                item = postfixInput.dequeueChar();
                temp.enqueue(item);
            
                if (item == 'r' || item == 'q')
                    value.push(true);
                else if (item == 'p')
                    value.push(false);
                    else if (item == '~')
                    {
                        v1 = value.popBool();
                        value.push(!v1);
                    }
                    else if (item == 'v')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push(v1||v2);
                    }
                    else if (item == '&')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push(v1&&v2);
                    }
                    else if(item == '>')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push(!v2 || v1);
                    }
                    else if (item == '<')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push((v1 && v2) || (!v1 && !v2));
                    }
            }
        }
        else
            return false;
        test5 = value.popBool(); 
        
        if(test5)
        {
            for (int i = 0; i<size; i++)
            {
                item = temp.dequeueChar();
                postfixInput.enqueue(item);
            
                if (item == 'p' || item == 'r')
                    value.push(false);
                else if (item == 'q')
                    value.push(true);
                    else if (item == '~')
                    {
                        v1 = value.popBool();
                        value.push(!v1);
                    }
                    else if (item == 'v')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push(v1||v2);
                    }
                    else if (item == '&')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push(v1&&v2);
                    }
                    else if(item == '>')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push(!v2 || v1);
                    }
                    else if (item == '<')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push((v1 && v2) || (!v1 && !v2));
                    }
            }
        }
        else
            return false;
        test6 = value.popBool();
        
        if(test6)
        {
            for (int i = 0; i<size; i++)
            {
                item = postfixInput.dequeueChar();
                temp.enqueue(item);
            
                if (item == 'p' || item == 'q')
                    value.push(false);
                else if (item == 'r')
                    value.push(true);
                    else if (item == '~')
                    {
                        v1 = value.popBool();
                        value.push(!v1);
                    }
                    else if (item == 'v')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push(v1||v2);
                    }
                    else if (item == '&')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push(v1&&v2);
                    }
                    else if(item == '>')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push(!v2 || v1);
                    }
                    else if (item == '<')
                    {
                        v1 = value.popBool();
                        v2 = value.popBool();
                        value.push((v1 && v2) || (!v1 && !v2));
                    }
            }
        }
        else
            return false;
        test7 = value.popBool();
          
        if(test7)
        {
            for (int i = 0; i<size; i++)
            {
                item = temp.dequeueChar();
                postfixInput.enqueue(item);
            
                if (item == 'p' || item == 'q' || item == 'r')
                    value.push(false);
                else if (item == '~')
                {
                    v1 = value.popBool();
                    value.push(!v1);
                }
                else if (item == 'v')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(v1||v2);
                }    
                else if (item == '&')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(v1&&v2);
                }
                else if(item == '>')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push(!v2 || v1);
                }
                else if (item == '<')
                {
                    v1 = value.popBool();
                    v2 = value.popBool();
                    value.push((v1 && v2) || (!v1 && !v2));
                }
            }
        }
        else
            return false;
   
        return true;
    }
}
