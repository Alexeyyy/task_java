package com.company;

import java.io.*;
import java.util.HashMap;

/**
 * Created by Alex on 30.07.2014.
 */
public class HtmlGenerator {
    private static String htmlTemplateBegin =
            "<html>" +
                    "<head>" +
                        "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">" +
                    "</head>" +
                    "<body>";
    private static String htmlTemplateEnd = "</body>" + "</html>";

    public static void GenerateHtml(String fFileIn, HashMap fDictionary, int fLinesQuantity)
    {
        try(BufferedReader inStream = new BufferedReader(new FileReader(fFileIn)))
        {
            String line = "";
            int line_counter = 0;
            int name = 0;

            while((line = inStream.readLine()) != null)
            {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("d:/" + name + ".html", true))) {
                    System.out.println(line);
                    if (line_counter == 0)
                        writer.write(htmlTemplateBegin);

                    //Запись линии в файл
                    writer.write(line + "\n");
                    line_counter++;

                    if (line_counter >= fLinesQuantity) {
                        writer.write(htmlTemplateEnd);
                        name++;
                        line_counter = 0;
                    }
                }
            }

            //Дописывает htmlTemplateEnd в конец последнего сгенерированного файла
            BufferedWriter writer = new BufferedWriter(new FileWriter("d:/" + name + ".html", true));
            writer.write(htmlTemplateEnd);
            writer.close();

        }
        catch (IOException e)
        {
            System.out.println("Required file could not be opened!");
        }
    }
}
