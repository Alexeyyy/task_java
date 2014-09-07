package task_2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
* Класс, осуществляющий поиск указанной директории, загрузку файлов в память ЭВМ и установку рапределния файлов между потоками.
* */
public class FileRuler {
    private ArrayList<File> directoryFiles;
    private HashMap<Integer, ArrayList<File>> distributedFiles;

    public FileRuler() {
        directoryFiles = new ArrayList<File>();
        distributedFiles = new HashMap<Integer, ArrayList<File>>();
    }

    public ArrayList<File> getFoundFiles() {
        return directoryFiles;
    }

    public HashMap<Integer, ArrayList<File>> getDistributedFiles() {
        return distributedFiles;
    }

    /*
     * Записывает файлы в список, если по указанному пути находится директория.
     * true - загрузка файлов произведена из директории
     * false - указана не директория
     */
    public boolean getDirectoryFiles(String path) {
        File item = new File(path);
        if(item.isDirectory()) {
            directoryFiles = new ArrayList<File>(Arrays.asList(item.listFiles()));
            return true;
        } else {
            return false;
        }
    }

    /*
     * Печатает все найденные файлы в консоль
     */
    public void printFilesList() {
        if(!directoryFiles.isEmpty()) {
            for(File item : directoryFiles) {
                if(item.isFile()) {
                    System.out.println(item.getName());
                }
            }
        } else {
            System.out.println("Files list is empty!");
        }
    }

    /*
    * Распределение файлов между потоками. Данные записываются в словарь, где
    * индекс - номер потока, значение - список файлов для обработки.
    * */
    public void setDistribution(int filesCount, int threadsCount) {
        Distributor distributor = new Distributor(filesCount, threadsCount);
        int[] distributionMap = distributor.getDistribution();
        int counter = 0;

        for(int i = 0; i < distributionMap.length; i++) {
            distributedFiles.put(i, new ArrayList<File>());
            for(int j = 0; j < distributionMap[i]; j++, counter++) {
                distributedFiles.get(i).add(directoryFiles.get(counter));
            }
        }
    }
}
