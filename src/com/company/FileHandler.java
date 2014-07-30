package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Alex on 29.07.2014.
 */
public class FileHandler {
    //Запись словаря из файла
    public static void RetrieveDataToDictionary(String fPath, HashMap fMap) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fPath)))
        {
            String word = "";
            while((word = reader.readLine()) != null)
            {
                fMap.put(word,word);
            }
        }
        catch (IOException e)
        {
            System.out.println("Demanded dictionary file is not found!");
        }
    }

    //Загрузка текста для обработки из файла
    public static String LoadText(String fPath)
    {
        StringBuilder sb = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(fPath)))
        {
            String line ="";

            while((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("Demanded text file is not found!");
        }

        return sb.toString();
    }
}
