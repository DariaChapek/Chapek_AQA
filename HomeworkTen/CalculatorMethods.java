<<<<<<< Updated upstream
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
=======
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
>>>>>>> Stashed changes
    }

}
