package DS.THREAD;

class Printer {
    public synchronized void printerFunc() {
        for(int i = 0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + "-> " + i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

//    public void printerFunc() {
//        for(int i = 0;i<5;i++){
//            System.out.println(Thread.currentThread().getName()+ "-> " + i);
//            try{
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    } // Try running this

}
class Thread1 extends Thread{
    Printer t;
    Thread1(Printer t, String thread1){
        super(thread1);
        this.t=t;
    }

    public void run(){
        t.printerFunc();
    }
}

class Thread2 extends Thread{
    Printer t;
    Thread2(Printer t, String thread2){
        super(thread2);
        this.t=t;
    }
    public void run(){
        t.printerFunc();
    }
}
 class ThreadDemoWithAndWithoutSync {

    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();
        Thread1 thread1 = new Thread1(printer, "Thread1");
        Thread2 thread2 = new Thread2(printer, "Thread2");

        thread2.start();
        thread1.start();

        for(int i = 0; i < 5;i++) {
            System.out.println("from main");
        }
        new Printer().printerFunc();
        //thread2.join();
    }
}
