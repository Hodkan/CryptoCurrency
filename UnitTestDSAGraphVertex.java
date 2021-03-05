import java.util.*;

public class UnitTestDSAGraphVertex
{
    public static void main(String[] args)
    {
        int testNum = 0;
        int testPassed = 0;
        DSAGraphVertex vertex = null;
        try
        {
            testNum++;
            System.out.print("Testing vertex creation: ");
            vertex = new DSAGraphVertex("A");
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
            System.out.print("Testing get Label: ");
            if(vertex.getLabel().equals("A"))
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
            System.out.print("Testing setUnvisible:");
            vertex.setUnvisible();
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
            System.out.print("Testing getVisible: ");
            if(!vertex.getVisible())
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
            System.out.print("Testing setVisible: ");
            vertex.setVisible();
            if(vertex.getVisible())
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
            System.out.print("Testing add edge from: ");
            DSAGraphVertex vertex2  = new DSAGraphVertex("B");
            vertex.addEdgeFrom(vertex2);
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
            System.out.print("Testing add edge to: ");
            DSAGraphVertex vertex3  = new DSAGraphVertex("C");
            vertex.addEdgeTo(vertex3);
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
            System.out.print("Testing hasPathTo: ");
            if(vertex.hasPathTo("C"))
            {
                System.out.println("passed");
                testPassed++;
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
            System.out.print("Testing setVisited + getVisited: ");
            vertex.setVisited();
            if(vertex.getVisited())
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
            System.out.print("Testing clearVisited: ");
            vertex.clearVisited();
            if(!vertex.getVisited())
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
            System.out.print("Testing getBaseNum: ");
            if(vertex.getBaseNum() == 1)
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
            System.out.print("Testing setQuoteNum: ");
            if(vertex.getQuoteNum() == 1)
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
            System.out.print("Testing getNewAdj: ");
            if(vertex.getNewAdj().getLabel().equals("C"))
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


        //Test Summary
        
        System.out.println("\nPASSED TEST NUM : " + testPassed + "/" + testNum);

    }
}
