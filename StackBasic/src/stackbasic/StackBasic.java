// StackBasic.java
// demonstrates the built-in stack
package stackbasic;

import java.io.IOException;     //exception for I/O
import java.util.Scanner;       //for input
import java.util.Stack;         //for Stack class

public class StackBasic {
    public static void main(String[] args) {
        int stackSize;      //stack size
        int stackNum;       //number to be inserted in stack
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("How many integer? ");
        stackSize = in.nextInt();   //insert stack size
        
        Stack theStack = new Stack();  //make new stack
        
        for(int i=0; i<stackSize; i++){
            System.out.print("Enter number: ");
            stackNum = in.nextInt();        //insert number
            theStack.push(stackNum);        //push element onto stack
        }
        
        System.out.print(theStack);
        
        while(!theStack.isEmpty()){          //until it is empty, delete item from stack
            Integer value = (Integer) theStack.pop();
            System.out.print(value);        //display the popped item
            System.out.print(" ");
        }
        
        System.out.println("");
    } 
}