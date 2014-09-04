package task_2;

/**
 * Created by 1 on 04.09.2014.
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Hello! This is " + this.getName());
    }
}
