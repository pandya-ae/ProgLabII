package mergesort;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

public class Mergesort {
    public static void main(String[] args) {
        Queue<Integer> myQueue = new ArrayDeque<>(); //create new queue named myQueue using ArrayDeque
        
        myQueue.add(5); //add 5 into myQueue
        myQueue.add(1); //add 1 into myQueue
        myQueue.add(7); //add 7 into myQueue
        myQueue.add(100); //add 100 into myQueue
        myQueue.add(90); //add 90 into myQueue
        System.out.println("Before sorting = ");
        
        myQueue.forEach((t) -> {
            System.out.print(t.toString() + " ");
        }); //print the element of myQueue before Sorting
        System.out.println();
        
        //ascending order algorithm
        
        //the Comparator method to compare the value of element 
        Comparator<Integer> compasc = (Integer o1, Integer o2) -> {
            if(o1 < o2) //if o1 < o2
                return -1; //will return -1 (then we put o1 element in S)
            else //if o1 > o2
                return 1; //will return 1 (then we put o2 elemnt in S)
        };
        
        Algorithm.mergeSort(myQueue, compasc); //sort myQueue using mergeSort
        System.out.println("Ascending = ");
        
        myQueue.forEach((t) -> {
            System.out.print(t.toString() + " ");
        }); //print the element of myQueue after sorting
        System.out.println();
        
        //descending order algorithm
        
        //the Comparator method to compare the value of element 
        Comparator<Integer> compdesc = (Integer o1, Integer o2) -> {
            if(o1 > o2) //if o1 > o2
                return -1; //will return -1 (then we put o1 element in S)
            else //if o1 < o2
                return 1; //will return 1 (then we put o2 elemnt in S)
        };
        
        Algorithm.mergeSort(myQueue, compdesc); //sort myQueue using mergeSort
        System.out.println("Descending = ");
        
        myQueue.forEach((t) -> {
            System.out.print(t.toString() + " ");
        }); //print the element of myQueue after sorting
        System.out.println();
    }
}    