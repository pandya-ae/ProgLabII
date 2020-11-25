package shape2;

public class TestShape {
    public static void main(String[] args) {
        Shape2 s1 = new Rectangle(1, 2); // upcast
        System.out.println(s1);
        System.out.println("Area is " + s1.getArea());
        Shape2 s2 = new Triangle(3, 4); // upcast
        System.out.println(s2);
        System.out.println("Area is " + s2.getArea());
        // Cannot create instance of an interface
        // Shape2 s3 = new Shape2("green"); // Compilation Error!!
    }
}
