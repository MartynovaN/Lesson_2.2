package lesson2_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private final Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String phone) {

        for (List<String> phones : phoneBook.values()) {

            if (phones.contains(phone)) {
                System.out.println("Такой номер уже есть в справочнике: " + phone);
                return;
            }
        }

        phoneBook
                .computeIfAbsent(surname, key -> new ArrayList<>())
                .add(phone);
    }

    public List<String> get(String surname) {
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }
}
