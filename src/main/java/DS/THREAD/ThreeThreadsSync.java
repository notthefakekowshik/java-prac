//package DS.THREAD;
//
//class ThreeThreadsImpl implements Runnable{
//
//    int counter = 1;
//    private static final Object lock = new Object();
//
//    @Override
//    public void run() {
//        synchronized (lock) {
//            while(counter < 20) {
//                if(Thread.currentThread().getName().equals("two") && counter % 2==0) {
//                    System.out.println(Thread.currentThread().getName() + "-->" + counter);
//                    counter +=1;
//                }
//                else if(Thread.currentThread().getName().equals("three") && counter % 3==0) {
//                    System.out.println(Thread.currentThread().getName() + "-->" + counter);
//                    counter +=1;
//                }
//                else if(Thread.currentThread().getName().equals("five") && counter % 5==0) {
//                    System.out.println(Thread.currentThread().getName() + "-->" + counter);
//                    counter +=1;
//                }
//                else {
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                lock.notifyAll();
//            }
//        }
//
//    }
//}
//public class ThreeThreadsSync {
//    public static void main(String[] args) {
//        ThreeThreadsImpl threeThreads = new ThreeThreadsImpl();
//
//        Thread two = new Thread(threeThreads, "two");
//        Thread three = new Thread(threeThreads, "three");
//        Thread five = new Thread(threeThreads, "five");
//
//        two.start();
//        three.start();
//        five.start();
//
//
//    }
//}
package DS.THREAD;

class ThreeThreadsImpl implements Runnable {

    private int counter = 2;
    private static final Object lock = new Object();

    @Override
    public synchronized void run() {
        while (counter <= 20) {
            try {
                if (Thread.currentThread().getName().equals("two") && counter % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-->" + counter);
                    counter += 1;
                    this.notifyAll();
                } else if (Thread.currentThread().getName().equals("three") && counter % 3 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-->" + counter);
                    counter += 1;
                    this.notifyAll();
                } else if (Thread.currentThread().getName().equals("five") && counter % 5 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-->" + counter);
                    counter += 1;
                    this.notifyAll();
                    // what if I use lock.notify() in all the cases.
                } else if (counter % 2 != 0 && counter % 3 != 0 && counter % 5 != 0) {
                    counter += 1;
                } else {
                    this.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

//        synchronized (this) {
//            while (counter <= 20) {
//                try {
//                    if (Thread.currentThread().getName().equals("two") && counter % 2 == 0) {
//                        System.out.println(Thread.currentThread().getName() + "-->" + counter);
//                        counter += 1;
//                        this.notifyAll();
//                    } else if (Thread.currentThread().getName().equals("three") && counter % 3 == 0) {
//                        System.out.println(Thread.currentThread().getName() + "-->" + counter);
//                        counter += 1;
//                        this.notifyAll();
//                    } else if (Thread.currentThread().getName().equals("five") && counter % 5 == 0) {
//                        System.out.println(Thread.currentThread().getName() + "-->" + counter);
//                        counter += 1;
//                        this.notifyAll();
//                        // what if I use lock.notify() in all the cases.
//                    } else if (counter % 2 != 0 && counter % 3 != 0 && counter % 5 != 0) {
//                        counter += 1;
//                    } else {
//                        this.wait();
//                    }
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        // You can use this/lock.
    }
}

public class ThreeThreadsSync {
    public static void main(String[] args) {
        ThreeThreadsImpl threeThreads = new ThreeThreadsImpl();

        Thread two = new Thread(threeThreads, "two");
        Thread three = new Thread(threeThreads, "three");
        Thread five = new Thread(threeThreads, "five");

        two.start();
        three.start();
        five.start();
    }
}
