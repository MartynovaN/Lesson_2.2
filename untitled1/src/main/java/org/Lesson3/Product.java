public class Product {

    // Поля класса
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean reserved;

    // Конструктор
    public Product(String name, String productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean reserved) {

        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.reserved = reserved;
    }

    // Метод вывода информации о товаре
    public void printInfo() {
        System.out.println("Информация о товаре:");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");

        if (reserved) {
            System.out.println("Забронирован: Да");
        } else {
            System.out.println("Забронирован: Нет");
        }
    }
}