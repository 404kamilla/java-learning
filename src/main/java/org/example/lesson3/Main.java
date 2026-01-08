package org.example.lesson3;
import org.example.lesson2.User;
import java.util.Scanner;

public class Main {

private static UserManager manager = new UserManager(); //чтобы мы могли пользоваться методами класса юзер менеджер и мы выделяем для них новую ячеку памяти
 private static Scanner scanner = new Scanner(System.in);//private - инкапсуляция, static потому что мы используем его в статик методе мейн и не иммем привязки к какому-то обьекту

    public static void main(String[] args) {


        System.out.println("=== ПРОСТАЯ СИСТЕМА ПОЛЬЗОВАТЕЛЕЙ ===\n");

        //главный цикл программы

        boolean running = true;

        while (running) {
            // Показываем меню
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Показать всех");
            System.out.println("3. Найти по имени");
            System.out.println("4. Сколько пользователей?");
            System.out.println("5. Найти по email");
            System.out.println("0. Выход");
            System.out.print("Выберите: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": //добавить
                    addUser(manager, scanner);
                    break;

                case "2": //показать всех пользователей
                    manager.showAllUsers();
                    break;

                case "3": //найти по имени
                    findByName(manager, scanner);
                    break;

                case "4": //вывести кол-во пользователей
                    System.out.println("Количество пользователей: " + manager.getCount());
                    break;

                    case "5": //найти по email
                    findByEmail(manager, scanner);
                    break;

                case "0": //выход
                    System.out.println("Выход");
                    running = false;
                    break;
            }
        }
        scanner.close();
    }
    // private - метод виден только внутри класса Main
// static - метод принадлежит КЛАССУ Main, а не объекту (можно вызвать без new Main())
// void - метод ничего не возвращает
// addUser - имя метода
// (UserManager manager, Scanner scanner) - параметры:
//     UserManager manager - переменная типа UserManager
//     Scanner scanner - переменная типа Scanner
    private static void addUser(UserManager manager, Scanner scanner){
        System.out.println("\n--- ДОБАВЛЕНИЕ ПОЛЬЗОВАТЕЛЯ ---");
        try{
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();

            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите email: ");
            String email = scanner.nextLine();

            // new - создаем новый объект
            // User(...) - вызываем конструктор класса User
            // user - переменная типа User
            User user = new User(name, age, email);

            // manager.addUser() - вызываем метод addUser у объекта manager
            // user - передаем созданный объект User в метод
            manager.addUser(user);

            // } catch - начало блока "если в try была ошибка, выполни это"
            // (NumberFormatException e) - ловим ошибку преобразования строки в число
            // e - переменная с информацией об ошибке
        } catch (NumberFormatException e){
            System.out.println("Ошибка: возраст должен быть числом!");
        }
        // Второй catch - можно ловить несколько типов ошибок
        // IllegalArgumentException - наша ошибка из конструктора User
        catch (IllegalArgumentException e){
            // e.getMessage() - текст ошибки из исключения
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

    private static void findByName(UserManager manager, Scanner scanner){
        System.out.print("\nВведите имя для поиска: ");
        String name = scanner.nextLine();
        User user = manager.findByName(name);

        if(user != null){
            System.out.println("Пользователь найден!" + user.getInfo());
        }
        else {
            System.out.println("Пользователь не найден");
        }
    }

    private static void findByEmail(UserManager manager, Scanner scanner){
        System.out.print("\nВведите email для поиска: ");
        String email = scanner.nextLine();
        User foundUser = manager.findUserByEmail(email);

        if(foundUser != null){
            System.out.println("Найден! " + foundUser.getInfo());
        }

        else {
            System.out.println("Такого email нет ");

        }

    }

}

