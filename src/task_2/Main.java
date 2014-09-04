package task_2;


public class Main {
    public static void main(String[] args) {
        MyThread[] threads= new MyThread[10];

        for(int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread("Thread " + i);
            threads[i].start();
        }

        System.out.println("Finished!");

        FileRuler ruler = new FileRuler();
        ruler.GetDirectoryFiles("c:/");
        ruler.PrintFilesList();
    }
}
