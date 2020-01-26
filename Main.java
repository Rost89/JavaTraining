//        1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;
//        2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
//        значениями 0 3 6 9 12 15 18 21;
//        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
//        и числа меньшие 6 умножить на 2;
//        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
//        5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
//        6. ** Написать метод, в который передается не пустой одномерный целочисленный
//        массив, метод должен вернуть true если в массиве есть место, в котором сумма
//        левой и правой части массива равны.
//        Примеры: checkBalance([1, 1, 1, || 2, 1]) > true, checkBalance ([2, 1, 1, 2, 1]) > false,
//        checkBalance ([10, || 10]) > true, граница показана символами ||, эти символы в массив не входят.
//        Делить массив пополам не нужно! Например, для массива [1,2,3,4,10] резульат должен быть true.
//        7. **** Написать метод, которому на вход подается одномерный массив и число n
//        (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива
//        на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.

package javaLesson2;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] myArray; // объявление массива
        myArray = new int[10];  // создание массива т.е выделение памяти под него
        int[] arr = {1, 1, 0, 0, 1, 1, 0, 0, 1, 1};


        //task 1
        System.out.println("Task 1.\n");
        int[] arrayTask1 = new int[]{1, 1, 0, 0, 1, 1, 0, 0, 1, 1};
        System.out.println("Initial array:");
        printArray(arrayTask1);

        //swap 1, 0
        for (int i = 0; i < arrayTask1.length; i++) {
            if (arrayTask1[i] == 0) {
                arrayTask1[i] = 1;
            } else {
                arrayTask1[i] = 0;
            }
        }
        System.out.println("Received array:");
        printArray(arrayTask1);

        //task 2
        System.out.println("Task 2.\n");

        int[] arrayTask2 = new int[8];
        for (int i = 0; i < arrayTask2.length; i++) {
            arrayTask2[i] = (i + i * 2);

        }
        printArray(arrayTask2);

        //task 3
        System.out.println("Task 3.\n");
        int[] arrayTask3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Initial array:");
        printArray(arrayTask3);
        System.out.println("\nReceived array:");
        for (int i = 0; i < arrayTask3.length; i++) {
            if (arrayTask3[i] < 6) {
                arrayTask3[i] *= 2;
            }
        }
        printArray(arrayTask3);

        //task 4
        System.out.println("Task 4.\n");
        int[][] arrayTask4 = new int[10][10];
        System.out.println("Initial array:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arrayTask4[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0, j = 0; i < 10; i++, j++) {
            arrayTask4[i][j] = 1;
            arrayTask4[i][9 - j] = 1;
        }
        System.out.println("\nReceived array:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arrayTask4[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n------------------------------");

        //task 5
        System.out.println("Task 5.\n");
        int[] arrayTask5 = new int[]{56, 34, 2, 56, 777, 78, -87, 3, 6, 98};
        int maxTemp = arrayTask5[0];
        int minTemp = arrayTask5[0];

        for (int i = 0; i < 10; i++) {
            if (maxTemp < arrayTask5[i]) {
                maxTemp = arrayTask5[i];
            }
            if (minTemp > arrayTask5[i]) {
                minTemp = arrayTask5[i];
            }
        }
        System.out.println("max = " + maxTemp + " min = " + minTemp);
        System.out.println("\n------------------------------");

        //task 6
        System.out.println("Task 6.\n");
        int[] arrayTask6 = new int[10];
        Random random = new Random();
        for (int i = 0; i < arrayTask6.length; i++){
            arrayTask6[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(arrayTask6));
        System.out.println(equalParts(arrayTask6));
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static boolean equalParts (int[] array) {
        int sumFirstPart = array[0];
        int sumSecondPart = array[array.length - 1];
        int i = 0, j = array.length - 1;

        while (true) {
            if (array.length == 2) {
                if (sumFirstPart == sumSecondPart) {
                    return true;
                } else {
                    return false;
                }
            }
            if (sumFirstPart > sumSecondPart) {
                sumSecondPart += array[j - 1];
                j--;
            } else {
                sumFirstPart += array[i + 1];
                i++;
            }
            if (i == j - 1) break;
        }
        if (sumFirstPart == sumSecondPart) {
            return true;
        } else {
            return false;
        }
    }
}




