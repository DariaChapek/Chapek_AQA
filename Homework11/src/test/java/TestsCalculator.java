import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsCalculator {

    @Test
    public void testAdd() {
        System.out.println("testAdd() method");
        int number = CalculatorMethods.add(2, 5);
        Assert.assertEquals(number, 7);
    }

    @Test
    public void testSub() {
        System.out.print("testSub() method");
        int number = CalculatorMethods.sub(9, 5);
        Assert.assertEquals(number, 4);
    }

    @Test
    public void testMul() {
        System.out.print("testMul() method");
        int number = CalculatorMethods.mul(3, 4);
        Assert.assertEquals(number, 12);
    }

    @Test
    public void testDiv() {
        System.out.println("testDiv() method");
        double number = CalculatorMethods.div(6, 2);
        Assert.assertEquals(number, 3);
    }

    @Test(expectedExceptionsMessageRegExp = "На ноль делить нельзя.")
    public void testException() {
        System.out.println("Checking Exception");
        double number = CalculatorMethods.div(6, 0);
    }

}
