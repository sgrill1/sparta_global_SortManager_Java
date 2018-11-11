package com.sparta.sdg;

import com.sparta.sdg.sorters.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class PerformanceTester {
    private static int[] arrayToSort;
    private int[] unsortedArray;

    @BeforeClass
        public static void setupClass(){
            Random random = new Random();
            arrayToSort = new int[100];
            for (int i = 0; i<100; i++){
                arrayToSort[i] = random.nextInt (100);
        }
    }

    @Before
        public void setup(){
        unsortedArray = arrayToSort.clone ();
    }

    @Test
        public void testBubbleSorter(){
            Sorter bubbleSort = new BubbleSort ();
            long start = System.nanoTime ();
            int[] sortedArray = bubbleSort.sortArray (unsortedArray);
            long end = System.nanoTime ();
            printResult (bubbleSort.toString (), end-start,sortedArray);
    }

    @Test
    public void testMergeSorter(){
        Sorter mergeSort = new MergeSort ();
        long start = System.nanoTime ();
        int[] sortedArray = mergeSort.sortArray (unsortedArray);
        long end = System.nanoTime ();
        printResult (mergeSort.toString (), end-start,sortedArray);
    }

    @Test
    public void testQuickSorter(){
        Sorter quickSort = new QuickSort ();
        long start = System.nanoTime ();
        int[] sortedArray = quickSort.sortArray (unsortedArray);
        long end = System.nanoTime ();
        printResult (quickSort.toString (), end-start,sortedArray);
    }

    @Test
    public void testBinarySorter(){
        Sorter binarySort = new BinarySort ();
        long start = System.nanoTime ();
        int[] sortedArray = binarySort.sortArray (unsortedArray);
        long end = System.nanoTime ();
        printResult (binarySort.toString (), end-start,sortedArray);
    }


    private void printResult(String sorter, long time, int[] sortedArray){
        DecimalFormat df = new DecimalFormat ("###,###.####");
        System.out.println (sorter + ":");
        System.out.println (Arrays.toString (sortedArray));
        System.out.println ("Time taken: " + (df.format((time)) + " nano seconds"));
    }
}
