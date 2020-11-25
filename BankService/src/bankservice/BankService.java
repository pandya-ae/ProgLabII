//BankService.java
//demonstrates an application of queue using LinkedList
package bankservice;

import java.util.Scanner;       //for input
import java.io.IOException;     //for I/O
import java.util.LinkedList;    //for linked list
import java.util.Iterator;      //for list iteration

class Customer{                 //customer object constructor
    private final String name;        //customer name
    private final double idCust; //customer id and balance
    private final double balance; //customer id and balance
    
    public Customer(String _name, double _idCust, double _balance){     //create customer
        name = _name;
        idCust = _idCust;
        balance = _balance;
    }
    
    public String getName(){    //return customer name
        return name;
    }
    
    public double getIdCust(){  //return customer id
        return idCust;
    }
    
    public double getBalance(){ //return customer balance
        return balance;
    }
}   //end class Customer


class BankServiceStart{                 //queue constructor
    private final LinkedList<Customer> list;  //declare linked list for queue
    
    public BankServiceStart(){
        list = new LinkedList<>();      //create linked list
    }
    
    public boolean isEmpty(){           //true if queue is empty
        return(list.isEmpty());
    }
    
    public void enqueue(Customer item){ //add customer to queue
        list.addLast(item);
    }
    
    public void dequeue(){              //remove customer from queue
        list.removeFirst();
    }
    
    public Customer callCust(){         //get front customer name
        return list.getFirst();
    }

    public void displayQueue(){
        Iterator<Customer> i = list.iterator();
        if(!i.hasNext())
            System.out.println("Queue is currently empty");
        else{
            while(i.hasNext()){
                Customer tempCust = i.next();
                System.out.println("Name: " + tempCust.getName() +  //print customer info
                        "\nCustomer ID: " + tempCust.getIdCust() +
                        "\nBalance: " + tempCust.getBalance());
            }
        }
    }
} //end class BankServiceStart


public class BankService {
    public static void main(String[] args) throws IOException {
        String name_m;          //for getting customer name
        double idCust_m = 0;    //for getting customer id
        double balance_m;       //for getting customer balance
        int queueCom = 0;       //for queue command
        
        Scanner in = new Scanner(System.in);    //for input
        
        BankServiceStart bankQueue = new BankServiceStart();    //create queue
        
        //creating a bank system
        System.out.println("Welcome to Rajasa Bank Queueing System! ");
        
        while(queueCom != 4){       //while we are not done
            System.out.println("What would you like to do?");   //ask command
            System.out.println("1: Check queue\t" + 
                    "2: Add customer to queue\t" +
                    "3: Call customer from queue\t" +
                    "4: Finish");
            queueCom = in.nextInt();
            
            switch(queueCom){
                case 1:
                    bankQueue.displayQueue();
                    break;

                case 2:
                    System.out.print("Customer name: ");
                    name_m = in.next();
                    idCust_m++;
                    System.out.print("Balance: ");
                    balance_m = in.nextDouble();
                    //create customer object
                    Customer newCust = new Customer(name_m, idCust_m, balance_m);
                    bankQueue.enqueue(newCust);
                    System.out.println(name_m + " has been added to queue!");
                    break;
                    
                case 3:
                    if(bankQueue.isEmpty())
                        System.out.println("Queue is empty");
                    else{
                        Customer toServe = bankQueue.callCust();
                        System.out.println("Calling " + toServe.getName());
                        bankQueue.dequeue();
                    }
                    break;
                    
                case 4:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Incorrect command. Try again.");
            }
        }
    }   //end main
}       //end class BankService