/*  Ali ALbayrak
    19978497
    DSA Assigment 1
*/

/*  I used this class on my previous work on practical 6.
    Later, I edited and updated this class to work on DSA Assignment */

import java.util.*;
import java.io.Serializable;
public class DSAGraphVertex implements Serializable
{
    private String label;
    private boolean visited;
    // Visibilty is for filter in/out the vertex/asset
    private boolean visible;
    /* This list keep track of paths from this vertex*/
    private DSALinkedList pathFromList;
    /* This list keep track of paths to this vertex */
    private DSALinkedList pathToList;
    /*Constructor*/
    public DSAGraphVertex(String inLabel)
    {
        label = inLabel;
        visited = false;
        visible = true;
        pathFromList = new DSALinkedList();
        pathToList = new DSALinkedList();
    }

    public String getLabel()
    {
        return label;
    }

    /* Number of paths from this vertex*/
    public int getBaseNum()
    {
        int baseNum = 0;
        Iterator iter = pathFromList.iterator();
        while(iter.hasNext())
        {
            iter.next();
            baseNum++;
        }
        return baseNum;
    }
    
    /* return the number of paths to this vertex*/
    public int getQuoteNum()
    {
        int quoteNum = 0;
        Iterator iter = pathToList.iterator();
        while(iter.hasNext())
        {
            iter.next();
            quoteNum++;
        }
        return quoteNum;
    }
      

    public DSALinkedList getListFrom()
    {
        return pathFromList;
    }
    
    public DSALinkedList getListTo()
    {
        return pathToList;
    }
       
    public DSAGraphVertex getNewAdj()
    {
        Iterator iter = pathToList.iterator();
        boolean flag = false;
        DSAGraphVertex temp = null;
        while(iter.hasNext() & !flag)
        {
            temp =(DSAGraphVertex) iter.next();
            if(!temp.getVisited())
            {
                flag = true;
            }
        }
        if(!flag)
        {
            temp = null;
        }
        return temp;        

    }

    /* Visiblity for filter in/out */
    public void setUnvisible()
    {
        visible = false;
    }

    public void setVisible()
    {
        visible = true;
    }
        
    public boolean getVisible()
    {
        return visible;
    }        
 
   
    public void addEdgeFrom(DSAGraphVertex vertex)
    {
        pathFromList.insertLast(vertex);
    }

    public void addEdgeTo(DSAGraphVertex vertex)
    {
        pathToList.insertLast(vertex);
    }
    
    public boolean hasPathTo(String label)
    {
        Iterator iter = pathToList.iterator();
        boolean flag = false;
        while(iter.hasNext() & !flag)
        {
            DSAGraphVertex temp = (DSAGraphVertex) iter.next();
            String tempStr =  temp.getLabel();
            if(tempStr.equals(label))
            {
                flag = true;
            }
        }
        return flag;
    }

    public void setVisited()
    {
        visited = true;
    }

    public void clearVisited()
    {
        visited = false;
    }
    
    public boolean getVisited()
    {
        return visited;
    }

    public String toString()
    {
        String str = "Asset Label:" + label + " Direct trade path to: " + this.getBaseNum()
                        + " Direct trade path from: " + this.getQuoteNum() + " different currencies"; 
        return str;
    }
}

