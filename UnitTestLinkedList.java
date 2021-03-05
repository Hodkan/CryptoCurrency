/*  Ali Albayrak
    19978497
    DSA Assignment 1
*/

/* This Unit test class is taken from provided samples for prac 4 written by Connor
    And edited for DSA Assignment 1 */
import java.io.*;

public class UnitTestLinkedList
{
	public static void main(String args[])
	{
        // VARIABLE DECLARATIONS
        int passedTest = 0;
        int testNum = 0;
        DSALinkedList list = null;
        String sTest;
        Object value;

//---------------------------------------------------------------------------

        System.out.println("\n\nTesting Normal Conditions - Constructor\n");

        // TEST 1 : CONSTRUCTOR
        try
         {
            testNum++;
            list = new DSALinkedList();
            System.out.print("Testing creation of DSALinkedList: ");
            if (list.isEmpty() == false)
                throw new IllegalArgumentException("Head must be null.");
            passedTest++;
            System.out.println("passed");
        } 
        catch(Exception e) 
        { 
            System.out.println("FAILED"); 
        }

//---------------------------------------------------------------------------

        System.out.println("\nTest inserting first and removing first (stack behaviour)\n");
    

        // TEST 2 : INSERT FIRST
        try 
        {
            testNum++;
            System.out.print("Testing insertFirst(): ");
            list.insertFirst("123");
            list.insertFirst("456");
            list.insertFirst("789");
            passedTest++;
            System.out.println("passed");
        } 
        catch(Exception e) 
        { 
            System.out.println("FAILED"); 
        }

        // TEST 3 : PEEK LAST
        try 
        {
            testNum++;
            System.out.print("Testing peekLast(): ");
            sTest = (String)list.peekLast();
            if (sTest != "123")
            {
                throw new IllegalArgumentException("FAILED.");
            }
            passedTest++;
            System.out.println("passed");
        } 
        catch(Exception e) 
        { 
            System.out.println("FAILED"); 
        }

        // TEST 4 : REMOVE FIRST
        try 
        {
            testNum++;
            System.out.print("Testing removeFirst(): ");
            sTest = (String)list.removeFirst();
            if (sTest != "789")
            {
                throw new IllegalArgumentException("FAILED.");
            }
            sTest = (String)list.removeFirst();
            if (sTest != "456")
            {
                throw new IllegalArgumentException("FAILED.");
            }
            sTest = (String)list.removeFirst();
            if (sTest != "123")
            {
                throw new IllegalArgumentException("FAILED.");
            }
            passedTest++;
            System.out.println("passed");
        } 
        catch(Exception e) 
        { 
            System.out.println("FAILED"); 
        }

        // TEST 5 : IS EMPTY
        try 
        {
            testNum++;
            System.out.print("Testing isEmpty(): ");
            sTest = (String)list.removeFirst();
            System.out.println("FAILED");
        } 
        catch(Exception e) 
        { 
            passedTest++; 
            System.out.println("passed"); 
        }

//---------------------------------------------------------------------------

        System.out.println("\nTest inserting last and removing first (queue behaviour)\n");

        // TEST 6 : INSERT LAST()
        try 
        {
            testNum++;
            System.out.print("Testing insertLast(): ");
            list.insertLast("123");
            list.insertLast("456");
            list.insertLast("789");
            passedTest++;
            System.out.println("passed");
        } 
        catch(Exception e) 
        { 
            System.out.println("FAILED"); 
        }

        // TEST 7 : PEEK LAST
        try 
        {
            testNum++;
            System.out.print("Testing peekFirst(): ");
            sTest = (String)list.peekFirst();
            if (sTest != "123")
            {
                throw new IllegalArgumentException("FAILED.");
            }
            passedTest++;
            System.out.println("passed");
        } 
        catch(Exception e) 
        { 
            System.out.println("FAILED"); 
        }

        // TEST 8 : REMOVE FIRST
        try 
        {
            testNum++;
            System.out.print("Testing removeFirst(): ");
            sTest = (String)list.removeFirst();
            if (sTest != "123")
            {
                throw new IllegalArgumentException("FAILED.");
            }
            sTest = (String)list.removeFirst();
            if (sTest != "456")
            {
                throw new IllegalArgumentException("FAILED.");
            }
            sTest = (String)list.removeFirst();
            if (sTest != "789")
            {
                throw new IllegalArgumentException("FAILED.");
            }
            passedTest++;
            System.out.println("passed");
        } 
        catch(Exception e) 
        { 
            System.out.println("FAILED"); 
        }

        // TEST 9 : IS EMPTY 2
        try 
        {
            testNum++;
            System.out.print("Testing isEmpty(): ");
            sTest = (String)list.removeFirst();
            System.out.println("FAILED");
        } 
        catch(Exception e) 
        { 
            passedTest++; 
            System.out.println("passed"); 
        }

        // TEST 10 : INSERT FIRST
        try 
        {
            testNum++;
            System.out.print("Testing insertFirst()");
            list.insertFirst("123");
            list.insertFirst("456");
            list.insertFirst("789");
            passedTest++;
            System.out.println("passed");
        } 
        catch(Exception e) 
        { 
            System.out.println("FAILED"); 
        }

//---------------------------------------------------------------------------

        // PRINT TEST SUMMARY
        System.out.print("\nNumber PASSED: " + passedTest + "/" + testNum);
    }
//---------------------------------------------------------------------------
}
