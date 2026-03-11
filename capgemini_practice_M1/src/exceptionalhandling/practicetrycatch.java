package exceptionalhandling;

import java.sql.SQLOutput;

public class practicetrycatch {

    public static void main(String[] args) {
//        exception obj1 = new exception();
//        System.out.print(obj1.divide(4,0));
        level3();
    }

    //StackTrace-- snapsont of call stack

    public static void level1()
    {
        try {
            int[] array = new int[5];
            array[6] = 10;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public static void level2()
    {
          level1();
    }
    public static void level3()
    {
        level2();
    }

}

class exception
{

    //thowable -- exception -- ioexception, runtimeexception .. etc

    // unexpected error that occur and break flow of program - exception

    // to handle exception - we use try catch
    // exception is object which is thrown at runtime

    public static int divide(int a, int b)
    {
        try {
            return a / b;
        }
        // here exception is object , like student is object of student class
        catch(ArithmeticException | NullPointerException e)
        {
            // here it calls toString method in throwable
            // that helps to print name of class of exception + message
            // when exception, jvm calls constructor with message-
            // that by stacktrace stores in it, that tells, at what line, wat error is occured
            System.out.print(e);
            return -1;
        }
        // cannot write, because hirearchical nature, exception is high in hirerachy, we should change order
//        catch(ArithmeticException e)
//        {
//
//        }
        // we can also write multiple exception in one catch- must be disjoint exception
        // can create multiple catch block
    }
}

