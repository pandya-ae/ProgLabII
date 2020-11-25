//LinkListClass.java
//demonsrates the use of the built-in LinkedListClass

package linklistclass;

import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;    //important for LinkedListClass

public class LinkListClass {
    public static void main(String[] args) throws IOException{
        LinkedList theList1 = new LinkedList();       //make new list
        LinkedList theList2 = new LinkedList();        //make new list
        
        Scanner in = new Scanner(System.in);            //set scanner
        int nodeNum1;                   //the number of integers for first list
        int nodeNum2;                   //the number of integers for second list
        int tempNum;                     //temporary holder for integer
        
        System.out.print("First list size? ");
        nodeNum1 = in.nextInt();             //insert first list size
        
        for(int i=0; i<nodeNum1; i++){
            System.out.print("Insert number: ");
            tempNum = in.nextInt();          //insert number
            theList1.addLast(tempNum); //on the end of list
        }
        System.out.println(theList1);       //display list
        
        System.out.print("Second list size? ");
        nodeNum2 = in.nextInt();             //insert second list size
        
        for(int i=0; i<nodeNum2; i++){
            System.out.print("Insert number: ");
            tempNum = in.nextInt();            //insert number
            theList2.addFirst(tempNum);   //on the start of list
        }
        System.out.println(theList2);       //display list
        
        System.out.println("\nDeleting first node of first list");
        theList1.removeFirst();                  //deleting the first node of first list
        System.out.println(theList1);       //first list after deletion
        
        System.out.println("\nDeleting last node of second list");
        theList2.removeLast();                   //deleting the last node of second list
        System.out.println(theList2);       //second list after deletion
    }
}