public class Lesson3 {

    public static void main(String[] args) {

        // задание 1

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
        System.out.println();

        product3.printInfo();
        System.out.println();

        // задание 2

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);

        productsArray[1] = new Product("iPhone 16 Pro", "10.09.2025",
                "Apple Inc.", "USA", 6899, false);

        productsArray[2] = new Product("Xiaomi 15", "15.03.2025",
                "Xiaomi", "China", 3999, true);

        productsArray[3] = new Product("Huawei P70", "20.01.2025",
                "Huawei", "China", 4299, false);

        productsArray[4] = new Product("Google Pixel 10", "05.05.2025",
                "Google", "USA", 4799, true);

        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printInfo();
            System.out.println();
        }

        // задание 3

        Park park = new Park();

        Park.Attraction attraction1 =
                park.new Attraction("Колесо обозрения", "10:00 - 22:00", 500);

        Park.Attraction attraction2 =
                park.new Attraction("Американские горки", "11:00 - 21:00", 700);

        Park.Attraction attraction3 =
                park.new Attraction("Автодром", "09:00 - 20:00", 300);

        attraction1.printInfo();
        attraction2.printInfo();
        attraction3.printInfo();

    }
}