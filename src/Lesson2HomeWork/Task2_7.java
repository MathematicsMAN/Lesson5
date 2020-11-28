package Lesson2HomeWork;

import java.util.Arrays;
import java.util.Random;

/* **** Написать метод, которому на вход подается одномерный массив
  и число n (может быть положительным, или отрицательным), при этом
  метод должен сместить все элементы массива на n позиций. Элементы
  смещаются циклично. Для усложнения задачи нельзя пользоваться
  вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один
  вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) ->
  [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.*/
public class Task2_7 {
    public static void main(String[] args) {
        final int SIZE_ARR = 10;
        int[] array = new int[SIZE_ARR];
        int n;

        generateArr(array);
        System.out.println("Array:\n" + Arrays.toString(array));

        n = 1;
        rotateArray(array, n);
        System.out.println("Array after rotate (n = " + n + "):\n" + Arrays.toString(array));

        n = 3;
        rotateArray(array, n);
        System.out.println("Array after rotate (n = " + n + "):\n" + Arrays.toString(array));
        n = -2;
        rotateArray(array, n);
        System.out.println("Array after rotate (n = " + n + "):\n" + Arrays.toString(array));
        n = -5;
        rotateArray(array, n);
        System.out.println("Array after rotate (n = " + n + "):\n" + Arrays.toString(array));

    }

    private static void generateArr(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = rand.nextInt(100);
    }

    private static void rotateArray(int[] a, int n) {
        n %= a.length;
        if (n < 0) rotateArrayLeft(a, -n);
        else rotateArrayRight(a, n);
    }

    private static void rotateArrayLeft(int[] a, int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            temp = a[0];
            for (int j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            a[a.length - 1] = temp;
        }
    }

    private static void rotateArrayRight(int[] a, int n) {
        int temp;
        for (int i = 0; i < n; i++) {
            temp = a[a.length - 1];
            for (int j = a.length - 1; j > 0; j--) {
                a[j] = a[j - 1];
            }
            a[0] = temp;
        }
    }
}
