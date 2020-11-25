package heapapp;            // file package
import java.io.*;           // utility import

class Node{
    private int iData;      // data item (key)
    
    public Node(int key){   // constructor
        iData = key;
    }
    
    public int getKey(){            // function getKey
        return iData;               // returning the data value
    }
    
    public void setKey (int id){    // function setKey
        iData = id;
    }    
}

class Heap{
    private Node[] heapArray;           // declaring the array
    private int maxSize;                // size of array
    private int currentSize;            // number of nodes in array
    
    public Heap(int mx){                // constructor
        maxSize = mx;                   // setting size to mx
        currentSize = 0;                // nodes in the array is 0
        heapArray = new Node[maxSize];  // create array
    }
    
    public boolean isEmpty(){           // if the heap is empty or the array index is 0
        return currentSize == 0;        // returning the nodes of the array that is still 0
    }
    
    public boolean insert(int key){         // inserting a new node
        if(currentSize == maxSize)          // if the size of array is 0
            return false;                   // then false
        Node newNode = new Node(key);       // make a new node referring to the data (key)
        heapArray[currentSize] = newNode;   // initialize the heap with array[0] with 0 as its index
        trickleUp(currentSize++);           // index gets incremented with the trickleUp function
        return true;                        // boolean is true
    } // end insert()
    
    public void trickleUp(int index){       // function for comparing and switching up the value of the parent and child
        int parent = (index-1)/2;           // index for parent of the child
        Node bottom = heapArray[index];     // node for child of the parent
        
        while(index > 0 && heapArray[parent].getKey() < bottom.getKey()){ // if i > 0 and value of the parent is less than the child
            heapArray[index] = heapArray[parent]; // move it down
            index = parent;         // temp child becomes the parent
            parent = (parent-1)/2;  // the child that was an index becomes a parent
        } // end while
        
        heapArray[index] = bottom;  // heapArray[index] becomes the parent
    } // end trickleUp()
    
    public Node remove(){                           // delete item with max key (assumes non-empty list)
        Node root = heapArray[0];                   // index of the root node is set to 0
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    } // end remove()
    
    public void trickleDown(int index){     // function for comparing and switching down the value of the parent and child
        int largerChild;                    // value of the larger child (right-side)
        Node top = heapArray[index];        // save root
        while(index < currentSize/2){       // while node has at least one child
            int leftChild = 2 * index + 1;  // index for the last child
            int rightChild = leftChild + 1; // index for the last child
            
            // find the larger child (rightChild exists?)
            if(rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) // if the value of the left child is less than the right child
                largerChild = rightChild;   // make the right child the larger child
            else                            // if not
                largerChild = leftChild;    // then the left child is the larger child
            
            // top >= largerChild?
            if (top.getKey() >= heapArray[largerChild].getKey()) // proving that the top is always bigger than the larger child
                break;
            
            // shift child up
            heapArray[index] = heapArray[largerChild];
            index = largerChild; // go down
        } // end while
        heapArray[index] = top; // root to index
    } // end trickleDown()
    
    public boolean change(int index, int newValue){     // changing (replacing) a node
        if(index<0 || index>=currentSize)               // if input is wrong
            return false;
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        
        if(oldValue < newValue) // if raised
            trickleUp(index);   // trickle it up
        else                    // if lowered
            trickleDown(index); // trickle it down
        return true;
    } // end change()
    
    public void displayHeap(){                          // displaying the current heap tree
        System.out.print("heapArray: ");                // array format
        for(int m=0; m<currentSize; m++)                // looping the index of heapArray
            if(heapArray[m] != null)                    // index of heapArray can't be null
                System.out.print(heapArray[m].getKey() + " ");
            else
                System.out.print("-- ");
        System.out.println("");
        
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;                           // current item
        String dots = "....................";
        System.out.println(dots + dots);     // dotted top line
        
        while(currentSize > 0){
            if(column == 0)                  // first item in row?
                for(int k=0; k<nBlanks; k++) // preceding blanks
                    System.out.println(" ");
            
            System.out.print(heapArray[j].getKey());
            
            if(++j == currentSize)           // done?
                break;
            
            if(++column==itemsPerRow){        // end of row?
                nBlanks /= 2;                 // half the blanks
                itemsPerRow *= 2;             // twice the items
                column = 0;                   // start over on
                System.out.println();         // new row
            }
            else                              // next item on row
                for(int k=0; k<nBlanks*2-2; k++)
                    System.out.print(' ');    // interim blanks
                }  // end for
                System.out.println("\n"+dots+dots); // dotted bottom line
        }
    }

class HeapApp{
    public static void main(String[] args) throws IOException{
        int value, value2;
        Heap theHeap = new Heap(31);  // make a Heap; max size 31
        boolean success;

        theHeap.insert(78);           // insert 10 items
        theHeap.insert(3);
        theHeap.insert(9);
        theHeap.insert(10);
        theHeap.insert(23);
        theHeap.insert(77);
        theHeap.insert(34);
        theHeap.insert(86);
        theHeap.insert(90);
        theHeap.insert(100);
        theHeap.insert(20);
        theHeap.insert(66);
        theHeap.insert(94);
        theHeap.insert(63);
        theHeap.insert(97);
        
        while(true){                             // until [Ctrl]-[C]
            System.out.print("Enter (s)how the heap tree, (i)nsert a new node, (r)emove the entered node, (c)hange a node: "); // I modified the text prompt to make it clearer
            int choice = getChar();
            switch(choice){
                case 's':                        // show case
                    theHeap.displayHeap();       // calling the displayHeap function
                    break;
                case 'i':                        // insert case
                    System.out.print("Enter value to insert: ");
                    value = getInt();                   // returning the value in the array
                    success = theHeap.insert(value);    // if success - heap not full - value is inserted to the heap
                    if( !success )                      // if unsuccess
                        System.out.println("Can't insert; heap full");
                    break;
                case 'r':                        // remove case
                    if( !theHeap.isEmpty() )     // if the heap is not empty
                        theHeap.remove();        // remove the root with the remove function
                    else
                        System.out.println("Can't remove; heap empty"); // can't remove a value if the heap is empty
                    break;
                case 'c':                        // change case
                    System.out.print("Enter current index of item: ");
                    value = getInt();                           // returning value of the array
                    System.out.print("Enter new key: ");
                    value2 = getInt();                          // returning value2 to the array
                    success = theHeap.change(value, value2);    // if success, change the value
                    if( !success )                              // if unsuccess
                        System.out.println("Invalid index");
                    break;
                default:
                    System.out.println("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()

    public static String getString() throws IOException{            // ignoring error message
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
     }

    public static char getChar() throws IOException{                // ignoring error message
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException{                  // ignoring error message
        String s = getString();
        return Integer.parseInt(s);
    }
}  // end class HeapMain