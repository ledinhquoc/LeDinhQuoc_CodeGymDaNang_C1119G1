package AdvancedObjectOrientedDesign.thuchanh.edible;

import AdvancedObjectOrientedDesign.thuchanh.animal.Animal;
import AdvancedObjectOrientedDesign.thuchanh.animal.Chicken;
import AdvancedObjectOrientedDesign.thuchanh.animal.Tiger;

public class MainEdible {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal: animals){
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken);
            Edible edibler = (Chicken) animal;
            System.out.println(edibler.howToEat());
        }
    }
}
