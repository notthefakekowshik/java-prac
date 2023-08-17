package DS;

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
public class ThreadDemo2 {

    public static void main(String[] args) {
        Testing1 testing1 = new Testing1();
        Testing2 testing2 = new Testing2();
        Thread t = new Thread(testing1);
        t.start();


    }
}
