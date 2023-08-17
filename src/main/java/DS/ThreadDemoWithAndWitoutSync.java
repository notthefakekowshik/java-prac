package DS;

class Printer {
    public synchronized void printerFunc() {
        for(int i = 0;i<5;i++){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

//    public void printerFunc() {
//        for(int i = 0;i<5;i++){
//            System.out.println(i);
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
    Thread1(Printer t){
        this.t=t;
    }

    public void run(){
        t.printerFunc();
    }
}

class Thread2 extends Thread{
    Printer t;
    Thread2(Printer t){
        this.t=t;
    }
    public void run(){
        t.printerFunc();
    }
}

public class ThreadDemoWithoutSync {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread1 thread1 = new Thread1(printer);
        Thread2 thread2 = new Thread2(printer);

        thread1.start();
        thread2.start();
    }
}
