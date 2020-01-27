//1. Дан одномерный массив, состоящий из 0 и 1. Нужно преобразовать его в массив, который
//   будет содержать числа, отображающие сколько 0 или 1 стоит подряд. Пример:
//   массив​ [0,0,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1] преобразуется в [4,7,2,4].
//2. Дан массив целых чисел. Нужно узнать среднее арифметическое всех чисел
//   массива, стоящих на нечетных позициях. Arr[1], arr[3] и т.д.
//3. Дан массив целых чисел и некое целое число N. Нужно узнать, есть ли в массиве
//   число, равное N. Если есть - вывести в консоль сумму всех чисел от 0 элемента, до
//   элемента, который равен N включительно.
//4. Посчитать сумму всех элементов квадратной матрицы.


package additionForHomework2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Task1
        System.out.println("Task 1.");
        int[] array1 = new int[] {0,0,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1};
        ArrayList<String> arrayResult = new ArrayList<>();
        int count = 1;
        boolean flag = false;
        System.out.println("Initial array: " + Arrays.toString(array1));

        for (int i = 0; i < array1.length-1; i++){

        if(array1[i] == array1[i+1]) {
            count++;
            flag = true;
            if ((i == array1.length - 2) && (array1[i] == array1[i+1])) {
                arrayResult.add(String.valueOf(count));
            }
        } else {
            arrayResult.add(String.valueOf(count));
            count = 1;
        }
        }
        if (flag) {
            System.out.print("Result array: ");
            for (int i = 0; i < arrayResult.size(); i++) {
                String value = arrayResult.get(i);
                System.out.print((value) + " ");
            }
            System.out.println();
        } else {
            System.out.println("Повторяющихся чисел не найдено.");
        }

        // Task2
        System.out.println("Task 2.");
        int[] array2 = new int[10];
        Random random = new Random();
        for (int i = 0; i < array2.length; i++){
            array2[i] = random.nextInt(10);
        }
        System.out.println("Initial array: " + Arrays.toString(array2));
        int average2 = 0;
        int count2 = 0;
        for(int i = 1; i < array2.length; i = i + 2){
            average2 += array2[i];
            if (array2[i] != 0) {
                count2++;
            }
        }
        System.out.println("Result sum = " + (float)average2/count2);

        // Task3
        System.out.println("Task 3.");
        int[] array3 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println("Initial array: " + Arrays.toString(array3));
        int N = 10;
        int count3 = 0;
        for (int i = 0; i < array1.length; i++){
            if (array3[i] != N) {
                count3++;
            } else {
                break;
            }
        }
        for(int i = 1; i <= count3; i++){
            array3[0] += array3[i];
        }
        System.out.println("Result sum for N = " + N + " sum = " + array3[0]);

        // Task4
        System.out.println("Task 4.");
        int[][] array4 = new int[5][5];
        int resultSum4 = 0;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                array4[i][j] = random.nextInt(10);
                resultSum4 += array4[i][j];
            }
        }
        System.out.println("Initial array: ");
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(array4[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("resultSum = " + resultSum4);
    }
}
