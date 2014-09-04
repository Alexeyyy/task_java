/**
 * Created by 1 on 04.09.2014.
 */
package task_2;

public class TestThread implements Runnable {
    public void run() {
        /*double calc;
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            calc = Math.sin(i*i);
            if(i % 10000 == 0) {
                System.out.print(getName() + "counts" + i/10000);
            }
        }*/
        System.out.println("Hello from minor thread!");
    }
}




