package HomeworkNine;

public class CalculatorMethods {

    public static int add (int number1, int number2) {
        return number1 + number2;
    }

    public static int sub(int number1, int number2) {
        return number1 - number2;
    }

    public static int mul (int number1, int number2) {
        return number1 * number2;
    }

    public static double div (int number1, int number2) {
        if (number2 != 0.0){
            return (double) number1 / number2;
        } else {
            try {
                throw new Exception("На ноль делить нельзя.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}
