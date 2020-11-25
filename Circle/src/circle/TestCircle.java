package Circle;
        
public class TestCircle {
    public static void main(String[] args) {
        // Declare and Construct an instance of the Circle class called c1
        Circle c1 = new Circle(2.0, "blue");                    // Use 3rd constructor
        System.out.println("The radius is: " + c1.getRadius()); // Use dot operator
        System.out.println("The color is: " + c1.getColor());
        System.out.printf("The area is: %.2f%n", c1.getArea());
        System.out.println(" ");
        
        // Declare and Construct another instance of the Circle class called c2
        Circle c2 = new Circle(2.0);                            // Use 2nd constructor
        System.out.println("The radius is: " + c2.getRadius());
        System.out.println("The color is: " + c2.getColor());
        System.out.printf("The area is: %.2f%n", c2.getArea());
        System.out.println(" ");
        
        // Declare and Construct yet another instance of the Circle class called c3
        Circle c3 = new Circle(2.0);                            // Use 2nd constructor
        System.out.println("The radius is: " + c3.getRadius()); // Use dot operator
        System.out.println("The color is: " + c3.getColor());
        System.out.printf("The area is: %.2f%n", c3.getArea());
        System.out.println(" ");
    
        // Declare and Contruct an Instance of the Cylinder Class Called c4
        Cylinder c4 = new Cylinder(500);     // Use Cylinder
        System.out.println("\nThe radius is: " + c4.getRadius());   // Invoke superclass Circle's methods
        System.out.println("The color is: " + c4.getColor());       // Invoke superclass Circle's methods
        System.out.printf("The area is: %.2f%n", c4.getArea());     // Invoke superclass Circle's methods
        System.out.println("The height is: " + c4.getHeight());
        System.out.printf("The volume is: %.2f%n", c4.getVolume());
        
        // Declare and Contruct an Instance of the Cylinder Class Called c4
        Circle c5 = new Cylinder(1.1,2.2);     // Use Cylinder
        System.out.println("\nThe radius is: " + c5.getRadius());   // Invoke superclass Circle's methods
        System.out.println("The color is: " + c5.getColor());       // Invoke superclass Circle's methods
        System.out.println("The height is: " + c5.getHeight());     // compilation error
        System.out.printf("The volume is: %.2f%n", c5.getVolume()); // compilation error
        System.out.printf("The area is: %.2f%n", c5.getArea());     // Run the overridden version!
        System.out.println(c5.toString());                          // Run the overridden version!
    }
}