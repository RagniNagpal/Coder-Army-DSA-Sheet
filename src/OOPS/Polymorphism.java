package OOPS;

public class Polymorphism {
    public static class Dog{
        void speak(){
            System.out.println("Bhau Bhau");
        }
    }
    public static class Cat{
        void speak(){
            System.out.println("Meow Meow");
        }
    }
    public static class Lion{
        void speak(){
            System.out.println("GRRRR");
        }
    }
    public static class Pikachu{
        void speak(){
            System.out.println("Pika Pika");
        }
    }
    public static class Human{
        void speak(){
            System.out.println("Hello");
        }
    }
    public static void main(String[] args) {
        Dog d=new Dog();
        Cat c=new Cat();
        Human h=new Human();
        Pikachu p=new Pikachu();
        d.speak();
        h.speak();
    }
}


//
//package OOPS;
//
//public class Polymorphism {
//
//    // Parent class
//    static class Animal {
//        void speak() {
//            System.out.println("Animal speaks");
//        }
//    }
//
//    // Child classes
//    static class Dog extends Animal {
//        @Override
//        void speak() {
//            System.out.println("Bhau Bhau");
//        }
//    }
//
//    static class Cat extends Animal {
//        @Override
//        void speak() {
//            System.out.println("Meow Meow");
//        }
//    }
//
//    static class Lion extends Animal {
//        @Override
//        void speak() {
//            System.out.println("GRRRR");
//        }
//    }
//
//    static class Human extends Animal {
//        @Override
//        void speak() {
//            System.out.println("Hello");
//        }
//    }
//
//    static class Pikachu extends Animal {
//        @Override
//        void speak() {
//            System.out.println("Pika Pika");
//        }
//    }
//
//    public static void main(String[] args) {
//
//        Animal a;   // parent reference
//
//        a = new Dog();
//        a.speak();     // Bhau Bhau
//
//        a = new Cat();
//        a.speak();     // Meow Meow
//
//        a = new Lion();
//        a.speak();     // GRRRR
//
//        a = new Human();
//        a.speak();     // Hello
//
//        a = new Pikachu();
//        a.speak();     // Pika Pika
//    }
//}



//57:55