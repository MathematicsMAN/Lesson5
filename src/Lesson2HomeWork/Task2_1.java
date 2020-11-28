package Lesson2HomeWork;

import java.util.*;

/*Задать целочисленный массив, состоящий из элементов 0 и 1.
 Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла
  и условия заменить 0 на 1, 1 на 0*/
public class Task2_1 {
    public static void main(String[] args) {

         final int SIZE_ARR = 20;
        int[] array = new int[SIZE_ARR];

        generateArr(array);

        System.out.println("Start array:\n" + Arrays.toString(array));

        convertArr(array);

        System.out.println("Array after convert:\n" + Arrays.toString(array));
    }

    private static void generateArr(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(2);
    }

    private static void convertArr(int[] array){
        for (int i = 0; i < array.length; i++)
            array[i] ^= 1;
            //Second variant:  array[i] = (array[i] + 1) % 2;
    }
}
