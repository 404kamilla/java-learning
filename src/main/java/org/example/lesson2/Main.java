package org.example.lesson2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { //статик потому что общий
        Scanner console = new Scanner(System.in);

        System.out.println("=== Регистрация пользователя ===");
        // try-catch - обработка возможных ошибок
        try {
            //создаем обьект user
            System.out.print("Введите имя: ");
            String name = console.nextLine();

            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(console.nextLine());

            System.out.print("Введите email: ");
            String email = console.nextLine();

            // КЛЮЧЕВАЯ СТРОКА: СОЗДАНИЕ ОБЪЕКТА
            // new - создать новый объект
            // User(...) - вызвать конструктор класса User
            // user - переменная, хранящая ссылку на объект
            User user = new User(name, age, email);
            // Теперь в переменной user находится СОЗДАННЫЙ объект


            // Вызываем метод greet() у объекта user
            user.greet();

            System.out.println(user.getInfo());

            // ▼▼▼ 3. РАБОТА С ГЕТТЕРАМИ ▼▼▼

            System.out.println("\n=== Информация через геттеры ===");
            // user.getName() - вызываем геттер, получаем имя
            System.out.println("Имя: " + user.getName());
            System.out.println("Возраст: " + user.getAge());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Совершеннолетний: " + user.isAdult());

            // ▼▼▼ 4. РАБОТА С СЕТТЕРАМИ (ИЗМЕНЕНИЕ ДАННЫХ) ▼▼▼
            System.out.println("\n=== Изменение данных ===");
            System.out.print("Введите новое имя: ");

            user.setName(console.nextLine()); //изменит имя с проверкой

            System.out.print("Введите новый возраст: ");
            user.setAge(Integer.parseInt(console.nextLine()));

            System.out.print("Введите новый email: ");
            user.setEmail(console.nextLine());

            System.out.println("Обновленная инфа: " + user.getInfo());


            // ▼▼▼ 5. ДЕМОНСТРАЦИЯ ВАЛИДАЦИИ (БЕЗОПАСНОСТЬ!) ▼▼▼

            System.out.println("\n=== Проверка валидации ===");

            try {

                user.setAge(-5);
                System.out.println("Ошибка! Эта строка не должна выполниться");

            } catch (IllegalArgumentException e) {
                System.out.println("Поймали ошибку: " + e.getMessage());
                System.out.println("Объект user НЕ повредился! Возраст остался: " + user.getAge());
            }
        }
        catch(NumberFormatException e){
            System.out.println("Ошибка: возраст должен быть числом!");

        } catch (IllegalArgumentException e) {
            // Если сработала наша валидация в конструкторе/сеттерах
            System.out.println("Ошибка валидации данных: " + e.getMessage());

        }

        finally {
            // finally выполнится ВСЕГДА, даже если была ошибка
            console.close(); // Важно: закрываем Scanner
            System.out.println("\n=== Программа завершена ===");
        }


    }
    }

