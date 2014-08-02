package com.company;

import java.util.HashMap;

public class Main
{
    private static HashMap dictionary = new HashMap();

    public static void main(String[] args)
    {
        try
        {
            int lineQuantity = Integer.parseInt(args[3]);
            FileHandler.RetrieveDataToDictionary(args[0], dictionary);
            HtmlGenerator.GenerateHtml(args[1], args[2], dictionary, lineQuantity);
        }
        catch(Exception e)
        {
            System.out.println("Some wrong command line args... Try again please.");
        }
    }
}
