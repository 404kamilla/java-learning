package org.example.lesson2;

public class User {
    private String name; //private - только внутри этого класса можно менять
    private int age;
    private String email;

//▲▲▲ ЗАЧЕМ private? ИНКАПСУЛЯЦИЯ! ▲▲▲
// Безопасность: нельзя сделать user.age = -100 извне
// Контроль: все изменения через методы с проверками

    //Конструктор - создает новый обьект(не то же самое что и метод)
    public User(String name,int age, String email) { // public - можно вызывать из любого места
        setEmail(email);
        setAge(age);
        setName(name);
       // this.name = name;// this -ссылка на ТЕКУЩИЙ объект. this.name - поле "name" ЭТОГО объекта
       // this.age = age;
       // this.email = email;
        // КОНСТРУКТОР ВЫЗЫВАЕТСЯ ПРИ: new User("Анна", 25, "anna@mail.com")
    }
    // ▼▼▼ 5. ГЕТТЕРЫ (GETTERS) - получить значения ▼▼▼

    // public String - метод ВОЗВРАЩАЕТ строку
    // getName() - имя метода ("получить имя")

    public String getName() {
        return name; //возвращаем значение поля name
    }

    public int getAge(){
        return age;
    }

    public String getEmail(){
        return email;
    }
    // ▲▲▲ ЗАЧЕМ ГЕТТЕРЫ? ▲▲▲
    // 1. Контролируемый доступ к данным
    // 2. Можно добавить логирование: "кто-то запросил email"
    // 3. Можно вернуть модифицированные данные

    // ▼▼▼ 6. СЕТТЕРЫ (SETTERS) - установить значения С ПРОВЕРКОЙ ▼▼▼

    // void - метод НИЧЕГО не возвращает
    // setName(String name) - установить имя, принимает строку


    public void setName(String name) {
       if(name == null || name.trim().isEmpty()){
           throw new IllegalArgumentException("Имя не может быть пустым");// Бросаем исключение - программа остановится с ошибкой

       }
       this.name = name.trim();
    }

    public void setAge(int age) {
        if(age < 0 || age >150){
            throw new IllegalArgumentException("Возраст должен быть от 0 и до 150 лет");

        }
        this.age = age;
    }

    public void setEmail(String email) {
        if(email == null || !email.contains("@")){
            throw new IllegalArgumentException("Некорретный email");
        }
        this.email = email;
    }
    // ▲▲▲ ЗАЧЕМ СЕТТЕРЫ? ▲▲▲
    // 1. Валидация данных (безопасность!)
    // 2. Единое место для проверок
    // 3. Можно добавить логи: "пользователь сменил email"

    // ▼▼▼ 7. МЕТОДЫ - ПОВЕДЕНИЕ ОБЪЕКТА ▼▼▼
    public void greet(){
        System.out.println("Привет, "+ this.name);
        System.out.println("Тебе" + this.age + "лет");
    }

    public boolean isAdult(){
        return this.age >=18;
    }

    public String getInfo(){
        return String.format("Имя: %s, Возраст: %d, Email: %s, Взрослый: %s",
                this.name,  //подставить вместо первого %s
                this.age,   //подставить вместо %d
                this.email, //
                isAdult() ? "ДА" : "НЕТ"); //тернарный оператор

    }

    private String password;

    public void setPassword(String password){
        if(password == null || password.length() < 8){
            throw new IllegalArgumentException("Пароль должен быть не менее 8 символов");
        }

        this.password = password;
    }

    //метод проверки пароля
    public boolean checkPassword(String inputPassword){
        return this.password.equals(inputPassword);

    }
}


