package com.company;

import java.util.HashMap;

public class Main
{
    private static HashMap dictionary = new HashMap();

    public static void main(String[] args)
    {
        FileHandler.RetrieveDataToDictionary("dictionary.txt", dictionary);
        HtmlGenerator.GenerateHtml("book.txt", dictionary, 800);
    }
}
