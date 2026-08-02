import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {

        // задание 1
        printThreeWords();

        // задание 2
        checkSumSign();

        // задание 3
        printColor();

        // задание 4
        compareNumbers();

        // задание 5
        System.out.println(checkSum(5, 7));
        System.out.println(checkSum(3, 4));

        // задание 6
        checkNumber(5);
        checkNumber(-3);
        checkNumber(0);

        // задание 7
        System.out.println(checkNegative(-7));
        System.out.println(checkNegative(3));
        System.out.println(checkNegative(0));

        // задание 8
        printString("Hello Pavel", 3);

        // задание 9
        System.out.println(isLeapYear(2024));
        System.out.println(isLeapYear(1900));
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2023));

        // задание 10
        int[] array10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertArray(array10);
        System.out.println(Arrays.toString(array10));

        // задание 11
        fillArray();

        // задание 12
        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyLessThanSix(array12);

        // задание 13
        createDiagonalArray();

        // задание 14
        int[] newArray = createArray(5, 7);
        System.out.println(Arrays.toString(newArray));
    }


    // задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }


    // задание 2
    public static void checkSumSign() {
        int a = 5;
        int b = -2;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }


    // задание 3
    public static void printColor() {
        int value = 50;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }


    // задание 4
    public static void compareNumbers() {
        int a = 8;
        int b = 12;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }


    // задание 5
    public static boolean checkSum(int a, int b) {
        int sum = a + b;

        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }


    // задание 6
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }


    // задание 7
    public static boolean checkNegative(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }


    // задание 8
    public static void printString(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }


    // задание 9
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }


    // задание 10
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }


    // задание 11
    public static void fillArray() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.println(Arrays.toString(array));
    }


    // задание 12
    public static void multiplyLessThanSix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }

        System.out.println(Arrays.toString(array));
    }


    // задание 13
    public static void createDiagonalArray() {
        int size = 5;
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }


    // задание 14
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];

        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }

        return array;
    }
}