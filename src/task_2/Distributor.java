package task_2;

/*
* Класс, рассчитывающий распределение файлов по потокам
* */
public class Distributor {
    private int filesQuantity;
    private int threadsQuantity;

    public Distributor(int filesCount, int threadsCount) {
        filesQuantity = filesCount;
        threadsQuantity = threadsCount;
    }

    /*
    * "Карта" распределения числа обрабатываемых файлов на поток.
    * */
    public int[] getDistribution() {
        int [] distribution;
        if(threadsQuantity < filesQuantity) {
            distribution = new int[threadsQuantity];
            int filesForThread = filesQuantity/threadsQuantity;

            for(int i = 0; i < distribution.length; i++) {
                if(i != distribution.length - 1) {
                    distribution[i] = filesForThread;
                } else {
                    distribution[i] = filesQuantity - filesForThread * (distribution.length - 1);
                }
            }
        } else {
            while(threadsQuantity != filesQuantity) {
                threadsQuantity --;
            }
            distribution = new int[threadsQuantity];
            for(int i = 0; i < distribution.length; i++) {
                distribution[i] = 1;
            }
        }
        return distribution;
    }
}
