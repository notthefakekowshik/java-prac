package DS.THREAD;


class Counter{

    int var = 0;
    public void incrementer() throws InterruptedException {
        for(int i = 0;i < 10;i++) {
            System.out.println(Thread.currentThread().getName() + " " + var);
            Thread.sleep(1000);
            var+=1;
        }

//        synchronized(this) {
//            for(int i = 0;i < 10;i++) {
//                System.out.println(Thread.currentThread().getName() + " " + var);
//                Thread.sleep(1000);
//                var+=1;
//            }
//        }
    }

    public void decrementer() throws InterruptedException {
        for(int i = 0;i < 10;i++) {
            System.out.println(Thread.currentThread().getName() + " " + var);
            Thread.sleep(1000);
            var-=1;
        }

//        synchronized(this) {
//            for(int i = 0;i < 10;i++) {
//                System.out.println(Thread.currentThread().getName() + " " + var);
//                Thread.sleep(1000);
//                var-=1;
//            }
//        }
    }

}
public class SynchronizedDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter obj = new Counter();
        Thread t1 = new Thread(() -> {
            try {
                obj.incrementer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                obj.decrementer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
