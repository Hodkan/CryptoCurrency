import java.util.*;

public class UnitTestDSAGraph
{
    public static void main(String[] args)
    {
        int testNum = 0;
        int testPassed = 0;
        DSAGraph graph = null;
        


        System.out.println("\n\nTesting Constructor");
        System.out.println("=====================");
        
        try
        {   
            testNum++;
            System.out.print("Testing creation of graph: ");
            graph = new DSAGraph();
            testPassed++;
            System.out.println("passed.");
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        
        System.out.println("\nTesting Methods");
        
        try
        {
            testNum++;
            System.out.print("Testing Add vertex:");
            graph.addVertex("A");
            testPassed++;
            System.out.println("passed");
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }
    
        try
        {
            testNum++;
            System.out.print("Testing hasVertex:");
            boolean match = graph.hasVertex("A");
            if(match)
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing getVertexCount:");
            int count = graph.getVertexCount();
            if(count == 1)
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing getVertex:");
            DSAGraphVertex vertex = graph.getVertex("A");
            testPassed++;
            System.out.println("passed");
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing addEdge:");
            graph.addEdge("AB","A","B","active");
            testPassed++;
            System.out.println("passed");
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing getEdgeCount:");
            int count = graph.getEdgeCount();
            if(count == 1)
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing vertex -> getAdjacent: ");
            DSALinkedList list = graph.getAdjacent("A");
            if(!list.isEmpty())
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing isAdjacent(vertex a, vertex b): ");
            boolean check = graph.isAdjacent("A","B");
            if(check)
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");

        }

        try
        {
            testNum++;
            System.out.print("Testing set Edge Attributes: ");
            graph.setEdgeAtt("AB","1","2",3);
            testPassed++;
            System.out.println("passed");
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }
        
        
        try
        {
            testNum++;
            System.out.print("Testing hasEdge:");
            if(graph.hasEdge("AB"))
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("Failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing getEdge: ");
            graph.getEdge("AB");
            testPassed++;
            System.out.println("passed");
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }


        try
        {
            testNum++;
            System.out.print("Testing getNewEdge: ");
            if(graph.getNewEdge("A").getLabel().equals("AB"))
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing reset vertex visit: ");
            graph.getVertex("A").setVisited();
            graph.resetVertexVisit();
            if(!graph.getVertex("A").getVisited())
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing reset edge visit: ");
            graph.getEdge("AB").setVisited();
            graph.resetEdgeVisit();
            if(!graph.getEdge("AB").getVisited())
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing filter out Asset: ");
            graph.fOutAsset("A");
            if(!graph.getVertex("A").getVisible())
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }


        try
        {
            testNum++;
            System.out.print("Testing filter in Asset: ");
            graph.fInAsset("A");
            if(graph.getVertex("A").getVisible())
            {
                testPassed++;
                System.out.println("passed");
            }
            else
            {
                System.out.println("failed");
            }
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        try
        {
            testNum++;
            System.out.print("Testing display As List:");
            graph.displayAsList();
            testPassed++;
            System.out.println("passed");
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }


        try
        {
            testNum++;
            System.out.print("Testing search: ");
            graph.search("A","B");
            testPassed++;
            System.out.println("passed");
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        
        // TEST SUMMARY
        System.out.println("\nTest Number Passed: " + testPassed + "/" + testNum);
    }
}    
