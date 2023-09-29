import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем HashMap для хранения телефонной книги
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем записи в телефонную книгу (учитываем возможность разных номеров для одного человека)
        addContact(phoneBook, "Иванов", "111-111", "222-222");
        addContact(phoneBook, "Петров", "333-333");
        addContact(phoneBook, "Сидоров", "444-444", "555-555");

        // Выводим телефонную книгу, отсортированную по убыванию числа телефонов
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(Map<String, List<String>> phoneBook, String name, String... phones) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<>());
        }
        Collections.addAll(phoneBook.get(name), phones);
    }

    // Метод для вывода телефонной книги, отсортированной по убыванию числа телефонов
    public static void printPhoneBook(Map<String, List<String>> phoneBook) {
        // Создаем список записей (имя и количество телефонов) для сортировки
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем записи по убыванию числа телефонов
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " телефон(ов)");
        }
    }
}
