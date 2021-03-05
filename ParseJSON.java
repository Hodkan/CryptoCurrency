/*  Ali ALbayrak
    19978497
    DSA Assignment 1
*/

/* This class is created for handling JSON operations*/
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;
import java.io.*;
public class ParseJSON
{
    /* Read asset data and return it as updated graph*/
    public static DSAGraph assetData(DSAGraph inGraph, String infileName)
    {
        DSAGraph graph = inGraph;
        try
        {
            String fileName = infileName;
            JSONTokener jsonToken = new JSONTokener(new FileReader(fileName));
            JSONObject obj = new JSONObject(jsonToken);
            JSONArray symbols = obj.getJSONArray("symbols");
            JSONObject symbol;
            String label,base,quote,status;
            int pathNum = 0; 
            for(int i = 0 ; i < symbols.length(); i++)
            {
                symbol = (JSONObject) symbols.get(i);
                label = symbol.getString("symbol");
                base = symbol.getString("baseAsset");
                quote = symbol.getString("quoteAsset");
                status = symbol.getString("status");
                graph.addEdge(label,base,quote,status);
                pathNum++;
            }
            System.out.println(pathNum + " trade paths loaded.");
        }

        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return graph;
    }

    // Read trade data and return the graph as updated
    public static DSAGraph tradeData(DSAGraph graph, String infileName)
    {        
        try
        {
            String fileName1 = infileName;
            JSONTokener jsonToken1 = new JSONTokener(new FileReader(fileName1));
            JSONArray array = new JSONArray(jsonToken1);
            JSONObject tradeObj;
            String label1, weight, volume;
            int count;

            for(int i = 0; i < array.length(); i++)
            {
                tradeObj = (JSONObject) array.get(i);
                label1 = tradeObj.getString("symbol");
                weight = tradeObj.getString("weightedAvgPrice");
                volume = tradeObj.getString("volume");
                count = tradeObj.getInt("count");
                graph.setEdgeAtt(label1,weight,volume,count);
                
            }
            System.out.println("Trade data loaded.");
        }
    
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return graph;
    }


}
