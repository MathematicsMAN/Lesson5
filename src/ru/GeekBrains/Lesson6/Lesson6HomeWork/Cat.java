package ru.GeekBrains.Lesson6.Lesson6HomeWork;

public class Cat extends Animal {
    private int canRun;
    private float canJump;
    private int canSwim;
    private static int numberCats;

    public Cat(String name, int canRun, float canJump, int canSwim) {
        super(name);
        this.canRun = canRun;
        this.canJump = canJump;
        this.canSwim = canSwim;
        numberCats++;
    }

    public Cat(String name, int canRun, float canJump) {
        this(name,canRun,canJump,0);
    }

    public Cat() {
        this(null,0,0,0);
    }

    public static int getNumberCats() {
        return numberCats;
    }

    public boolean run(int length) {
        return super.run(length,canRun);
    }

    public boolean swim(int length) {
        if(length >= 0){
            if(canSwim > 0){
                return super.swim(length,canSwim);
            } else {
                System.out.println("Коты не плавают");
            }
        } else {
            System.out.println("Расстояние не может быть отрицательным");
        }
        return false;
    }

    public boolean jump(float height) {
        return super.jump(height,canJump);
    }
}
