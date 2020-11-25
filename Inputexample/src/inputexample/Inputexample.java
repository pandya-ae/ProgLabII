package inputexample;
import java.util.Scanner;

public class Inputexample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter your age in years: ");
        double age = input.nextDouble();
        System.out.println("Enter heart rate = ");
        double rate = input.nextDouble();
        
        double fb = (rate-age) * 0.65;
    }   
}