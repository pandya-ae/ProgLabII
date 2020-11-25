// Stack.java
// demonstrates stack
package stack;

import java.io.IOException;     //exception for I/O
import java.util.Scanner;       //for input
import java.util.Arrays;

class StackInit{
    private final int maxSize;  //size of stack array
    private final int[] stackArray;   //initialize array
    private int top;            //top of stack
    
    public StackInit(int s){     //constructor
        maxSize = s;                    //set array size
        stackArray = new int[maxSize];  //create array
        top = -1;                       //no items yet
    }
    
    public void push(int j){    //put item on top of stack
        stackArray[++top] = j;  //increment top, insert item
    }

    public double pop(){         //take item from top of stack
        return stackArray[top--];   //access item, decrement top
 }

    public void printStack(){
        System.out.println(Arrays.toString(stackArray));
    }

    public boolean isEmpty() { //true if stack empty
        return(top==-1);
    }

public class Stack {
    public void main(String[] args) throws IOException {
        int stackSize;      //stack size
        int stackNum;       //number to be inserted in stack
        Scanner in = new Scanner(System.in);
        
        System.out.print("How many integer? ");
        stackSize = in.nextInt();   //insert stack size
        
        StackInit theStack = new StackInit(stackSize);  //make new stack
        
        for(int i=0; i<stackSize; i++){
            System.out.print("Enter number: ");
            stackNum = in.nextInt();        //insert number
            theStack.push(stackNum);        //push element onto stack
        }
        theStack.printStack();              //print Stack
        
        
    while(!theStack.isEmpty()){          //until it is empty, delete item from stack
                double value = theStack.pop();
                System.out.print(value);        //display the popped item
                System.out.print(" ");
            }

            System.out.println("");
            }   //end main()
    }   //end class Stack
}