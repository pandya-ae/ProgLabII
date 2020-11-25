package mergesort;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

public class Algorithm {
    public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp){ //to merge 2 sorted sequences
        while(!S1.isEmpty() && !S2.isEmpty()){
            if(comp.compare(S1.peek(), S2.peek()) < 0) //if peek of S1 < peek of S2 will return -1 (see Comparator in Mergesort.java)
                S.add(S1.remove()); //put S1.peek into S sequence
            else //if S1.peek()-S2.peek() > 0
                S.add(S2.remove()); //put S2.peek into S sequence
        }
        while(!S1.isEmpty()) //if S1 is not empty
            S.add(S1.remove()); //put S1.peek into S sequence
        while(!S2.isEmpty()) //if S2 is not empty
            S.add(S2.remove()); //put S2.peek into S sequence
    }
    
    public static <K> void mergeSort(Queue<K> S, Comparator<K> comp){ //method of mergesort
        int n = S.size();  //n is the length of S
        if (n<2) return;
        Queue<K> S1 = new ArrayDeque<>(); //create sequence S1
        Queue<K> S2 = new ArrayDeque<>(); //create sequence S2
        while (S1.size() < n/2) //divide sequence S on halved portions
            S1.add(S.remove()); //put into S1
        while(!S.isEmpty()) //the rest of sequence S
            S2.add(S.remove()); //put into S2
        mergeSort(S1, comp); //recursively sort S1
        mergeSort(S2, comp); //recursively sort S2
        merge(S1,S2,S,comp);  //mege 2 sorted sequences
    }   
}
