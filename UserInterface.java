/* Author: ALi ALbayrak
    Program: User Interface submodules for user Input
    Date: 31/10/2020
    Purpose:This class designed for handling all user input cases.
    Note: This class is taken from my own previous work on PDI last term.
*/


import java.util.*;

public class UserInterface
{
    // THis method asks for user input between two integer boundaries.Returns int.  IF fails asks for valid input again.
    public static int userInput(String prompt, int lower, int upper)
    {
        int value;
        Scanner sc = new Scanner(System.in);
        String out = prompt;
        String errorMsg = " Error: Please enter a valid value between " + lower + " and " + upper + " \n";
        do
        {
            try
            {
                System.out.println(out);
                value = sc.nextInt();
            }
            catch(InputMismatchException e)
            {
                sc.next();
                value = lower -1;
            }
            out = errorMsg + prompt;
        }
        while((value < lower) || ( value  > upper));
        return value;
    }



    //This method asks user for a string input. Returns string value. If fails asks for new valid value.
    public static String userInput(String prompt)
    {
        String value;
        Scanner sc = new Scanner(System.in);
        String out = prompt;
        String errorMsg = " Error: Please enter a valid value \n";
        do
        {
            try
            {
                System.out.println(out);
                value = sc.nextLine();
            }
            catch(InputMismatchException e)
            {
                sc.next();
                value = "";
            }
            out = errorMsg + prompt;
        }
        while(!(value instanceof String));
        return value;
    }

            
    //This method displays imported string
    public static void displayError(String error)
    {
        System.out.println(error);
    }
}
