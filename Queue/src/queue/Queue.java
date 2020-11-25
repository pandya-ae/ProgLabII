// Queue.java
// demonstrates queue
package queue;
import java.io.IOException;     //exception for I/O
import java.util.Scanner;       //for input
import java.util.Arrays;

class QueueInit{
    private final int maxSize;
    private final int[] queueArray;
    private int front;
    private int rear;
    private int nItems;
    
    public QueueInit(int s){     //constructor
        maxSize = s;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(int j){     //put item at rear of queue
        if (rear == maxSize-1)      //deal with wraparound
            rear = -1;
        queueArray[++rear] = j;     //increment rear and insert
        nItems++;                   //one more item
    }

    public int dequeue(){               //take item from front of queue
        int temp = queueArray[front++]; //get value and increment front
        if(front == maxSize)            //deal with wraparound
            front = 0;
        nItems--;                       //one less item
        return temp;
    }

    public boolean isEmpty(){           //true if queue is empty
        return (nItems==0);
    }

    public boolean isFull(){            //true if queue is full
        return (nItems==maxSize);
    }

    public void printQueue(){
        System.out.println(Arrays.toString(queueArray));
    }


public class Queue {
    public void main(String[] args) throws IOException{
        int queueSize;          //for queue size
        int numTemp;            //for inserted number
        int numChoice = 0;      //for command
        
        Scanner in = new Scanner(System.in);    //for input
        System.out.print("Enter queue size: ");
        queueSize = in.nextInt();
        
        QueueInit theQueue = new QueueInit(queueSize);  //set queue
        
        while(numChoice != 3){
            System.out.println("\n 1: Enqueue \t 2 : Dequeue \t 3 : End");
            System.out.print("Enter command: ");
            numChoice = in.nextInt();
            if(numChoice == 1){
                if(theQueue.isFull())
                    System.out.println("Queue is full");
                else{
                    System.out.print("Enter number: ");
                    numTemp = in.nextInt();
                    theQueue.enqueue(numTemp);  
                }
                theQueue.printQueue();
            }
            else if(numChoice == 2){
                if(theQueue.isEmpty())
                    System.out.println("Queue is empty");
                else{
                    numTemp = theQueue.dequeue();
                    System.out.println("Dequeue number: " + numTemp);
                }
            }
            else if(numChoice != 3){
                System.out.println("Wrong command");
                }
            }   //end main()
        }   //end class Queue
    }
}