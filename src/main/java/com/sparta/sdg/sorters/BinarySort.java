package com.sparta.sdg.sorters;

import com.sparta.sdg.sorters.BinaryTree.BinaryTree;
import com.sparta.sdg.sorters.BinaryTree.BinaryTreeImplementation;

public class BinarySort implements Sorter{
    @Override
    public int[] sortArray(int[] arrayToSort) {
        BinaryTree binaryTree = new BinaryTreeImplementation(arrayToSort);
        return binaryTree.getSortedTreeDesc();
    }

    @Override
    public String toString() {
        return "Binary Sorter";
    }
}
