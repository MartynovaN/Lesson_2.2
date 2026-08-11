package lesson2_4;

public class Main {

    public static void main(String[] args) {

        Dog dogBobik = new Dog("Бобик");
        Dog dogSharik = new Dog("Шарик");

        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");
        Cat catVasya = new Cat("Васька");

        System.out.println("=== Проверяем животных ===");

        dogBobik.run(150);
        dogBobik.run(600);

        dogBobik.swim(5);
        dogBobik.swim(15);

        catMurzik.run(100);
        catMurzik.run(250);

        catMurzik.swim(10);

        System.out.println();

        System.out.println("=== Количество животных ===");

        System.out.println("Всего животных: " + Animal.getCountAnimals());
        System.out.println("Собак: " + Dog.getCountDogs());
        System.out.println("Котов: " + Cat.getCountCats());

        System.out.println();

        System.out.println("=== Кормим котов ===");

        Bowl bowl = new Bowl(10);

        Cat[] cats = {catMurzik, catBarsik, catVasya};

        for (Cat cat : cats) {
            cat.eat(bowl, 5);
        }

        System.out.println();

        System.out.println("=== Сытость котов ===");

        for (Cat cat : cats) {
            cat.printInfo();
        }

        System.out.println();

        System.out.println("Осталось еды в миске: " + bowl.getFood());

        System.out.println();

        System.out.println("=== Добавляем еду ===");

        bowl.addFood(10);

        System.out.println("После добавления еды в миске: "
                + bowl.getFood());
    }
}