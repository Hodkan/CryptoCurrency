import java.util.*;

public class UnitTestDSAGraphEdge
{
    public static void main(String args[])
    {
        DSAGraphEdge edge = null;
        int testNum = 0;
        int testPassed = 0;

        try
        {
            testNum++;
            System.out.print("Testing edge creation: ");
            edge= new DSAGraphEdge("AB","active");
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
            System.out.print("Testing setVisited & getVisited: ");
            edge.setVisited();
            if(edge.getVisited())
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
            edge.clearVisited();
            if(!edge.getVisited())
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
            System.out.print("Testing setBase: ");
            DSAGraphVertex baseVertex = new DSAGraphVertex("A");
            edge.setBase(baseVertex);
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
            System.out.print("Testing setQuote: ");
            DSAGraphVertex quoteVertex = new DSAGraphVertex("B");
            edge.setQuote(quoteVertex);
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
            System.out.print("Testing getLabel: ");
            String label = edge.getLabel();
            if(label.equals("AB"))
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
            System.out.print("Testing getBase: ");
            DSAGraphVertex bVertex = edge.getBase();
            if(bVertex.getLabel().equals("A"))
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
            System.out.print("Testing getQuote: ");
            DSAGraphVertex qVertex = edge.getQuote();
            if(qVertex.getLabel().equals("B"))
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
            System.out.print("Testing getStatus: ");
            String stats = edge.getStatus();
            if(stats.equals("active"))
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
            System.out.print("Testing setWeight/getWeight: ");
            edge.setWeight("10");
            if(edge.getWeight() == 10.0)
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
            System.out.print("Testing setVolume/getVolume: ");
            edge.setVolume("15");
            if(edge.getVolume() == 15.0)
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
            System.out.print("Testing setCount/getCount: ");
            edge.setCount(30);
            if(edge.getCount() == 30)
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
        System.out.println("\nTest Passed: " + testPassed + "/" + testNum);
    }
}
