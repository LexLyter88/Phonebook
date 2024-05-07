import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
   
   public class UserInputProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
   
        System.out.println("Введите данные в следующем порядке через пробел: Фамилия Имя Отчество датарождения номертелефона пол: ");
        String input = scanner.nextLine();
   
        String[] userData = input.split(" ");
        if (userData.length != 6) {
            System.out.println("Ошибка: Неверное количество данных. Пожалуйста, введите данные в требуемом формате.");
            return;
        }
   
        String lastName = userData[0];
        String firstName = userData[1];
        String middleName = userData[2];
        String birthDate = userData[3];
        String phoneNumber = userData[4];
        String gender = userData[5];
   
        // Проверка формата данных с помощью регулярных выражений // Проверяем форматы данных (можно добавить дополнительные проверки здесь)
        if (!Pattern.matches("[А-Яа-яЁё]+", lastName) || !Pattern.matches("[А-Яа-яЁё]+", firstName) || !Pattern.matches("[А-Яа-яЁё]+", middleName)) {
            System.out.println("Ошибка: Некорректный формат ФИО.");
            return;
        }
           
        if (!Pattern.matches("\\d{4}-\\d{2}-\\d{2}", birthDate)) {
            System.out.println("Ошибка: Некорректный формат даты рождения.");
            return;
        }
           
        if (!Pattern.matches("\\d{10}", phoneNumber)) {
            System.out.println("Ошибка: Некорректный формат номера телефона.");
            return;
        }
   
        if (!gender.equalsIgnoreCase("Мужской") && !gender.equalsIgnoreCase("Женский")) {
            System.out.println("Ошибка: Некорректное значение пола.");
            return;
        } 
   
        File file = new File(lastName + ".txt");
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender + "\n");
            System.out.println("Данные успешно записаны в файл: " + file.getName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка при записи в файл. Пожалуйста, попробуйте еще раз.");
        }
    }              
}
   