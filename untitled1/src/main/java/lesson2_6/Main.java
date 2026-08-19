package lesson2_6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Задание 1. Студенты

        Student student1 = new Student(
                "Иван",
                "Инженер по тестированию на Java 2.0 — группа 1",
                1,
                Arrays.asList(5, 4, 5, 4)
        );

        Student student2 = new Student(
                "Анна",
                "Инженер по тестированию на Java 2.0 — группа 1",
                2,
                Arrays.asList(5, 5, 4, 5)
        );

        Student student3 = new Student(
                "Петр",
                "Инженер по тестированию на Java 2.0 — группа 2",
                2,
                Arrays.asList(2, 3, 2, 2)
        );

        Student student4 = new Student(
                "Ольга",
                "Инженер по тестированию на Java 2.0 — группа 2",
                3,
                Arrays.asList(4, 4, 5, 4)
        );

        Set<Student> students = new HashSet<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        StudentService studentService = new StudentService();

        System.out.println("Студенты до удаления:");
        studentService.printStudents(students, 1);
        studentService.printStudents(students, 2);
        studentService.printStudents(students, 3);

        studentService.removeStudents(students);

        System.out.println("\nСтуденты после удаления студентов со средним баллом < 3:");
        studentService.printStudents(students, 1);
        studentService.printStudents(students, 2);
        studentService.printStudents(students, 3);

        studentService.promoteStudents(students);

        System.out.println("\nСтуденты после перевода на следующий курс:");
        studentService.printStudents(students, 2);
        studentService.printStudents(students, 3);
        studentService.printStudents(students, 4);


        // Задание 2. Телефонный справочник

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "89991111111");
        phoneBook.add("Иванов", "89992222222");
        phoneBook.add("Петров", "89993333333");

        System.out.println("\nТелефоны Иванова:");
        System.out.println(phoneBook.get("Иванов"));

        System.out.println("\nТелефоны Петрова:");
        System.out.println(phoneBook.get("Петров"));

        System.out.println("\nПопытка добавить существующий номер:");
        phoneBook.add("Иванов", "89991111111");

        System.out.println("\nТелефоны Сидорова:");
        System.out.println(phoneBook.get("Сидоров"));
    }
}