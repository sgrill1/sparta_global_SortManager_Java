package com.sparta.sdg;

        import com.sparta.sdg.sorters.QuickSort;
        import com.sparta.sdg.sorters.Sorter;
        import static org.junit.Assert.*;
        import org.junit.Before;
        import org.junit.BeforeClass;
        import org.junit.Test;

        import java.util.Arrays;

public class SorterTest {
    private static int[] unsortedArray;
    private int[] sortedArray;
    private Sorter sorter = new QuickSort ();

    @BeforeClass
    public static void setClass() {
        unsortedArray = new int[]{3, 1, 4, 2};
    }

    @Before
    public void setup() {
        unsortedArray = new int[]{3, 1, 4, 2};
        sortedArray = sorter.sortArray (unsortedArray);
    }

    @Test
    public void testSortedArray() {
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue (sortedArray[i + 1] >= sortedArray[i]);
        }

    }

    @Test
    public void testArraySize() {
        unsortedArray = new int[]{3, 1, 4, 2};
        sortedArray = sorter.sortArray (unsortedArray);
        assertEquals (unsortedArray.length, sortedArray.length);
    }

    @Test
    public void testNegativeNumberArray() {
        unsortedArray = new int[]{-3, -1, -4, -2};
        sortedArray = sorter.sortArray (unsortedArray.clone ());
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue (sortedArray[i + 1] >= sortedArray[i]);
        }
    }

    @Test
    public void zeroesArray() {
        unsortedArray = new int[]{0, 0, 0, 0};
        sortedArray = sorter.sortArray (unsortedArray);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue (sortedArray[i + 1] >= sortedArray[i]);
        }
    }

    @Test
    public void emptyArray() {
        int[] testEmptyArray = {};
        sortedArray = sorter.sortArray (testEmptyArray);
        System.out.println (Arrays.toString (sortedArray));
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertTrue (sortedArray[i + 1] >= sortedArray[i]);
        }
    }

}