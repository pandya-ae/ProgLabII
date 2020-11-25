package hashing;
import java.util.Scanner;

public class Hashing {
    public static int[] ArrayData;           // initialize array ArrayData
    int arraySize;                           // initialize size of array
    int itemsInArray = 0;                    // initialize items in array as 0
    
    Hashing(int size){                       // constructor Hashing
        arraySize=size;                      // set arraySize as size
        ArrayData = new int[size];           // create new ArrayData with length based on the size
        for(int i = 0; i < size; i++){       // for all values in the array
            ArrayData[i] = -1;               // set the value as "-1" means that array is still empty
        }
    }
 
    public int modMethod(int hashvalue, int sizehash, int[] Arr){       // modulo method
        int index = hashvalue % 13;                                     // index is the result of hashvalue mod by 13, the biggest prime mod < 15
        return index;                                                   // return index
    }
 
    public boolean checkArray(int[] array){             // method to check array full or not
        boolean full = true;                            // set full as true (boolean)
        for(int i=0; i < arraySize; i++){               // check to all values in the array
            if(array[i] == -1){                         // if there is a value of -1
                full = false;                           // update full as false
                break;
            }
        }
        return full;                                    // return full
    }
 
    public void insert(int key, int[] Array){               // insert method using linear probing to handle collision
        int indexArr = modMethod(key,arraySize,ArrayData);  // get indexArray using modulo method
        if(checkArray(Array)==true){                        // check using checkArray method, if array is full
            System.out.println("Array is full!"); 
        }else{ //if array is not full
            while(ArrayData[indexArr] != -1){     // loop or repeat the below function if the value of data in indexArr is not empty (-1)
                indexArr += 3;                    // then add 3 to indexArr (linear probing)
                if(indexArr == arraySize){        // if indexArr similar than the length of the array (arraySize)
                    indexArr = 0;                 // set indexArr to 0
                }
            }
            ArrayData[indexArr] = key;            // insert the data (key) to the ArrayData with index as indexArr
        }
    }
 
    public void insert2(int key, int[] Array){                  // insert method using quadratic probing to handle collision
        int indexArr = modMethod(key,arraySize,ArrayData);      // get indexArray using modulo method
        int i = 1; //set i is 1
        if(checkArray(Array)==true){                            // check using checkArray method, if array is full
            System.out.println("Array is full!");
        }else{                                                  // if array is not full
            while(ArrayData[indexArr] != -1){                     // loop or repeat the below function if the value of data in indexArr is not empty (-1)
                indexArr += i * i;                                // then add i*i to indexArr (quadratic probing)
                if(indexArr == arraySize){                        // if indexArr similar than the length of the array (arraySize)
                    indexArr = 0;                                 // set indexArr to 0
                }else if(indexArr >= arraySize){                  // if indexArr >= the length of the array (arraySize)
                    indexArr %= arraySize;                        // indexArr = indexArray % arraySize 
                }
                i++;                                              // add 1 to i and repeat the function again if we can't find an index with empty slot  
            }
            ArrayData[indexArr] = key;                            // insert the data (key) to the ArrayData with index as indexArr
        }
    }
 
    public void insert3(int key, int[] Array){              // insert method using double hashing to handle collision
        int index1 = modMethod(key,arraySize,ArrayData);    // get index1 using modulo method
        int PRIME = 47;                                     // set the prime number so this function can't infinite
                                                            // int index2 = (key+(key%10))%arraySize; //get index2 (h')
        int index2 = PRIME - key % PRIME;                   // the other second hash function that you can used
        if(checkArray(Array) == true){                      // check using checkArray method, if array is full
            System.out.println("Array is full!");
        }else{                                                // if array is not full                                 
            int indexNext = index1;                           // set indexNext as index1
            while(ArrayData[indexNext] != -1){                // loop or repeat the below function if the value of data in indexNext is not empty (-1)
                int i = 1;                                    // set i = 1
                indexNext = index1 + (i * index2);            // update indexNext using that equation (double hashing)
                if(indexNext == arraySize){                   // if indexNext is similar than the length of the array (arraySize)
                  indexNext = 0;                              // set indexNext to 0
                }
                else if(indexNext >= arraySize){
                  indexNext %= arraySize;
                }
                i++;                                          // add 1 to i and repeat the function again if we can't find an index with an empty slot            
            }
            ArrayData[indexNext] = key;                       // insert the data (key) to the ArrayData with index as indexNext
        }
    }
    
    public static void main(String[] args) {
        Hashing theFunc = new Hashing(21);                    // create new Hash array with a length of 20
        Scanner in = new Scanner(System.in);
        int input;
        
        System.out.println("Collision method: ");
        System.out.println("1. Linear probing");
        System.out.println("2. Quadratic probing");
        System.out.println("3. Double hashing");
        input = in.nextInt();
        
        switch(input){
            case 1: theFunc.insert(15, ArrayData);
                    theFunc.insert(33, ArrayData);
                    theFunc.insert(70, ArrayData);
                    theFunc.insert(45, ArrayData);
                    theFunc.insert(81, ArrayData);
                    theFunc.insert(68, ArrayData);
                    theFunc.insert(54, ArrayData);
                    theFunc.insert(29, ArrayData);
                    theFunc.insert(97, ArrayData);
                    theFunc.insert(100, ArrayData);
                    theFunc.insert(34, ArrayData);
                    theFunc.insert(17, ArrayData);
                    theFunc.insert(62, ArrayData);
                    theFunc.insert(71, ArrayData);
                    theFunc.insert(53, ArrayData);
                break;
            case 2: theFunc.insert2(15, ArrayData);
                    theFunc.insert2(33, ArrayData);
                    theFunc.insert2(70, ArrayData);
                    theFunc.insert2(45, ArrayData);
                    theFunc.insert2(81, ArrayData);
                    theFunc.insert2(68, ArrayData);
                    theFunc.insert2(54, ArrayData);
                    theFunc.insert2(29, ArrayData);
                    theFunc.insert2(97, ArrayData);
                    theFunc.insert2(100, ArrayData);
                    theFunc.insert2(34, ArrayData);
                    theFunc.insert2(17, ArrayData);
                    theFunc.insert2(62, ArrayData);
                    theFunc.insert2(71, ArrayData);
                    theFunc.insert2(53, ArrayData);
                break;
            case 3: theFunc.insert3(15, ArrayData);
                    theFunc.insert3(33, ArrayData);
                    theFunc.insert3(70, ArrayData);
                    theFunc.insert3(45, ArrayData);
                    theFunc.insert3(81, ArrayData);
                    theFunc.insert3(68, ArrayData);
                    theFunc.insert3(54, ArrayData);
                    theFunc.insert3(29, ArrayData);
                    theFunc.insert3(97, ArrayData);
                    theFunc.insert3(100, ArrayData);
                    theFunc.insert3(34, ArrayData);
                    theFunc.insert3(17, ArrayData);
                    theFunc.insert3(62, ArrayData);
                    theFunc.insert3(71, ArrayData);
                    theFunc.insert3(53, ArrayData);
                break;
        }
        for (int ArrayData1 : ArrayData) {        // print all values in ArrayData
            System.out.print(ArrayData1 + " ");   // print data one by one
        }
    }
}