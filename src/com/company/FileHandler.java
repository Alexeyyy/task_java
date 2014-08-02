package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//Класс, обеспечивающий работу с файлами
public class FileHandler {
    //Запись словаря из файла
    public static void RetrieveDataToDictionary(String fPath, HashMap fMap) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fPath)))
        {
            String word = "";
            while((word = reader.readLine()) != null)
            {
                fMap.put(word.toLowerCase(),word.toLowerCase());
            }
        }
        catch (IOException e)
        {
            System.out.println("Demanded dictionary file is not found!");
        }
    }
}
