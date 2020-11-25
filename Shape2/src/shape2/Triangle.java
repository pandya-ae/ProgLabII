package shape2;

// The subclass Triangle need to implement all the abstract methods in Shape
public class Triangle implements Shape2 {
    // Private member variables
    private final int base;
    private final int height;
    
    // Constructor
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Triangle[base=" + base + ",height=" + height + "]";
    }
    
    // Need to implement all the abstract methods defined in the interface
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
