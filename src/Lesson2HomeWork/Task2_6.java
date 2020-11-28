package Lesson2HomeWork;

import java.util.Arrays;
import java.util.Random;

/*Написать метод, в который передается не пустой одномерный
  целочисленный массив, метод должен вернуть true, если в массиве
  есть место, в котором сумма левой и правой части массива равны.
  Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
  checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами
  ||, эти символы в массив не входят.*/
public class Task2_6 {
    public static void main(String[] args) {
        final int SIZE_ARR = 10;
        int[] array = new int[SIZE_ARR];
        int maxValueInArray = 6;

        generateArr(array, maxValueInArray);
        System.out.println("Array:\n" + Arrays.toString(array));

        if (checkBalance(array)) {
            System.out.println("Условие задачи выполняется");
        } else System.out.println("Условие задачи не выполняется");

    }

    private static void generateArr(int[] array, int max) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(max);
    }

    private static boolean checkBalance(int[] a) {
        int sumArray = 0;
        int sumOfHalf = 0;

        for (int num : a) {
            sumArray += num;
        }
        System.out.println("Sum of all elements : " + sumArray);

        if (sumArray % 2 == 1) return false;

        for (int i = 0; i < a.length; i++) {
            sumOfHalf += a[i];
            if (sumOfHalf == sumArray / 2)
                return true;
            if (sumOfHalf > sumArray / 2)
                return false;
        }
        return false;
    }


}
