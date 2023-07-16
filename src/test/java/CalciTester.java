import org.example.JunitDemo;
import org.junit.Assert;
import org.junit.Test;

public class CalciTester {

    @Test
    public void additionTester(){
        Assert.assertEquals(JunitDemo.add(1,2) , 5);
    }

    @Test
    public void additionTesterTrue() {
        Assert.assertTrue(JunitDemo.add(1,2) == 3);
    }
}
