package lesson2;

import java.util.Arrays;

public class package21 {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("1. Before:\t" + Arrays.toString(array1));
        modify(array1);
        System.out.println("1. After:\t" + Arrays.toString(array1));

        int[] arrInt = new int[8];
        fillIn(arrInt);
        System.out.println("2. Filled with cycle:\t" + Arrays.toString(arrInt));

        int[] mas = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("3. Before:\t" + Arrays.toString(mas));
        doubling(mas);
        System.out.println("3. After:\t" + Arrays.toString(mas));

        final int side = 10;
        int[][] dArr = new int[side][side];
        crossFill(dArr);
        for (int i = 0; i < dArr.length; i++) {
            for (int j = 0; j < dArr[i].length; j++) {
                System.out.print(dArr[i][j] + " ");
            }
            System.out.println();
        }

        }
        private static void modify(int[] array){
            for (int i = 0; i < array.length; i++)
                array[i] = (array[i] == 1) ? 0 : 1;
        }

    private static void fillIn(int[] array){
        for (int i = 0; i < array.length; i++)
            array[i] = i * 3 + 1;
    }

    private static void doubling(int[] array){
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6)
                array[i] *= 2;
    }

    private static void crossFill(int[][] array){
        int strght, bckwd;
        for (strght = 0, bckwd = array.length - 1; strght < array.length; strght++, bckwd--) {
            array[strght][bckwd] = 1;
            array[strght][strght] = 1;
        }
    }

    }