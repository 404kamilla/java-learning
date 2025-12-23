package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        String name = console.nextLine();
        console.close(); //закрываем консоль
        if(name == null || name.trim().isEmpty()){
            System.out.println("Вы не ввели имя, вы будете гостем");
            name = "Гость";

        }
        else {
           name = name.trim();
            if(name.length()>50){
                System.out.println("Имя слишком длинное. Обрежем до 50 символов.");
                name = name.substring(0, 50);
            }
        }
        System.out.println("Привет, " + name);
    }
}