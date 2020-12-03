package ru.GeekBrains.Lesson3;

/*Написать программу, которая загадывает случайное число
  от 0 до 9 и пользователю дается 3 попытки угадать это число.
  При каждой попытке компьютер должен сообщить, больше ли
  указанное пользователем число, чем загаданное, или меньше.
  После победы или проигрыша выводится запрос – «Повторить игру
   еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).*/

import java.util.Random;
import java.util.Scanner;

public class Lesson3HomeWork {
    public static void main(String[] args) {
        final int MAX_NUMBER = 10;
        int attempts = 3;

        guessTheNumber(attempts, MAX_NUMBER);
    }

    private static void guessTheNumber(int attempts, int max) {
        int hiddenNumber = getNumber(max);
        int inputNumber;
        boolean isGuess = false;

        do{
            System.out.println("Давай, поиграем в игру - угадайку!\n" +
                    "Компьютер загадает число от 0 до " + (max - 1) +
                    ".\tТвоя задача - угадать это число. Всего попыток " + attempts +
                    "\nЧтоб было легче, компьютер будет давать подсказки.\nНачнём!");
            for (int i = 0; i < attempts && !isGuess; i++) {
                System.out.print("Твоя попытка №" + (i + 1) + " из " + attempts);
                System.out.print(".\tВведи число от 0 до " + (max - 1) + ": ");
                inputNumber = readNumber();
                if (inputNumber == hiddenNumber){
                    isGuess = true;
                } else if (inputNumber < hiddenNumber){
                    System.out.println("Загаданное число больше.");
                } else {
                    System.out.println("Загаданное число меньше.");
                }
            }
            if (isGuess){
                System.out.println("Поздавляем!!! Ты угадал число.\n" +
                        "Компьютер дейстивтельно загадал " + hiddenNumber);
                isGuess = false;
            } else {
                System.out.println("Тебе не удалось угадать число.\n" +
                        "Подумай как можно угадать за меньшее число попыток " +
                        "и ты в следующий раз обязательно справишься\n" +
                        "Компьютер загадал " + hiddenNumber);
            }
        }while (doYouWantPlayAgain());
        System.out.println("С тобой было хорошо играть. До следующих встречь!");
    }

    private static int readNumber() {
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            scanner.next();
        }
        return num;
    }

    private static int getNumber(int num) {
        Random random = new Random();
        return random.nextInt(num + 1);
    }

    private static boolean doYouWantPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Понравилось? Давай сыиграем ещё раз!");
        System.out.print("Для продолжения введи '+': ");
        switch (scanner.next()) {
            case "y", "yes", "да", "+","у":
                return true;
        }
        return false;
    }
}
