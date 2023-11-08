package DS.THREAD;


import lombok.experimental.Helper;
import sun.awt.windows.ThemeReader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Helperr implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "!!");
    }
}
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable helper = new Helperr();
        for(int i = 0;i<10;i++) {
            executorService.execute(helper);
        }
    }
}
