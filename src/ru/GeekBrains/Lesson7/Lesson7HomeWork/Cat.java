package ru.GeekBrains.Lesson7.Lesson7HomeWork;

public class Cat {
    private String name;
    private final int appetite;  //аппетит кота
    private int satiety;   //сытость кота

    public Cat(String name, int appetite, int satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public Cat(String name) {
        this(name,10,0);
    }

    public int getAppetite() {
        return appetite;
    }

    public int getSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public void feedingCat(Plate plate) {
        int takeFood;

        if(plate.getFood() != 0) {
            takeFood = Math.min(hungry(),plate.getFood());
            addSatiety(takeFood);
            plate.decreaseFood(takeFood);
        }
    }

    public int hungry() {
        return appetite - satiety;
    }

    public void addSatiety(int food) {
        if(satiety + food > appetite){
            satiety = appetite;
        }
        else {
            satiety += food;
        }
    }

    public void decreaseSatiety(int food) {
        if(satiety < food){
            satiety = 0;
        }
        else {
            satiety -= food;
        }
    }

    @Override
    public String toString() {
        return "Кот " + name +
                " сыт до уровня " + satiety +
                "; его аппетит: " + appetite;
    }

    public void printInfo() {
        System.out.println(this);
    }
}
