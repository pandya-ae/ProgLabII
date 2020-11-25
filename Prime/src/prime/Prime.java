package prime;
import java.util.Scanner;

public class Prime {
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = reader.nextInt();
        
        boolean prime = false;
        for (int i = 2; i <= num/2; i++)
        {
            if(num % i == 0)
            {
                prime = true;
            }
        }
        if (!prime)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
    }
}