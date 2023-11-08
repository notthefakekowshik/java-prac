package DS.THREAD;

class Testing1 implements Runnable{

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("in the testing 1");

    }

}
class Testing2 implements Runnable {

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("in the testing 2");

    }
}

class Testing3 {
    public void third_run() {
        System.out.println("i am in the third run");
    }
}
public class ThreadDemo2{

    public static void main(String[] args) {
        Testing1 testing1 = new Testing1();
        Testing2 testing2 = new Testing2();
        Thread t = new Thread(testing1);
        t.start();

    }
}
