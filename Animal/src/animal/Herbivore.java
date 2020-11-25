package animal;

public class Herbivore extends typeAnimal {
    String type;
    
    public Herbivore (String Animal) {
        super (Animal);
        this.type = "plant";
    }
    
    public String type () {
        return type;
    }
}