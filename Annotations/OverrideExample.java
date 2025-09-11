import java.util.Scanner;

// Parent class
class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

// Child class overriding makeSound
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof Woof!");
    }
}

public class OverrideExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter animal type (dog/other): ");
        String input = sc.nextLine();

        Animal animal;
        if (input.equalsIgnoreCase("dog")) {
            animal = new Dog();  // Polymorphism
        } else {
            animal = new Animal();
        }

        animal.makeSound();
        sc.close();
    }
}
