package animal;

public class Animal {

    public static void main(String[] args) {
        Carnivore a = new Carnivore ("Lion");
        Herbivore b = new Herbivore ("Deer");
        Omnivore c = new Omnivore ("Human");
        
        System.out.println(a.nameAnimal () + " as a carnivore primarily eats " + a.type);
        System.out.println(b.nameAnimal () + " as a herbivore primarily eats " + b.type);
        System.out.println(c.nameAnimal () + " as an omnivore eats both " + c.type);
    }
    
}