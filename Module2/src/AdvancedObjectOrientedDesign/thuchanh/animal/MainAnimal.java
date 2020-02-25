package AdvancedObjectOrientedDesign.thuchanh.animal;

public class MainAnimal {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals){
            animal.makeSound();
        }
    }
}