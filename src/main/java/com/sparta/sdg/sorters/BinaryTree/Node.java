package com.sparta.sdg.sorters.BinaryTree;

public class Node {
    private final int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value){
        this.value = value; //constructor to assign each node a value upon initialization
    }

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
