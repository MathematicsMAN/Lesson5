package Lesson2HomeWork;

import java.util.Arrays;
import java.util.Random;

/*Задать одномерный массив и найти в нем минимальный
  и максимальный элементы (без помощи интернета);*/
public class Task2_5 {
    public static void main(String[] args) {
        final int SIZE_ARR = 20;
        int[] array = new int[SIZE_ARR];
        int maxValueInArray = 100;
        int max, min;

        generateArr(array,maxValueInArray);
        System.out.println("Array:\n" + Arrays.toString(array));

        max  = min = array[0];

        for (int num : array) {
            if(num > max) max = num;
            if(num < min) min = num;
        }

        System.out.printf("Max value: %d\nMin value: %d",max,min);
    }

    private static void generateArr(int[] array, int max) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(max);
    }
}
