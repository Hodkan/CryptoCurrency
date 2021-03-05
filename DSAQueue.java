/*  Ali ALbayrak
    19978497
    DSA Assignment 1
*/

/*  This class is used on my previously submitted work on prac 5. */
/*  This class iss created for implemantation of linked list with queue behaviour.*/
import java.util.*;
import java.io.Serializable;
public class DSAQueue implements Serializable, Iterable
{
    private DSALinkedList list;


    public DSAQueue()
    {
        list = new DSALinkedList();
    }
    
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public void enqueue(Object value)
    {
        list.insertLast(value);
    }

    public Object dequeue()
    {
        return list.removeFirst();
    }

    public Object peek()
    {
        return list.peekFirst();
    }
    
    public Iterator iterator()
    {
        return list.iterator();
    }


}

