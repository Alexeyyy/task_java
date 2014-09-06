package task_2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        int threads_quantity = 2;
        int files_quantity = 5;
        /*Distributor d = new Distributor(files_quantity, threads_quantity);
        int[] distribution = d.getDistribution();
        MyThread[] threads= new MyThread[threads_quantity];*/

        FileRuler ruler = new FileRuler();
        ruler.getDirectoryFiles("files");
        System.out.println(ruler.getFoundFiles().size());
        MyThread t = new MyThread("thread", ruler.getFoundFiles());
        t.run();

        /*for(int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread("Thread " + i, new File("file.txt"));
            threads[i].start();
        }*/
/*
        System.out.println("Finished!");

        FileRuler ruler = new FileRuler();
        ruler.getDirectoryFiles("c:/");
        ruler.printFilesList();*/
    }
}
