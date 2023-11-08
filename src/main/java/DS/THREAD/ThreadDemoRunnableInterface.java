package DS.THREAD;

public class ThreadDemoRunnableInterface implements Runnable{

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("in the thread runnable interface");
    }

    public static void main(String[] args) {
        ThreadDemoRunnableInterface threadDemoRunnableInterface = new ThreadDemoRunnableInterface();
        Thread thread = new Thread(threadDemoRunnableInterface);
        thread.start();
        new Thread().run();
    }

}
