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

    public static void main(String[] args) {
        FileHandler.RetrieveDataToDictionary("d:/dictionary.txt", dictionary);
        HtmlGenerator.GenerateHtml("d:/file_java.txt", dictionary, 20);
    }
}
