package OOPS;

public class Basics2 {
    public static class Car{
        int seats;
        String name;
        double length;
        String type;
        int torque;
        void print(){
            System.out.println(seats + " " + name + " " + length + " " + type + " " + torque + " ");
        }
    }
    public static void main(String[] args) {
//      Student s1=new Student();
        Car c=new Car();
        c.length=3.99;
        c.name="Kia sonet";
        c.seats=5;
        c.torque=178;
        c.type="SUV";

        change(c);
        System.out.println(c.seats);
        c.print();
    }
    private static void change(Car c){
        c.seats=4;
    }
}




//public → accessible everywhere
//
//protected → same package + subclass
//
//default → same package only
//
//private → same class only

//        | Modifier    | Same Class | Same Package | Subclass (other pkg) | Other Class |
//        | ----------- | ---------- | ------------ | -------------------- | ----------- |
//        | `public`    | ✅          | ✅            | ✅                    | ✅           |
//        | `protected` | ✅          | ✅            | ✅                    | ❌           |
//        | *(default)* | ✅          | ✅            | ❌                    | ❌           |
//        | `private`   | ✅          | ❌            | ❌                    | ❌           |

//Java is ALWAYS pass by value