package task_2;

/**
 * Created by 1 on 04.09.2014.
 */
import java.io.*;
import java.util.ArrayList;

public class MyThread extends Thread {
    private ArrayList<File> handledFiles;

    public MyThread(String name, ArrayList<File> files) {
        super(name);
        handledFiles = files;
    }

    @Override
    public void run() {
        for(File item : handledFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(item.getAbsolutePath()))) {
                String line = "";
                int counter = 0;
                File tmpFile = new File(item.getAbsolutePath() + ".tmp");
                PrintWriter writer = new PrintWriter(tmpFile);

                while((line = reader.readLine()) != null) {
                    try(BufferedReader reader_2 = new BufferedReader(new FileReader(item.getAbsolutePath()))) {
                        int counter2 = 0;
                        String line2 = "";
                        boolean isWritten = false;
                        while((line2 = reader_2.readLine()) != null && counter != counter2) {
                            if(line.equals(line2) && counter != counter2) {
                                isWritten = true;
                                break;
                            }
                            isWritten = false;
                            counter2++;
                        }
                        if(!isWritten)
                            writer.println(line);
                        counter++;
                    } catch (IOException e) {
                        //...
                    }
                }
                writer.close();

                //переписываем данные одного файла в другой
                PrintWriter writer1 = new PrintWriter(item);
                BufferedReader reader1 = new BufferedReader(new FileReader(tmpFile.getAbsolutePath()));
                line = "";
                while((line = reader1.readLine()) != null) {
                    writer1.println(line);
                }
                tmpFile.deleteOnExit();
                writer1.close();
                reader1.close();
            } catch (FileNotFoundException e) {
                System.out.println(this.getName() + " doesn't find this file =(. Sorry.");
            } catch (IOException e) {
                System.out.println("exception!");
            }
        }
        System.out.println("Hello! This is " + this.getName() + " and I've finished my work!");
    }
}
