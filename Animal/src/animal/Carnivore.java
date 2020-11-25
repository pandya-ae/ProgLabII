package animal;

public class Carnivore extends typeAnimal {
    String type;
    
    public Carnivore (String Animal) {
        super (Animal);
        this.type = "meat";
    }
    
    public String type () {
        return type;
    }
}