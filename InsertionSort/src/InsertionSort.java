/**
 * Created by anthonymace on 10/30/14.
 */

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {
        int[] testArray = fillArray(100);
        long startTime = System.nanoTime();
        insertionSort(testArray);
        System.out.println(Arrays.toString(testArray));
        long endTime = System.nanoTime();
        System.out.println("Total sort time: " + (endTime - startTime) + "ns");
    }

    public static void insertionSort(int[] arrayToSort) {
        for (int i = 1; i < arrayToSort.length; i++) {
            int valueToSort = arrayToSort[i];
            int indexOfValueToMove = i;
            while (indexOfValueToMove > 0 && arrayToSort[indexOfValueToMove - 1] > valueToSort) {
                arrayToSort[indexOfValueToMove] = arrayToSort[indexOfValueToMove - 1];
                indexOfValueToMove--;
            }
            arrayToSort[indexOfValueToMove] = valueToSort;
        }
    }

    public static int[] fillArray(int size) {
        Random generator = new Random();
        int[] returnArray = new int[size];
        for (int i = 0; i < size; i++) {
            returnArray[i] = generator.nextInt(size);
        }
        return returnArray;
    }

}