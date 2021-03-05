/*  Ali Albayrak
    19978497
    DSA Assignment 1
*/

/*This class is created for keeping the path information*/
import java.util.*;
import java.io.Serializable;
public class DSAGraphEdge implements Serializable
{
    private String label;
    private DSAGraphVertex base;
    private DSAGraphVertex quote;
    private String status;
    private double weight;
    private double volume;
    private int count;
    private boolean visited;

    /*COnstructor*/
    public DSAGraphEdge(String inlabel, String inStatus)
    {
        label = inlabel;
        status = inStatus;
        visited = false;
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

    public void setBase(DSAGraphVertex inBase)
    {
        base = inBase;
    }

    public void setQuote(DSAGraphVertex inQuote)
    {
        quote = inQuote;
    }

    public String getLabel()
    {
        return label;
    }
    
    public DSAGraphVertex getBase()
    {
        return base;
    }
    
    public DSAGraphVertex getQuote()
    {
        return quote;
    }

    public String getStatus()
    {
        return status;
    }
    
    public void setWeight(String inWeight)
    {    
        weight = Double.parseDouble(inWeight);
    }

    public double getWeight()
    {
        return weight;
    }

    public void setVolume(String inVolume)
    {
        volume = Double.parseDouble(inVolume);
    }

    public double getVolume()
    {
        return volume;
    }

    public void setCount(int inCount)
    {
        count = inCount;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public String toString()
    {
        String str = "Trade label: " + label + " \ntrade from : " + base.getLabel()
                            +" \ntrade to : " + quote.getLabel() + " \nAvg. Weight: "
                             + weight + " \nVolume: " + volume + " \nStatus: "
                             + status + " \nTotal count so far : " + count;
        return str;
    } 

}
        
