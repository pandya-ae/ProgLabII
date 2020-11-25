package Circle;
        
public class Circle {
    // Private instance variables
    public double radius;              

    /**
     *
     */
    public String color;
    
    // Constructors (overloaded)
    public Circle(){
        radius = 1.0;                   // 1st Constructor
        color = "red";
    }
    public Circle(double r){
        radius = r;                     // 2nd Constructor
        color = "red";
    }
    public Circle(double r, String c){
        radius = r;                     // 3rd Constructor
        color = c;
    }
    public double getRadius(){
        return radius;
    }
    public String getColor(){
        return color;
    }
    public double getArea(){
        final double pi = 3.14;
        return radius * radius * pi;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }
    @Override
    public String toString(){
        return "This is a Circle";
    }

    String getHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object[] getVolume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}