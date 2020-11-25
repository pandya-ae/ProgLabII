package linkedlist;

import java.io.IOException;
import java.util.Scanner;

public class LinkedList {
    public static void main(String[] args) {
    
    class Node{
    public int iData;                                                           //data item
    public Node next;                                                           //next link in list
    
    public Node(int id){                                                        //constructor
        iData = id;                                                             //initialize data
    }                                                                           //('next' is automatically set to null)
    
    public void displayLink(){                                                  //display ourself
        System.out.print("{" + iData + "} ");
    }
}                                                                               //end class Node

    class LinkListInit{
    private Node first;                                                         //ref to first node on list
    
    public LinkListInit(){                                                      //constructor
        first = null;                                                           //no items on list yet
    }
    
    public boolean isEmpty(){                                                   //true if list is empty
        return (first==null);
    }
    
    public void insertFirst(int id)
    {                                                                           //insert at start of list
        Node newNode = new Node(id);                                            //make new node
        newNode.next = first;                                                   //newNode --> old first
        first = newNode;                                                        //first --> newNode
    }
    
    public void insertLast(int id)                                              //insert at end of list
    {
        if(first==null)                                                         //if the list is empty
        insertFirst(id);                                                        //create first node
        else{                                                                   //if not
            Node temp = first;                                                  //start from first node
            while(temp.next!=null){                                             //until we are at the last node
            temp = temp.next;                                                   //keep going
            }
            temp.next = new Node(id);                                           //add new node at the end
        }

    }
    
    public Node deleteFirst()                                                   //delete first item
    {
        Node temp = first;                                                      //save reference to node
        first = first.next;                                                     //delete it: first --> next node
        return temp;                                                            //return deleted node
    }
    
    public Node deleteLast()                                                    //delete last node
    {
        Node temp = first;                                                      //start from first node
        while(temp.next.next != null){                                          //till we are at the second last node
            temp = temp.next;                                                   //keep going
        }
        Node toReturn = temp.next;                                              //store the last node
        temp.next = null;                                                       //delete reference to last node       
        return toReturn;                                                        //return deleted node
    }
    
    public void displayList()                                                   //display list
    {
        System.out.print("List (first-->last): ");
        Node current = first;                                                   //start at the beginning of the list
        while(current!=null){                                                   //until end of list
            current.displayLink();                                              //print data
            current = current.next;                                             //move to next link
        }
        System.out.println("");
    }
   }                                                                            //end class LinkList
  }  
}

class LinkList {
  public static void main(String[] args) throws IOException{
        LinkListInit theList1 = new LinkListInit();                             //make new list
        LinkListInit theList2 = new LinkListInit();                             //make new list
        
        Scanner in = new Scanner(System.in);                                    //set scanner
        int nodeNum1;                                                           //the number of integers for first list
        int nodeNum2;                                                           //the number of integers for second list
        int tempNum;                                                            //temporary holder for integer
        
        System.out.print("First list size? ");
        nodeNum1 = in.nextInt();                                                //insert first list size
        
        for(int i=0; i<nodeNum1; i++){
            System.out.print("Insert number: ");
            tempNum = in.nextInt();                                             //insert number
            theList1.insertLast(tempNum);                                       //on the end of list
        }
        theList1.displayList();                                                 //display list
        

        System.out.print("Second list size? ");
        nodeNum2 = in.nextInt();                                                //insert second list size
        
        for(int i=0; i<nodeNum2; i++){
            System.out.print("Insert number: ");
            tempNum = in.nextInt();                                             //insert number
            theList2.insertFirst(tempNum);                                      //on the start of list
        }
        theList2.displayList();                                                 //display list
        
        System.out.println("\nDeleting first node of first list");
        theList1.deleteFirst();                                                 //deleting the first node of first list
        theList1.displayList();                                                 //first list after deletion
        
        System.out.println("\nDeleting last node of second list");
        theList2.deleteLast();                                                  //deleting the last node of second list
        theList2.displayList();                                                 //second list after deletion
    }                                                                           //end main() 
}                                                                               //end class LinkList