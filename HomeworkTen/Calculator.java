package HomeworkNine;


import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number1 = 0;
        int number2 = 0;

        System.out.println("Введите число 1");
        if (scanner.hasNextInt()) {
            number1 = scanner.nextInt();
        } else {
            System.out.println("Неверное число 1.");
        }

        System.out.println("Введите число 2");
        if (scanner.hasNextInt()) {
            number2 = scanner.nextInt();
        } else {
            System.out.println("Неверное число 2.");
        }

        System.out.println("Введите операцию");
        scanner.nextLine();
        if (scanner.hasNextLine()) {
            String sign = scanner.nextLine();
            switch (sign) {
                case "+":
                    System.out.println(CalculatorMethods.add(number1, number2));
                    break;
                case "-":
                    System.out.println(CalculatorMethods.sub(number1, number2));
                    break;
                case "*":
                    System.out.println(CalculatorMethods.mul(number1, number2));
                    break;
                case "/":
                    System.out.println(CalculatorMethods.div(number1, number2));
                    break;
                default:
                    System.out.println("Неверный знак.");
            }
        }

    }

}
