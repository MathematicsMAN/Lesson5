package ru.GeekBrains.Lesson6.Lesson6HomeWork;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int MAX_ANIMALS = 20;
        final int CAN_DOG_MAX_RUN = 500;
        final int CAN_DOG_MAX_SWIM = 10;
        final float CAN_DOG_MAX_JUMP = 0.5f;
        final int CAN_CAT_MAX_RUN = 200;
        final int CAN_CAT_MAX_SWIM = 0;
        final float CAN_CAT_MAX_JUMP = 2.0f;
        Random random = new Random();

        Animal[] animals = new Animal[MAX_ANIMALS];

        for (int i = 0, j = 0; i + j < MAX_ANIMALS;) {
            switch (random.nextInt(2)) {
                case 0 -> animals[i + j] = new Cat("Cat-" + ++i + "й",
                                           random.nextInt(CAN_CAT_MAX_RUN - 100) + 100,
                                          CAN_CAT_MAX_JUMP * random.nextFloat() + 1);
                case 1 -> animals[i + j] = new Dog("Dog-" + ++j + "й",
                                           random.nextInt(CAN_DOG_MAX_RUN - 200) + 200,
                                          CAN_DOG_MAX_JUMP * random.nextFloat(),
                                          random.nextInt(CAN_DOG_MAX_SWIM - 5) + 5);
            }
        }

        for (Animal animal : animals) {
            if (animal instanceof Runner){
                ((Runner)animal).run(random.nextInt(100) + 100);
            }
            if(animal instanceof Swimmer){
                ((Swimmer)animal).swim(random.nextInt(10));
            }
            if(animal instanceof Jumper){
                ((Jumper)animal).jump(2 * random.nextFloat());
            }
        }

        System.out.println("\nВсего животных: " + Animal.getNumberAnimals());
        System.out.println("Всего котов: " + Cat.getNumberCats());
        System.out.println("Всего собак: " + Dog.getNumberDogs());
    }
}
