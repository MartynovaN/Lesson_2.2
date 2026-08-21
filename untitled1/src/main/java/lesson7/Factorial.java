package lesson7;

public class Factorial {

    public int calculate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }

        int result = 1;

        for (int i = 2; i <= number; i++) {
            result *= i;
        }

        return result;
    }
}