package DS;

public class ThreadDemoThreadClass extends Thread {

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        for(int i = 0; i < 5;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("starting");
        ThreadDemoThreadClass t1 = new ThreadDemoThreadClass();
        ThreadDemoThreadClass t2 = new ThreadDemoThreadClass();
        t1.start();
        t2.start();
        System.out.println("done");

    }

}
