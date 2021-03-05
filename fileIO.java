/*  Ali ALbayrak
    19978497
    DSA Assignment 1
*/

/* This class is submitted on my previous work for prac 5. 
    Later, edited for DSA Assginment 30/10/2020 */

/* This class is created for handle read/write the serialized file operations*/ 
import java.util.*;
import java.io.*;

public class fileIO
{
    public static void writeSerializedFile(String fileName, DSAGraph graph)
    {
            writeSerFile(fileName, graph);
    }
        
    private static void writeSerFile(String fileName, DSAGraph graph)
    {
        FileOutputStream fileStrm;
        ObjectOutputStream objStrm;
        
        try
        {
            fileStrm = new FileOutputStream(fileName);
            objStrm = new ObjectOutputStream(fileStrm);
            objStrm.writeObject(graph);
            
            objStrm.close();
        }
        
        catch(Exception e)
        {
            throw new IllegalArgumentException("Unable to save object to file" + e.getMessage());
        }
    }


    public static DSAGraph readSerializedFile(String fileName)
    {
        DSAGraph graph = readSerFile(fileName);
        return graph;
    }

    private static DSAGraph readSerFile(String fileName) throws IllegalArgumentException
    {
        FileInputStream fileStrm;
        ObjectInputStream objStrm;
        DSAGraph inGraph;
        
        try
        {
            fileStrm = new FileInputStream(fileName);
            objStrm = new ObjectInputStream(fileStrm);
            inGraph = (DSAGraph) objStrm.readObject();
            objStrm.close();
        }
        
        catch( ClassNotFoundException e)
        {
            System.out.println("Class is not found");
            inGraph = null;
        }
        
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
            inGraph = null;
        }
        
        catch (Exception e)
        {
            throw new IllegalArgumentException("Unable to load object from file");
        }

        return inGraph;
    
    }


  
} 
            
