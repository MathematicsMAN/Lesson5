package ru.GeekBrains.Lesson7.Lesson7HomeWork;

import java.util.Random;

public class Test {

    static Random random = new Random();
    static final int MAX_CATS = 5;
    static final int MAX_APPETITE = 15; //аппетит кота
    static final int MAX_SATIETY = 12;  //сытость кота
    static final int MAX_PLATES = 5;
    static final int MAX_PLATE_FULL = random.nextInt(MAX_SATIETY + 2);//наполняемость миски

    static Cat[] cats = new Cat[MAX_CATS];
    static Plate[] plates = new Plate[MAX_PLATES];

    public static void main(String[] args) {

        int appetite;
        for (int i = 0; i < MAX_CATS; i++) {
            appetite = random.nextInt(MAX_APPETITE - 10) + 10;
            cats[i] = new Cat("Cat" + (i + 1) + "-й",appetite,
                    random.nextInt(appetite - 5) + 5);
        }
        for (int i = 0; i < MAX_PLATES; i++) {
            plates[i] = new Plate(random.nextInt(MAX_PLATE_FULL - 3) + 3);
        }

        startDay();
    }

    private static void startDay() {
        printStatusCats();
        fullingPlates();
        printStatusPlates();
        feedingCats();
        printStatusPlates();
        printStatusCats();
        sleepingCats();
        printStatusCats();
    }

    private static void printStatusCats() {
        System.out.println("------Информация по котам----------");
        for (int i = 0; i < MAX_CATS; i++) {
            cats[i].printInfo();
        }
    }

    private static void printStatusPlates() {
        System.out.println("------Информация по мискам----------");
        for (int i = 0; i < MAX_PLATES; i++) {
            plates[i].printInfo();
        }
    }

    private static void feedingCats() {
        System.out.println("-------Кормление котов----------");
        for (int i = 0; i < MAX_CATS; i++) {
            if(cats[i].getSatiety() < cats[i].getAppetite()) {
                for (int j = 0; j < MAX_PLATES; j++) {
                    if(plates[i].getFood() == 0){
                        continue;
                    }
                    cats[i].feedingCat(plates[j]) ;
                    if(cats[i].hungry() == 0){
                        break;
                    }
                }
            }
        }
    }

    private static void fullingPlates() {
        System.out.println("-------Наполнение мисок---------");
        for (int i = 0; i < MAX_PLATES; i++) {
            plates[i].addFood(random.nextInt(MAX_PLATE_FULL));
        }
    }

    private static void sleepingCats() {
        System.out.println("-------Коты спят, их сытость понижается---------");
        for (int i = 0; i < MAX_CATS; i++) {
            cats[i].decreaseSatiety(random.nextInt(MAX_SATIETY - 5) + 5);
        }
    }
}
