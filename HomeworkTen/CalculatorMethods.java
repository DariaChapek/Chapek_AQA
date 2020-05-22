package HomeworkTen;

public class CalculatorMethods {

    public static int addition (int number1, int number2) {
        return number1 + number2;
    }

    public static int subtraction(int number1, int number2) {
        return number1 - number2;
    }

    public static int multiply (int number1, int number2) {
        return number1 * number2;
    }

    public static double division (int number1, int number2) throws Exception {
        if (number2 != 0){
            return (double) number1 / number2;
        } else {
                throw new Exception("На ноль делить нельзя.");
        }
    }

}
