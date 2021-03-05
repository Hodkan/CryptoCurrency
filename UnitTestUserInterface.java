
import java.util.*;
import java.io.*;

public class UnitTestUserInterface
{
    public static void main(String[] args)
    {
        int testNum = 0;
        int testPassed = 0;
        String prompt;
        int lower, upper;
        

        System.out.println("Testing User Interface class");
        System.out.print("Testing userInput with integers: ");
        prompt = " Please enter an integer";
        lower = 1;
        upper = 9;
        String simInput = "1";
        testNum++;
        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
        int result = UserInterface.userInput(prompt,lower,upper);
        String output = capOut.toString();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        if(result == 1)
        {
            testPassed++;
            System.out.println("passed");
        }
        else
        {
            System.out.println("failed");
        }



        System.out.print("\nTesting getting string from user: ");
        
        testNum++;
        prompt = "Please enter a string: ";
        simInput = "filename.txt";
        capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));
        System.setIn(new ByteArrayInputStream(simInput.getBytes()));
        String strResult = UserInterface.userInput(prompt);
        output = capOut.toString();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        if(strResult.equals(simInput))
        {
            System.out.println("passed");
            testPassed++;
        }
        else
        {
            System.out.println("failed");
        }

        System.out.println("\n\nTotal tests passed: " + testPassed + "/" + testNum);

    

    }
}
