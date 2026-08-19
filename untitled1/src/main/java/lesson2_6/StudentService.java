package lesson2_6;

import java.util.Iterator;
import java.util.Set;

public class StudentService {

    // Удаляет студентов со средним баллом меньше 3
    public void removeStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    // Переводит студентов на следующий курс,
    // если средний балл не меньше 3
    public void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    // Выводит имена студентов указанного курса
    public void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}