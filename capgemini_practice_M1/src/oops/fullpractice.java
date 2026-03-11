package oops;

public class fullpractice {
}

abstract class P
{
    private String name;
    private int age;

    public P(String name, int age) {
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
        if(age > 0) {
            this.age = age;
        }
        else
        {
            System.out.print("invalid age ");
            this.age = 1;
        }
    }
    abstract void display();
}
class St extends P implements Comparable<St>
{
    private int id;
    private double marks;

    public St(int id, String name, int age,double marks) {
        super(name, age);
        this.id = id;
        this.marks = marks;
    }


    @Override
    public int compareTo(St o)
    {
        return Double.compare(o.marks,this.marks);
    }
    @Override
    public void display()
    {
        System.out.print("id: " + id + " name: "+ getName()+" marks: "+ marks);
    }

}
class E extends P
{
    private int id;
    private double salary;

    public E(String name, int age, int id, double salary) {
        super(name, age);
        this.id = id;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public void display()
    {
        System.out.print("id: " + id + " name: "+ getName()+" salary: "+ salary);
    }
}


