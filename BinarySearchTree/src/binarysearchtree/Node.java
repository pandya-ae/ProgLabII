package binarysearchtree;

public class Node{
    public int value; //element data
    public Node leftChild; //pointer to leftChild node
    public Node rightChild; //pointer to rightChild node
    
    Node(int value){ //constructor
        this.value = value; //initialize element data of node
    } 
    
    public int getValue(){ //function getValue
        return value; //to get the value of element data
    }
}