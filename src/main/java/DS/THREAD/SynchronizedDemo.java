package DS.THREAD;


class Counter{

    int var = 1;
    public void counter() {
        synchronized(this) {
            for(int i = 0;i < 10;i++) {
                System.out.println(Thread.currentThread().getName() + " " + var);
                var+=1;
            }
        }
    }
}
public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            new Counter().counter();
        }, "t1");

        Thread t2 = new Thread(() -> new Counter().counter(), "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
