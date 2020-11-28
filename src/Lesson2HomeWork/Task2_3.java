package Lesson2HomeWork;

import java.util.Arrays;

/*Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
 пройти по нему циклом, и числа меньшие 6 умножить на 2*/
public class Task2_3 {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Start array:\n" + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if(array[i] < 6) array[i] *= 2;
        }

        System.out.println("Finish array:\n" + Arrays.toString(array));
    }
}
