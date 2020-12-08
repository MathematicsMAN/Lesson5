package ru.GeekBrains.Lesson5;

public class Worker {
    String name;
    String position;
    String eMail;
    String phone;
    int salary;
    int age;

    public Worker(String name, String position, String eMail, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.eMail = eMail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        String Info = String.format("Имя сотрудника: %s;%nдолжность: %s;" +
                "%ne-mail: %s;%nтелефон: %s;%nзарплата: %s;%nвозраст: %s",name,position,eMail,phone,salary,age);
        System.out.println(Info);
    }
}
