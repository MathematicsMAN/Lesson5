package ru.GeekBrains.Lesson7.Lesson7HomeWork;

public class Plate {
    private int food;
    private int maxFood;

    public Plate(int maxFood) {
        this.maxFood = maxFood;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Plate: food= " + food + "; maxFood= " + maxFood;
    }
    public void addFood(int food) {
        if(this.food + food > this.maxFood){
            this.food = maxFood;
        }
        else {
            this.food += food;
        }
    }

    public void decreaseFood(int food) {
        if(this.food < food){
            this.food = 0;
        }
        else {
            this.food -= food;
        }
    }

    public int getFood() {
        return food;
    }
}
