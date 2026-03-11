package oops;

public class abstarction {

    public static void main(String[] args)
    {
        College obj1 = new S(1, "abby", 42.0);
        College obj2 = new Employee(101,"abhay", 23003);
        obj1.displaydetail();
        obj2.displaydetail();
    }

}

abstract class College
{
    private int id;
    private String name;


    public College(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
       if(id >= 0) {
           this.id = id;
       }
       else {
           System.out.println("invalid id, setting default id 1");
           this.id = 1;
       }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
        else
        {
            System.out.println("invaild name. setting deafault - unknown");
            this.name = "unknown";
        }
    }

    abstract void displaydetail();
}
class S extends College
{
    private double marks;

    public S(int id, String name, double marks) {
        super(id, name);
        setMarks(marks);
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
       if(marks >= 0) {
           this.marks = marks;
       }
       else {
           System.out.println("invalid input");
       }
    }

    @Override
    void displaydetail()
    {
        System.out.println("id: "+getId()+"name:" + getName()+ "marks: "+ getMarks());
    }
}
class Employee extends College
{
    private double salary;

    public Employee(int id, String name, double salary) {
        super(id, name);
        setsalary(salary);
    }

    public double getsalary() {
        return salary;
    }

    public void setsalary(double salary) {
        if(salary >= 0) {
            this.salary = salary;
        }
        else {
            System.out.println("invalid input");
        }
    }

    @Override
    void displaydetail()
    {
        System.out.println("id: "+getId()+"name:" + getName()+ "salary: "+ getsalary());
    }
}


