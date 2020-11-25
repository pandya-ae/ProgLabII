package chaining;           // package name
import java.util.Scanner;   // scanner utility

class LinkedHashEntry{
    String key;             // define key (String)
    int value;              // define value (int)
    LinkedHashEntry next;   // pointer to next of LinkedHashEntry

    /* Constructor LinkedHashEntry */
    LinkedHashEntry(String key, int value){ // parameters are key and value
        this.key = key;                     // set key as key
        this.value = value;                 // set value as value
        this.next = null;                   // set next as null
    }
}

class HashTable{                        // class for the hash table
    private int TABLE_SIZE;             // size of the hash table
    private int size;                   // define size
    private LinkedHashEntry[] table;    // define array for the hash table

   /* Constructor HashTable */
    public HashTable(int ts){                       // constructor
        size = 0;                                   // set the size to 0 as counter
        TABLE_SIZE = ts;                            // set the hash table size to the parameter of the constructor
        table = new LinkedHashEntry[TABLE_SIZE];    // create an array that corresponds to the size of the hash table
        for (int i = 0; i < TABLE_SIZE; i++)        // hash table size looping
            table[i] = null;                        // index of the hash table is null, thus the hash table is created
    }

    /* Function to get number of key-value pairs */
    public int getSize(){
        return size;                            // set size as size
    }
    
    public boolean isEmpty(){
        return size == 0;                       // set size as 0
    }
    
    /* Function to clear hash table */
    public void makeEmpty(){
        size = 0;                               // make the size 0
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;                    // the hash table has been emptied
    }
    
    /* Function to get value of a key */
    public int get(String key){                             // get the value of the key with the parameter of the variable is a string
        int hash = (myhash( key ) % TABLE_SIZE);            // define hash as the hash code that responds to the key % hash table size
        if(table[hash] == null){                            // if the hash table array is 0
            return -1;                                      // location of the selected hash table is 0
        }
        else{
            LinkedHashEntry entry = table[hash];            // define entry as a hash table that corresponds to "hash" index
            while(entry != null && !entry.key.equals(key))  // while index of table is not 0
                entry = entry.next;                         // entry is made into a node
            if(entry == null)                               // if entry is null
                return -1;                                  // location of the selected hash table is empty
            else
                return entry.value;                         // return the value of the entry node
        }
    }
    
   /* Function to insert a key value pair */
    public void insert(String key, int value){                      
        int hash = (myhash(key) % TABLE_SIZE);                      // define hash as the hash code that corresponds to the key % hash table size
        if(table[hash] == null)                                     // if hash table array is 0
            table[hash] = new LinkedHashEntry(key, value);          // store the data - key and value - in the hash table
        else{
            LinkedHashEntry entry = table[hash];                    // define node for hash table
            while (entry.next != null && !entry.key.equals(key))    // while index of table is  not 0
                entry = entry.next;                                 // entry is made into a node
            if (entry.key.equals(key))                              // if the key corresponds to the value of the node
                entry.value = value;                                // store the value in it
            else                                                    // if the node already has a value in it
                entry.next = new LinkedHashEntry(key, value);       // keep storing the value in the next node
        }
        size++;
    }
        
    /* Function to remove a key */
    public void remove(String key){
        int hash = (myhash( key ) % TABLE_SIZE);                // define hash as the hash code that corresponds to the key % hash table size
        if(table[hash] != null){                                // if hash table is not or already has value
            LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[hash];
            while (entry != null && !entry.key.equals(key)){
                prevEntry = entry;
                entry = entry.next;
            }
            
            if(entry.key.equals(key)){
                if(prevEntry == null)
                    table[hash] = entry.next;
                else
                    prevEntry.next = entry.next;
                size--;
            }
        }
    }
    
    /* Function myhash which gives a hash value for a given string */
    private int myhash(String x){
        int hashVal = x.hashCode( );                            // define a formula for the hash code, then returns it as hashVal
        hashVal %= TABLE_SIZE;                                  // to determine the hash value in the given table
        if (hashVal < 0)                                        // if hashVal is < 0
            hashVal += TABLE_SIZE;                              // then the table size is added to the temporary hash value
        return hashVal;                                         // returns the hash value
    }

   /* Function to print hash table */
    public void printHashTable(){
        System.out.println("\nHash Table");                     // prints "Hash Table"
        for (int i = 0; i < TABLE_SIZE; i++){                   // define the looping for the hash table
            System.out.print("\nBucket " + (i + 1) + " : ");    // buckets from 0 to table[i]
            LinkedHashEntry entry = table[i];                   // define location of the hash table as entry value
            while(entry !=null){                                // while value is not null
                System.out.print(entry.value + " ");            // prints " "
                entry = entry.next;                             // for the next node
            }
        }
    }
}

/* Class Chaining */
public class Chaining{                                                          // class for chaining
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);                                  // scanning user input
        System.out.println("Hash Table Test\n\n");                              // text prompt
        System.out.println("Enter size");                                       // user entering the hash table size
        
       /* Make object of HashTable */
        HashTable ht = new HashTable(scan.nextInt() );                          // enabling user to modify the hash table
        char ch;                                                                    
        
       /* Perform HashTable operations  */
        do{                                                                     // do the operations
            System.out.println("\nHash Table Operations\n");                    // operations menu
            System.out.println("1. insert ");                                   // to insert an element
            System.out.println("2. remove");                                    // to remove an element
            System.out.println("3. get");                                       // to get a value
            System.out.println("4. check empty");                               // to check whether the hash table is empty or not
            System.out.println("5. clear");                                     // to clear the table
            System.out.println("6. size");                                      // to display current value size
            int choice = scan.nextInt();                                        // scanning the user input
            switch (choice){                                                    // switch case function
                case 1 :                                                        // case 1: inserting an element
                    System.out.println("Enter key and value");                  // text prompt
                    ht.insert(scan.next(), scan.nextInt() );                    // inserting user's key and value input to the hash table
                    break;                                                      // break before displaying the hash table
                case 2 :                                                        // case 2: removing an element                                        
                    System.out.println("Enter key");                            // text prompt
                    ht.remove( scan.next() );                                   // removing user's key input from the hash table
                    break;                                                      // break before displaying the hash table
                case 3 :                                                        // case 3: getting a value
                    System.out.println("Enter key");                            // user entering the key of the desired value
                    System.out.println("Value = "+ ht.get( scan.next() ));      // displaying user's desired value
                    break;                                                      // break before displaying the hash table
                case 4 :                                                        // case 4: checking the hash table, whether it is empty or not
                    System.out.println("Empty Status " +ht.isEmpty());          // displaying the hash table emptiness status
                    break;                                                      // break before displaying the hash table
                case 5 :                                                        // case 5: clearing the table
                    ht.makeEmpty();                                             // clearing the hash table
                    System.out.println("Hash Table Cleared\n");                 // text prompt
                    break;                                                      // break before displaying the hash table
                case 6 :                                                        // case 6: displaying the current size of user's value input
                    System.out.println("Size = "+ ht.getSize() );               // displaying the current value size
                    break;                                                      // break before displaying the hash table
                default :                                                       // case: default
                    System.out.println("Wrong Entry\n ");                       // if user entered the wrong case
                    break;                                                      // break before
            } // end choices
            /* Display hash table */
            ht.printHashTable();                                                // function to print the hash table
            System.out.println("\nDo you want to continue (Type y or n)\n");    // prompt to whether continue the program or not
            ch = scan.next().charAt(0);                                         // scanning the user input
        } // end case
        while (ch == 'Y'|| ch == 'y');                                          // if Y or y is inserted, the hash table operation repeats
    }
} // end class