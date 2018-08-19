/*      Created By:         Matthew Krieger
 *      Date:               October 25, 2015
 *      Assignment:         Homework III  
 */


public class LLQueue
{
    private int size;
    private Node front;
    private Node rear;
    
    public LLQueue()
    {
        size = 0;
        front = null;
        rear = null;
    }

    public boolean empty()
    {
        return (size == 0);
    }
    
    public int size()
    {
        return size;
    }
    
    public void enqueue (char item)
    {
        Node newNode = new Node(item);
        if(this.empty())
            front = newNode;
        else
            rear.setNext(newNode);
        rear = newNode;
        size++;
    }
    
    public void enqueue (boolean value)
    {
        Node newNode = new Node(value);
        if(this.empty())
            front = newNode;
        else
            rear.setNext(newNode);
        rear = newNode;
        size++;
    }
    
    public void enqueue (char item, boolean value)
    {
        Node newNode = new Node(item, value, null);
        if(this.empty())
            front = newNode;
        else
            rear.setNext(newNode);
        rear = newNode;
        size++;
    }
    
    public char dequeueChar ()
    {
        char item;
        item = front.getData();
        front = front.getNext();
        size--;
        if (this.empty())
            rear = null;
        return item;
    }
    
    public boolean dequeueBoolean ()
    {
        boolean value;
        value = front.getValue();
        front = front.getNext();
        size--;
        if (this.empty())
            rear = null;
        return value;
    }
    
    public char frontChar()
    {
        return front.getData();
    }
    
    public boolean frontBoolean()
    {
        return front.getValue();
    }
    
    public void printQueue()
    {
        if (empty())
            System.out.print("The queue is empty.");
        else
        {
            Node temp = front;
            for (int i = 0; i<size(); i++)
            {
                temp.displayNode();
                temp = temp.getNext();
            }
        }
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
            next = null;
        }
        
        public Node(boolean value)
        {
            truthValue = value;
            next = null;
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
            System.out.print (data);
        }
    }
}


