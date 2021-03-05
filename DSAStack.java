/*  Ali Albayrak
    19978497
    DSA Assignment 1
*/

/* This class is submitted on my previous work for prac 5.*/
/* This class is created for implementation of linked list with stack behaviour*/
import java.util.*;
import java.io.Serializable;
public class DSAStack implements Iterable, Serializable
{
    private DSALinkedList list;

    public DSAStack()
    {
        list = new DSALinkedList();
    }
    
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
    
    public void push(Object value)
    {
        list.insertFirst(value);
    }
    
    public Object pop()
    {
        return list.removeFirst();
    }

    public Object top()
    {
        return list.peekFirst();
    }

    public Iterator iterator()
    {
        return list.iterator();
    }
}
