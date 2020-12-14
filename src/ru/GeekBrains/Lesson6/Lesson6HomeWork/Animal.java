package ru.GeekBrains.Lesson6.Lesson6HomeWork;

public abstract class Animal implements Runner, Swimmer, Jumper {
    protected String name;
    private static int numberAnimals;

    public Animal(String name) {
        this.name = name;
        this.numberAnimals++;
    }

    public Animal() {
        this(null);
    }

    public static int getNumberAnimals() {
        return numberAnimals;
    }

    public boolean run(int length, int maxRun){
        if(testLength(length)) {
            if (length <= maxRun) {
                System.out.println(name + " пробежал " + length + " м");
                return true;
            } else {
                System.out.println(name + " не может бегать более " + maxRun + " м");
            }
        }
        return false;
    }

    public boolean swim(int length, int maxSwim){
        if(testLength(length)){
            if(length <= maxSwim) {
                System.out.println(name + " проплыл " + length + " м");
                return true;
            } else {
                System.out.println(name + " не может проплыть более " + maxSwim + " м");
            }
        }
        return false;
    }

    public boolean jump(float height, float maxJump){
        if(testLength(height)){
            if(height <= maxJump) {
                System.out.printf("%s пырыгнул на %.2f м%n",name,height);
                return true;
            } else {
                System.out.printf("%s не может  прыгнуть выше %.2f м%n",name,maxJump);
            }
        }
        return false;
    }

    private boolean testLength(int length){
        if(length < 0){
            System.out.println("Расстояние не может быть отрицательным");
            return false;
        }
        return true;
    }

    private boolean testLength(float length){
        if(length < 0){
            System.out.println("Высота не может быть отрицательной");
            return false;
        }
        return true;
    }

}
