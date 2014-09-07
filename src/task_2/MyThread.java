package task_2;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;

/*
* Класс, унаследованный от класса Thread для добавления доп. функциональности (по обработке файлов)
* */
public class MyThread extends Thread {
    private ArrayList<File> handledFiles;

    //Статистика
    private static int handledFilesQuantity = 0;
    private static int filesQuantity = 0;
    private static int writtenRowsQuantity = 0;
    private static int totalRowsQuantity = 0;

    public MyThread(String name, ArrayList<File> files, int filesCount) {
        super(name);
        handledFiles = files;
        filesQuantity = filesCount;
    }

    /* Перегруженнвй метод run(), осуществ. удаление одинаковых слов из файла
     * Принцип действия: в процессе выполнения создается копия файла, куда записываются слова.
     * Запись производится без повторений. После, созданный файл переписывается в существующий и
     * удаляется.
     * */
    @Override
    public void run() {
        for(File item : handledFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(item.getAbsolutePath()))) {
                String line = "";
                int linePos = 0;
                File tmpFile = new File(item.getAbsolutePath() + ".tmp");
                PrintWriter writer = new PrintWriter(tmpFile);

                while((line = reader.readLine()) != null) {
                    try(BufferedReader readerVerification = new BufferedReader(new FileReader(item.getAbsolutePath()))) {
                        int linePosVer = 0;
                        String lineVer = "";
                        boolean isWritten = false;
                        while((lineVer = readerVerification.readLine()) != null && linePos != linePosVer) {
                            if(line.equals(lineVer) && linePosVer != linePos) {
                                isWritten = true;
                                break;
                            }
                            isWritten = false;
                            linePosVer++;
                        }
                        if(!isWritten) {
                            writer.println(line);
                            writtenRowsQuantity++;
                        }
                        linePos++;
                    } catch (IOException e) {
                        //...
                    }
                    totalRowsQuantity++;
                }
                writer.close();

                saveData(item, tmpFile);

            } catch (FileNotFoundException e) {
                System.out.println(this.getName() + " : " + e.getMessage());
            } catch (IOException e) {
                System.out.println(this.getName() + " : " + e.getMessage());
            }
        }
        printProgress();
    }

    /*
    * Сохраняет полученные в результате обработки данные в исходный файл.
    * */
    private void saveData(File goalFile, File tmpFile) {
        try {
            PrintWriter finalWriter = new PrintWriter(goalFile);
            BufferedReader finalReader = new BufferedReader(new FileReader(tmpFile.getAbsolutePath()));
            String line = "";

            while((line = finalReader.readLine()) != null) {
                finalWriter.println(line);
            }

            tmpFile.deleteOnExit();
            finalWriter.close();
            finalReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(this.getName() + " : " + e.getMessage());
        } catch (IOException e) {
            System.out.println(this.getName() + " : " + e.getMessage());
        }
    }

    /*
    * Отображает прогресс выполнения программы в консоли. + Устанавливает задержку.
    * */
    private void printProgress() {
        try {
            synchronized (this) {
                this.wait(10);
                handledFilesQuantity += handledFiles.size();
                System.out.format("%d/%d\n", handledFilesQuantity, filesQuantity);
            }
        } catch (InterruptedException e) { }
    }

    /*
    * Обеспечивает вывод статистики работы программы.
    * */
    public void printStatistics() {
        System.out.println("Handled files quantity - " + filesQuantity);
        System.out.println("Total rows count - " + totalRowsQuantity);
        System.out.println("Deleted rows count - " + (totalRowsQuantity - writtenRowsQuantity));
    }
}
