package task_2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 1 on 04.09.2014.
 */
public class FileRuler {
    private ArrayList<File> directoryFiles;

    public FileRuler() {
        directoryFiles = new ArrayList<File>();
    }

    public ArrayList<File> getFoundFiles() {
        if(directoryFiles.isEmpty())
            return null;
        else
            return directoryFiles;
    }

    //Записывает файлы в список, если по указанному пути находится директория
    public boolean getDirectoryFiles(String path) {
        File item = new File(path);
        if(item.isDirectory()) {
            directoryFiles = new ArrayList<File>(Arrays.asList(item.listFiles()));
            return true;
        }
        else
            return false;
    }

    //Печатает все найденные файлы
    public void printFilesList() {
        if(!directoryFiles.isEmpty()) {
            for(File item : directoryFiles) {
                if(item.isFile()) {
                    System.out.println(item.getName());
                }
            }
        }
        else {
            System.out.println("Список файлов пуст!");
        }
    }
}
