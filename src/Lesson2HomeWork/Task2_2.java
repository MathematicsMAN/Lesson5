package Lesson2HomeWork;

import java.util.Arrays;

/*Задать пустой целочисленный массив размером 8. С помощью
  цикла заполнить его значениями 0 3 6 9 12 15 18 21*/
public class Task2_2 {
    public static void main(String[] args) {
        final int SIZE_ARR = 8;
        int[] array = new int[SIZE_ARR];

        for (int i = 0; i < array.length; i++)
            array[i] = i * 3;
        System.out.println("Array:\t" + Arrays.toString(array));
    }
}
