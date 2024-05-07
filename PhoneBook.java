import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook = new HashMap<>();

    public void addEntry(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    public void printSortedPhoneBook() {
        phoneBook.entrySet().stream()
            .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
            .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("Иван", "123456789");
        phoneBook.addEntry("Иван", "987654321");
        phoneBook.addEntry("Мария", "111222333");
        phoneBook.addEntry("Алексей", "444555666");
        phoneBook.addEntry("Алексей", "666555444");
        phoneBook.addEntry("Алексей", "222333444");

        phoneBook.printSortedPhoneBook();
    }
}
