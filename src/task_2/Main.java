package task_2;

import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            int threads_quantity = Integer.parseInt(args[0]);
            String directoryPath = args[1];
            FileRuler ruler = new FileRuler();

            if(ruler.getDirectoryFiles(directoryPath)) {
                ruler.setDistribution(ruler.getFoundFiles().size(), threads_quantity);
                HashMap<Integer, ArrayList<File>> distributedFiles = ruler.getDistributedFiles();

                MyThread[] threads = new MyThread[distributedFiles.size()];

                System.out.println("Ok. We start with " + ruler.getFoundFiles().size() + " files and with " + threads.length + " threads.");

                for (int i = 0; i < threads.length; i++) {
                    threads[i] = new MyThread("Thread " + i, distributedFiles.get(i), ruler.getFoundFiles().size());
                    threads[i].setPriority(Thread.MIN_PRIORITY + (Thread.MAX_PRIORITY - Thread.MIN_PRIORITY)/threads.length * i);
                }

                for (int i = 0; i < threads.length; i++) {
                    threads[i].run();
                }

                for(int i = 0; i < threads.length; i++) {
                    try {
                        if(i == 0) {
                            threads[0].printStatistics();
                        }
                        threads[i].join();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                System.out.println("You've set not a directory!");
            }
        } catch(Exception e) {
            System.out.println("Smth goes wrong! Error: " + e.getMessage());
        }
    }
}
