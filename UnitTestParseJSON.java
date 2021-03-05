import java.util.*;

public class UnitTestParseJSON
{
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph();
        String assetFileName = "assetdata.json";
        String tradeFileName = "tradedata.json";
        int testNum = 0;
        int testPassed = 0;
        
        System.out.println("\n\nTest Parsing the asset data");
        System.out.println("=================================");
        try
        {
            testNum++;
            System.out.println("Test JSON parser: ");
            graph = ParseJSON.assetData(graph,"assetdata.json");
            System.out.println("passed");
            testPassed++;
        }
        catch(Exception e)
        {
            System.out.println("Failed");
        }

        System.out.print("Test getting correct values: ");
        try
        {
            testNum++;
            if(graph.getVertex("ETH").getLabel().equals("ETH"))
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

        
        System.out.println("\nNumber PASSED: " + testPassed + "/" + testNum);
    }
}

    
            

