package inheritance_package;

//Animal superclass
class Animal {
 String name;
 int age;

 // Constructor
 Animal(String name, int age) {
     this.name = name;
     this.age = age;
 }

 // Method to be overridden
 public void makeSound() {
     System.out.println("Animal makes a sound");
 }
}

//Dog subclass
class Dog extends Animal {
 Dog(String name, int age) {
     super(name, age);
 }

 @Override
 public void makeSound() {
     System.out.println(name + " the dog barks: Woof");
 }
}

//Cat subclass
class Cat extends Animal {
 Cat(String name, int age) {
     super(name, age);
 }

 @Override
 public void makeSound() {
     System.out.println(name + " the cat meows: Meow");
 }
}

//Bird subclass
class Bird extends Animal {
 Bird(String name, int age) {
     super(name, age);
 }

 @Override
 public void makeSound() {
     System.out.println(name + " the bird chirps: Tweet");
 }
}

//Main Method
public class AnimalHierarchy {
 public static void main(String[] args) {
     Animal dog = new Dog("Buddy", 3);
     Animal cat = new Cat("Jacky", 2);
     Animal bird = new Bird("Bite", 1);

     // Polymorphism 
     dog.makeSound();
     cat.makeSound();
     bird.makeSound();
 }
}
