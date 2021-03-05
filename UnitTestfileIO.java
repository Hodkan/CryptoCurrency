

import java.util.*;
import java.io.*;

public class UnitTestfileIO
{
    public static void main(String args[])
    {
        int testNum = 0;
        int passedNum = 0;
        DSAGraph graph = null;
        String fileName = "testFileIO";


        System.out.println("\n\nTesting Writing graph to serialized file");
        System.out.println("===========================================");
        try
        {
            testNum++;
            graph = new DSAGraph();
            String status = "True";
            graph.addEdge("AB","A","B",status);
            graph.addEdge("BC","B","C",status);
            fileName = "testFileIO";
            System.out.print("Testing writing into serialized file: ");
            fileIO.writeSerializedFile(fileName,graph);
            passedNum++;
            System.out.println("passed");
        }
        catch (Exception e)
        {
            System.out.println("Failed");
        }


        System.out.println("\nTesting reading from serialized file");
        System.out.println("=====================================");
        
        try
        {
            testNum++;
            graph = null;
            graph = fileIO.readSerializedFile(fileName);
            System.out.print("Testing reading graph"  +
                                " from serialized file: ");
            if(graph != null)
            {
                System.out.println("passed");
                passedNum++;
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

    
        testNum++;
        System.out.print("Testing reading correct values: ");
        if(graph.getVertexCount() == 3 && graph.getEdgeCount() == 2)
        {
            System.out.println("passed");
            passedNum++;
        }
        else
        {
            System.out.println("failed");
            
        }

        
        System.out.println("\nNumber PASSED: " + passedNum + "/" + testNum);
        

    }
}
        
        
    
