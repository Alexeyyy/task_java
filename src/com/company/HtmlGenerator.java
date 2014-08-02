package com.company;

import java.io.*;
import java.util.HashMap;

//Класс, обеспечивающий генерацию html-файлов на базе загруженного текста
public class HtmlGenerator {
    private static String htmlTemplateBegin =
            "<html>" +
                    "<head>" +
                        "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">" +
                    "</head>" +
                    "<body>";
    private static String htmlTemplateEnd = "</body>" + "</html>";
    private static String htmlStyleStart = "<span style=\"font-weight: bold; font-style: italic\">";
    private static String htmlStyleEnd = "</span>";

    public static String HandleLine(String fLine, HashMap fDictionary)
    {
        if(fLine == "")
            return "";

        StringBuilder line = new StringBuilder(fLine);

        int i = 0;
        int start, end;
        while(i < line.length())
        {
            if(line.charAt(i) >= 'A' && line.charAt(i) <= 'z')
            {
                start = i;
                while( i < line.length() && line.charAt(i) >= 'A' && line.charAt(i) <= 'z')
                {
                    i++;
                }
                end = i;

                if(fDictionary.containsKey(line.substring(start, end).toString().toLowerCase()))
                {
                    line.insert(start, htmlStyleStart);
                    line.insert(end + htmlStyleStart.length(), htmlStyleEnd);
                    i += (htmlStyleEnd.length() + htmlStyleStart.length());
                }
            }
            i++;
        }

        return line.toString();
    }

    public static void GenerateHtml(String fFileIn, String fFileOut, HashMap fDictionary, int fLinesQuantity)
    {
        try(BufferedReader inStream = new BufferedReader(new FileReader(fFileIn)))
        {
            String line = "";
            int line_counter = 1;
            int name = 0;
            String partial_line_left = "";
            String partial_line_right = "";

            while ((line = inStream.readLine()) != null)
            {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fFileOut + name + ".html", true)))
                {
                    if (line_counter == 1)
                    {
                        writer.write(htmlTemplateBegin + "<br/>");
                        //если имел место перенос строки то
                        if (partial_line_right.length() != 0)
                            writer.write(partial_line_right + "<br/>");
                    }
                    //Пока не граница, продолжаем обработку в обычном режиме
                    if (line_counter < fLinesQuantity)
                    {
                        //Обработка линии
                        line = HandleLine(line, fDictionary);
                        //Запись линии в файл
                        writer.write(line + "<br/>");
                    }
                    //Граница - занимаемся поиском точки, чтобы избежать переноса предложения
                    else if (line_counter == fLinesQuantity)
                    {
                        if (line.indexOf('.') != -1)
                        {
                            partial_line_left = HandleLine(line.substring(0, line.indexOf('.') + 1), fDictionary);
                            partial_line_right = HandleLine(line.substring(line.indexOf('.') + 1, line.length()), fDictionary);
                            writer.write(partial_line_left + "<br/>");
                            name++;
                            line_counter = 1;
                            writer.write(htmlTemplateEnd);
                            continue;
                        }
                        else
                        {
                            writer.write(HandleLine(line, fDictionary) + "<br/>");
                            while ((line = inStream.readLine()) != null)
                            {
                                if (line.indexOf('.') != -1)
                                {
                                    partial_line_left = HandleLine(line.substring(0, line.indexOf('.') + 1), fDictionary);
                                    partial_line_right = HandleLine(line.substring(line.indexOf('.') + 1, line.length()), fDictionary);
                                    writer.write(partial_line_left + "<br/>");
                                    writer.write(htmlTemplateEnd);
                                    name++;
                                    line_counter = 1;
                                    break;
                                }
                                else
                                {
                                    writer.write(HandleLine(line, fDictionary) + "<br/>");
                                }
                                line_counter++;
                            }
                            continue;
                        }
                    }
                    line_counter++;
                }
            }

            //для случая, когда line_counter < fLinesQuantity соблюдается до конца записи
            if (line_counter != fLinesQuantity && fLinesQuantity != 1)
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fFileOut + name + ".html", true));
                writer.write(htmlTemplateEnd);
                writer.close();
            }
        }
        catch (IOException e)
        {
            System.out.println("Required file could not be opened!");
        }
    }
}
