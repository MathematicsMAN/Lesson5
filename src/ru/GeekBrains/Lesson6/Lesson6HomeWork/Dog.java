package ru.GeekBrains.Lesson6.Lesson6HomeWork;

public class Dog extends Animal {
    private int canRun;
    private int canSwim;
    private float canJump;
    private static int numberDogs;

    public Dog(String name,int canRun, float canJump, int canSwim) {
        super(name);
        this.canRun = canRun;
        this.canSwim = canSwim;
        this.canJump = canJump;
        numberDogs++;
    }

    public Dog() {
        this(null,0,0,0);
    }

    public static int getNumberDogs() {
        return numberDogs;
    }

    public boolean run(int length) {
        return super.run(length,canRun);
    }

    public boolean swim(int length) {
        return super.swim(length,canSwim);
    }

    public boolean jump(float height) {
        return super.jump(height,canJump);
    }
}
