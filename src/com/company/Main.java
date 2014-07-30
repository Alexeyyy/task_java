package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//1)Upload a dictionary to HashMap in java(+)
//2)Upload text to String (+)
//3)Write down a html-template to file

public class Main {
    private static HashMap dictionary = new HashMap();
    private static String text = "";

    public static void main(String[] args) {
        /*FileHandler.RetrieveDataToDictionary("d:/file_java.txt", dictionary);
        text = FileHandler.LoadText("d:/file_java.txt");
        System.out.println(dictionary.size());
        System.out.println(text);*/
        HtmlGenerator.GenerateHtml("d:/file_java.txt", dictionary, 20);
    }
}
