package OOPS;

class Student{
    String name;
    int rno;
    double cgpa;
}
public class Basics {
//    public static class Student{
//        String name;
//        int rno;
//        double cgpa;
//    }
    public static void main(String[] args) {
        Student s1=new Student();
        s1.name="Ragni";
        s1.rno=2267;
        s1.cgpa=8.51;

        Student s2=new Student(); //make box like array 1 having name, rno,cgpa
        s2.name="Chirag";
        s2.rno=1281;
        s2.cgpa=9.8;

        System.out.println("Name " + s1.name + " RNo " + s1.rno + " CGPA " + s1.cgpa);
        System.out.println("Name " + s2.name + " RNo " + s2.rno + " CGPA " + s2.cgpa);
        s1.cgpa=8.86;
        System.out.println(s1.cgpa);
    }
}


//classes : blue print eq Scanner
//object: real world entity
