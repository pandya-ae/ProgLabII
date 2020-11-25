package myfirstjavaproject;

public class MyFirstJavaProject {
    
    public static void helloGood(String stringTime, String stringName){
        System.out.println("\nGood " + stringTime);
        System.out.println("\nMy name is " + stringName);
    }
    public static void myFavorites(){
        System.out.println("\nmy hobbies are writing, reading, and biking");
        System.out.println("\nmy favorite soccer player is Cristiano Ronlado");
        System.out.println("\nmy best places to visit are Yogyakarta, Borobudur");
        System.out.println("\nmy films ranking are: \n1. Time Track, \n2. Interstellar");
    }
    public static int theTotalOfSalesToday (int[] sales){
        int sum  = 0;
        for (int itemSales : sales){
            sum += itemSales;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("\nHello World");
        System.out.println("\nI'm Julia Roberts");
        System.out.println("\nMy hobbies are writing, reading, and biking");
        System.out.println("\nMy favorite soccer is Messi");
        System.out.println("\nHow do you today guy");
        helloGood("morning", "Julia Roberts");
        myFavorites();
        
        int[] sales1 = {40, 22, 15, 29, 39, 22, 30, 35};
        System.out.println("The total sales this weeks: " + theTotalOfSalesToday(sales1));
    }  
}