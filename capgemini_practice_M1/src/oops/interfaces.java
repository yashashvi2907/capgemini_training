package oops;

import java.lang.classfile.Interfaces;

public class interfaces {

    public static void main(String[] args) {

        //polymorphism - subclass object refrences to parent class interafce
        Payable obj1 = new Helper("abby", 3000);

        // interface cannot be instantiated-->
        //Payable obj2 = new Payable();

        demo1 obj3 = new demo2();
        obj3.show();
        demo2 obj4 = new demo2();
        obj4.show();
    }
}
interface Payable
{
    //cannot have instance varible - that belongs to object and depenndet on object for values

    double salary=0;

    void calculateSal();

}
interface demo
{}

//one class can implement multiple interfaces

class Helper implements Payable, demo {
    private String name;
    private double Salary;


    public Helper(String name, double salary) {
        this.name = name;
        Salary = salary;
    }

    // must implement all abstarct method of iyerface and must be public
    // becaus ienterfaces methods and field s are public by default
    @Override
    public void calculateSal() {
        System.out.println("name: " + name);
        System.out.println("salary: " + Salary);
    }
}
// if implementing class is not implementing all abatract method in it, must make that class also abstract

abstract class hello implements Payable
{

}
// multiple inheritance using interfaces-

interface demo1
{
  void show();
    default void print()
    {
        System.out.println("A");
    }
}
interface demo3
{
  void show();
  default void print()
  {
      System.out.println("B");
  }
}

class demo2 implements demo1, demo3
{
    @Override
    public void show()
    {System.out.println("subclass method");

    }
    public void print() {

        // if ther are duplicates default method than we have to call using super keyword
        demo1.super.print();
    }
}



