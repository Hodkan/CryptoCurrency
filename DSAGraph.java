/*  Student Name: ALi ALbayrak
    Studen ID: 19978497
    DSA Assignment 1
*/
/* I used this class on my previous submitted work on week 6 practical.
   I used that work as foundation and edited this class for the DSA Assignment*/
import java.util.*;
import java.io.Serializable;

/*This class created for handling graph structure and its operations*/
public class DSAGraph implements Serializable
{
    private DSALinkedList vertices;
    private DSALinkedList edges;
    
    //Constructor
    public DSAGraph()
    {
        vertices = new DSALinkedList();
        edges = new DSALinkedList();
    }

    // Add vertex to vertices list
    public void addVertex(String label)
    {
        if(!this.hasVertex(label))
        {
            DSAGraphVertex vertex = new DSAGraphVertex(label);
            vertices.insertLast(vertex);
        }
    }

    //checks vertices list if it has the label-vertex
    public boolean hasVertex(String label)
    {
        boolean has= false;
        Iterator iter = vertices.iterator();
        while(iter.hasNext() & !has)
        {
            DSAGraphVertex vertex =(DSAGraphVertex) iter.next();
            if(vertex.getLabel().equals(label))
            {
                has = true;
            }
        }
        return has;
    }

    //Gets the vertex number - asset number
    public int getVertexCount()
    {
        int count = 0;
        Iterator iter = vertices.iterator();
        
        while(iter.hasNext())
        {
            iter.next();
            count++;
        }
        
        return count;
    }


    // Gets the edge number - trade path number
    public int getEdgeCount()
    {
        int count = 0;
        Iterator iter = edges.iterator();
        while(iter.hasNext())
        {
            iter.next();
            count++;
        }
        
        return count;
    }

