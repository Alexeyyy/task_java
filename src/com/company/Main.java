package com.company;

import java.util.HashMap;

public class Main
{
    private static HashMap dictionary = new HashMap();

    public static void main(String[] args)
    {
        if(args.length != 0)
        {
            for(int i = 0; i < args.length; i++)
            {
                System.out.println(args[i]);
            }
        }
        FileHandler.RetrieveDataToDictionary(args[0], dictionary);
        HtmlGenerator.GenerateHtml(args[1], dictionary, 800);
    }
}

//"dictionary.txt"
//"book.txt"
