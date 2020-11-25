package animal;

public class Omnivore extends typeAnimal {
    String type;
    
    public Omnivore (String Animal) {
        super (Animal);
        this.type = "meat and plant";
    }
    
    public String type () {
        return type;
    }
}