package ua.opnu.list;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Khabib Nurmagomedov");
        Cat cat = new Cat("Conor Mcgregor");

        System.out.println(dog.getName() + " Saying: " + dog.makeSound());
        System.out.println(cat.getName() + " Saying: " + cat.makeSound());
    }
}
