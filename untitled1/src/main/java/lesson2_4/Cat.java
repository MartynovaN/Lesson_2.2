package lesson2_4;

public class Cat extends Animal {

    private static int countCats = 0;

    private boolean satiety;

    public Cat(String name) {
        super(name);
        countCats++;
        satiety = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            satiety = true;
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCountCats() {
        return countCats;
    }

    public void printInfo() {
        if (satiety) {
            System.out.println(name + " сыт.");
        } else {
            System.out.println(name + " голоден.");
        }
    }
}