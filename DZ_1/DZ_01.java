package DZ_1;
import java.util.Scanner;

public class DZ_01 {
    public static void main(String[] args) {
        ex4();
    }

    static int ex1() {
        // Вычислить n-ое треугольного число (сумма чисел от 1 до n)
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int result = number * (number + 1) / 2;
        System.out.println("Сумма чисел от 1 до введенного числа равна " + result);
        return result;
    }

    static int ex2() {
        // Вычислить n! (произведение чисел от 1 до n)
        System.out.println("Введите число:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println("n! равен " + result);
        return result;
    }

    static String ex3() {
        // Вывести все простые числа от 1 до 1000
        String result = "";
        for (int i = 1; i < 1001; i++) {
            int res_i = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    res_i += 1;
                }
            }
            if (res_i == 0) {
                result = result + i + " ";
            }
        }
        System.out.println(result);
        return result;

    }

    static double ex4() {
        // Реализовать простой калькулятор
        System.out.println("Введите первое число:");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();

        System.out.println("Какое действие будем выполнять? ( + , - , * , / ) ");
        Scanner scanner1 = new Scanner(System.in);
        String op = scanner1.nextLine();

        System.out.println("Введите второе число:");
        double b = scanner.nextDouble();

        double result = 0;

        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
        }

        System.out.println(a + op + b + " = " + result);
        return result;
    }

}
