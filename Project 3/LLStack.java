/*      Created By:         Matthew Krieger
 *      Date:               October 25, 2015
 *      Assignment:         Homework III  
 */


public class LLStack
{
    private int size;
    private Node top;
    
    public LLStack()
    {
        size = 0;
        top = null;
    }

    public boolean empty()
    {
        return (top == null);
    }
    
    public int size()
    {
        return size;
    }
    
    public void push (char item)
    {
        Node newNode = new Node (item);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    
    public void push (boolean value)
    {
        Node newNode = new Node (value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    
    public void push (char item, boolean value)
    {
        Node newNode = new Node (item, value, top);
        top = newNode;
        size++;
    }
    
    public char popChar ()
    {
        char item;
        item = top.getData();
        top = top.getNext();
        size--;
        return item;
    }
    
    public boolean popBool ()
    {
        boolean value;
        value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }
    
    public char onTopChar ()
    {
        return top.getData();
    }
    
    public boolean onTopBoolean ()
    {
        return top.getValue();
    }
    
    private class Node
    {
        private char data;
        private boolean truthValue;
        private Node next;
        
        public Node()
        {
            this('0', true, null);
        }
        
        public Node(char c)
        {
            data = c;
        }
        
        public Node(boolean value)
        {
            truthValue = value;
        }
        
        public Node(char c, boolean value)
        {
            data = c;
            truthValue = value;
            next = null;
        }
        
        public Node(char c, boolean value, Node n)
        {
            data = c;
            truthValue = value;
            next = n;
        }
        
        public void setData (char newData)
        {
            data = newData;
        }
        
        public void setValue (boolean newValue)
        {
            truthValue = newValue;
        }
        
        public void setNext (Node newNext)
        {
            next = newNext;
        }
        
        public char getData()
        {
            return data;
        }
        
        public boolean getValue()
        {
            return truthValue;
        }
        
        public Node getNext()
        {
            return next;
        }
        
        public void displayNode()
        {
            System.out.println (data);
        }
        
    }
}
