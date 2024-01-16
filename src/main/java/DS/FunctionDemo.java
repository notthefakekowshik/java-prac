package DS;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


class SquareHelper {
    public static int doublerReturn(int a) {
        return a*a;
    }

    public static void doubler(int a) {
        System.out.println(a*a);
    }
}

class Wisher{
    public void wishMe() {
        System.out.println("hello, I am wishing you!");
    }
}

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer,Integer> square = SquareHelper::doublerReturn;
        int ans = square.apply(5);
        System.out.println(ans);

        Consumer<Integer> consumer = SquareHelper::doubler;
        consumer.accept(4);

        Supplier<Double> randomValue = Math::random;
//        same as
//        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());

        Wisher wisher = new Wisher();
        Runnable runnable = wisher::wishMe;
        runnable.run();
    }
}
