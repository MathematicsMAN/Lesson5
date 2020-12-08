package ru.GeekBrains.Lesson5;

public class Lesson5HomeWork {
    public static void main(String[] args) {
        Worker[] workers = new Worker[5];
        workers[0] = new Worker("Orlov Ivan", "Washer","orlov@gov.ru","880056789",50000,57);
        workers[1] = new Worker("Ivanov Ivan", "Chief","ivanov@gov.ru","880012345",50000,47);
        workers[2] = new Worker("Petrov Ivan", "Driver","petrov@gov.ru","880023456",40000,37);
        workers[3] = new Worker("Sidorov Ivan", "Doctor","sidorov@gov.ru","880034567",70000,42);
        workers[4] = new Worker("Kotov Ivan", "Teacher","kotov@gov.ru","880045678",45000,27);

        for (Worker person :
                workers) {
            if (person.age > 40){
                person.printInfo();
                System.out.println();
            }
        }

    }
}