    // returns the vertex
    public DSAGraphVertex getVertex(String label)
    {
        boolean flag = false;
        DSAGraphVertex temp = null;
        Iterator iter1 = vertices.iterator();
        while(iter1.hasNext() & !flag)
        {
            temp = (DSAGraphVertex) iter1.next();
            String tempLabel = temp.getLabel();
            if(tempLabel.equals(label))
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

    //Finds the vertex that can be direct traded most number of assets
    public DSAGraphVertex getMostBaseVertex()
    {
        DSAGraphVertex temp = null;
        DSAGraphVertex most = new DSAGraphVertex("temp");
        Iterator iter = vertices.iterator();
        while(iter.hasNext())
        {
            temp = (DSAGraphVertex) iter.next();
            int a = temp.getBaseNum();
            int b= most.getBaseNum();
            if(a > b)
            {
                most = temp;
            }
        }
        return most;
    }

    //Finds the most vertex that is a quote in paths
    public DSAGraphVertex getMostQuoteVertex()
    {
        DSAGraphVertex temp = null;
        DSAGraphVertex most = new DSAGraphVertex("temp");
        Iterator iter = vertices.iterator();
        while(iter.hasNext())
        {
            temp = (DSAGraphVertex) iter.next();
            int a = temp.getQuoteNum();
            int b= most.getQuoteNum();
            if(a > b)
            {
                most = temp;
            }
        }
        return most;
    }   


    // Gets adjacency list of the vertex
    public DSALinkedList getAdjacent(String label)
    {        
        DSALinkedList adjList = new DSALinkedList();
        DSAGraphVertex tempVer = null;
        DSAGraphEdge tempEdge = null;
        String tempLabel = null;
        Iterator iter = edges.iterator();
        while(iter.hasNext())
        {
            tempEdge = (DSAGraphEdge) iter.next();
            tempVer = tempEdge.getBase();
            tempLabel = tempVer.getLabel();
            if(tempLabel.equals(label))
            {
                DSAGraphVertex tempV2 = (DSAGraphVertex) tempEdge.getQuote();
                adjList.insertFirst(tempV2);
            }
        }

        return adjList;   
    }

    // checks if two vertex is adjacent
    public boolean isAdjacent(String label1, String label2)
    {
        boolean isAdj = false;
        String label = label1+label2;
        Iterator iter2 = edges.iterator();
        while(iter2.hasNext() & !isAdj)
        {
            DSAGraphEdge temp =(DSAGraphEdge) iter2.next();
            String tempLabel = temp.getLabel();
            if(tempLabel.equals(label))
            {
                isAdj = true;
            }
        }
        return isAdj;
    }


    // adds the edge to edge list, creates new vertex if they dont exist
    public void addEdge(String inlabel, String inBase, String inQuote, String inStatus)
    {
        if(!this.hasEdge(inlabel))
        {   
            //create new edge
            DSAGraphEdge newEdge = new DSAGraphEdge(inlabel,inStatus);
            DSAGraphVertex base = null;
            //if vertex doesnt exist create new one
            if(!this.hasVertex(inBase))
            {
                base = new DSAGraphVertex(inBase);
                vertices.insertLast(base);
            }
            //if it exists, get that vertex
            else
            {
                base = getVertex(inBase);
            }
            //set that vertex as base in the edge
            newEdge.setBase(base);

            DSAGraphVertex quote = null;
            //if vertex doesnt exist create new one
            if(!this.hasVertex(inQuote))
            {
                quote = new DSAGraphVertex(inQuote);
                vertices.insertLast(quote);
            }
            
            else
            {
                quote = getVertex(inQuote);
            }                
            //set second vertex as quote in the edge
            newEdge.setQuote(quote);
            //add vertex to the other vertex's adjacency lists
            base.addEdgeTo(quote);
            quote.addEdgeFrom(base);      
            //insert new edge to the edge link list of graph
            edges.insertLast(newEdge);
        }
    }

    // Sets the edge's attributes
    public void setEdgeAtt(String inlabel, String weight, String volume, int count)
    {
        DSAGraphEdge edge = this.getEdge(inlabel);
        edge.setWeight(weight);
        edge.setVolume(volume);
        edge.setCount(count);
    }   

    //checks if graph has the edge
    public boolean hasEdge(String label)
    {
        boolean has= false;
        Iterator iter = edges.iterator();
        while(iter.hasNext() & !has)
        {
            DSAGraphEdge edge =(DSAGraphEdge) iter.next();
            if(edge.getLabel().equals(label))
            {
                has = true;
            }
        }
        return has;
    }   
    

    //gets the edge
    public DSAGraphEdge getEdge(String label)
    {
        DSAGraphEdge edge = null;
        Iterator iter = edges.iterator();
        boolean has = false;
        while(iter.hasNext() && !has)
        {
            edge = (DSAGraphEdge) iter.next();
            if(edge.getLabel().equals(label))
            {
                has = true;
            }
        }

        if(!has)
        {
            edge = null;
        }
        return edge;
    }


    //gets a unvisited, not filtered-out and with active status edge, from vertex label
    public DSAGraphEdge getNewEdge(String label)
    {
        DSAGraphEdge edge = null;
        boolean found = false;
        Iterator iter = edges.iterator();
        while(iter.hasNext() && !found)
        {
            DSAGraphEdge tempEdge = (DSAGraphEdge) iter.next();
            DSAGraphVertex base = tempEdge.getBase();
            String baseLabel = base.getLabel();
      
            if((label.equals(baseLabel)) && (!tempEdge.getVisited())
                             && (!tempEdge.getStatus().equals("BREAK")))
            {
                DSAGraphVertex quote = tempEdge.getQuote();
                if((!quote.getVisited()) &&(quote.getVisible()))
                { 
                    edge = tempEdge;
                    found = true;
                }
            }
        }
        
        return edge;
                
    }

    // clear all vertices visit status
    public void resetVertexVisit()
    {
        Iterator iter = vertices.iterator();
        while(iter.hasNext())
        {
            DSAGraphVertex temp =(DSAGraphVertex) iter.next();
            temp.clearVisited();
        }
    }

    // clears all edges visit status
    public void resetEdgeVisit()
    {
        Iterator iter = edges.iterator();
        while(iter.hasNext())
        {
            DSAGraphEdge temp = (DSAGraphEdge) iter.next();
            temp.clearVisited();
        }
    }

    //filter out an asset by setting its visibilty
    public void fOutAsset(String label)
    {
        DSAGraphVertex vertex = this.getVertex(label);
        if(vertex != null)
        {
            vertex.setUnvisible();
        }
        else
        {
            System.out.println("Asset can not found.");
        }
    }

    // filter back an asset in graph
    public void fInAsset(String label)
    {
        DSAGraphVertex vertex = this.getVertex(label);
        if(vertex != null)
        {
            vertex.setVisible();
        }
        else
        {
            System.out.println("Asset can not be found.");
        }
    }
   
    // prints top ten volumed trade
    public void printTTenVolume()
    {
        int countV = 1;
        DSAGraphEdge temp;
        double volume = 0;
        DSAGraphEdge[] objArray = new DSAGraphEdge[10];
        for(int i =0 ; i < objArray.length; i++)
        {
            objArray[i] = new DSAGraphEdge("","");
            objArray[i].setVolume("0");
        }
        Iterator iter = edges.iterator();
        while(iter.hasNext())
        {
            temp = (DSAGraphEdge) iter.next();
            double tempVol = temp.getVolume();
            if(tempVol > objArray[0].getVolume())
            {
                objArray[0] = temp;
                objArray = sort(objArray,1);
            }
        }
        
        System.out.println("\nTop-ten Trade Paths by Volume: ");

        for(int ii = objArray.length-1; ii >= 0; ii--)
        {
            String pLabel = objArray[ii].getLabel();
            volume = objArray[ii].getVolume();
            System.out.println(countV + "." +  pLabel + "   Volume: " + volume);
            countV++;
        }
    }

    // prints top ten count trade
    public void printTTenCount()
    {
        int orderNum = 1;
        DSAGraphEdge temp;
        int count = 0;
        DSAGraphEdge[] objArray = new DSAGraphEdge[10];
        for(int i =0 ; i < objArray.length; i++)
        {
            objArray[i] = new DSAGraphEdge("","");
            objArray[i].setCount(0);
        }
        Iterator iter = edges.iterator();
        while(iter.hasNext())
        {
            temp = (DSAGraphEdge) iter.next();
            int tempCount = temp.getCount();
            if(tempCount > objArray[0].getCount())
            {
                objArray[0] = temp;
                objArray = sort(objArray,2);
            }
        }
        
        System.out.println("\nTop-ten Trade Paths by Count: ");

        for(int ii = objArray.length-1; ii >= 0; ii--)
        {
            String pLabel = objArray[ii].getLabel();
            count = objArray[ii].getCount();
            System.out.println(orderNum + "." +  pLabel + "   Count: " + count);
            orderNum++;
        }
       
    }

    //prints top ten weighted trades
    public void printTTenWeight()
    {
        int orderNum = 1;
        DSAGraphEdge temp;
        double weight = 0;
        DSAGraphEdge[] objArray = new DSAGraphEdge[10];
        for(int i =0 ; i < objArray.length; i++)
        {
            objArray[i] = new DSAGraphEdge("","");
            objArray[i].setWeight("0");
        }
        Iterator iter = edges.iterator();
        while(iter.hasNext())
        {
            temp = (DSAGraphEdge) iter.next();
            double tempWeight = temp.getWeight();
            if(tempWeight > objArray[0].getWeight())
            {
                objArray[0] = temp;
                objArray = sort(objArray,3); // should be increasing order 
            }
        }
        
        System.out.println("\nTop-ten Trade Paths by Avg.Weight: ");

        for(int ii = objArray.length-1; ii >= 0; ii--)
        {
            String pLabel = objArray[ii].getLabel();
            weight = objArray[ii].getWeight();
            System.out.println(orderNum + "." +  pLabel + "   Avg.Weight: " + weight);
            orderNum++;
        }
    }

    //Sorts the array with bubble sort
    private DSAGraphEdge[] sort(DSAGraphEdge[] array, int selection)
    {
        int pass = 0;
        DSAGraphEdge temp;
        boolean sorted;
        do
        {
            sorted = true;
            for(int i =0; i <= (array.length-1 - pass) -1; i++)
            {
                //sorting by volume
                if(selection ==1)
                {
                    if(array[i].getVolume() > array[i+1].getVolume())
                    {
                        temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        sorted = false;
                    }
                }
                //sorting by count
                else if(selection == 2)
                {
                    if(array[i].getCount() > array[i+1].getCount())
                    {
                        temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        sorted = false;
                    }
                }
                //sorting by weight
                else if(selection == 3)
                {
                    if(array[i].getWeight() > array[i+1].getWeight())
                    {
                        temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        sorted = false;
                    }
                }
            }
            pass = pass+1;
        }
        while(!sorted);
        
        return array;
    }
 

    // Displays general info about the graph
    public void displayAsList()
    {
        int count = 0;
        int ecount = 0;
        System.out.println("Graph as List: " );
        
        count = this.getVertexCount();
        ecount = this.getEdgeCount();

        System.out.println("Graph has " + count + " assests and "
                                     + ecount + " direct trade paths.");
    }

    //DF Searching algorithm
    public void search(String label1,String label2)
    {
        DSAStack stack = new DSAStack();
        DSALinkedList sList = new DSALinkedList();
        sList =  sRec(label1,label2, stack, sList,label1);
        Iterator iter = sList.iterator();
        int count = 0;
        double weight = 1.0;
        if(!iter.hasNext())
        {
            System.out.println("There is no available path.");
        }
        while(iter.hasNext())
        {
            count++;
            weight = 1 ;
            DSAStack edgeStack = (DSAStack) iter.next();
            System.out.print("\n" + count + ".  path: ");
            while(!edgeStack.isEmpty())
            {
                DSAGraphEdge edge = (DSAGraphEdge) edgeStack.pop();
                weight = weight * edge.getWeight();
                System.out.print(edge.getLabel());
                if(!edgeStack.isEmpty())
                {
                    System.out.print(" >> "); 
                }
            }
            
            System.out.println(" : Total avg. weight is: " + weight + "\n");
        }
        
        resetVertexVisit();
        resetEdgeVisit();       
            
    }

    private DSALinkedList sRec(String label1, String label2, DSAStack stack, DSALinkedList sList, String baseVer)
    {
        DSAGraphEdge edge = this.getNewEdge(label1);
        /*if there is an unvisited edge from source*/
        if(edge != null) 
        {
            DSAGraphVertex quote = edge.getQuote();
            String tempLabel = quote.getLabel();
            DSAGraphVertex base1= edge.getBase();
            /* if end of edge equals to destination*/
            if(tempLabel.equals(label2))
            {
                edge.setVisited();
                stack.push(edge);
                DSAStack nStack = new DSAStack();
                Iterator iter = stack.iterator();
                //save all the path way to the stack
                while(iter.hasNext())
                {   
                    nStack.push(iter.next());
                }
                //save the stack to linked list
                sList.insertFirst(nStack);
                //go back and keep searching new paths
                DSAGraphEdge temp = (DSAGraphEdge) stack.pop();
                String base = temp.getBase().getLabel();
                sList = sRec(base,label2,stack,sList,baseVer);
                this.resetEdgeVisit();
                this.resetVertexVisit();
                temp.setVisited();
            }
            /*if end of edge not equal to dest.*/
            else
            {
                edge.setVisited();
                stack.push(edge);
                quote.setVisited();
                base1.setVisited();
                
                sList = sRec(tempLabel,label2,stack,sList,baseVer);
                
                
            }
        }
        /*if there is no more path to go and we are not at the base vertex */
        else if(!label1.equals(baseVer))
        {
            DSAGraphEdge temp =(DSAGraphEdge) stack.pop();
            DSAGraphVertex quote = temp.getQuote();
            String base = temp.getBase().getLabel();
            sList = sRec(base,label2,stack,sList,baseVer); 
            this.resetEdgeVisit();
            temp.setVisited();
        }

        /* we are at the base and no more path to check*/
        else
        {
            System.out.println("Search completed: Some possible paths are: ");
            this.resetVertexVisit();
            this.resetEdgeVisit();
        }

        return sList;

    }
}
