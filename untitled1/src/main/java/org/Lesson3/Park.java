public class Park {

    // Внутренний класс
    public class Attraction {

        private String name;
        private String workingHours;
        private double price;

        // Конструктор
        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        // Метод вывода информации
        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println();
        }
    }

}
