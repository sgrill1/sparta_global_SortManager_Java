package com.sparta.sdg.sorters.BinaryTree;

public class BinaryTreeImplementation implements BinaryTree {

    private Node rootNode;
    private int numberOfElements = 1;
    private int index = 0;

    public BinaryTreeImplementation(final int element) {
        rootNode = new Node (element);
    }

    public BinaryTreeImplementation(final int[] elements){
        rootNode = new Node(elements[0]);
        for(int i =1; i<elements.length; i++){
            addElement (elements[i]);
        }
    }

    public int getRootElement() {
        return rootNode.getValue ();
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void addElement(int element) {
        Node node = rootNode;

        boolean exitCriteria = true;
        while (exitCriteria) {
            if (element == node.getValue ()) return;
            if (element < node.getValue()) {
                if (node.getLeftChild () != null){
                    node = node.getLeftChild ();
                } else {
                    node.setLeftChild (new Node (element));
                    numberOfElements++;
                    exitCriteria = false;
                }
            } else if (element > node.getValue ()) {
                if (node.getRightChild () != null){
                    node = node.getRightChild ();
                } else {
                    node.setRightChild (new Node (element));
                    numberOfElements++;
                    exitCriteria = false;
                }
            }
        }
    }

    public void addElements(int[] elements) {
        for(int i = 0; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    public boolean findElement(int value) {

        Node focusNode = rootNode;

        while (focusNode != null) {
            if (focusNode.getValue () == value)
                return true;

            if (focusNode.getValue () > value) {
                focusNode = focusNode.getLeftChild ();

            } else if (focusNode.getValue () < value) {
                focusNode = focusNode.getRightChild ();
            }
        }
        return false;
    }


    public int getLeftChild(int element)  {
        Node focusNode = rootNode;
        if (focusNode.getValue () == rootNode.getValue ()) {
            return focusNode.getLeftChild ().getValue ();
        }
        while(focusNode.getValue () != element) {
            if (focusNode.getValue () > element) {
                focusNode = focusNode.getLeftChild ();

            } else if (focusNode.getValue () < element) {
                focusNode = focusNode.getRightChild ();
            }
        }
        return focusNode.getLeftChild().getValue ();


}

    public int getRightChild(int element) {
        Node focusNode = rootNode;
        if (focusNode.getValue () == rootNode.getValue ()) {
            return focusNode.getRightChild ().getValue ();
        }
        while(focusNode.getValue () != element) {
            if (focusNode.getValue () > element) {
                focusNode = focusNode.getLeftChild ();

            } else if (focusNode.getValue () < element) {
                focusNode = focusNode.getRightChild ();
            }
        }
        return focusNode.getRightChild().getValue ();


    }

    public int[] getSortedTreeAsc() {
        int[] sortedArray = new int[getNumberOfElements()];
        fillArrayAsc (rootNode, sortedArray);
        return sortedArray;
    }

    public int[] getSortedTreeDesc(){
        int[] sortedArray = new int[getNumberOfElements ()];
        fillArrayDesc (rootNode, sortedArray);
        return sortedArray;
    }

    private void fillArrayAsc(Node fillingNode, int[]arrayToFill) {
        if(fillingNode.getLeftChild () != null){
            fillArrayAsc(fillingNode.getLeftChild (),arrayToFill);
        }
        arrayToFill[index++] = fillingNode.getValue ();

        if (fillingNode.getRightChild () != null){
            fillArrayAsc (fillingNode.getRightChild (), arrayToFill);
        }

    }

    private void fillArrayDesc(Node fillingNode, int[]arrayToFill) {
        if(fillingNode.getRightChild () != null){
            fillArrayDesc(fillingNode.getRightChild (),arrayToFill);
        }
        arrayToFill[index++] = fillingNode.getValue ();

        if (fillingNode.getLeftChild () != null){
            fillArrayDesc (fillingNode.getLeftChild (), arrayToFill);
        }

    }
}
