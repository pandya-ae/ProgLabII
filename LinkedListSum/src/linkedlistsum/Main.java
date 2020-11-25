package linkedlistsum;

import java.io.IOException;
import java.util.Scanner;

class Node {
    public int iData;                                               //data item
    public Node next;                                               //next link in list

    public Node(int id){                                            //constructor
        iData = id;                                                 //initialize data
    }                                                               //('next' is automatically set to null)

    public void displayLink(){                                      //display ourselves
        System.out.print("[" + iData + "] ");
    }
}

class LinkListInit {
    private Node first;                                             //ref to first node on list

    public LinkListInit() {                                         //constructor
        first = null;                                               //no items on list yet
    }

    public boolean isEmpty() {                                      //true if list is empty
        return (first == null);
    }

    public void insertFirst(int id) {                               //insert at start of list
        Node newNode = new Node(id);                                //make new node
        newNode.next = first;                                       //newNode --> old first
        first = newNode;                                            //first --> newNode
    }

    public void insertLast(int id) {                                //insert at end of list
        if (first == null)                                          //if the list is empty
            insertFirst(id);                                        //create first node
        else {                                                      //if not
            Node temp = first;                                      //start from first node
            while (temp.next != null) {                             //until we are at the last node
                temp = temp.next;                                   //keep going
            }
            temp.next = new Node(id);                               //add new node at the end
        }
    }

    public Node deleteFirst() {                                     //delete first item (assume list not empty)
        Node temp = first;                                          //save reference to node
        first = first.next;                                         //delete it: first --> next node
        return temp;                                                //return deleted node
    }

    public Node deleteLast() {                                      //delete last node
        Node temp = first;                                          //start from first node
        while (temp.next.next != null) {                            //till we are at the second last node
            temp = temp.next;                                       //keep going
        }
        Node toReturn = temp.next;                                  //store the last node
        temp.next = null;                                           //delete reference to last node
        return toReturn;                                            //return deleted node
    }

    public void displayList() {
        System.out.print("List (first to last): ");
        Node current = first;                                       //start at the beginning of the list
        while (current != null) {                                   //until end of list
            current.displayLink();                                  //print data
            current = current.next;                                 //move to next link
        }
        System.out.println();
    }

    public int sumList() {
        int sum = 0;
        Node current = first;
        while (current!=null){
            sum += current.iData;
            current = current.next;
        }
        return sum;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        LinkListInit list1 = new LinkListInit();
     Scanner scan = new Scanner(System.in);

        System.out.print("Number of elements : ");
     int listSize = scan.nextInt();
     int temp;
     for (int i=0;i<listSize;i++){
            System.out.print("Element : ");
            temp = scan.nextInt();
            list1.insertLast(temp);
        }
     
     list1.displayList();
        System.out.printf("Sum : %d",list1.sumList());
    }
}