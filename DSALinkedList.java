/*  Ali Albayrak
    19978497
    DSA Assignment 1
*/
/*  This class was used in my previous submission for prac 05.
    Later, I edited this class to work on DSA Assignment*/

/* This class is created for keep track of vertices and edges in the graph.*/
/* This class represents double ended doubly linked list */

import java.util.*;
import java.io.Serializable;
public class DSALinkedList implements Iterable, Serializable
{    
    DSAListNode head;
    DSAListNode tail;
    
    public DSALinkedList()
    {
        head = null;
        tail = null;
    }

    void insertFirst(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        if(isEmpty())
        {
            head = newNd;
            tail = newNd;
        }
        else
        {
            newNd.setNext(head);
            head = newNd;
        }
    }

    void insertLast(Object newValue)
    {
        DSAListNode newNd = new DSAListNode(newValue);
        if(isEmpty())
        {
            head = newNd;
            tail = newNd;
        }
        else
        {
            newNd.setPrev(tail);
            tail.setNext(newNd);
            tail = newNd;
        }
    }

    public boolean isEmpty()
    {
        return (head==null);
    }

    public Object peekFirst()
    {
        Object nodeValue;
        if(isEmpty())
        {
            throw new IllegalArgumentException("List is empty");
        }
        else
        {
            nodeValue = head.getValue();
        }
        return nodeValue;
    }

    public Object peekLast()
    {
        Object nodeValue;
        if(isEmpty())
        {
            throw new IllegalArgumentException("List is empty.");
        }
        else
        {
            nodeValue = tail.getValue();
        }
        return nodeValue;
    }

    public Object removeFirst()
    {
        Object nodeValue;
        if(isEmpty())
        {
            throw new IllegalArgumentException("List is empty");
        }
        else if (head.getNext() == null)   //added for double-ended
        {
            nodeValue = head.getValue();
            head = null;
            tail = null;   
        }
        else
        {
            nodeValue = head.getValue();
            head = head.getNext();
            head.setPrev(null);
        }
        return nodeValue;
    }

    public Object removeLast()
    {
        Object nodeValue;
        if(isEmpty())
        {
            throw new IllegalArgumentException("List is empty");
        }
        else if(head.getNext() == null)
        {
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else
        {
            nodeValue = tail.getValue();
            tail = tail.getPrev();
            tail.setNext(null);
            
        }
        return nodeValue;
    }
        



    private class DSAListNode implements Serializable
    {
        private Object m_value;
        private DSAListNode m_next;
        private DSAListNode m_prev;


        private DSAListNode(Object inValue)
        {
            m_value = inValue;
            m_next = null;
            m_prev = null;
        }

        private Object getValue()
        {
            return m_value;
        }
        
        private void setValue(Object inValue)
        {
            m_value = inValue;
        }
        
        private DSAListNode getNext()
        {
            return m_next;
        }
        
        private void setNext(DSAListNode newNext)
        {
            m_next = newNext;
            
        }
        
        private DSAListNode getPrev()
        {
            return m_prev;
        }
        
        private void setPrev(DSAListNode newPrev)
        {
            m_prev = newPrev;
        }
    
    }

    @Override    
    public Iterator iterator() 
    {
        return new LinkedListIterator(this);
    }


    private class LinkedListIterator implements Iterator
    {

        private DSAListNode iterNext;
        public LinkedListIterator(DSALinkedList theList)
        {
            iterNext = theList.head;
        }
        @Override
        public boolean hasNext()
        {
            return (iterNext != null);
        }
        @Override
        public Object next()
        {
            Object value;
            if(iterNext == null)
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }


        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("Not supported");
        }
    }
    

        
}
