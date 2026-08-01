public class Lesson2 {

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();

    }

    //задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //задание 2
    public static void checkSumSign() {

        int a = 5;
        int b = -2;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }
}
