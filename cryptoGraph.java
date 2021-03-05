/* Student Name: Ali ALBAYRAK
    Student  ID: 19978497
    DSA Assignment 1
*/
import java.util.*;

/*This class contains main method and menu options for user*/
public class cryptoGraph
{

    public static void main(String[] args)
    {
        /*If no args prints usage*/
        if(args.length == 0)
        {
            System.out.println("\nUsage: "
                    + "\nFor Interactive testing mode: run with -i."
                    +"\nFor use of serial files run with -Xss4m flag."
                    +"\nRecommended usage for full functionality:"
                    +"\n java -Xss4m <other arguments> -cp <json package> cryptoGraph -i"
                    + "\nFor Report mode: java -cp <json package> cryptoGraph -r <asset_file> <trade_file>");
        }

        /* Runs interactive mode*/
        else if(args[0].equals("-i"))
        {

            int selection;
            String fileName;
            DSAGraph graph = new DSAGraph();
            boolean assetDataLoaded = false;
            boolean tradeDataLoaded = false;
            System.out.println("\n\n Welcome to cryptoGraph Interactive! ");
            do
            {
                String prompt = "\n\nPlease select an option: " + "\n1.Load Data"
                    + "\n2.Display an asset" + "\n3.Display a trade path"
                    + "\n4.Find potential trade paths" + "\n5.Asset filter"
                    + "\n6.Asset Overview" + "\n7.Trade Overview"
                    + "\n8.Save Data"+ "\n9.Exit";
                selection = UserInterface.userInput(prompt,1,9);
                switch(selection)
                {

                    case 1:
                        String inprompt = "\n1.Load Asset data" 
                                    + "\n2.Load Trade data" 
                                    + "\n3.Load from Serialized data";
                        int inselection = UserInterface.userInput(inprompt,1,3);
                        switch(inselection)
                        {
                            /*Load asset data by using JSON*/
                            case 1:
                                graph = ParseJSON.assetData(graph,"assetdata.json");
                                assetDataLoaded = true;
                                break;
                            /*Load trade data by using JSON*/
                            case 2:
                                if(assetDataLoaded)
                                {
                                    graph = ParseJSON.tradeData(graph,"tradedata.json");
                                    tradeDataLoaded = true;
                                }
                                else
                                {
                                    System.out.println("\nPlease load asset data first!");
                                }
                                break;
                            /*Load datas by using Serialized file*/
                            case 3:
                                prompt = "\nPlease enter a file name to read from: ";
                                fileName = UserInterface.userInput(prompt);
                                graph = fileIO.readSerializedFile(fileName);
                                assetDataLoaded = true;
                                tradeDataLoaded = true;  //assumption may be wrong
                                break;
                        }

                    break;
                    
                    //Display asset
                    case 2:
                        if(assetDataLoaded)
                        {
                            prompt = "\nEnter a asset label: ";
                            String assetLabel = UserInterface.userInput(prompt);
                            DSAGraphVertex asset = graph.getVertex(assetLabel);
                            if(asset != null)
                            {
                                System.out.println(asset.toString());
                            }
                            else
                            {
                                System.out.println("\nCould not find: " + assetLabel);
                            }
                        }
                
                        else
                        {
                            System.out.println("\nPlease load the data first");
                        }
                    break;
                    
                    //Display trade path
                    case 3:
                        if(assetDataLoaded && tradeDataLoaded)
                        {
                            prompt = "\nEnter a trade label: ";
                            String tradelabel = UserInterface.userInput(prompt);
                            DSAGraphEdge trade = graph.getEdge(tradelabel);
                            if(trade != null)
                            {
                                System.out.println(trade.toString());
                            }
                            else
                            {
                                System.out.println("\nCould not find: " + tradelabel);
                            }
                        }
                        else
                        {
                            System.out.println("\nPlease load trade and asset datas");
                        }
                    break;
                
                    //Potential trade paths
                    case 4:
                        if(assetDataLoaded && tradeDataLoaded)
                        {
                            prompt = "\nPlease enter a base asset: ";
                            String baseLabel = UserInterface.userInput(prompt);
                            prompt = "Please enter a quote asset: ";
                            String quoteLabel = UserInterface.userInput(prompt);
                            graph.search(baseLabel, quoteLabel);
                        }
                        else
                        {
                            System.out.println("\nPlease load asset and trade data first.");
                        }                
                    
                    break;

                    //Filter in-out
                    case 5:
                        if(assetDataLoaded)
                        {
                            prompt = "\nPlease select an option: "
                                        +"\n1.Filter out an asset"
                                        +"\n2.Filter in an asset";
                            int select = UserInterface.userInput(prompt,1,2);
                            switch(select)
                            {
                                case 1:
                                    prompt = "Please enter a asset label to filter out:";
                                    String alabel = UserInterface.userInput(prompt);
                                    graph.fOutAsset(alabel);
                                    System.out.println(alabel + " is filtered now.");
                                break;
                        
                                case 2: 
                                    prompt ="Please enter an asset label to filter back in:";
                                    String label = UserInterface.userInput(prompt);
                                    graph.fInAsset(label);
                                    System.out.println(label + " is back in the graph now.");
                                break;
                             }       
                        }
                        else
                        {
                            System.out.println("\nPlease load asset data first.");
                        }
                    break;

                    //Asset Overview
                    case 6:
                        if(assetDataLoaded && tradeDataLoaded)
                        {
                            int count = graph.getVertexCount();
                            DSAGraphVertex mostBase = graph.getMostBaseVertex();
                            DSAGraphVertex mostQuote = graph.getMostQuoteVertex();
                            System.out.println("\n\nTotal Asset Number: " + count);
                            System.out.println("\nThe Asset has the most direct trade path from : "
                                                + mostBase.getLabel() + "." 
                                                + "\n" + mostBase.getLabel()
                                                 + "  can be directly traded for : "
                                                    + mostBase.getBaseNum() 
                                                        + " different crypto currencies.");
                            System.out.println("\nThe Asset has the most direct trade path to : "
                                                + mostQuote.getLabel() + ".\n"
                                                + mostQuote.getLabel() 
                                                + " can be directly traded from: " 
                                                    + mostQuote.getQuoteNum()
                                                        + " different crypto currencies.");
                    
                        }
                        else
                        {
                            System.out.println("\nPlease load the asset and trade data first.");
                        }
                    break;


                    //Trade Overview                
                    case 7:
                        if(assetDataLoaded && tradeDataLoaded)
                        {
                            int count = graph.getEdgeCount();
                            System.out.println("\n\nTotal Direct Trade Path Number :" + count);
                            graph.printTTenVolume();
                            graph.printTTenCount();
                            graph.printTTenWeight();
                            //active trade paths number may be added
                        }
                        else
                        {
                            System.out.println("\nPlease load the asset and trade data first.");
                        }
                    break;
                    
                    //Save file
                    case 8:
                       if(assetDataLoaded)
                        {
                            prompt = "\nPlease enter a file name to save the graph: ";
                            fileName = UserInterface.userInput(prompt);
                            try
                            {
                                fileIO.writeSerializedFile(fileName,graph);
                            }
                            catch(StackOverflowError e)
                            {
                                System.out.println("Please add -Xss4m flag to java command.");
                            }
                        }
                        else
                        {
                            System.out.println("\nPlease load the asset data first.");
                        }

                         
                    break;
                
                    case 9:
                        System.out.println("\n\nGOOD BYE!");
                    break;
                            
                          
                }
            }
            while(selection != 9);
        }

        // Report mode
        else if(args[0].equals("-r") && (args.length == 3))
        {
            System.out.println("\n\nWELCOME TO REPORT MODE!\n\n");
            String assetFile = args[1];
            String tradeFile = args[2];
            DSAGraph graph = new DSAGraph();
            graph = ParseJSON.assetData(graph,assetFile);
            graph = ParseJSON.tradeData(graph,tradeFile);
            int count = graph.getVertexCount();
            DSAGraphVertex mostBase = graph.getMostBaseVertex();
            DSAGraphVertex mostQuote = graph.getMostQuoteVertex();
            System.out.println("\n\nTotal Asset Number: " + count);
            System.out.println("\nThe Asset has the most direct trade path from : "
                                + mostBase.getLabel() + "."+ "\n" + mostBase.getLabel()
                                + "  can be directly traded for : "+ mostBase.getBaseNum() 
                                + " different crypto currencies.");
            System.out.println("\nThe Asset has the most direct trade path to : "
                                + mostQuote.getLabel() + ".\n"+ mostQuote.getLabel() 
                                + " can be directly traded from: " + mostQuote.getQuoteNum()
                                + " different crypto currencies.");
            int countEdge = graph.getEdgeCount();
            System.out.println("\n\nTotal Direct Trade Path Number :" + countEdge);
            graph.printTTenVolume();
            graph.printTTenCount();
            graph.printTTenWeight();           

            
        }

        //Wrong arg number, display usage
        else
        {
             System.out.println("Usage: "
                    + "\nFor Interactive testing mode: cryptoGraph -i"
                    + "\nFor Report mode: cryptoGraph -r <asset_file> <trade_file>");
        }
    }
}
