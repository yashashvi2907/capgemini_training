package oops;

import java.awt.*;

public class practice_alloops_sorting {
}

abstract class Human
{
    int id;
    Human(int id)
    {
        this.id = id;
    }

    abstract void sing();

    void display()
    {
       System.out.print("hello");
    }

}
class Singer extends Human
{
    String name;

    Singer(int id, String name)
    {
        super(id);
        this.name = name;
    }

    @Override
    void sing()
    {
        System.out.println("yess sings");
    }
}
abstract class Shape
{

    abstract void area();

    void display()
    {
        System.out.println("area:");
    }
}
class Circle extends Shape
{
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    void area()
  {
      System.out.println("area of circle: (2*pi*r*r): " + radius*radius);
  }

}
class Rectangle extends Shape
{
  int length;
  int breadth;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    void area() {
        System.out.println("area: "+ length*breadth);
    }
}
interface Drawable
{

}



