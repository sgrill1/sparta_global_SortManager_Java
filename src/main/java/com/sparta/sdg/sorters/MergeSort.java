package com.sparta.sdg.sorters;

import java.util.Arrays;

public class MergeSort implements Sorter{
    public int[] sortArray(int[] arrayToSort){
        if(arrayToSort.length == 1){
            return arrayToSort;
        }

        int[] leftArray = Arrays.copyOfRange(arrayToSort,0,arrayToSort.length/2);
        int[] rightArray = Arrays.copyOfRange (arrayToSort,arrayToSort.length/2, arrayToSort.length);
        int[] newLeftArray = sortArray (leftArray);
        int[] newRightArray = sortArray (rightArray);
        return merge (newLeftArray,newRightArray);
    }

    private int[] merge(int[] firstArray, int[] secondArray) {
        int[] newArray = new int[firstArray.length + secondArray.length];
        int i = 0;
        int j = 0;

        for (int k = 0; k < newArray.length; k++) {
            if (i == firstArray.length) {
                newArray[k] = secondArray[j];
                j++;
            } else if (j == firstArray.length) {
                newArray[k] = firstArray[i];
                i++;
            } else if (firstArray[i] <= secondArray[j]) {
                newArray[k] = firstArray[i];
                i++;
            } else if (firstArray[i] >= secondArray[j]) {
                newArray[k] = secondArray[j];
                j++;
            }
        }
        return newArray;
    }
    @Override
    public String toString() {
        return "Merge Sorter";
    }
}
