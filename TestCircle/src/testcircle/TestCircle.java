package Circle;
        
public class TestCircle {
    public static void main(String[] args) {
        // Declare and Construct an instance of the Circle class called c1
        Circle c1 = new Circle(2.0, "blue"); // Use 3rd constructor
        System.out.println("The radius is: " + c1.getRadius()); // Use dot operator
        System.out.println("The color is: " + c1.getColor());
        System.out.printf("The area is: %.2f%n", c1.getArea());
        
        // Declare and Construct another instance of the Circle class called c2
        Circle c2 = new Circle(2.0); // Use 2nd constructor
        System.out.println("The radius is: " + c2.getRadius());
        System.out.println("The color is: " + c2.getColor());
        System.out.printf("The area is: %.2f%n", c2.getArea());
        
        // Declare and Construct yet another instance of the Circle class called c3
        Circle c3 = new Circle(2.0); // Use 2nd constructor
        System.out.println("The radius is: " + c3.getRadius()); // Use dot operator
        System.out.println("The color is: " + c3.getColor());
        System.out.printf("The area is: %.2f%n", c3.getArea());
    }
    
}