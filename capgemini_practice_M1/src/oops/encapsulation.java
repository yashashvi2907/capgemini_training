package oops;
import java.util.*;

class CustomSort implements Comparator<Student>
{
    @Override
    public int compare(Student s1, Student s2)
    {
        if(s1.getMarks() != s2.getMarks())
        {
            return Double.compare(s1.getMarks(), s2.getMarks());
        }
        return s1.getName().compareTo(s2.getName());
    }
}

public class encapsulation {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "A", 4,38.0));
        list.add(new Student(9, "A", 1,67.0));
        list.add(new Student(3, "C", 2,28.0));

        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Student>()
        {
            @Override
            public int compare(Student s1, Student s2)
            {
                return Integer.compare(s1.getId(), s2.getId());
            }

        });

        System.out.println(list);

    }
}
class Person
{
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
       if(age> 0) {
           this.age = age;
       }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
class Student extends Person implements Comparable<Student>
{
    private int id;
    private double marks;

    public Student(int id,String name, int age, double marks) {
        this.id = id;
        super(name, age);
        setMarks(marks);
    }


    public int getId() {
        return id;
    }

    public double getMarks() {
        return marks;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarks(double marks) {
        if(marks>=0){
            this.marks = marks;
        }
    }

    @Override
    public int compareTo(Student s)
    {
        if(marks>=0 && this.marks != s.marks)
        {
            return Double.compare(s.marks, this.marks);
        }
        else if(!getName().equals(s.getName()))
        {
            return this.getName().compareTo(s.getName());
        }
        return Integer.compare(this.id, s.id);
    }


    @Override
    public String toString() {
        return "{ " +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", marks=" + marks +
                " }";
    }

//class Student implements Comparable<Student>
//{
//    private int id;
//    private String name;
//    private double marks;
//
//    public Student(int id, String name, double marks) {
//        this.id = id;
//        this.name = name;
//        this.marks = marks;
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public double getMarks() {
//        return marks;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setMarks(double marks) {
//        this.marks = marks;
//    }
//
//    @Override
//    public int compareTo(Student s)
//    {
//        if(marks>=0 && this.marks != s.marks)
//        {
//            return Double.compare(s.marks, this.marks);
//        }
//        else if(!this.name.equals(s.name))
//        {
//            return this.name.compareTo(s.name);
//        }
//        return Integer.compare(this.id, s.id);
//    }
//
//    @Override
//    public String toString() {
//        return "{ " +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", marks=" + marks +
//                " }";
//    }
}

