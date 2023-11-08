package DS.THREAD;

class PrinterClass implements Runnable{

    Object lock = new Object();
    int counter  = 0;
    /**
     * Runs this operation.
     */
    @Override
    public void run() {

        while(counter < 10)
        {
            synchronized (lock) {
                if(counter % 2==0 && Thread.currentThread().getName().equals("Even")){
                    System.out.println(Thread.currentThread().getName() + ":" + counter);
                    counter+=1;
                    lock.notify();
                }
                else {
                    System.out.println(Thread.currentThread().getName() + ":" + counter);
                    counter+=1;
                    lock.notify();
                }

                if(counter < 10 ){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}

class PrinterClassDemo implements Runnable {

    int counter = 0;

    final Object lock = new Object();

//    @Override
//    public void run() {
//        while(counter < 10) {
//            if(counter % 2==0 && Thread.currentThread().getName().equals("Even")) {
//                synchronized (lock) {
//                    System.out.println("Even -> " + counter);
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//            else if(counter%2==1 && Thread.currentThread().getName().equals("Odd")) {
//                synchronized (lock) {
//                    System.out.println("Odd -> " + counter);
//                    lock.notify();
//                }
//            }
//
//        }
//    }

    @Override
    public void run() {
        while (counter < 10) {
            synchronized (lock) {
                if ((counter % 2 == 0 && Thread.currentThread().getName().equals("Even"))
                        || (counter % 2 == 1 && Thread.currentThread().getName().equals("Odd"))) {
                    System.out.println(Thread.currentThread().getName() + " -> " + counter);
                    counter++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}


public class ThreadsEvenOdd {

    public static void main(String[] args) {
//        PrinterClass pc = new PrinterClass();
//        Thread thread1 = new Thread(pc, "Even");
//        Thread thread2 = new Thread(pc, "Odd");
//
//        thread1.start();
//        thread2.start();

        PrinterClassDemo printerClassDemo = new PrinterClassDemo();

        Thread t1 = new Thread(printerClassDemo, "Even");
        Thread t2 = new Thread(printerClassDemo, "Odd");
        t1.start();
        t2.start();
    }
}
