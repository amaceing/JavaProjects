/**
 * Created by anthonymace on 10/30/14.
 */

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {

    }

    public static void insertionSort(int[] arrayToSort) {
        for (int i = 1; i < arrayToSort.length; i++) {
            int valueToSort = arrayToSort[i];
            int indexOfValueToMove = i;
            while (i > 0 && arrayToSort[indexOfValueToMove - 1] > arrayToSort[indexOfValueToMove]) {
                arrayToSort[indexOfValueToMove] = arrayToSort[indexOfValueToMove - 1];
                indexOfValueToMove--;
            }
            arrayToSort[indexOfValueToMove] = valueToSort;
        }
    }

    public static int[] fillArray(int size) {

    }

}
