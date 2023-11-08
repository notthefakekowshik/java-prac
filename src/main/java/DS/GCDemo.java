package DS;

public class GCDemo {
    public void finalize() {
        System.out.println("GC called");
    }
    public static void main(String[] args) {
        GCDemo gc1 = new GCDemo();
        //gc1 = null;
        System.gc();

    }
}
