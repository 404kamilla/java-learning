package org.example.lesson3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.example.lesson2.User;

public class UserManager {
    // private - доступ только внутри этого класса, другие классы не видят
// ArrayList<User> - тип переменной: список (динамический массив), который хранит объекты класса User
// users - имя переменной (обычно во множественном числе, т.к. содержит коллекцию объектов)
// = new ArrayList<>() - создаем новый пустой список (new - выделяем память, ArrayList<>() - вызываем конструктор)
    private ArrayList<User> users = new ArrayList<>();
    private Map<String, User> userByEmail = new HashMap<>(); //<KeyType, ValueType>

    public void addUser(User user){  // метод добавления юзера
        if(user == null){
            System.out.println("Ошибка: пользователь не может быть null");
            return;
        }
        if(userByEmail.containsKey(user.getEmail())){
            throw new IllegalArgumentException("Email уже существует!");
        }
        users.add(user);
        userByEmail.put(user.getEmail(), user);
        System.out.println("Пользователь добавлен: "+ user.getName());
    }


    public User findUserByEmail(String email){
        return userByEmail.get(email);
    }

    public void showAllUsers(){ // метод показать всех юзеров
        if (users.isEmpty()){
            System.out.println("Список пользователей пуст");
            return;
        }
        System.out.println("\n=== ВСЕ ПОЛЬЗОВАТЕЛИ ===");
        for(int a = 0; a< users.size(); a++ ){
            User casheUser = users.get(a);
            System.out.println((a + 1) + ". " +casheUser.getInfo());
        }
    }

    public User findByName(String currentName){   //поиск по имени  User в начала это тип возвращаемого значения, как стринг или инт
        for(User user: users){
            if (user.getName().equalsIgnoreCase(currentName)){
                return user;
            }
        }
        return null;
    }

    public int getCount() {   //мотд возвращает кол-во юзеров
        return users.size();
    }


}
