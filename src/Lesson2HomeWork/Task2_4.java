package Lesson2HomeWork;

import java.util.Arrays;

/*Создать квадратный двумерный целочисленный массив
  (количество строк и столбцов одинаковое), и с помощью
   цикла(-ов) заполнить его диагональные элементы единицами;*/
public class Task2_4 {
    public static void main(String[] args) {
        final int SIZE_ARR = 10;
        int[][] array = new int[SIZE_ARR][SIZE_ARR];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (i == j) || (i == SIZE_ARR - j - 1) ? 1 : 0;
            }
        }

        for (int[] line : array) {
            System.out.println(Arrays.toString(line));
        }
    }
}
