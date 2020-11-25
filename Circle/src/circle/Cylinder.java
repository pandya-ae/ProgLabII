package Circle;

public class Cylinder extends Circle{
    // private instance variables
    private double height;
    
    //Constructors
    public Cylinder(){
        super();  //invoke superclass' constructor Circle
        this.height = 1.0;
    }
    
    public Cylinder(double height){
        super();  //invoke superclass' constructor Circle
        this.height = height;
    }
    
    public Cylinder(double height, double radius){
        super(radius); //invoke superclass' constructor Circle(radius)
        this.height = height;
    }
    
    public Cylinder(double height, double radius, String color){
        super(radius, color);  //invoke superclass' constructor Circle(radius)
        this.height = height;
    }
    
    //Getter and Setter

    /**
     *
     * @param height
     */
    /*public double getHeight(){
        return this.height;
    }*/
    
    public void setHeight(double height){
        this.height = height;
    }
    
    //Return the volume of this Cylinder

    /**
     *
     * @return
     */
    /*public double getVolume(){
        return getArea()*height;    // Use Circle's getArea()
    }*/
    
    // Define itself
    @Override
    public String toString(){
        return "This is a Cylinder";    //to be refined later (polymorphism)
    }
    
    /**
     *
     * @return
     */
    @Override
    public double getArea(){
        final double pi = 3.14;
        return 2*pi*radius*radius + 2*pi*height;
    }

}