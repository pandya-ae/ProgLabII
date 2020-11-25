package shape;

abstract public class Shape {
    //Private member variable
    private final String color;
    
    //Constructor
    public Shape (String color){
        this.color = color;
    }
    
    @Override
    public String toString(){
        return "Shape of color=\"" + color + "\"";
    }
    
    //All shape subclass must implement a method called getArea()
    abstract double getArea();
    
}