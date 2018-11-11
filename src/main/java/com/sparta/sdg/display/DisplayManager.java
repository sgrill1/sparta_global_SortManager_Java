package com.sparta.sdg.display;

import java.util.Arrays;

public class DisplayManager implements Display{

    public void displayArrayToSort(int[] arrayToSort, String sortType) {
        System.out.println (Arrays.toString (arrayToSort));
    }
    public void displaySortedArray(int[] sortedArray, String sortType){
        System.out.println ("Sorted using: " + sortType);
        System.out.println (Arrays.toString(sortedArray));
    }

    @Override
    public void displayExceptionMessage(String message){
        System.out.println ("The following error has occurred: " + message);
    }

}
