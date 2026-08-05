public class Lesson3 {

    public static void main(String[] args) {

        Product product = new Product(
                "Ноутбук",
                "15.07.2026",
                "Lenovo",
                "Китай",
                165000,
                false
        );

        Product product3 = new Product(
                "Ноутбук2",
                "06.08.2026",
                "Lenovo",
                "Китай",
                175000,
                true
        );

        product.printInfo();

        product3.printInfo();
    }
}